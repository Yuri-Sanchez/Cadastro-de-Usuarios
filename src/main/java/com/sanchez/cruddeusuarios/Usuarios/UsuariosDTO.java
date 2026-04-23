package com.sanchez.cruddeusuarios.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuariosDTO {
    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String cpf;
}
