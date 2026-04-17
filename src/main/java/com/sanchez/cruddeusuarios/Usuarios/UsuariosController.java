package com.sanchez.cruddeusuarios.Usuarios;

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
    public UsuariosModel cadastrarUsuario (@RequestBody UsuariosModel usuarioNovo){
        return usuariosService.criarUsuario(usuarioNovo);
    }

    //READ - listar
    @GetMapping("/listar")
    public List<UsuariosModel> listarUsuarios(){
    return usuariosService.listarUsuarios();
    }

    //READ - listar por ID
    @GetMapping("/listar/{id}")
    public UsuariosModel listarPorId(@PathVariable Long id){
        return usuariosService.listarUsuarioPorId(id);
    }

    //UPDATE - atualizar
    @PutMapping("/atualizar/{id}")
    public UsuariosModel atualizarUsuario(@PathVariable Long id, @RequestBody UsuariosModel usuarioAtualizado){
        return usuariosService.atualizarUsuario(id, usuarioAtualizado);
    }

    //DELETE - deletar
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuarioPorId(@PathVariable Long id){
        usuariosService.deletar(id);
    }
}
