package com.tecsup.gestion.dao;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;
	Employee findEmployeeByLogin(String login) throws DAOException, EmptyResultException;
	Employee createEmployee(Employee employee) throws DAOException, EmptyResultException;
	void updateEmployee(Employee employee) throws DAOException, EmptyResultException;
	int deleteEmployee(int id) throws DAOException, EmptyResultException;
}
