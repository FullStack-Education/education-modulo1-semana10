package br.com.fullstack.education.m1s10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity extends AbstractEntity {

    private String nome;

    private String login;

    private String senha;

}
