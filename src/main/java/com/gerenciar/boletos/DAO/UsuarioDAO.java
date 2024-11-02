package com.gerenciar.boletos.DAO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDAO(@NotBlank String nome, @NotNull int idade, @NotBlank String cpf) {
}
