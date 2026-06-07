import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Clientes from './pages/Clientes'; // aqui você importa o container principal

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/clientes" element={<Clientes />} />
        {/* <Route path="/vendas" element={<Vendas />} /> */}
        {/* <Route path="/dashboard" element={<Dashboard />} /> */}
      </Routes>
    </Router>
  );
}

export default App;
