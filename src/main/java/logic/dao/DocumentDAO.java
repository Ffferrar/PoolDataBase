package logic.dao;

import logic.docs.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Document> allDocs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Document").list();
    }

    public List<Document> allDocsById(String userIdParam){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Document where userId = :userIdParam").list();
    }

    public void add(Document document){
        Session session = sessionFactory.getCurrentSession();
        session.persist(document);
    }

    public void delete(Document document){
        Session session = sessionFactory.getCurrentSession();
        session.delete(document);
    }

    public void edit(Document document) {
        Session session = sessionFactory.getCurrentSession();
        session.update(document);
    }

    public Document getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Document.class, id);
    }
}
