package logic.controller;

import logic.dao.DocumentDAO;
import logic.docs.Document;
import logic.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TryController {

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


}
