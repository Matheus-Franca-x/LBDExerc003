package controller;

import java.sql.SQLException;
import java.util.List;

import model.Viagem;

public class ViagemController implements ICrud<Viagem>
{

	@Override
	public void cadastrar(Viagem v) throws SQLException, ClassNotFoundException
	{
		
	}

	@Override
	public void alterar(Viagem v) throws SQLException, ClassNotFoundException
	{
		
	}

	@Override
	public void excluir(Viagem v) throws SQLException, ClassNotFoundException 
	{
		
	}

	@Override
	public Viagem buscar(Viagem v) throws SQLException, ClassNotFoundException 
	{
		return null;
	}

	@Override
	public List<Viagem> listar() throws SQLException, ClassNotFoundException 
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
