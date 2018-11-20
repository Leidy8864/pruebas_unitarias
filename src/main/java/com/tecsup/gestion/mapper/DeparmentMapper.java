package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Deparment;

public class DeparmentMapper implements RowMapper<Deparment>{

	public Deparment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Deparment dep = new Deparment();
		dep.setDeparmentId(rs.getInt("deparment_id"));
		dep.setName(rs.getString("name"));
		dep.setDescription(rs.getString("description"));
		dep.setCity(rs.getString("city"));
		return dep;
	}
}
