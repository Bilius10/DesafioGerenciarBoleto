package com.gerenciar.boletos.DAO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record BoletoDAO(@NotBlank String Establecimento, @NotNull double valor, @NotNull int ativo,
                        @NotNull int idUsuario, @NotNull LocalDateTime dataVencimento, @NotNull LocalDateTime dataCriacao) {
}
