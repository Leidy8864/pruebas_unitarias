package com.tecsup.gestion.services;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Deparment;

public interface DeparmentService {
	Deparment find(int deparment_id) throws DAOException, EmptyResultException;
	Deparment findName(String name) throws DAOException, EmptyResultException;
	Deparment createDeparment(Deparment deparment) throws DAOException, EmptyResultException;
	Deparment updateDeparment(Deparment deparment) throws DAOException, EmptyResultException;
}
