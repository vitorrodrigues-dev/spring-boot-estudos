package br.com.fiap.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.produtos.model.Produto;

// Aqui eu indico que a interface ProdutoRepository é um repositório do Spring Data JPA, ou seja, ela vai me fornecer métodos prontos para realizar operações de CRUD (Create, Read, Update e Delete) no banco de dados.
// Produto é a entidade que eu quero gerenciar e Long é o tipo da chave primária da entidade Produto.

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
