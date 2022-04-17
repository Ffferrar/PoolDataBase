package logic.service;

import logic.dao.DocumentDAO;
import logic.docs.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocServiceTest {
    private DocumentDAO documentDAO;

    @Autowired
    public void setFilmDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @Transactional
    public List<Document> allDocs() {
        return documentDAO.allDocs();
    }

    @Transactional
    public void add(Document document) {
        documentDAO.add(document);
    }

    @Transactional
    public void delete(Document document) {
        documentDAO.delete(document);
    }

    @Transactional
    public void edit(Document document) {
        documentDAO.edit(document);
    }

    @Transactional
    public Document getById(String id) {
        return documentDAO.getById(id);
    }

}
