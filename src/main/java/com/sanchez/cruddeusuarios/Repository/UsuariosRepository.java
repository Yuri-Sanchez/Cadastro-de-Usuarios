package com.sanchez.cruddeusuarios.Repository;

import com.sanchez.cruddeusuarios.Model.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<UsuariosModel, Long> {
}
