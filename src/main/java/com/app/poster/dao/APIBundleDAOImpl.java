package com.app.poster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.app.poster.model.APIBundle;

@Component("apiBundleDAO")
public class APIBundleDAOImpl implements IAPIBundleDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(APIBundle apiBundle) {
		String sql = "INSERT INTO API_BOX "
				+ "( BUNDLE_NAME, BUNDLE_DESCRIPTION) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { apiBundle.getBundleName(),
				apiBundle.getBundleDescription() });

	}

	@Override
	public void modify(APIBundle apiBundle) {
		String sql = "UPDATE API_BOX "
				+ "SET BUNDLE_NAME =?, BUNDLE_DESCRIPTION =? WHERE ID= ?";
		jdbcTemplate.update(sql, new Object[] { apiBundle.getBundleName(),
				apiBundle.getBundleDescription(), apiBundle.getId() });

	}

	@Override
	public void delete(APIBundle apiBundle) {
		String sql = "DELETE FROM API_BOX "
				+ "WHERE ID= ?";
		jdbcTemplate.update(sql, new Object[] { apiBundle.getId() });

	}

	@Override
	public APIBundle read(APIBundle apiBundle) {
		String sql = "SELECT ID,BUNDLE_NAME,BUNDLE_DESCRIPTION from API_BOX";
		APIBundle apiBundleResult = new APIBundle();
		apiBundleResult = jdbcTemplate
				.queryForObject(sql, apiBundleRowMapper());
		return apiBundleResult;

	}

	@Override
	public List<APIBundle> readAll() {
		String sql = "SELECT ID,BUNDLE_NAME,BUNDLE_DESCRIPTION from API_BOX";
		List<APIBundle> apiBundleList = new ArrayList<APIBundle>();
		apiBundleList = jdbcTemplate.query(sql, apiBundleRowMapper());
		return apiBundleList;
	}

	private RowMapper<APIBundle> apiBundleRowMapper() {
		return new RowMapper<APIBundle>() {

			public APIBundle mapRow(ResultSet result, int arg1)
					throws SQLException {
				APIBundle apiBundle = new APIBundle();
				apiBundle.setId(result.getInt("ID"));
				apiBundle.setBundleName(result.getString("BUNDLE_NAME"));
				apiBundle.setBundleDescription(result
						.getString("BUNDLE_DESCRIPTION"));

				return apiBundle;
			}

		};
	}

}
