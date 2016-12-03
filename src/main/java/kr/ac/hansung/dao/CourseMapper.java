package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Course;


public class CourseMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
		Course course = new Course();
		course.setYear(rs.getInt("year"));
		course.setSemester(rs.getInt("semester"));
		course.setCode(rs.getString("code"));
		course.setName(rs.getString("name"));
		course.setClassify(rs.getString("classify"));
		course.setCredit(rs.getInt("credit"));

		return course;
	}

}
