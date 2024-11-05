package com.gerenciar.boletos.ENTITY;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Boleto {

    @Serial
    private static final long serialVersionUID = 87654345L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoleto;
    private String Establecimento;
    private double valor;
    private boolean ativo;
    private LocalDateTime dataVencimento;
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "Usuario_idUsuario", nullable = false)
    private Usuario usuario;

    public Boleto(Long idBoleto, String Establecimento, double valor, boolean ativo, LocalDateTime dataVencimento, LocalDateTime dataCriacao, Usuario usuario) {
        this.idBoleto = idBoleto;
        this.Establecimento = Establecimento;
        this.valor = valor;
        this.ativo = ativo;
        this.dataVencimento = dataVencimento;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
    }

    public Boleto() {
    }

    public String getEstablecimento() {
        return Establecimento;
    }

    public void setEstablecimento(String estabelecimento) {
        this.Establecimento = estabelecimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIdBoleto(Long idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Long getIdBoleto() {
        return idBoleto;
    }
}
