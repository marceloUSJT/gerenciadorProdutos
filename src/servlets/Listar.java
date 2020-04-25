package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import dao.ProdutoDAO;

@WebServlet("/Listar.do")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayList<Produto> lista = produtoDAO.listarProdutos();
		PrintWriter saida = response.getWriter();
		
		for(int i = 0; i < lista.size(); i++) {
			saida.println("<strong>Código: </strong>"+lista.get(i).getCodigo());
			saida.println("<br><strong>Nome: </strong>"+lista.get(i).getNome());
			saida.println("<br><strong>Descrição: </strong>"+lista.get(i).getDescricao());
			saida.println("<br><strong>Valor:</strong> R$"+lista.get(i).getValor());
			saida.println("<br><strong>Estoque: </strong>"+lista.get(i).getEstoque());
			saida.println("<br><a href='Alterar.do?codigo="+lista.get(i).getCodigo()+"'>Alterar</a>");
			saida.println("<a href='Excluir.do?codigo="+lista.get(i).getCodigo()+"'>Excluir</a>");
			saida.println("<hr>");
		}
	}
}
