package logic.service;

import logic.dao.DocumentDAO;
import logic.docs.Document;
import logic.user.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    private DocumentDAO documentDAO;

    @Autowired
    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public List<Document> allDocs() {
        return documentDAO.findAll();
    }

    public void add(Document document) {
        documentDAO.save(document);
    }

    public void delete(Document document) {
        documentDAO.delete(document);
    }

    public Document getById(String id) {
        Optional<Document> userFromDb = documentDAO.findById(id);
        return userFromDb.orElse(new Document());
    }

}
