package br.com.fiap.produtos.service;

import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Aqui eu indico que a classe ProdutoService é um serviço do Spring, ou seja, ela vai me fornecer métodos para realizar operações de negócio relacionadas à entidade Produto.
public class ProdutoService {

    @Autowired // Aqui eu indico que o Spring deve injetar uma instância da interface ProdutoRepository na classe ProdutoService, ou seja, eu não preciso me preocupar em criar uma instância da interface ProdutoRepository, o Spring vai fazer isso por mim.
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    } // Aqui eu indico que o método salvar vai receber um objeto do tipo Produto e vai retornar um objeto do tipo Produto. O método save é um método pronto do Spring Data JPA que vai salvar o objeto Produto no banco de dados.

    public Produto buscarPorId(Long id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if(produtoOptional.isPresent()){
            return produtoOptional.get();
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    } // Aqui eu indico que o método buscarPorId vai receber um objeto do tipo Long e vai retornar um objeto do tipo Produto. O método findById é um método pronto do Spring Data JPA que vai buscar o objeto Produto no banco de dados pelo seu id. O método findById retorna um objeto do tipo Optional, ou seja, ele pode ou não conter um objeto do tipo Produto. Se o objeto Produto estiver presente, eu retorno o objeto Produto, caso contrário, eu lanço uma exceção.

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    } // Aqui eu indico que o método listarTodos vai retornar uma lista de objetos do tipo Produto. O método findAll é um método pronto do Spring Data JPA que vai buscar todos os objetos Produto no banco de dados.

    public Produto atualizar(Produto produto){
        Optional<Produto> produtoAtualizado =
                           produtoRepository.findById(produto.getId());
        if(produtoAtualizado.isPresent()){
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    } // Aqui eu indico que o método atualizar vai receber um objeto do tipo Produto e vai retornar um objeto do tipo Produto. O método save é um método pronto do Spring Data JPA que vai salvar o objeto Produto no banco de dados.

    public void excluir(Long id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isPresent()){
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    } // Aqui eu indico que o método excluir vai receber um objeto do tipo Long e não vai retornar nada. O método deleteById é um método pronto do Spring Data JPA que vai excluir o objeto Produto no banco de dados pelo seu id. O método findById retorna um objeto do tipo Optional, ou seja, ele pode ou não conter um objeto do tipo Produto. Se o objeto Produto estiver presente, eu excluo o objeto Produto, caso contrário, eu lanço uma exceção.
}
