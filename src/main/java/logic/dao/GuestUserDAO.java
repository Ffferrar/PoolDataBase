package logic.dao;

import logic.user.GuestUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuestUserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public List<GuestUser> allDocs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from GuestUser").list();
    }

    public void add(GuestUser guestUser){
        Session session = sessionFactory.getCurrentSession();
        session.persist(guestUser);
    }

    public void delete(GuestUser guestUser){
        Session session = sessionFactory.getCurrentSession();
        session.delete(guestUser);
    }

    public void edit(GuestUser guestUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(guestUser);
    }

    public GuestUser getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(GuestUser.class, id);
    }
}
