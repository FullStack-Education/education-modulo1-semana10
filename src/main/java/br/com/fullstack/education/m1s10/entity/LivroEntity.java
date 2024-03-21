package br.com.fullstack.education.m1s10.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "livro")
@EqualsAndHashCode(callSuper = true)
public class LivroEntity extends AbstractEntity {

    @Column(nullable = false, length = 150)
    private String titulo;

    private String subtitulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private Integer nroPaginas;

    @Column(nullable = false, length = 50)
    private String isbn;

    private LocalDate dataPublicacao;

}
