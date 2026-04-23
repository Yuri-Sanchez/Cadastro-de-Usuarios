package com.sanchez.cruddeusuarios.Usuarios;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuariosController {
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

    //CREATE - cadastrar
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo usuário" , description = "Rota cria um novo usuário e insere no banco de dados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Usuário criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do usuário")
    })
    public ResponseEntity<String> cadastrarUsuario (@RequestBody UsuariosDTO usuario){
        UsuariosDTO usuarioNovo = usuariosService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso: " + usuarioNovo.getNome() + " (ID): " + usuarioNovo.getId());
    }

    //READ - listar
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os usuários", description = "Rota lista todos os usuários")
    public ResponseEntity<List<UsuariosDTO>> listarUsuarios(){
        List<UsuariosDTO> usuarios = usuariosService.listarUsuarios();
    return ResponseEntity.ok(usuarios);
    }

    //READ - listar por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o usuário por id", description = "Rota lista um novo usuário pelo seu id")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        UsuariosDTO usuario = usuariosService.listarUsuarioPorId(id);

        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com id " + id + " não existe nos nossos registros");
        }
    }

    //UPDATE - atualizar
    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Altera o usuário por id", description = "Rota altera um usuário pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado, não foi possível alterar")
    })
    public ResponseEntity<?> atualizarUsuario(
            @Parameter(description = "Manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Manda os dados do usuário a ser atualizado no corpo da requisição")
            @RequestBody UsuariosDTO usuarioAtualizado){

        UsuariosDTO usuario = usuariosService.atualizarUsuario(id, usuarioAtualizado);
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com o id " + id + " não existe nos nossos registros");
        }
    }

    //DELETE - deletar
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuarioPorId(@PathVariable Long id) {
        if (usuariosService.listarUsuarioPorId(id) != null) {
            usuariosService.deletar(id);
            return ResponseEntity.ok("Usuário com ID " + id + " deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O usuário com id " + id + " não encontrado");
        }
    }
}
