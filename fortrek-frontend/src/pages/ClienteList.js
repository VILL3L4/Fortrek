import React from "react";
import "../styles/Clientes.css";

function ClienteList({ clientes }) {
  return (
    <div className="clientes-list-container">
      <h2>Lista de Clientes</h2>
      <table className="clientes-tabela">
        <thead>
          <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>Data de Nascimento</th>
            <th>Gênero</th>
          </tr>
        </thead>
        <tbody>
          {clientes.length > 0 ? (
            clientes.map((cliente, index) => (
              <tr key={index}>
                <td>{cliente.nome}</td>
                <td>{cliente.email}</td>
                <td>{cliente.dataNascimento}</td>
                <td>{cliente.genero}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="sem-clientes">
                Nenhum cliente cadastrado ainda.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default ClienteList;
