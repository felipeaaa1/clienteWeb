package main;

import java.util.List;

import DAO.ClienteDAO;
import DAO.DataSource;
import br.com.teste.Cliente;

public class MainTeste {
	public static void main(String args[]) {
		DataSource ds = new DataSource();
		ClienteDAO clienteDAO = new ClienteDAO(ds);
		List<Cliente> lista = clienteDAO.readAll();
		if(lista!= null) {
			for (Cliente c: lista)
			System.out.println(c.getNome());
		}
		ds.closeDataSource();
	}
}
