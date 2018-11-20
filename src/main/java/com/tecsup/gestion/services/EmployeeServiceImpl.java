package com.tecsup.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.EmployeeDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}

	@Override
	public Employee findLogin(String login) throws DAOException, EmptyResultException {
		Employee emp = employeeDAO.findEmployeeByLogin(login);

		return emp;
	}

	@Override
	public Employee createEmployee(Employee employee) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}
	
}


