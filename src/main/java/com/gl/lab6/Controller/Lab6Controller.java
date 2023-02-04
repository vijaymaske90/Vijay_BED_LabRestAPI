package com.gl.lab6.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gl.lab6.Model.Student;
import com.gl.lab6.Service.StudentService;

@Controller
@RequestMapping("/student")
public class Lab6Controller {
	
	@Autowired 
	private StudentService studentService;
	
	@RequestMapping("/main")
	public String HomePage() {
		return "main";
	}
	
	@RequestMapping("/list")
	public String getWelcome(ModelMap modelMap) {
		List<Student> stud = studentService.fetchAllStudent();
		modelMap.addAttribute("allStudent", stud);
		return "list";
	}
	
	@RequestMapping("/addForm")
	public String addForm(ModelMap modelMap, @ModelAttribute ("student") Student stud, @ModelAttribute ("String") String rError) {
		
		modelMap.addAttribute("student", stud);
		if (rError!=null)
			modelMap.addAttribute("Err", rError);
		return "addForm";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student thestud, ModelMap modelMap, RedirectAttributes ra) {

		String err = "Student already exists";
		String errL = "Fields cannot be blank";

		if (thestud.getStudFirstName().isEmpty() ||thestud.getStudLastName().isEmpty() || thestud.getStudDept().isEmpty()
				|| thestud.getStudCountry().isEmpty()) {
			ra.addFlashAttribute("student", thestud);
			ra.addFlashAttribute("String", errL);
			return "redirect:/student/addForm";
		}

		List<Student> listOfStudents = studentService.fetchAllStudent();
		for (Student stud : listOfStudents) {
			if (stud.getStudFirstName().equalsIgnoreCase(thestud.getStudFirstName())
					&& stud.getStudLastName().equalsIgnoreCase(thestud.getStudLastName())
					&& stud.getStudDept().equalsIgnoreCase(thestud.getStudDept())
					&& stud.getStudCountry().equalsIgnoreCase(thestud.getStudCountry())) {
				System.out.println("STUD" + thestud.toString());
				ra.addFlashAttribute("student", thestud);
				ra.addFlashAttribute("String", err);
				return "redirect:/student/addForm";

			}
			
		}
	    Student studentTemp=null;   
		if(thestud.getStudId()!=0) {
			studentTemp=studentService.fetchStudentById(thestud.getStudId());
			studentTemp.setStudFirstName(thestud.getStudFirstName());
			studentTemp.setStudLastName(thestud.getStudLastName());
			studentTemp.setStudDept(thestud.getStudDept());
			studentTemp.setStudCountry(thestud.getStudCountry());
			
		}
		else
			studentTemp=new Student(thestud);
		studentService.saveStudent(studentTemp);
		return "redirect:/student/list";

	}	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studId") int studId, ModelMap modelMap) {
		studentService.deleteStudentById(studId);	
		return "redirect:/student/list"; 
	}
	
	@RequestMapping("/showFormUpdate")
	public String update(@RequestParam("studId") int studId, ModelMap modelMap) {
		Student stud = studentService.fetchStudentById(studId);
		modelMap.addAttribute("student", stud);
		return "addForm";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
	}
}
