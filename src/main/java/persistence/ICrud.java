package persistence;

import java.sql.SQLException;
import java.util.List;

public interface ICrud<T> 
{
	void cadastrar() throws SQLException, ClassNotFoundException;
	void alterar() throws SQLException, ClassNotFoundException;
	void excluir() throws SQLException, ClassNotFoundException;
	T consultar() throws SQLException, ClassNotFoundException;
	List<T> list() throws SQLException, ClassNotFoundException;
}
