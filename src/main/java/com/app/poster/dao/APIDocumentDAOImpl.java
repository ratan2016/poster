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
import com.app.poster.model.APIDocument;

@Component("apiDocumentDAO")
public class APIDocumentDAOImpl implements IAPIDocumentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(APIDocument apiDocument) {
		String sql = "INSERT INTO API_DOCUMENT "
				+ "( DOCUMENT_NAME, DOCUMENT_DESCRIPTION, API_BOX_ID) VALUES (?, ?, ?)";
		jdbcTemplate.update(
				sql,
				new Object[] { apiDocument.getDocumentName(),
						apiDocument.getDocumentDescription(),
						apiDocument.getBundleId() });

	}

	@Override
	public void modify(APIDocument apiDocument) {
		String sql = "UPDATE API_DOCUMENT "
				+ "SET DOCUMENT_NAME =?, DOCUMENT_DESCRIPTION =?, API_BOX_ID= ? WHERE ID= ?";
		jdbcTemplate.update(sql, new Object[] { apiDocument.getDocumentName(),
				apiDocument.getDocumentDescription(),
				apiDocument.getBundleId(), apiDocument.getId() });

	}

	@Override
	public void modifyWithContent(APIDocument apiDocument) {
		String sql = "UPDATE API_DOCUMENT "
				+ "SET DOCUMENT_CONTENT =? WHERE ID= ?";
		jdbcTemplate.update(
				sql,
				new Object[] { apiDocument.getDocumentContent(),
						apiDocument.getId() });

	}

	@Override
	public void delete(APIDocument apiDocument) {
		String sql = "DELETE FROM API_DOCUMENT " + "WHERE ID= ?";
		jdbcTemplate.update(sql, new Object[] { apiDocument.getId() });

	}

	@Override
	public APIDocument read(APIDocument apiDocument) {
		String sql = "SELECT ID,DOCUMENT_NAME,DOCUMENT_DESCRIPTION, API_BOX_ID,DOCUMENT_CONTENT from API_DOCUMENT WHERE ID=?";
		APIDocument apiDocumentResult = new APIDocument();
		apiDocumentResult = jdbcTemplate.queryForObject(sql,
				new Object[] { apiDocument.getId() },
				apiDocumentRowMapper(true));
		return apiDocumentResult;

	}

	@Override
	public List<APIDocument> readAll() {
		String sql = "SELECT ID,DOCUMENT_NAME,DOCUMENT_DESCRIPTION, API_BOX_ID from API_DOCUMENT";
		List<APIDocument> apiDocumentList = new ArrayList<APIDocument>();
		apiDocumentList = jdbcTemplate.query(sql, apiDocumentRowMapper(false));
		return apiDocumentList;
	}

	private RowMapper<APIDocument> apiDocumentRowMapper(
			final boolean documentContent) {
		return new RowMapper<APIDocument>() {

			public APIDocument mapRow(ResultSet result, int arg1)
					throws SQLException {
				APIDocument apiDocument = new APIDocument();
				apiDocument.setId(result.getInt("ID"));
				apiDocument.setDocumentName(result.getString("DOCUMENT_NAME"));
				apiDocument.setDocumentDescription(result
						.getString("DOCUMENT_DESCRIPTION"));
				apiDocument.setBundleId(result.getInt("API_BOX_ID"));
				if (documentContent) {
					String content = result.getString("DOCUMENT_CONTENT");
					apiDocument.setDocumentContent(content);
				}
				return apiDocument;
			}

		};
	}

	@Override
	public List<APIDocument> readPerApplication(APIBundle apiBundle) {
		String sql = "SELECT ID,DOCUMENT_NAME,DOCUMENT_DESCRIPTION, API_BOX_ID from API_DOCUMENT WHERE API_BOX_ID=?";
		List<APIDocument> apiDocumentList = new ArrayList<APIDocument>();
		apiDocumentList = jdbcTemplate
				.query(sql, new Object[] { apiBundle.getId() },
						apiDocumentRowMapper(false));
		return apiDocumentList;
	}

}
