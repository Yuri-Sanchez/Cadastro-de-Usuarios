package com.sanchez.cruddeusuarios.Usuarios;

import org.springframework.stereotype.Component;

@Component
public class UsuariosMapper {

    public UsuariosModel map(UsuariosDTO usuariosDTO){
        UsuariosModel usuariosModel = new UsuariosModel();
        usuariosModel.setId(usuariosDTO.getId());
        usuariosModel.setNome(usuariosDTO.getNome());
        usuariosModel.setIdade(usuariosDTO.getIdade());
        usuariosModel.setEmail(usuariosDTO.getEmail());
        usuariosModel.setCpf(usuariosDTO.getCpf());

        return usuariosModel;
    }

    public UsuariosDTO map(UsuariosModel usuariosModel){
        UsuariosDTO usuariosDTO = new UsuariosDTO();
        usuariosDTO.setId(usuariosModel.getId());
        usuariosDTO.setNome(usuariosModel.getNome());
        usuariosDTO.setIdade(usuariosModel.getIdade());
        usuariosDTO.setEmail(usuariosModel.getEmail());
        usuariosDTO.setCpf(usuariosModel.getCpf());

        return usuariosDTO;
    }
}
