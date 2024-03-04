package controller;

import java.sql.SQLException;
import java.util.List;

import model.Onibus;

public class OnibusController implements ICrud<Onibus>
{

	@Override
	public void cadastrar(Onibus o) throws SQLException, ClassNotFoundException 
	{
		
	}

	@Override
	public void alterar(Onibus o) throws SQLException, ClassNotFoundException 
	{
		
	}

	@Override
	public void excluir(Onibus o) throws SQLException, ClassNotFoundException
	{
		
	}

	@Override
	public Onibus buscar(Onibus o) throws SQLException, ClassNotFoundException 
	{
		return null;
	}

	@Override
	public List<Onibus> listar() throws SQLException, ClassNotFoundException
	{
		return null;
	}

	@Override
	public boolean validar(String v) 
	{
		if(v.strip().equals(""))
			return true;
		
		return false;
	}

}
