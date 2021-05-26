package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;

import com.mysql.cj.xdevapi.PreparableStatement;

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
			PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Cliente> listaDeClientesSQL = new ArrayList<>();
			while (rs.next()) {
				
			}
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
