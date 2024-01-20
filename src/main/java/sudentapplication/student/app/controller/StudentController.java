package sudentapplication.student.app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sudentapplication.student.app.entity.Student;
import sudentapplication.student.app.service.StudentService;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showHomePage(){

        return "home-page";
    }

    @GetMapping("/showStudent")
    public String showStudent(Model theModel){

        theModel.addAttribute("students", studentService.findAll());

        return "students";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model theModel){

        theModel.addAttribute("student", new Student());

        return "add-student";
    }

    @PostMapping("/processSave")
    public String processAddStudent(@Valid @ModelAttribute("student") Student theStudent,
                                    BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "add-student";
        }
        else {
            studentService.add(theStudent);
            return "redirect:/showStudent";
        }
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("id") int id, Model theModel){

        try{
            theModel.addAttribute("student", studentService.findById(id));
        }
        catch (Exception e){
            theModel.addAttribute("id", id);
            return "student-not-found";
        }

        return "add-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id, Model theModel){

        try{
            studentService.delete(id);
        }
        catch (Exception e){
            theModel.addAttribute("id", id);
            return "student-not-found";
        }

        return "redirect:/showStudent";
    }

    @GetMapping("/updateSpecificStudent")
    public String updateSpecificStudent(){

        return "update-specific-student";
    }

    @GetMapping("/deleteSpecificStudent")
    public String deleteSpecificStudent(){

        return "delete-specific-student";
    }
}
