import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';

function Navbar() {
  return (
    <nav className="navbar">
      <h2 className="logo">Fortrek</h2>
      <ul className="nav-links">
        <li><Link to="/clientes">Clientes</Link></li>
        <li><Link to="/vendas">Vendas</Link></li>
        <li><Link to="/dashboard">Dashboard</Link></li>
      </ul>
    </nav>
  );
}

export default Navbar;
