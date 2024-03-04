package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Viagem;

public class ViagemDao implements ICrud<Viagem>
{
	
	private GenericDao gDao;
	
	

	public ViagemDao(GenericDao gDao) 
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
	public Viagem consultar() throws SQLException, ClassNotFoundException 
	{
		return null;
	}

	@Override
	public List<Viagem> list() throws SQLException, ClassNotFoundException 
	{
		return null;
	}

}
