package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;
import dao.ProdutoDAO;

@WebServlet("/Alterar.do")
public class Alterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter saida = response.getWriter();
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		double valor = Double.parseDouble(request.getParameter("valor"));
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		
		Produto produto = new Produto(codigo, nome, descricao, valor, estoque);
		ProdutoService service = new ProdutoService();
		service.alterarProduto(produto);
		
		saida.println("Produto alterado com sucesso!");
		saida.println("<a href='Listar.do'>Clique aqui para voltar</a>");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		ProdutoDAO produtoDAO = new ProdutoDAO();
		PrintWriter saida = response.getWriter();
				
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Produto produto = produtoDAO.consultar(codigo);
		
		saida.println("<form action='Alterar.do' method='POST'>");
		saida.println("<label>Codigo:<input type='number' value='"+produto.getCodigo()+"' readonly name='codigo'></label>");
		saida.println("<br><label>Nome:<input type='text' value='"+produto.getNome()+"' name='nome'><label>");
		saida.println("<br><label>Descrição:<input type='text' value='"+produto.getDescricao()+"' name='descricao'></label>");
		saida.println("<br><label>Valor: R$<input type='text' value='"+produto.getValor()+"' name='valor'></label>");
		saida.println("<br><label>Estoque: <input type='number' value='"+produto.getEstoque()+"' name='estoque'></label>");
		saida.println("<br><input type='submit' value='Alterar'>");
	}
}
