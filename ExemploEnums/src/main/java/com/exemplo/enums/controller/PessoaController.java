package com.exemplo.enums.controller;

import com.exemplo.enums.model.Pessoa;
import com.exemplo.enums.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController implements PessoaControllerDocs{

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa save(@RequestBody Pessoa pessoa){
        return this.pessoaService.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> getAll(){
        return this.pessoaService.findAll();
    }
}
