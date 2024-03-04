package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Motorista;

public class MotoristaController implements ICrud<Motorista>
{

	@Override
	public void cadastrar(Motorista m) throws SQLException, ClassNotFoundException 
	{
		
	}

	@Override
	public void alterar(Motorista m) throws SQLException, ClassNotFoundException 
	{
		
	}

	@Override
	public void excluir(Motorista m) throws SQLException, ClassNotFoundException 
	{
		System.out.println(m.toString());
	}

	@Override
	public Motorista buscar(Motorista m) throws SQLException, ClassNotFoundException 
	{
		return null;
	}

	@Override
	public List<Motorista> listar() throws SQLException, ClassNotFoundException 
	{
		List<Motorista> motoristas = new ArrayList<>();
		
		Motorista m = new Motorista();
		m.setCodigo(1);
		m.setNome("a");
		m.setNaturalidade("s");
		
		motoristas.add(m);
		
		return motoristas;
	}
	
	@Override
	public boolean validar(String v)
	{
		if(v.strip().equals(""))
			return true;
		
		return false;
	}

}
