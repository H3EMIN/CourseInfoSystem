package kr.ac.hansung.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;
@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount(){
		String sqlStatement = "select count(*) from courseinfo";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
		
	}
	public Course getCourse(String name){
		String sqlStatement = "select * from courseinfo where name=?";
		return jdbcTemplateObject.queryForObject(sqlStatement,new Object[]{name}, new CourseMapper());
	}
	public List<Course> getCourses(){
		String sqlStatement = "select * from courseinfo";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}
	public List<Course> getSignup(){
		String sqlStatement = "select * from newcourseinfo";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}
	public List<Course> getCourses(int year, int semester){
		String sqlStatement = "select * from courseinfo where year="+year+" and semester="+semester;
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}
	
	public List<Course> getYearSemester(){

		String sqlStatement  = "select year, semester, sum(credit) from courseinfo group by year, semester";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper(){
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCredit(rs.getInt("sum(credit)"));
				return course;
			}
		});
	}
	
	public boolean insert(Course course){
		String code = course.getCode();
		String name = course.getName();
		String classify = course.getClassify();
		int credit = course.getCredit();
		int semester = course.getSemester();
		int year = course.getYear();
		String sqlStatement = "insert into newcourseinfo (year, semester, code, name, classify, credit) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement,new Object []{year, semester, code, name, classify, credit}) == 1);
	}
	public boolean delete(int code){
		String sqlStatement = "delete from courseinfo where code=?";
		return (jdbcTemplateObject.update(sqlStatement,new Object[]{code})==1);
	}
}
