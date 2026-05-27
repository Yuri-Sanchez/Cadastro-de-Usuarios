package com.sanchez.cruddeusuarios.Controller;

import com.sanchez.cruddeusuarios.DTO.UsuariosDTO;
import com.sanchez.cruddeusuarios.Docs.UsuariosControllerDoc;
import com.sanchez.cruddeusuarios.Service.UsuariosService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name="Cadastros", description = "Endpoints responsaveis por criar, listar, atualizar e deletar usuários")
public class UsuariosController implements UsuariosControllerDoc {
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

    //CREATE - cadastrar
    @PostMapping("/criar")
    public ResponseEntity<String> cadastrarUsuario (@RequestBody UsuariosDTO usuario){
        UsuariosDTO usuarioNovo = usuariosService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso: " + usuarioNovo.getNome() + " (ID): " + usuarioNovo.getId());
    }

    //READ - listar
    @GetMapping("/listar")
    public ResponseEntity<List<UsuariosDTO>> listarUsuarios(){
        List<UsuariosDTO> usuarios = usuariosService.listarUsuarios();
    return ResponseEntity.ok(usuarios);
    }

    //READ - listar por ID
    @GetMapping("/listar/{id}")
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
