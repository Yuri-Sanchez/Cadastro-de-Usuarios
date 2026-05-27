package com.sanchez.cruddeusuarios.Docs;

import com.sanchez.cruddeusuarios.DTO.UsuariosDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UsuariosControllerDoc {

    @Operation(
            summary = "Cria um novo usuário",
            description = "Rota cria um novo usuário e insere no banco de dados"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Usuário criado com sucesso"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro na criação do usuário"
    )
    ResponseEntity<String> cadastrarUsuario(@RequestBody UsuariosDTO usuario);


    @Operation(
            summary = "Lista todos os usuários",
            description = "Rota lista todos os usuários"
    )
    ResponseEntity<List<UsuariosDTO>> listarUsuarios();


    @Operation(
            summary = "Lista o usuário por id",
            description = "Rota lista um novo usuário pelo seu id"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Usuário encontrado com sucesso"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Usuário não encontrado"
    )
    ResponseEntity<?> listarPorId(@PathVariable Long id);


    @Operation(
            summary = "Altera o usuário por id",
            description = "Rota altera um usuário pelo seu id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Usuário alterado com sucesso"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Dados da atualização inválidos"
    )
    @ApiResponse(responseCode = "404",
            description = "Usuário não encontrado, não foi possível alterar"
    )
    ResponseEntity<?> atualizarUsuario(
            @Parameter(description = "Manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Manda os dados do usuário a ser atualizado no corpo da requisição")
            @RequestBody UsuariosDTO usuarioAtualizado
    );

    
    @Operation(
            summary = "Roda de deleção",
            description = "Rota deleta usuário por id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Exclusão bem sucedida"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Usuário não encontrado"
    )
    ResponseEntity<String> deletarUsuarioPorId(@PathVariable Long id);
}
