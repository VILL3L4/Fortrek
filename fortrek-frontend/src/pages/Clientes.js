import React, { useEffect, useState } from "react";
import api from "../services/api";
import ClienteForm from "./ClienteForm";
import ClienteList from "./ClienteList";
import "../styles/Clientes.css";

function Clientes() {
  const [clientes, setClientes] = useState([]);
  const [loading, setLoading] = useState(false);
  const [accordionOpen, setAccordionOpen] = useState("form");

  const carregarClientes = async () => {
    setLoading(true);
    try {
      const response = await api.get("/clientes");
      setClientes(response.data);
    } catch (error) {
      console.error("Erro ao carregar clientes:", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    carregarClientes();
  }, []);

  return (
    <div className="clientes-page">
      <div className="clientes-header">
        <h1>Gestão de Clientes</h1>
      </div>

      <div className="accordion">
        {/* Accordion Cadastro */}
        <div className={`accordion-item ${accordionOpen === "form" ? "open" : ""}`}>
          <button
            className="accordion-title"
            onClick={() =>
              setAccordionOpen(accordionOpen === "form" ? null : "form")
            }
          >
            Dados do cliente
            <span className="accordion-icon">
              {accordionOpen === "form" ? "▲" : "▼"}
            </span>
          </button>
          <div className="accordion-content">
            {accordionOpen === "form" && (
              <ClienteForm atualizarLista={carregarClientes} />
            )}
          </div>
        </div>

        {/* Accordion Lista */}
        <div className={`accordion-item ${accordionOpen === "list" ? "open" : ""}`}>
          <button
            className="accordion-title"
            onClick={() =>
              setAccordionOpen(accordionOpen === "list" ? null : "list")
            }
          >
            Lista de Clientes
            <span className="accordion-icon">
              {accordionOpen === "list" ? "▲" : "▼"}
            </span>
          </button>
          <div className="accordion-content">
            {accordionOpen === "list" && (
              loading ? (
                <p className="loading-text">Carregando clientes...</p>
              ) : (
                <ClienteList clientes={clientes} />
              )
            )}
          </div>
        </div>
      </div>
    </div>
  );
}

export default Clientes;
