package com.julia.paginacao.service;

import com.julia.paginacao.model.Pessoa;
import com.julia.paginacao.repository.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository = repository;
    }

    //retorna todos os registros em forma de lista
    public List<Pessoa> listarTodos(){
        return repository.findAll();
    }


    //retorna apenas a lista de objetos, sem informações da paginação
    public List<Pessoa> paginarComLista(int pagina, int itens){
        return repository.findAll(PageRequest.of(pagina, itens)).getContent();
    }


    //esse parâmetro tem valores default padrão quando não é informado nada: page 0, size 20
    public Page<Pessoa> paginarTodos(Pageable pageable){
        return repository.findAll(pageable);
    }


    public Page<Pessoa> paginarComParametros(int pagina, int itens){
        return repository.findAll(PageRequest.of(pagina, itens));
    }
    //retorna os registros divididos em páginas (conforme os parâmetros) e as informações de paginação
    //(quantos registros, quantas paginas, pagina atual, etc)
}
