package com.sanchez.cruddeusuarios.Usuarios;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    public UsuariosService (UsuariosRepository usuariosRepository){
        this.usuariosRepository = usuariosRepository;
    }

    //Criar usuário
    public UsuariosModel criarUsuario(UsuariosModel usuarioNovo){
        return usuariosRepository.save(usuarioNovo);
    }

    //Listar todos os usuários
    public List<UsuariosModel> listarUsuarios(){
        return usuariosRepository.findAll();
    }

    //Listar usuário por ID
    public UsuariosModel listarUsuarioPorId(Long id){
        Optional<UsuariosModel> usuarioPorId = usuariosRepository.findById(id);
        return usuarioPorId.orElse(null);
    }

    //Atualizar usuário
    public UsuariosModel atualizarUsuario(Long id, UsuariosModel usuarioAtualizado){
        if(usuariosRepository.existsById(id)){
            usuarioAtualizado.setId(id);
            return usuariosRepository.save(usuarioAtualizado);
        }
        return null;
    }

    //Deletar usuário por ID
    public void deletar(Long id){
        usuariosRepository.deleteById(id);
    }
}
