package ca.sheridancollege.purv.database;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.purv.beans.Student;

@Repository
public class DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertStudent() {
		// MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		// namedParameters.addValue("name",name);
		String query = "INSERT INTO student(name) VALUES('Lodo bc')";
		int rowsAffected = jdbc.update(query, new HashMap());
		if (rowsAffected > 0)
			System.out.println("Inserted student into database.");
	}

	public void insertStudent(String name) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO student(name) VALUES(:name)";
		namedParameters.addValue("name", name);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted student into database.");
	}

	public List<Student> getStudents() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM student";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public void deleteStudent(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM student WHERE id = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Deleted student " + id + " from database.");
	}

	public List<Student> getStudentById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM student WHERE id = :id";
		namedParameters.addValue("id", id);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
	}

}