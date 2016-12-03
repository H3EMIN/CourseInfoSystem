package kr.ac.hansung.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;

@Service
public class CoursesService {
	private CourseDAO courseDao;
	
	@Autowired
	public void setCourseDao(CourseDAO courseDao){
		this.courseDao = courseDao;
	}
	
	public List<Course> getCurrent(){
		//List<Offer> offers = offersService.getCurrent();
		//model.addAttribute("offers", offers);
		return courseDao.getSignup();
	}
	public List<Course> getOfferbyYearSemester(int year, int semester){
		//List<Offer> offers = offersService.getCurrent();
		//model.addAttribute("offers", offers);
		return courseDao.getCourses(year,semester);
	}
	public int[] getClassify(){
		// = offersService.getCurrent();
		//model.addAttribute("offers", offers);
		List<Course> courses = courseDao.getCourses();
		int []cl = {0,0,0,0,0,0,0};
		for(int i = 0; i<courses.size();i++){
			String classify = courses.get(i).getClassify();
			int credit = courses.get(i).getCredit() ;
			if(classify.contains("전기")) cl[0] += credit;
			else if(classify.contains("전지")) cl[1]+= credit;
			else if(classify.contains("전선")) cl[2]+= credit;
			else if(classify.contains("교필")) cl[3]+= credit;
			else if(classify.contains("핵교")) cl[4]+= credit;
			else if(classify.contains("일교")) cl[5]+= credit;
			cl[6] += credit;
		}
		//   전기 전지  전선 교필 핵교 일교
		return cl;
	}
	public boolean insertCourse(Course course){
		return courseDao.insert(course);
	}
	public List<Course> getYearSemester(){

		return courseDao.getYearSemester();
	}

}
