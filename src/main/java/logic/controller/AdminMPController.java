package logic.controller;

import logic.dao.DocumentDAO;
import logic.docs.Document;
import logic.service.DocumentService;
import logic.user.StudentUser;
import logic.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminMPController{

    private DocumentService documentService;

    @Autowired
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/")
    public String allDocs(@AuthenticationPrincipal User user, Model modelAndView) {

        modelAndView.addAttribute("UserName", user.getUsername());
        List<Document> documentList = documentService.allDocs();
        List<Document> finalList = new ArrayList<>();

        for (int i = 0; i < documentList.size(); i++){
            if (user.getId().equals(documentList.get(i).getUserId())){
                finalList.add(documentList.get(i));
            }
        }

        modelAndView.addAttribute("documentList", finalList);
        return "MainPage";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") String id, Model model) {
        Document document = documentService.getById(id);
        model.addAttribute("document", document);
        return "EditPage";
    }

    @PostMapping("/edit")
    public String editFilm(@ModelAttribute("document") Document document, Model model) {
        //documentService.edit(document);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("document", new Document());
        return "EditPage";
    }

    @PostMapping("/add")
    public String addFilm(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal User user, @ModelAttribute("document") Document doc, Model model) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        doc.setUserId(user.getId());
        try {
            doc.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        documentService.add(doc);
        return "redirect:/";
    }
}
