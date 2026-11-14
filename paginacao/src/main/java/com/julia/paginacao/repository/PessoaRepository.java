package com.julia.paginacao.repository;

import com.julia.paginacao.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    //se fosse CrudRepository precisaria de: Page<Pessoa> findAll(Pageable pageable)
}
