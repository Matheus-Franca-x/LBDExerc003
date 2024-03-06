package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Onibus;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ICrud;
import controller.OnibusController;

@WebServlet("/onibus")
public class OnibusServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Apenas carrega Onibus.jsp sem nenhum elemento
		List<Onibus> todosOnibus = new ArrayList<>();
		ICrud<Onibus> oControl = new OnibusController();
		
		try {
			todosOnibus = oControl.listar();
		} catch (SQLException | ClassNotFoundException e)
		{
			System.err.print(e);
		} finally {
			request.setAttribute("todosOnibus", todosOnibus);
			
			RequestDispatcher rd = request.getRequestDispatcher("onibus.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//entrada
		String cmd = request.getParameter("botao");
		String placa = request.getParameter("placa");
		String marca = request.getParameter("marca");
		String ano = request.getParameter("ano");
		String descricao = request.getParameter("descricao");
		List<Onibus> todosOnibus = new ArrayList<>();
		
		//saida
		String saida = "";
		String erro = "";
		Onibus o = new Onibus();
		ICrud<Onibus> oControl = new OnibusController();
		
		try {
			if(!cmd.contains("Cadastrar") || !cmd.contains("Alterar"))
			{
				if(!cmd.contains("Buscar"))
				{
					if(oControl.validar(ano))
					{
						saida = "Ano inválido!";
						return;
					}					
					o.setMarca(marca);
					o.setAno(Integer.parseInt(ano));
					o.setDescricao(descricao);
				}
				
				o.setPlaca(placa);
			}
			
			if(cmd.contains("Cadastrar"))
			{
				oControl.cadastrar(o);
				saida = "Onibus cadastrado com sucesso!";
				o = null;
			}
			if(cmd.contains("Alterar"))
			{
				oControl.alterar(o);
				saida = "Onibus alterado com sucesso!";
				o = null;
			}
			if(cmd.contains("Excluir"))
			{
				oControl.excluir(o);
				saida = "Onibus excluido com sucesso!";
				o = null;
			}
			if(cmd.contains("Buscar"))
			{
				o = oControl.buscar(o);
			}
			
			todosOnibus = oControl.listar();
			
		} catch (SQLException | ClassNotFoundException | NumberFormatException e)
		{
			erro = e.getMessage();
		} finally {
			try {
				todosOnibus = oControl.listar();
			} catch (SQLException | ClassNotFoundException e) {
				erro = e.getMessage();
			}
			
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("onibus", o);
			request.setAttribute("todosOnibus", todosOnibus);
			
			RequestDispatcher rd = request.getRequestDispatcher("onibus.jsp");
			rd.forward(request, response);
		}
		
	}

}
