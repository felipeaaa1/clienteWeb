package main;

import DAO.DataSource;

public class MainTeste {
	public static void main(String args[]) {
		DataSource ds = new DataSource();
		ds.closeDataSource();
	}
}
