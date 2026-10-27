package br.com.fiap.produtos.controller;

import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Aqui eu indico que a classe ProdutoController é um controlador do Spring, ou seja, ela vai me fornecer métodos para receber requisições HTTP e retornar respostas HTTP.
@RequestMapping("/api") // Aqui eu indico que todos os métodos da classe ProdutoController vão ter o prefixo /api na sua URL, ou seja, se eu quiser acessar o método salvar, eu vou ter que acessar a URL /api/produtos.
public class ProdutoController {

    @Autowired // Aqui eu indico que o Spring deve injetar uma instância da classe ProdutoService na classe ProdutoController, ou seja, eu não preciso me preocupar em criar uma instância da classe ProdutoService, o Spring vai fazer isso por mim.
    private ProdutoService produtoService;

    @PostMapping("/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    } // Aqui eu indico que o método salvar vai receber um objeto do tipo Produto no corpo da requisição HTTP e vai retornar um objeto do tipo Produto. O método save é um método pronto do Spring Data JPA que vai salvar o objeto Produto no banco de dados.

    @GetMapping("/produtos")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarTodos(){
        return produtoService.listarTodos();
    } // Aqui eu indico que o método listarTodos vai retornar uma lista de objetos do tipo Produto. O método findAll é um método pronto do Spring Data JPA que vai buscar todos os objetos Produto no banco de dados.

    @GetMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    } // Aqui eu indico que o método buscarPorId vai receber um objeto do tipo Long na URL da requisição HTTP e vai retornar um objeto do tipo Produto. O método findById é um método pronto do Spring Data JPA que vai buscar o objeto Produto no banco de dados pelo seu id. O método findById retorna um objeto do tipo Optional, ou seja, ele pode ou não conter um objeto do tipo Produto. Se o objeto Produto estiver presente, eu retorno o objeto Produto, caso contrário, eu lanço uma exceção.

    @DeleteMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        produtoService.excluir(id);
    } // Aqui eu indico que o método excluir vai receber um objeto do tipo Long na URL da requisição HTTP e não vai retornar nada. O método deleteById é um método pronto do Spring Data JPA que vai excluir o objeto Produto no banco de dados pelo seu id. O método findById retorna um objeto do tipo Optional, ou seja, ele pode ou não conter um objeto do tipo Produto. Se o objeto Produto estiver presente, eu excluo o objeto Produto, caso contrário, eu lanço uma exceção.

    @PutMapping("/produtos/{id}"  )
    @ResponseStatus(HttpStatus.OK)
    public Produto atualizar(@RequestBody Produto produto){
        return produtoService.atualizar(produto);
    } // Aqui eu indico que o método atualizar vai receber um objeto do tipo Produto no corpo da requisição HTTP e vai retornar um objeto do tipo Produto. O método save é um método pronto do Spring Data JPA que vai salvar o objeto Produto no banco de dados.

    //jackon é uma biblioteca que o Spring Boot usa para converter objetos Java em JSON e vice-versa. O Spring Boot usa o Jackson para converter os objetos Java em JSON quando ele retorna uma resposta HTTP e para converter o JSON em objetos Java quando ele recebe uma requisição HTTP.

    // @ResponseStatus é uma anotação do Spring que indica qual é o status HTTP que deve ser retornado na resposta HTTP. O status HTTP é um código numérico que indica se a requisição HTTP foi bem-sucedida ou não. Por exemplo, o status HTTP 200 indica que a requisição HTTP foi bem-sucedida, o status HTTP 201 indica que a requisição HTTP foi bem-sucedida e que um novo recurso foi criado, o status HTTP 204 indica que a requisição HTTP foi bem-sucedida e que não há conteúdo para retornar, o status HTTP 400 indica que a requisição HTTP foi mal-sucedida e que houve um erro do cliente, o status HTTP 404 indica que a requisição HTTP foi mal-sucedida e que o recurso solicitado não foi encontrado, o status HTTP 500 indica que a requisição HTTP foi mal-sucedida e que houve um erro do servidor.

    //@RequestBody é uma anotação do Spring que indica que o objeto Java que está sendo passado como parâmetro do método deve ser convertido em JSON e enviado no corpo da requisição HTTP. O Spring Boot usa o Jackson para converter o objeto Java em JSON.

    //Resumindo de forma simplificada os 4 Produtos, o do controoler, o do model, o do service e o do repository, eles trabalham juntos para permitir que eu possa criar, ler, atualizar e excluir produtos no banco de dados. O ProdutoController recebe as requisições HTTP e chama os métodos do ProdutoService, que por sua vez chama os métodos do ProdutoRepository para acessar o banco de dados. O Produto é a entidade que representa um produto no banco de dados.

}