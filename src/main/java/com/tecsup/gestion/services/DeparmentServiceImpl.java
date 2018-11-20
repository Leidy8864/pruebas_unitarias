package com.tecsup.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.DeparmentDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Deparment;

@Service
public class DeparmentServiceImpl implements DeparmentService{

	@Autowired
	private DeparmentDAO deparmentDAO;
	
	@Override
	public Deparment find(int deparment_id) throws DAOException, EmptyResultException {
		Deparment dep = deparmentDAO.findDeparment(deparment_id);

		return dep;
	}

	@Override
	public Deparment findName(String name) throws DAOException, EmptyResultException {
		Deparment dep = deparmentDAO.findDeparmentByName(name);

		return dep;
	}

	@Override
	public Deparment createDeparment(Deparment deparment) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deparment updateDeparment(Deparment deparment) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

}
