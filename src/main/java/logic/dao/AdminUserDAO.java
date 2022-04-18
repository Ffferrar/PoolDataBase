package logic.dao;

import logic.user.AdminUser;
import logic.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminUserDAO implements UserDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> allDocs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from AdminUser").list();
    }

    @Override
    public void add(User adminUser){
        Session session = sessionFactory.getCurrentSession();
        session.persist(adminUser);
    }

    @Override
    public void delete(User adminUser){
        Session session = sessionFactory.getCurrentSession();
        session.delete(adminUser);
    }

    @Override
    public void edit(User adminUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(adminUser);
    }

    @Override
    public AdminUser getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(AdminUser.class, id);
    }
}
