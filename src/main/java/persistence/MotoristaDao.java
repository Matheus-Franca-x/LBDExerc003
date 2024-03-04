package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Motorista;

public class MotoristaDao implements ICrud<Motorista>
{
	private GenericDao gDao;

	public MotoristaDao(GenericDao gDao) {
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
	public Motorista consultar() throws SQLException, ClassNotFoundException
	{
		return null;
	}

	@Override
	public List<Motorista> list() throws SQLException, ClassNotFoundException
	{
		return null;
	}

}
