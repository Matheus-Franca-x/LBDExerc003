package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Onibus;

public class OnibusDao implements ICrud<Onibus>
{
	private GenericDao gDao;
	

	public OnibusDao(GenericDao gDao) 
	{
		this.gDao = gDao;
	}

	@Override
	public void cadastrar() throws SQLException, ClassNotFoundException 
	{
		
	}

	@Override
	public void alterar() throws SQLException, ClassNotFoundException
	{
		
	}

	@Override
	public void excluir() throws SQLException, ClassNotFoundException 
	{
		
	}

	@Override
	public Onibus consultar() throws SQLException, ClassNotFoundException 
	{
		return null;
	}

	@Override
	public List<Onibus> list() throws SQLException, ClassNotFoundException 
	{
		return null;
	}

}
