package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProdutoService;
import model.Produto;

@WebServlet("/Excluir.do")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter saida = response.getWriter();
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		
		ProdutoService service = new ProdutoService();
		service.excluirProduto(produto);
		
		saida.println("Produto excluido com sucesso!");
		saida.println("<a href='index.html'>Clique aqui para voltar</a>");	
	}
}
