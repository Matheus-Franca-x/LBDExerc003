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
	public Onibus consultar(Onibus o) throws SQLException, ClassNotFoundException 
	{
		return null;
	}

	@Override
	public List<Onibus> list() throws SQLException, ClassNotFoundException 
	{
		return null;
	}

}
