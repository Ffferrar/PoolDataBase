package logic.controller;

import logic.service.AdminService;
import logic.service.DocumentService;
import logic.service.GuestService;
import logic.service.StudentService;
import logic.user.GuestUser;
import logic.user.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/preRegistration")
    public ModelAndView preRegistration() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("preRegPage");

        return modelAndView;
    }

    @GetMapping("/studentRegistration")
    public ModelAndView studentRegistration() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("StudentRegPage");

        modelAndView.addObject("studentUserForm", new StudentUser());

        return modelAndView;
    }

    @PostMapping("/studentRegistration")
    public ModelAndView addStudentUser(@ModelAttribute("studentUserForm") StudentUser studentUser, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();


        if (bindingResult.hasErrors()) {
            modelAndView.addObject("pabindingError", "Ошибка");
            modelAndView.setViewName("StudentRegPage");
            return modelAndView;
        }
        if (!studentUser.getPassword().equals(studentUser.getPasswordConfirm())){
            modelAndView.addObject("passwordError", "Пароли не совпадают");
            modelAndView.setViewName("StudentRegPage");
            return modelAndView;
        }
        if (!studentService.saveUser(studentUser)){
            modelAndView.addObject("usernameError", "Пользователь с таким именем уже существует");
            modelAndView.setViewName("StudentRegPage");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/preRegistration");
        studentService.add(studentUser);
        return modelAndView;
    }

    @GetMapping("/guestRegistration")
    public ModelAndView guestRegistration() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("GuestRegPage");

        modelAndView.addObject("guestUserForm", new GuestUser());

        return modelAndView;
    }

    @PostMapping("/guestRegistration")
    public ModelAndView addGuestUser(@ModelAttribute("guestUserForm") GuestUser guestUser, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("GuestRegPage");
            return modelAndView;
        }
        if (!guestUser.getPassword().equals(guestUser.getPasswordConfirm())){
            modelAndView.addObject("passwordError", "Пароли не совпадают");
            modelAndView.setViewName("GuestRegPage");
            return modelAndView;
        }
        if (!guestService.saveUser(guestUser)){
            modelAndView.addObject("usernameError", "Пользователь с таким именем уже существует");
            modelAndView.setViewName("GuestRegPage");
            return modelAndView;
        }
        guestService.saveUser(guestUser);

        modelAndView.setViewName("redirect:/documentsPage");
        return modelAndView;
    }
}
