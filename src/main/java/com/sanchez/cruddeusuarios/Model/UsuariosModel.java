package com.sanchez.cruddeusuarios.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UsuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @NotNull
    @Positive
    @Column(name = "idade")
    private int idade;

    @Column(unique = true)
    private String email;

    @NotNull
    @Column(unique = true)
    private String cpf;
}
