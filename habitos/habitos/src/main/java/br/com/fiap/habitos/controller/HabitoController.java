package br.com.fiap.habitos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.habitos.model.Habito;
import br.com.fiap.habitos.service.HabitoService;

@RestController //controlado do Spring, fornece metodos de requisição para a aplicação
@RequestMapping("/api") //Mapeia a URL /api para o controlador

public class HabitoController {
    
    @Autowired //traz a classe de serviço para o controlador

    private HabitoService habitoService;

    @PostMapping("/habitos")
    @ResponseStatus (HttpStatus.CREATED) //Retorna o status 201 Created quando o habito é salvo com sucesso
    public Habito salvar(@RequestBody Habito habito) {
        return habitoService.salvar(habito); //Chama o método salvar do serviço, passando o objeto habito recebido na requisição
    }

    @GetMapping("/habitos")
    @ResponseStatus(HttpStatus.OK) //Retorna o status 200 OK quando a lista de habitos é retornada com sucesso
    public List<Habito> listarTodos() {
        return habitoService.listarTodos();
    }

    @GetMapping("/habitos/{id}")
    @ResponseStatus (HttpStatus.OK) //Retorna o status 200 OK quando o habito é retornado com sucesso
    public Habito ListarPorId(@PathVariable Long id) {
        return habitoService.listarPorId(id);
    } //@PathVariable indica que o valor do parâmetro id será obtido da URL da requisição, no caso, o valor do id será obtido da URL /habitos/{id}.

    @DeleteMapping("/habitos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //Retorna o status 204 No Content quando o habito é deletado com sucesso
    public void excluir(@PathVariable Long id) {
        habitoService.deletar(id);
    } 

    @PutMapping("/habitos/{id}")
    @ResponseStatus(HttpStatus.OK) //Retorna o status 200 OK quando o habito é atualizado com sucesso
    public Habito atualizar(@RequestBody Habito habito) {
        return habitoService.atualizar(habito);
    }


}
