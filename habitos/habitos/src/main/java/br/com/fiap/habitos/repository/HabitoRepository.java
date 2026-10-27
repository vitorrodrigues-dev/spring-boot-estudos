package br.com.fiap.habitos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.habitos.model.Habito;

public interface HabitoRepository extends JpaRepository<Habito, Long> {
    
}
