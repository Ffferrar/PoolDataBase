package logic.controller;

import logic.docs.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Контроллер отвечает за главную страницу для входа, **/
@Controller
public class StartPageController {

    @GetMapping("/startpage")
    public String startPage(Model model) {
        return "StartPage";
    }

}
