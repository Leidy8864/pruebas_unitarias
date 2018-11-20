package com.tecsup.gestion.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.EmployeeMapper;
import com.tecsup.gestion.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Employee findEmployee(int employee_id) throws DAOException, EmptyResultException {

		String query = "SELECT employee_id, login, password, first_name, last_name, salary, department_id "
				+ " FROM employees WHERE employee_id = ?";

		Object[] params = new Object[] { employee_id };

		try {

			Employee emp = (Employee) jdbcTemplate.queryForObject(query, params, new EmployeeMapper());
			//
			return emp;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public Employee findEmployeeByLogin(String login) throws DAOException, EmptyResultException {

		String query = "SELECT employee_id, login, password, first_name, last_name, salary, department_id "
				+ " FROM employees WHERE login = ?";

		Object[] params = new Object[] { login };

		try {

			Employee emp = (Employee) jdbcTemplate.queryForObject(query, params, new EmployeeMapper());
			//
			return emp;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public Employee createEmployee(final Employee employee) throws DAOException, EmptyResultException {

		try {
			final String query = "INSERT INTO employees(login, password, first_name, last_name, salary, employee_id) VALUES (?,?,?,?,?,?)";
			
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	                ps.setString(1, employee.getLogin());
	                ps.setString(2, employee.getPassword());
	                ps.setString(3, employee.getFirstname());
	                ps.setString(4, employee.getLastname());
	                ps.setInt(5, employee.getSalary());
	                ps.setInt(6, employee.getEmployeeId());
	                return ps;
				}
			}, holder);
			
			int newUserId = holder.getKey().intValue();
	        employee.setEmployeeId(newUserId);
	        return employee;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
		
	@Override
	public void updateEmployee(final Employee employee) throws DAOException, EmptyResultException  {
		
		try {
			final String query = "UPDATE employees SET login='"+employee.getLogin()+"', password='"+employee.getPassword()+"'" +" WHERE employee_id="+employee.getEmployeeId();
			
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	                ps.execute(query);
					return ps;
				}
			}, holder);

		} catch (EmptyResultDataAccessException e) {
			logger.info("Error: " + e.getMessage());
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
    public int deleteEmployee(int id) throws DAOException, EmptyResultException{
	               
        final String query = "DELETE FROM employees where employee_id = ?";

		try {

			return jdbcTemplate.update(query, new Object[] {Integer.valueOf(id)});

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
    }
}