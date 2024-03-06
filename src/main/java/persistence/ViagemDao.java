package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Motorista;
import model.Onibus;
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
		Onibus o = v.getOnibus();
		Motorista m = v.getMotorista();
		
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO viagem VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ps.setString(2, o.getPlaca());
		ps.setInt(3, m.getCodigo());
		ps.setInt(4, v.getHoraSaida());
		ps.setInt(5, v.getHoraChegada());
		ps.setString(6, v.getPartida());
		ps.setString(7, v.getDestino());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void alterar(Viagem v) throws SQLException, ClassNotFoundException 
	{
		Onibus o = v.getOnibus();
		Motorista m = v.getMotorista();
		
		Connection c = gDao.getConnection();
		String sql = "UPDATE viagem SET "
				   + "onibus_placa = ?, "
				   + "motorista_codigo = ?, "
				   + "hora_saida = ? "
				   + "hora_chega = ? "
				   + "partida = ? "
				   + "destino = ? "
				   + "WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, o.getPlaca());
		ps.setInt(2, m.getCodigo());
		ps.setInt(3, v.getHoraSaida());
		ps.setInt(4, v.getHoraChegada());
		ps.setString(5, v.getPartida());
		ps.setString(6, v.getDestino());
		ps.setInt(7, v.getCodigo());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void excluir(Viagem v) throws SQLException, ClassNotFoundException 
	{
		Connection c = gDao.getConnection();
		String sql = "DELETE viagem WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Viagem consultar(Viagem v) throws SQLException, ClassNotFoundException 
	{
		Connection c = gDao.getConnection();
		String sql = "SELECT codigo, "
				   + "onibus_placa, "
				   + "motorista_codigo, "
				   + "hora_saida, "
				   + "hora_chegada, "
				   + "partida, "
				   + "destino "
				   + "FROM viagem WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			Onibus o = new Onibus();
			Motorista m = new Motorista();
			
			v.setCodigo(rs.getInt("codigo"));
			o.setPlaca(rs.getString("onibus_placa"));
			v.setOnibus(o);
			m.setCodigo(rs.getInt("motorista_codigo"));
			v.setMotorista(m);
			v.setHoraSaida(rs.getInt("hora_saida"));
			v.setHoraChegada(rs.getInt("hora_chegada"));
			v.setPartida(rs.getString("partida"));
			v.setDestino(rs.getString("destino"));
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return v;
	}

	@Override
	public List<Viagem> listar() throws SQLException, ClassNotFoundException 
	{
		List<Viagem> viagens = new ArrayList<Viagem>();
		Connection c = gDao.getConnection();
		String sql = "SELECT codigo, "
				   + "onibus_placa, "
				   + "motorista_codigo, "
				   + "hora_saida, "
				   + "hora_chegada, "
				   + "partida, "
				   + "destino "
				   + "FROM viagem";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Onibus o = new Onibus();
			Motorista m = new Motorista();
			Viagem v = new Viagem();
			
			v.setCodigo(rs.getInt("codigo"));
			o.setPlaca(rs.getString("onibus_placa"));
			v.setOnibus(o);
			m.setCodigo(rs.getInt("motorista_codigo"));
			v.setMotorista(m);
			v.setHoraSaida(rs.getInt("hora_saida"));
			v.setHoraChegada(rs.getInt("hora_chegada"));
			v.setPartida(rs.getString("partida"));
			v.setDestino(rs.getString("destino"));
			
			viagens.add(v);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return viagens;
	}

}
