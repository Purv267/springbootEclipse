package ca.sheridancollege.purv.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.purv.beans.Student;
import ca.sheridancollege.purv.database.*;

@Controller
public class StudentController {

	List<Student> studentList = new CopyOnWriteArrayList<Student>();
	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		model.addAttribute("studentList", studentList);

		// da.insertStudent("");
		return "index";
	}

	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student) {
		System.out.print(student.getName());
		da.insertStudent(student.getName());
		model.addAttribute("studentList", da.getStudents());
		model.addAttribute("student", new Student());
		return "index";
	}

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(Model model, @PathVariable Long id) {
		da.deleteStudent(id);
		model.addAttribute("studentList", da.getStudents());
		model.addAttribute("student", new Student());
		return "index";
	}

//	@GetMapping("/editStudent/{id}")
//	public String editStudent(Model model, @PathVariable Long id) {
//		Student student = da.getStudentById(id).get(0);
//		model.addAttribute("student", student);
//		da.deleteStudent(id);
//		model.addAttribute("studentList", da.getStudents());
//		return "index";
//	}

	@GetMapping("/editStudent/{id}")
	public String editStudent(Model model, @PathVariable Long id) {
		Student student = da.getStudentById(id).get(0);
		model.addAttribute("student", student);
		da.deleteStudent(id);
		model.addAttribute("studentList", da.getStudents());
		return "index";
	}

}
