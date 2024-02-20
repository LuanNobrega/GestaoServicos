import React, {useEffect, useState} from 'react';
import './servico.css';

function Servico() {
    const [servico, setServico] = useState({nomeCliente:'',data:'',descricaoServico:'',valorpago:''});
    const [servicos, setServicos] = ([]);

    function handlerChange(event){
        const { name, value } = event.target;
        setServico({...servico, [name]: value});
    }

    function handleSubmit(event){
        event.preventDefault();
        console.log(servico)
    }

  return (
    <div className="container">
      <h1>Cadastro de Serviços</h1>
      <form onSubmit={handleSubmit}>
        <div className="col-6">
          <div>
            <label className="form-label">Nome do Cliente</label>
            <input onChange={handlerChange} value={servico.nomeCliente} name="nomeCliente" type="text" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Data do Serviço</label>
            <input onChange={handlerChange} value={servico.data} name="data" type="date" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Descrição do Serviço</label>
            <input onChange={handlerChange} value={servico.descricaoServico} name="descricaoServico" type="text" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Valor Pago</label>
            <input onChange={handlerChange} value={servico.valorpago} name="valorpago" type="number" className="form-control"></input>
          </div>
          <br></br>
          <input type="submit" value="Cadastrar" className='btn btn-success'/>
        </div>
      </form>
    </div>
  );
}

export default Servico;
