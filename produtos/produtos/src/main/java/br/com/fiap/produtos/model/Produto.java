package br.com.fiap.produtos.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table(name = "tbl_produtos")
///Isso se chama mapeamento objeto relacional, ou seja, a classe Produto está mapeada para a tabela tbl_produto no banco de dados.


public class Produto {

    @Id ///Indica que essa propriedade é a chave primária da tabela.
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "SEQ_PRODUTOS"///Somente para o banco de dados Oracle, que é o banco de dados que estamos utilizando no projeto.
    ) ///Indica que o valor da chave primária será gerado automaticamente pelo banco de dados.
    ///A forma como você vai gerar o valor da chave primária é através de uma sequência, ou seja, o banco de dados vai gerar um número sequencial para cada novo registro.
    @SequenceGenerator(
        name = "SEQ_PRODUTOS",
        sequenceName = "SEQ_PRODUTOS",
        allocationSize = 1
    ) ///Indica o nome da sequência que será utilizada para gerar o valor da chave primária.

    private Long id;

    @Column (length = 100, nullable = false) ///Indica o tamanho máximo da coluna no banco de dados e se ela pode ser nula ou não.
    private String nome;
    
    private double valor;
    private int quantidade;

    @Column (name = "data_fabricacao") ///Indica o nome da coluna no banco de dados que será mapeada para essa propriedade.
    private LocalDate dataFabricacao;

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
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }
    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    
}


