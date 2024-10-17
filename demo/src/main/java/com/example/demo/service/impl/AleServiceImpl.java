package com.example.demo.service.impl;

import com.example.demo.model.dto.AleObjeto;
import com.example.demo.service.AleService;
import com.example.demo.repository.impl.AleRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AleServiceImpl implements AleService {
    @Autowired
    private AleRepositoryImpl aleRepository;
    @Override
    public List<AleObjeto> obtem() {
        log.info("Coletando informações do banco de dados");
        return aleRepository.obtem();
    }

    @Override
    public void insere(AleObjeto input) {
        log.info("Inserindo informações do banco de dados");
        aleRepository.insere(input);
    }

    @Override
    public void atualiza(AleObjeto input) {
        log.info("Atualizando informações do banco de dados");
        aleRepository.atualiza(input);
    }

    @Override
    public void deleta(String id) {
        log.info("Deletando informações do banco de dados");
        aleRepository.deleta(id);
    }
}
