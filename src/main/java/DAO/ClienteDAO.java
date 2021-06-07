package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.Cliente;

public class ClienteDAO {

	
	private DataSource dataSource;
	
	public ClienteDAO(DataSource dataSource) {
		this.dataSource = dataSource;

	}
	public ArrayList<Cliente> readAll(){
		try {
//			tentando passar uma querry  
			String SQL = "SELECT * FROM cliente";
//			criando um obj ps que formúla uma requisição
			PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			
			
			ArrayList<Cliente> listaDeClientesSQL = new ArrayList<>();
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setId(rs.getInt("id"));
				cli.setNome(rs.getString("nome"));
				cli.setTelefone(rs.getString("telefone"));
				cli.setEmail(rs.getString("email"));
				listaDeClientesSQL.add(cli);
			}
			ps.close();
			return listaDeClientesSQL;
		}
		catch(SQLException ex){
			System.err.println("erro de SQL..."+ex.getMessage());
		}
		catch(Exception ex) {
			System.err.println("erro geral..."+ex.getMessage());
		}
		
		
		return null;
	}
}
