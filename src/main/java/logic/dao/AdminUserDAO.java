package logic.dao;

import logic.user.AdminUser;
import logic.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminUserDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<AdminUser> allAdmins() {
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
    public AdminUser findByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        return session.get(AdminUser.class, username);
    }
}
