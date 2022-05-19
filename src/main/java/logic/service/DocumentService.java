package logic.service;

import logic.dao.DocumentDAO;
import logic.docs.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocumentService {
    private DocumentDAO documentDAO;

    @Autowired
    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public List<Document> allDocs() {
        return documentDAO.allDocs();
    }

    public void add(Document document) {
        documentDAO.add(document);
    }

    public void delete(Document document) {
        documentDAO.delete(document);
    }

    public void edit(Document document) {
        documentDAO.edit(document);
    }

    public Document getById(String id) {
        return documentDAO.getById(id);
    }

}
