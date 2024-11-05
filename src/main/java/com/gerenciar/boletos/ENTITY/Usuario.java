package com.gerenciar.boletos.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Serial
    private static final long serialVersionUID = 1234543;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nome;
    private int idade;
    private String cpf;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Boleto> boletos;

    public Usuario(Long idUsuario, String nome, int idade, String cpf) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public Usuario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf.replace(".", "");
        cpf.replace("-", "");
        this.cpf = cpf;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
}
