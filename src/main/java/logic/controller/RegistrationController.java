package logic.controller;

//import logic.service.AdminService;
import logic.service.DocumentService;
import logic.service.GuestService;
import logic.service.StudentService;
import logic.user.GuestUser;
import logic.user.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    private GuestService guestService;
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setGuestService(GuestService guestService) {
        this.guestService = guestService;
    }


    @GetMapping("/preRegistration")
    public String preRegistration(Model model) {
        return "preRegPage";
    }

    @GetMapping("/studentRegistration")
    public String studentRegistration(Model model) {
        model.addAttribute("studentUserForm", new StudentUser());
        return "StudentRegPage";
    }

    @PostMapping("/studentRegistration")
    public String addStudentUser(@ModelAttribute("studentUserForm") StudentUser studentUser, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            model.addAttribute("pabindingError", "Ошибка");
            return "StudentRegPage";
        }
        if (!studentUser.getPassword().equals(studentUser.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "StudentRegPage";
        }
        if (!studentService.saveUser(studentUser)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "StudentRegPage";
        }

        studentService.saveUser(studentUser);
        return "redirect:/";
    }

    @GetMapping("/guestRegistration")
    public String guestRegistration(Model model) {

        model.addAttribute("guestUserForm", new GuestUser());
        return "GuestRegPage";
    }

    @PostMapping("/guestRegistration")
    public String addGuestUser(@ModelAttribute("guestUserForm") GuestUser guestUser, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "GuestRegPage";
        }
        if (!guestUser.getPassword().equals(guestUser.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "GuestRegPage";
        }
        if (!guestService.saveUser(guestUser)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "GuestRegPage";
        }
        guestService.add(guestUser);

        return "redirect:/";
    }

}
