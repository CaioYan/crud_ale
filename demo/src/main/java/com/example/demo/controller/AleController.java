package com.example.demo.controller;


import com.example.demo.model.dto.AleObjeto;
import com.example.demo.service.AleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("controller")
class AleController{

    @Autowired
    private AleService aleService;

    @GetMapping("/get")
    public List<AleObjeto> obtem(){
        return aleService.obtem();
    }

    @PutMapping("/put")
    public void atualiza(@RequestBody AleObjeto input){
        aleService.atualiza(input);
    }

    @PostMapping("/post")
    public void insere(@RequestBody AleObjeto input){
        aleService.insere(input);
    }

    @DeleteMapping("/delete/{id}")
    public void deleta(@PathVariable String id){
        aleService.deleta(id);
    }
}