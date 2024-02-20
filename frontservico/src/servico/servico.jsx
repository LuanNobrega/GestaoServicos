import React, { useEffect, useState } from 'react';
import './servico.css';
import axios from 'axios';

function Servico() {

  const [servico, setServico] = useState({
    nome: '',
    data: '',
    descricaoServico: '',
    valorServico: ''
  });

  const [servicos, setServicos] = useState([]);
  const [atualizar, setAtualizar] = useState([]);
  const [valorTotalServicos, setValorTotalServicos] = useState(0);

  useEffect(() => {
    buscarTodos();
  }, [atualizar]);

  function limpar() {
    setServico({
      nome: '',
      data: '',
      descricaoServico: '',
      valorServico: ''
    })
  }

  function excluir(id) {
    axios.delete("http://localhost:8080/api/servico/" + id).then(result => {
      setAtualizar(result);
    });
  }

  function buscarTodos() {
    axios.get("http://localhost:8080/api/servico/").then(result => {
      setServicos(result.data);
    })
  }

  function valorTotal() {
    axios.get("http://localhost:8080/api/servico/buscarValorTotal").then(result => {
      setValorTotalServicos(result.data);
    })
  }

  function handlerChange(event) {
    const { name, value } = event.target;
    setServico({ ...servico, [name]: value });
  }

  function handleSubmit(event) {
    event.preventDefault();
    if (servico.id == undefined) {
      console.log("inserir")
      axios.post("http://localhost:8080/api/servico/", servico).then(result => {
        setAtualizar(result);
      });
    } else {
      console.log("alterar")
      axios.put("http://localhost:8080/api/servico/", servico).then(result => {
        setAtualizar(result);
      });
    }
    limpar();
  }

  return (
    <div className="container">
      <h1>Cadastro de Serviços</h1>
      <form onSubmit={handleSubmit}>
        <div className="col-6">
          <div>
            <label className="form-label">Nome do Cliente</label>
            <input onChange={handlerChange} value={servico.nome || ''} name="nome" type="text" className="form-control" placeholder='Digite o nome do cliente' required></input>
          </div>
          <div>
            <label className="form-label">Data do Serviço</label>
            <input onChange={handlerChange} value={servico.data} name="data" type="date" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Descrição do Serviço</label>
            <input onChange={handlerChange} value={servico.descricaoServico || ''} name="descricaoServico" type="text" className="form-control" placeholder='Digite a descrição do serviço' required></input>
          </div>
          <div>
            <label className="form-label">Valor Pago</label>
            <input onChange={handlerChange} value={servico.valorServico || ''} name="valorServico" type="number" className="form-control" placeholder='Digite o valor do cliente' required></input>
          </div>
          <br></br>
          <input type="submit" value="Cadastrar" className='btn btn-success' />&nbsp;&nbsp;
          <button onClick={limpar} className='btn btn-warning'>Limpar Campos</button>
        </div>
      </form>
      <br></br>
      <button onClick={buscarTodos} className='btn btn-primary'>Listar todos</button>&nbsp;&nbsp;
      <button onClick={valorTotal} className='btn btn-secondary'>Valor Total</button>&nbsp;&nbsp;
      <span>{`Valor Total: ${valorTotalServicos}`}</span>
      <button className='btn btn-secondary'>Valor total por mês</button>
      <hr></hr>
      <br></br>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Nome</th>
            <th scope="col">Descrição do Serviço</th>
            <th scope="col">Data</th>
            <th scope="col">Valor do Serviço</th>
            <th scope="col">Opções</th>
          </tr>
        </thead>
        <tbody>
          {servicos.map(serv => (
            <tr key={serv.id}>
              <td></td>
              <td>{serv.nome}</td>
              <td>{serv.descricaoServico}</td>
              <td>{serv.data}</td>
              <td>{serv.valorServico}</td>
              <td>
                <button onClick={() => setServico(serv)} className='btn btn-primary'>Alterar</button>&nbsp;&nbsp;
                <button onClick={() => excluir(serv.id)} className='btn btn-danger'>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Servico;
