package com.exemplo.enums.controller;

import com.exemplo.enums.dto.PessoaDTO;
import com.exemplo.enums.dto.PessoaResponseDTO;
import com.exemplo.enums.dto.StatusDTO;
import com.exemplo.enums.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController{

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaResponseDTO save(@RequestBody PessoaDTO pessoa){
        return this.pessoaService.save(pessoa);
    }

    @GetMapping
    public List<PessoaResponseDTO> getAll(){
        return this.pessoaService.findAll();
    }

    @GetMapping("tipos")
    public List<StatusDTO> getTipos(){
        return this.pessoaService.findAllTypes();
    }

}
