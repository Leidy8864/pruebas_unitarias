package com.tecsup.gestion.dao;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Deparment;

public interface DeparmentDAO {
	
	Deparment findDeparment(int id) throws DAOException, EmptyResultException;
	Deparment findDeparmentByName(String name) throws DAOException, EmptyResultException;
	Deparment createDeparment(Deparment deparment) throws DAOException, EmptyResultException;
	void updateDeparment(Deparment deparment) throws DAOException, EmptyResultException;
	int deleteDeparment(int id) throws DAOException, EmptyResultException;
}
