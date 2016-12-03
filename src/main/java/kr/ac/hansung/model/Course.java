package kr.ac.hansung.model;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.*;

public class Course {
	@Range(min=1900,max = 2020, message="Warning: not presentCentury")
	private int year;
	@Range(min=1,max = 2, message="Warning: not exist semester")
	private int semester;
	@NotEmpty(message="Warning: please input Course's Code")
	@Pattern(regexp="...\\d\\d\\d\\d", message="Warning: please input ex)XXX1111")
	private String code;
	@NotEmpty(message="Warning: please input name")
	private String name;
	@NotEmpty(message="Warning: please input Classify")
	private String classify;
	@Range(min=1, max = 4, message="Warning: please input 1~4")
	private int credit;
	public Course(int year, int semester, String code, String name, String classify, int credit) {
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.classify = classify;
		this.credit = credit;
	}
	public Course() {
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return "[year=" + year + ", semester=" + semester + ", code=" + code + ", name=" + name + ", classify="
				+ classify + ", credit=" + credit + "]";
	}
	
	
}
