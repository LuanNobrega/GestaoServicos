package com.servico.backservico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servico.backservico.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico,Long> {
    
    //Consulta SQL para calcular a soma total dos valores do serviço é definida na anotação
    @Query("SELECT SUM(s.valorServico) FROM Servico s")
    Double valorTotal();

    // Consulta SQL para calcular a soma dos valores do serviço por mês é definida na anotação @Query. É importante notar que esta consulta retorna uma lista de arrays de objetos (List<Object[]>) porque ela retorna os resultados em formato de array, onde o primeiro elemento é o mês e o segundo elemento é a soma dos valores do serviço para esse mês.
    @Query("SELECT MONTH(s.data) AS mes, SUM(s.valorServico) AS soma_por_mes FROM Servico s GROUP BY MONTH(s.data)")
    List<Object[]> valorPorMes();
}
