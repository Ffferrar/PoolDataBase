package logic.controller;

import logic.dao.DocumentDAO;
import logic.docs.Document;
import logic.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AdminMPController{

    private DocumentService documentService;

    @Autowired
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allDocs() {

        List<Document> documentList = documentService.allDocs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MainPage");
        modelAndView.addObject("documentList", documentList);

        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") String id) {
        Document document = documentService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditPage");
        modelAndView.addObject("document", document);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("document") Document document) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        documentService.edit(document);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("document") Document document) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        documentService.add(document);
        return modelAndView;
    }
}
