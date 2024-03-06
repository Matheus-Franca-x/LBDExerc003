package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Motorista;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ICrud;
import controller.MotoristaController;

@WebServlet("/motorista")
public class MotoristaServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Motorista> motoristas = new ArrayList<>();
		String erro = "";
		ICrud<Motorista> mControl = new MotoristaController();
		
		try {
			motoristas = mControl.listar();
		} catch (SQLException | ClassNotFoundException e)
		{
			erro = e.getMessage();
			e.printStackTrace();
		} finally {
			request.setAttribute("motoristas", motoristas);
			request.setAttribute("erro", erro);
			
			RequestDispatcher rd = request.getRequestDispatcher("motorista.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String naturalidade = request.getParameter("naturalidade");
		List<Motorista> motoristas = new ArrayList<>();
		
		//saida
		String saida = "";
		String erro = "";
		Motorista m = new Motorista();
		ICrud<Motorista> mControl = new MotoristaController();
		
		try {
			motoristas = mControl.listar();
			if(!cmd.contains("Cadastrar") || !cmd.contains("Alterar"))
			{
				if(mControl.validar(codigo))
				{
					saida = "Código inválido!";
					request.setAttribute("saida", saida);
					request.setAttribute("motoristas", motoristas);
					RequestDispatcher rd = request.getRequestDispatcher("motorista.jsp");
					rd.forward(request, response);
				}
				
				m.setCodigo(Integer.parseInt(codigo));
				m.setNome(nome);
				m.setNaturalidade(naturalidade);
			}
			if(cmd.contains("Cadastrar"))
			{
				mControl.cadastrar(m);
				saida = "Motorista cadastrado com sucesso!";
				m = null;
			}
			if(cmd.contains("Alterar"))
			{
				mControl.alterar(m);
				saida = "Motorista alterado com sucesso!";
				m = null;
			}
			if(cmd.contains("Excluir"))
			{
				mControl.excluir(m);
				saida = "Motorista excluido com sucesso!";
				m = null;
			}
			if(cmd.contains("Buscar"))
			{
				m = mControl.buscar(m);
			}
		} catch (SQLException | ClassNotFoundException e)
		{
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("motorista", m);
			request.setAttribute("motoristas", motoristas);
			
			RequestDispatcher rd = request.getRequestDispatcher("motorista.jsp");
			rd.forward(request, response);
		}
		
	}

}
