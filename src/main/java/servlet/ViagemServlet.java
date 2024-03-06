package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Motorista;
import model.Onibus;
import model.Viagem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ICrud;
import controller.ViagemController;

@WebServlet("/viagem")
public class ViagemServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Apenas carrega Viagem.jsp sem nenhum elemento
		List<Viagem> viagens = new ArrayList<>();
		ICrud<Viagem> vControl = new ViagemController();
		
		try {
			viagens = vControl.listar();
		} catch (SQLException | ClassNotFoundException e)
		{
			System.err.print(e);
		} finally {
			request.setAttribute("viagens", viagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String onibus = request.getParameter("placaOnibus");
		String motorista = request.getParameter("codigaMotorista");
		String horaSaida = request.getParameter("horaSaida");
		String horaChegada = request.getParameter("horaChegada");
		String partida = request.getParameter("partida");
		String destino = request.getParameter("destino");
		List<Viagem> viagens = new ArrayList<>();
		
		//saida
		String saida = "";
		String erro = "";
		Viagem v = new Viagem();
		Motorista m = new Motorista();
		Onibus o = new Onibus();
		ICrud<Viagem> vControl = new ViagemController();
		
		try {
			viagens = vControl.listar();
			if(!cmd.contains("Cadastrar") || !cmd.contains("Alterar"))
			{
				if(vControl.validar(codigo))
				{
					saida = "Código inválido!";
					request.setAttribute("saida", saida);
					request.setAttribute("viagens", viagens);
					RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
					rd.forward(request, response);
				}
				if(vControl.validar(motorista))
				{
					saida = "Código de motorista inválido!";
					request.setAttribute("saida", saida);
					request.setAttribute("viagens", viagens);
					RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
					rd.forward(request, response);
				}
				if(vControl.validar(horaSaida))
				{
					saida = "Hora de saida inválido!";
					request.setAttribute("saida", saida);
					request.setAttribute("viagens", viagens);
					RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
					rd.forward(request, response);
				}
				if(vControl.validar(horaChegada))
				{
					saida = "Hora de chegada inválido!";
					request.setAttribute("saida", saida);
					request.setAttribute("viagens", viagens);
					RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
					rd.forward(request, response);
				}
				
				v.setCodigo(Integer.parseInt(codigo));
				o.setPlaca(onibus);
				v.setOnibus(o);
				
				m.setCodigo(Integer.parseInt(motorista));
				v.setMotorista(m);
				
				v.setHoraSaida(Integer.parseInt(horaSaida));
				v.setHoraChegada(Integer.parseInt(horaChegada));
				
				v.setPartida(partida);
				v.setDestino(destino);
			}
			if(cmd.contains("Cadastrar"))
			{
				vControl.cadastrar(v);
				saida = "Viagem cadastrado com sucesso!";
				v = null;
			}
			if(cmd.contains("Alterar"))
			{
				vControl.alterar(v);
				saida = "Viagem alterado com sucesso!";
				v = null;
			}
			if(cmd.contains("Excluir"))
			{
				vControl.excluir(v);
				saida = "Viagem excluido com sucesso!";
				v = null;
			}
			if(cmd.contains("Buscar"))
			{
				v = vControl.buscar(v);
			}
		} catch (SQLException | ClassNotFoundException | NumberFormatException e)
		{
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("viagem", v);
			request.setAttribute("viagens", viagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
			rd.forward(request, response);
		}
		
	}

}
