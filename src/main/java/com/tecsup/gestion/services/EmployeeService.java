package com.tecsup.gestion.services;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

public interface EmployeeService {
	Employee find(int employee_id) throws DAOException, EmptyResultException;
	Employee findLogin(String login) throws DAOException, EmptyResultException;
	Employee createEmployee(Employee employee) throws DAOException, EmptyResultException;
	Employee updateEmployee(Employee employee) throws DAOException, EmptyResultException;
}
