import React, { useState } from "react";
import api from "../services/api";
import "../styles/Clientes.css";

function ClienteForm({ atualizarLista }) {
  const [formData, setFormData] = useState({
    nome: "",
    genero: "",
    dataNascimento: "",
    email: "",
    confirmaEmail: "",
    senha: ""
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (formData.email !== formData.confirmaEmail) {
      alert("Os e-mails não coincidem!");
      return;
    }
    try {
      await api.post("/clientes", formData);
      alert("Cliente cadastrado com sucesso!");
      setFormData({
        nome: "",
        genero: "",
        dataNascimento: "",
        email: "",
        confirmaEmail: "",
        senha: ""
      });
      atualizarLista();
    } catch (error) {
      alert("Erro ao cadastrar cliente: " + error.message);
    }
  };

  return (
    <div className="form-container">
      <h2>Cadastro de Cliente</h2>
      <form className="cliente-form" onSubmit={handleSubmit}>
        <div className="form-row">
          <div className="form-group">
            <label>Nome completo</label>
            <input type="text" name="nome" value={formData.nome} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Gênero</label>
            <select name="genero" value={formData.genero} onChange={handleChange} required>
              <option value="">Selecione o gênero</option>
              <option value="MASCULINO">Masculino</option>
              <option value="FEMININO">Feminino</option>
              <option value="OUTRO">Outro</option>
              <option value="PREFIRO_NAO_DIZER">Prefiro não dizer</option>
            </select>
          </div>
        </div>

        <div className="form-row">
          <div className="form-group">
            <label>Data de nascimento</label>
            <input type="date" name="dataNascimento" value={formData.dataNascimento} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Email</label>
            <input type="email" name="email" value={formData.email} onChange={handleChange} required />
          </div>
        </div>

        <div className="form-row">
          <div className="form-group">
            <label>Confirmar Email</label>
            <input type="email" name="confirmaEmail" value={formData.confirmaEmail} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Senha</label>
            <input type="password" name="senha" value={formData.senha} onChange={handleChange} required />
          </div>
        </div>

        <button type="submit" className="btn-cadastrar">Cadastrar</button>
      </form>
    </div>
  );
}

export default ClienteForm;
