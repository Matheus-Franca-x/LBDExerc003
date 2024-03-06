package controller;

import java.sql.SQLException;
import java.util.List;

import model.Motorista;
import persistence.GenericDao;
import persistence.MotoristaDao;

public class MotoristaController implements ICrud<Motorista>
{

	@Override
	public void cadastrar(Motorista m) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		MotoristaDao mDao = new MotoristaDao(gDao);
		mDao.cadastrar(m);
		
	}

	@Override
	public void alterar(Motorista m) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		MotoristaDao mDao = new MotoristaDao(gDao);
		mDao.alterar(m);
	}

	@Override
	public void excluir(Motorista m) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		MotoristaDao mDao = new MotoristaDao(gDao);
		mDao.excluir(m);
	}

	@Override
	public Motorista buscar(Motorista m) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		MotoristaDao mDao = new MotoristaDao(gDao);
		m = mDao.consultar(m);
		return m;
	}

	@Override
	public List<Motorista> listar() throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		MotoristaDao mDao = new MotoristaDao(gDao);
		List<Motorista> motoristas = mDao.listar();
		
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
