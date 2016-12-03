package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CoursesService;

@Controller
public class CoursesController {
	private CoursesService coursesService;
	
	@Autowired
	public void setCoursesService(CoursesService coursesService) {
		this.coursesService = coursesService;
	}
	
	@RequestMapping("/semester")
	public String showInfoBySemester(Model model){
		
		List<Course> courseSemester = coursesService.getYearSemester();
		model.addAttribute("courseSemester",courseSemester);

		return "semester";
	}
	@RequestMapping("/moresemester")
	public String showInfoByYearSemester(Model model,@RequestParam("year")int year,@RequestParam("semester")int semester){
		List<Course> courseMoreInfo = coursesService.getOfferbyYearSemester(year,semester);
		model.addAttribute("courseMoreInfo",courseMoreInfo);

		return "moresemester";
	}
	
	@RequestMapping("/classify")
	public String showInfoByClassify(Model model){
		int [] cl = coursesService.getClassify();
		model.addAttribute("cl",cl);
		return "classify";
	}
	@RequestMapping("/signup")
	public String signup(Model model){
		model.addAttribute("course", new Course());
		//List<Offer> offers = offersService.getCurrent();
		//model.addAttribute("offers", offers);
		
		return "signup";
	}
	@RequestMapping(value = "/signup.do", method=RequestMethod.POST)
	public String signupClass(@Valid Course course, BindingResult result){
		coursesService.insertCourse(course);
		//List<Offer> offers = offersService.getCurrent();
		//model.addAttribute("offers", offers);
		if(result.hasErrors()){
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors){
				System.out.println(error.getDefaultMessage());
			}
			return "signup";
		}
		return "home";
	}
	
	@RequestMapping("/signupinfo")
	public String showSignupClassInfo(Model model){
		List<Course> signupCourse = coursesService.getCurrent();
		model.addAttribute("signupCourse",signupCourse);
		return "signupinfo";
	}

}
