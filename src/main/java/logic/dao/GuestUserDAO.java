package logic.dao;

import logic.user.GuestUser;
import logic.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestUserDAO implements UserDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> allDocs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from GuestUser").list();
    }

    @Override
    public void add(User guestUser){
        Session session = sessionFactory.getCurrentSession();
        session.persist(guestUser);
    }

    @Override
    public void delete(User guestUser){
        Session session = sessionFactory.getCurrentSession();
        session.delete(guestUser);
    }

    @Override
    public void edit(User guestUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(guestUser);
    }

    @Override
    public GuestUser getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(GuestUser.class, id);
    }
}
