package com.julia.paginacao.controller;

import com.julia.paginacao.model.Pessoa;
import com.julia.paginacao.service.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    public PessoaService service;

    public PessoaController(PessoaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    } //responseEntity controla a resposta http

    @GetMapping("/paginacao-listada")
    public ResponseEntity <List<Pessoa>> paginarComLista(@RequestParam int pagina, @RequestParam int itens){
        return ResponseEntity.ok(service.paginarComLista(pagina, itens));
    }


    @GetMapping("/paginacao")
    public ResponseEntity<Page<Pessoa>> paginarTodos(Pageable pageable) {
        return ResponseEntity.ok(service.paginarTodos(pageable));
    } //pageable não precisa de RequestParam porque o spring já faz a associação


    @GetMapping("/parametros")
    public ResponseEntity<Page<Pessoa>> paginarComParametros(@RequestParam int pagina, @RequestParam int itens){
        return ResponseEntity.ok(service.paginarComParametros(pagina, itens));
    } //boa prática especificar o que será devolvido: <Page<pessoa>>
}