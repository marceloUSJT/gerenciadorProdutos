package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

@WebServlet("/Cadastrar.do")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		double valor = Double.parseDouble(request.getParameter("valor"));
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		
		Produto produto = new Produto(codigo, nome, descricao, valor, estoque);
		ProdutoService service = new ProdutoService();
		service.cadastrarProduto(produto);
		response.sendRedirect("index.html");
		
	}

}
