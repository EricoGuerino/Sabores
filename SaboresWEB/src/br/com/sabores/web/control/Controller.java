package br.com.sabores.web.control;

import java.util.List;

public interface Controller<T>
{
	void saveController(T t);
	void alterarController(T t);
	void deleteController(T t);
	List<T> findAllController();
	T findOneController(T t);
	
}
