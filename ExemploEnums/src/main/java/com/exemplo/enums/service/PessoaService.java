package com.exemplo.enums.service;

import com.exemplo.enums.model.Pessoa;
import com.exemplo.enums.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return this.pessoaRepository.findAll();
    }
}
