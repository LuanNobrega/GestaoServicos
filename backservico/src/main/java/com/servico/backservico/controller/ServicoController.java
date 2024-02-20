package com.servico.backservico.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.service.ServicoService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/servico")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;

    @GetMapping("/")
    public List<Servico> buscarTodos(){
        return servicoService.buscarTodos();
    }

    @PostMapping("/")
    public Servico inserir(@RequestBody Servico servico) {
        return servicoService.inserir(servico);
    }
    
    @PutMapping("/")
    public Servico alterar(@RequestBody Servico servico) { // Adicione @RequestBody aqui
        return servicoService.alterar(servico);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        servicoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscarValorTotal")
    public Double buscarValorTotal(){
        return servicoService.buscarValorTotal();
    }

    @GetMapping("/obterValorPorMes")
    public Map<Integer, Double> obterValorPorMes() {
        return servicoService.obterValorPorMes();
    }
}
