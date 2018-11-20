package com.tecsup.gestion.dao;

import static org.junit.Assert.*;
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
import com.tecsup.gestion.model.Deparment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class DeparmentDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(DeparmentDAOTest.class);

	@Autowired
	private DeparmentDAO deparmentDAO;
	
	@Test
	public void testFindDeparmentById() {

		try {
			Deparment dep = deparmentDAO.findDeparment(200);
			logger.info(dep.toString());
			assertEquals("Departamento", dep.getName());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testFindDeparmentByName() {

		try {
			Deparment dep = deparmentDAO.findDeparmentByName("Departamento");
			logger.info(dep.toString());
			System.out.println(dep);
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void createDeparment() {

		try {
			Deparment dep = new Deparment(100, "Departamento1", "Descripcion1", "Lima");
	        Deparment savedDeparment = deparmentDAO.createDeparment(dep);
	        Deparment newDeparment = deparmentDAO.findDeparment(savedDeparment.getDeparmentId());
	        assertNotNull(newDeparment);
	        assertEquals("Departamento1", newDeparment.getName());
	        assertEquals("Descripcion1", newDeparment.getDescription());
	        logger.info(newDeparment.toString());
			
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	 
	@Test
	public void updateDeparment() {
		try {
			Deparment dep = new Deparment(300, "b", "c", "d");
	        Deparment savedDeparment = deparmentDAO.createDeparment(dep);
	        Deparment newDeparment = deparmentDAO.findDeparment(savedDeparment.getDeparmentId());
	        newDeparment.setName("bbb");
	        newDeparment.setDescription("ccc");
	        deparmentDAO.updateDeparment(newDeparment);
			Deparment updateDeparment = deparmentDAO.findDeparment(300);
			logger.info(updateDeparment.toString());
			
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void deleteDeparment() {
		try {
			Deparment dep = new Deparment(300, "bb", "cc", "d");
	        deparmentDAO.deleteDeparment(dep.getDeparmentId());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
}
