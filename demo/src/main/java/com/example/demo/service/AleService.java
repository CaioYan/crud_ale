package com.example.demo.service;

import com.example.demo.model.dto.AleObjeto;

import java.util.List;

public interface AleService {
    List<AleObjeto> obtem();
    void insere(AleObjeto input);

    void atualiza(AleObjeto input);

    void deleta(String id);
}
