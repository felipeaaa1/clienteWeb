package br.com.teste.service;

import java.util.ArrayList;
import java.util.List;

import DAO.ClienteDAO;
import DAO.DataSource;
import br.com.teste.Cliente;

public class ClienteService {

//	DataSource dataSource = new DataSource();
//	ClienteDAO clienteDAO = new ClienteDAO(dataSource);
//	List<Cliente> listaDeClientes = clienteDAO.readAll();

	List<Cliente> listaDeClientes = new ArrayList<>();
	
	
	 public void cadastrar(Cliente cliente) {
		 listaDeClientes.add(cliente);
	 }
	 public List<Cliente> getTodosClientes() {
		 return listaDeClientes;
	 }
	 public void excluir(int indice) {
		 listaDeClientes.remove(indice);
	}
	public Cliente buscarPorIndice(int indice) {
		return listaDeClientes.get(indice);
	}
	public void salvar(int indice, Cliente cliente) {
		if(indice != -1) {
			listaDeClientes.set(indice, cliente);
		}
		else { 
			listaDeClientes.add(cliente);
		}
	}
}
