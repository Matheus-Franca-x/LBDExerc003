package controller;

import java.sql.SQLException;
import java.util.List;

import model.Viagem;
import persistence.GenericDao;
import persistence.ViagemDao;

public class ViagemController implements ICrud<Viagem>
{

	@Override
	public void cadastrar(Viagem v) throws SQLException, ClassNotFoundException
	{
		GenericDao gDao = new GenericDao();
		ViagemDao vDao = new ViagemDao(gDao);
		vDao.cadastrar(v);
	}

	@Override
	public void alterar(Viagem v) throws SQLException, ClassNotFoundException
	{
		GenericDao gDao = new GenericDao();
		ViagemDao vDao = new ViagemDao(gDao);
		vDao.alterar(v);
	}

	@Override
	public void excluir(Viagem v) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		ViagemDao vDao = new ViagemDao(gDao);
		vDao.excluir(v);
	}

	@Override
	public Viagem buscar(Viagem v) throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		ViagemDao vDao = new ViagemDao(gDao);
		v = vDao.consultar(v);
		
		return v;
	}

	@Override
	public List<Viagem> listar() throws SQLException, ClassNotFoundException 
	{
		GenericDao gDao = new GenericDao();
		ViagemDao vDao = new ViagemDao(gDao);
		List<Viagem> viagens= vDao.listar();
		
		return viagens;
	}

	@Override
	public boolean validar(String v)
	{
		if(v.strip().equals(""))
			return true;
		
		return false;
	}

}
