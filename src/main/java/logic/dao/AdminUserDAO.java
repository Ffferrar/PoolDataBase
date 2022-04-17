package logic.dao;

import logic.user.AdminUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminUserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<AdminUser> allDocs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from AdminUser").list();
    }

    public void add(AdminUser adminUser){
        Session session = sessionFactory.getCurrentSession();
        session.persist(adminUser);
    }

    public void delete(AdminUser adminUser){
        Session session = sessionFactory.getCurrentSession();
        session.delete(adminUser);
    }

    public void edit(AdminUser adminUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(adminUser);
    }

    public AdminUser getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(AdminUser.class, id);
    }
}
