package com.exemplo.enums.controller;

import com.exemplo.enums.model.Pessoa;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@Api("Cadastro de pessoas")
public interface PessoaControllerDocs {

    Pessoa save(Pessoa pessoa);

    List<Pessoa> getAll();
}
