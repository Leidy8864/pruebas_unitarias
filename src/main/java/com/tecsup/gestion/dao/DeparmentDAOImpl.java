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
import com.tecsup.gestion.mapper.DeparmentMapper;
import com.tecsup.gestion.model.Deparment;

@Repository
public class DeparmentDAOImpl implements DeparmentDAO{

	private static final Logger logger = LoggerFactory.getLogger(DeparmentDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Deparment findDeparment(int deparment_id) throws DAOException, EmptyResultException {
		String query = "SELECT deparment_id, name, description, city"
				+ " FROM deparments WHERE deparment_id = ?";

		Object[] params = new Object[] { deparment_id };

		try {
			Deparment dep = (Deparment) jdbcTemplate.queryForObject(query, params, new DeparmentMapper());
			return dep;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Deparment findDeparmentByName(String name) throws DAOException, EmptyResultException {
		String query = "SELECT deparment_id, name, description, city "
				+ " FROM deparments WHERE name = ?";

		Object[] params = new Object[] { name };

		try {

			Deparment dep = (Deparment) jdbcTemplate.queryForObject(query, params, new DeparmentMapper());
			return dep;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Deparment createDeparment(final Deparment deparment) throws DAOException, EmptyResultException {
		try {
			final String query = "INSERT INTO deparments(deparment_id, name, description, city) VALUES (?,?,?,?)";
			
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	                ps.setInt(1, deparment.getDeparmentId());
	                ps.setString(2, deparment.getName());
	                ps.setString(3, deparment.getDescription());
	                ps.setString(4, deparment.getCity());
	                return ps;
				}
			}, holder);
			
	        return deparment;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void updateDeparment(final Deparment deparment) throws DAOException, EmptyResultException  {
		
		try {
			final String query = "UPDATE deparments SET name='"+deparment.getName()+"', description='"+deparment.getDescription()+"'" +" WHERE deparment_id="+deparment.getDeparmentId();
			
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
    public int deleteDeparment(int id) throws DAOException, EmptyResultException{
	               
        final String query = "DELETE FROM deparments where deparment_id = ?";

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
