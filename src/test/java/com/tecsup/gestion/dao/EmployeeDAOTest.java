package com.tecsup.gestion.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class EmployeeDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOTest.class);

	@Autowired
	private EmployeeDAO employeeDAO;

	@Test
	public void testFindEmployeeById() {

		try {
			//
			Employee emp = employeeDAO.findEmployee(100);
			logger.info(emp.toString());
			assertEquals("jgomez", emp.getLogin());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testFindEmployeeByLogin() {

		try {
			//
			Employee emp = employeeDAO.findEmployeeByLogin("jgomez");
			logger.info(emp.toString());
			System.out.println(emp);
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void createEmployee() {

		try {
			Employee employee = new Employee("lcallupe", "leidy123", "Leidy", "Callupe", 1111, 888);
	        Employee savedEmployee = employeeDAO.createEmployee(employee);
	        Employee newEmployee = employeeDAO.findEmployee(savedEmployee.getEmployeeId());
	        assertNotNull(newEmployee);
	        assertEquals("lcallupe", newEmployee.getLogin());
	        assertEquals("leidy123", newEmployee.getPassword());
	        logger.info(newEmployee.toString());
			
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void updateEmployee() {
		try {
			Employee employee = new Employee("a", "b", "c", "d", 1111, 999);
	        Employee savedEmployee = employeeDAO.createEmployee(employee);
	        Employee newEmployee = employeeDAO.findEmployee(savedEmployee.getEmployeeId());
	        newEmployee.setLogin("lcallupe2");
	        newEmployee.setPassword("leidy12345");
	        employeeDAO.updateEmployee(newEmployee);
			
			Employee updateEmployee = employeeDAO.findEmployee(999);
			logger.info(updateEmployee.toString());
			
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void deleteEmployee() {
		try {
			Employee employee = new Employee("lcallupe2", "leidy12345", "c", "d", 1111, 999);
	        employeeDAO.deleteEmployee(employee.getEmployeeId());
						
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
}

