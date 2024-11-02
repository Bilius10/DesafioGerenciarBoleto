package com.gerenciar.boletos.REPOSITORY;

import com.gerenciar.boletos.ENTITY.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
