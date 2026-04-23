package com.sanchez.cruddeusuarios.Usuarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;
    private final UsuariosMapper usuariosMapper;

    public UsuariosService (UsuariosMapper usuariosMapper, UsuariosRepository usuariosRepository){
        this.usuariosMapper = usuariosMapper;
        this.usuariosRepository = usuariosRepository;
    }

    //Criar usuário
    public UsuariosDTO criarUsuario(UsuariosDTO usuarioDTO){
        UsuariosModel usuario = usuariosMapper.map(usuarioDTO);
        usuario = usuariosRepository.save(usuario);
        return usuariosMapper.map(usuario);
    }

    //Listar todos os usuários
    public List<UsuariosDTO> listarUsuarios(){
        List<UsuariosModel> usuarios = usuariosRepository.findAll();
        return usuarios.stream()
                .map(usuariosMapper::map)
                .collect(Collectors.toList());
    }

    //Listar usuário por ID
    public UsuariosDTO listarUsuarioPorId(Long id){
        Optional<UsuariosModel> usuarioPorId = usuariosRepository.findById(id);
        return usuarioPorId.map(usuariosMapper::map).orElse(null);
    }

    //Atualizar usuário
    public UsuariosDTO atualizarUsuario(Long id, UsuariosDTO usuarioDTO){
        Optional<UsuariosModel> usuarioExistente = usuariosRepository.findById(id);
        if(usuarioExistente.isPresent()){
            UsuariosModel usuarioAtualizado = usuariosMapper.map(usuarioDTO);
            usuarioAtualizado.setId(id);
            UsuariosModel usuarioSalvo = usuariosRepository.save(usuarioAtualizado);
            return usuariosMapper.map(usuarioSalvo);
        }
        return null;
    }

    //Deletar usuário por ID
    public void deletar(Long id){
        usuariosRepository.deleteById(id);
    }
}
