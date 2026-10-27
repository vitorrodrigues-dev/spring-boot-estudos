package br.com.fiap.habitos.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table(name = "tbl_habitos")
public class Habito {
    
    @Id 
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "SEQ_HABITOS"
    )
    @SequenceGenerator(
        name = "SEQ_HABITOS", 
        sequenceName = "SEQ_HABITOS", 
        allocationSize = 1
    )
    private Long id;

    @Column(name = "nm_habito", nullable = false, length = 100)
    private String nome;

    @Column(name = "dt_inicio", nullable = false)
    private LocalDate inicio;

    @Column(name = "ds_descricao", nullable = false, length = 200)
    private String descricao;
    
    @Column(name = "nr_vezes_por_semana", nullable = false)
    private int vezesPorSemana;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVezesPorSemana() {
        return vezesPorSemana;
    }

    public void setVezesPorSemana(int vezesPorSemana) {
        this.vezesPorSemana = vezesPorSemana;
    }

    
}
