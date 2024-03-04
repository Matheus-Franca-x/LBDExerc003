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
	public Viagem consultar(Viagem v) throws SQLException, ClassNotFoundException 
	{
		return null;
	}

	@Override
	public List<Viagem> list() throws SQLException, ClassNotFoundException 
	{
		return null;
	}

}
