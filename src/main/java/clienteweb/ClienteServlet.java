package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.Cliente;


@WebServlet(urlPatterns = {"/cliente", "/clienteServlet", "/clienteController"})
public class ClienteServlet extends HttpServlet{
	List<Cliente> listaDeClientes = new ArrayList<>();
	
	
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		super.service(req, resp);
//		metodo para modificar o tipo de char esperado, UTF-8 aceita acentos
	}


@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//	inicializando um obj do tipo dispatcher com o endereço pra onde vai mandar as requisições 
	RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); 
	req.setAttribute("listaReq", listaDeClientes);
	dispatcher.forward(req, resp);
}



@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		Cliente cli = new Cliente();
		cli.setEmail(email);
		listaDeClientes.add(cli);
		resp.getWriter().print("mandou o e-mail: "+ email);
	
		
	}




}
