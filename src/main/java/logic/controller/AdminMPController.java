package logic.controller;

import logic.dao.DocumentDAO;
import logic.docs.Document;
import logic.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class AdminMPController{

    private DocumentService documentService;

    @Autowired
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/")
    public String allDocs(Model modelAndView) {

        List<Document> documentList = documentService.allDocs();
        modelAndView.addAttribute("documentList", documentList);

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
        return "EditPage";
    }

    @PostMapping("/add")
    public String addFilm(@RequestParam("file") MultipartFile file, @ModelAttribute("document") Document document, Model model) {
        Document doc = new Document();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        doc.setName(fileName);
        try {
            doc.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        documentService.add(doc);
        return "redirect:/";
    }
}
