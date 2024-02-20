package com.servico.backservico.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.repository.ServicoRepository;

@Service
public class ServicoService {
    
    @Autowired //Para trabalhar com injeção de dependencias
    private ServicoRepository servicoRepository;

    public List<Servico> buscarTodos(){
        return servicoRepository.findAll();
    }

    public Servico inserir(Servico servico){
        //return servicoRepository.save(servico);
        Servico servicoBanco = servicoRepository.save(servico);
        return servicoBanco;
    }

    public Servico alterar(Servico servico){
        //Para garantir que será alterado no banco
        return servicoRepository.saveAndFlush(servico); 
    }

    public void excluir(Long id){
        Servico servico = servicoRepository.findById(id).get();
        servicoRepository.delete(servico);
    }

    public Double buscarValorTotal(){
        return servicoRepository.valorTotal();
    }

    public Map<Integer, Double> obterValorPorMes() {
        Map<Integer, Double> valorPorMes = new HashMap<>();

        List<Object[]> resultado = servicoRepository.valorPorMes();
        for (Object[] obj : resultado) {
            Integer mes = (Integer) obj[0];
            Double somaPorMes = (Double) obj[1];
            valorPorMes.put(mes, somaPorMes);
        }

        return valorPorMes;
    }

}
