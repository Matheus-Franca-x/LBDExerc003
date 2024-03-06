package controller;

import java.sql.SQLException;
import java.util.List;

import model.Onibus;
import persistence.GenericDao;
import persistence.OnibusDao;

public class OnibusController implements ICrud<Onibus>
{

	@Override
	public void cadastrar(Onibus o) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		OnibusDao oDao = new OnibusDao(gDao);
		oDao.cadastrar(o);
	}

	@Override
	public void alterar(Onibus o) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		OnibusDao oDao = new OnibusDao(gDao);
		oDao.alterar(o);
	}

	@Override
	public void excluir(Onibus o) throws SQLException, ClassNotFoundException
	{
		GenericDao gDao = new GenericDao();
		OnibusDao oDao = new OnibusDao(gDao);
		oDao.excluir(o);
	}

	@Override
	public Onibus buscar(Onibus o) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		OnibusDao oDao = new OnibusDao(gDao);
		o = oDao.consultar(o);
		return o;
	}

	@Override
	public List<Onibus> listar() throws SQLException, ClassNotFoundException
	{
		GenericDao gDao = new GenericDao();
		OnibusDao oDao = new OnibusDao(gDao);
		List<Onibus> todosOnibus = oDao.listar();
		
		return todosOnibus;
	}

	@Override
	public boolean validar(String v) 
	{
		if(v.strip().equals(""))
			return true;
		
		return false;
	}

}
