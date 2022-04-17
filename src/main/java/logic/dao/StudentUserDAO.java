package logic.dao;

import logic.docs.Document;
import logic.user.StudentUser;
import logic.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


public class StudentUserDAO implements UserDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> allDocs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from StudentUser").list();
    }

    @Override
    public void add(User studentUser){
        Session session = sessionFactory.getCurrentSession();
        session.persist(studentUser);
    }

    @Override
    public void delete(User studentUser){
        Session session = sessionFactory.getCurrentSession();
        session.delete(studentUser);
    }

    @Override
    public void edit(User studentUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(studentUser);
    }

    @Override
    public StudentUser getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StudentUser.class, id);
    }
}
