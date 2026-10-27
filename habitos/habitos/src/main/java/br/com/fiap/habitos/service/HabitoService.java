package br.com.fiap.habitos.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.fiap.habitos.model.Habito;
import br.com.fiap.habitos.repository.HabitoRepository;

@Service //Serviço do Spring, fornece metodos de negócio para a aplicação
public class HabitoService {

    @Autowired //Injeção de dependência do Spring, permite que o Spring gerencie a criação e o ciclo de vida do objeto

    private HabitoRepository habitoRepository; 

    public Habito salvar(Habito habito) {
        return habitoRepository.save(habito); //Salva o habito no banco de dados
    } // Método salvar recebe um objeto do tipo Habito  e retorna um objeto do tipo Habito, o método save é um método do Spring Data JPA que salva o objeto no banco de dados.

    public List<Habito> listarTodos() {
        return habitoRepository.findAll(); //Retorna uma lista de todos os habitos cadastrados no banco de dados
    }

    public Habito listarPorId(Long id) {
        Optional<Habito> habitoOptional = habitoRepository.findById(id); //Retorna um objeto do tipo Optional<Habito> que pode ou não conter um objeto do tipo Habito, o método findById é um método do Spring Data JPA que busca um objeto no banco de dados pelo seu id.

        if(habitoOptional.isPresent()) { //isPresent() verifica se o objeto Optional contém um objeto do tipo Habito, se sim, retorna o objeto do tipo Habito contido no Optional, caso contrário, lança uma exceção.
            return habitoOptional.get(); //Retorna o objeto do tipo Habito contido no Optional<Habito>
        } else {
            throw new RuntimeException("Habito não encontrado");
        }
    }

    @DeleteMapping("/habitos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //Retorna o status 204 No Content quando o habito é deletado com sucesso
    public void deletar(@PathVariable Long id) {
        habitoRepository.deleteById(id); //Deleta o habito do banco de dados pelo seu id, o método deleteById é um método do Spring Data JPA que deleta um objeto no banco de dados pelo seu id.
    }

    @PutMapping("/habitos/{id}")
    @ResponseStatus(HttpStatus.OK) //Retorna o status 200 OK quando o habito é atualizado com sucesso
    public Habito atualizar(@RequestBody Habito habito) {
        return habitoRepository.save(habito); //Atualiza o habito no banco de dados, o método save é um método do Spring Data JPA que atualiza um objeto no banco de dados.
    }

}
