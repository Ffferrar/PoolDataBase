package logic.dao;

import logic.docs.Document;
import logic.user.StudentUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentUserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<StudentUser> allDocs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from StudentUser").list();
    }

    public void add(StudentUser studentUser){
        Session session = sessionFactory.getCurrentSession();
        session.persist(studentUser);
    }

    public void delete(StudentUser studentUser){
        Session session = sessionFactory.getCurrentSession();
        session.delete(studentUser);
    }

    public void edit(StudentUser studentUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(studentUser);
    }

    public StudentUser getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StudentUser.class, id);
    }
}
