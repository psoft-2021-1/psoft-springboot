package com.exemplo.enums.service;

import com.exemplo.enums.StatusTrabalhoEnum;
import com.exemplo.enums.dto.PessoaDTO;
import com.exemplo.enums.dto.StatusDTO;
import com.exemplo.enums.model.Pessoa;
import com.exemplo.enums.repository.PessoaRepository;
import com.exemplo.enums.service.excecoes.ExcecaoEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaDTO save(PessoaDTO dto){
        Pessoa entidade = new Pessoa();
        entidade.setNome(dto.getNome());
        entidade.setStatusTrabalho(StringToEnum(dto.getStatusTrabalho()));
        entidade = pessoaRepository.save(entidade);
        return new PessoaDTO(entidade);
    }

    public List<PessoaDTO> findAll() {
        //this.pessoaRepository.findAll()
        //        .stream().map(pessoa -> new PessoaResponseDTO(pessoa)).collect(Collectors.toList());
        List<Pessoa> pessoas = this.pessoaRepository.findAll();
        List<PessoaDTO> pessoasDTO = new ArrayList<>();
        for(Pessoa p : pessoas){
            pessoasDTO.add(new PessoaDTO(p));
        }
        return pessoasDTO;
    }

    public List<StatusDTO> findAllTypes(){
        //Arrays.stream(StatusTrabalhoEnum.values()).map(status -> new StatusDTO(status)).collect(Collectors.toList());
        List<StatusDTO> tipos = new ArrayList<>();
        for(StatusTrabalhoEnum status : StatusTrabalhoEnum.values()){
            tipos.add(new StatusDTO(status));
        }
        return tipos;
    }

    private StatusTrabalhoEnum StringToEnum(String valor){
        try{
            return StatusTrabalhoEnum.valueOf(valor);
        }
        catch(IllegalArgumentException e){
            throw new ExcecaoEnum(Arrays.toString(StatusTrabalhoEnum.values()));
        }
    }
}
