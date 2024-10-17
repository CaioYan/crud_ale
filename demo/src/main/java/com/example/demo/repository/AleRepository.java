package com.example.demo.repository;

import com.example.demo.model.dto.AleObjeto;

import java.util.List;

public interface AleRepository {
    List<AleObjeto> obtem();
    void insere(AleObjeto input);

    void atualiza(AleObjeto input);

    void deleta(String id);
}
