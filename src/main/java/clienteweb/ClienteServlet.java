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
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//	inicializando um obj do tipo dispatcher com o endereço pra onde vai mandar as requisições 
	RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); 
	req.setAttribute("listaReq", listaDeClientes);
	dispatcher.forward(req, resp);
}



@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		tela .jsp ta chamando esse metodo, e aqui pega o que vier do campo "email" colocamos ele no obj Cliente cli e colocamos na ListaDeClientes
		String email = req.getParameter("email");
		Cliente cli = new Cliente();
		cli.setEmail(email);
		listaDeClientes.add(cli);
		
//		aqui chama a tela cliente, logo após a adição, pro, uma linha, contra, duas requisições ao servidor (Requisição extra GET)
//		resp.sendRedirect("cliente");
		
//		aqui atribui mais um atributo ao obj req, no caso a lista atualizada e encaminha pro caminho definido no obj RequestDispatcher
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); 
		req.setAttribute("listaReq", listaDeClientes);
		
		
//		mandar mais um atributo para 
		req.setAttribute("reqMensagem", "deu bom o cadastro");
		dispatcher.forward(req, resp);

		
	}




}
