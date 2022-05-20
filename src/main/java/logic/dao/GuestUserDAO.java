package logic.dao;

//import logic.user.AdminUser;
import logic.user.GuestUser;
import logic.user.StudentUser;
import logic.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GuestUserDAO extends JpaRepository<GuestUser, String> {

    GuestUser findByName(String name);

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory){
//        this.sessionFactory = sessionFactory;
//    }
//
//    public List<GuestUser> allGuests() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from GuestUser").list();
//    }
//
//    public void add(GuestUser guestUser){
//        Session session = sessionFactory.getCurrentSession();
//        session.merge(guestUser);
//    }
//
//    public void delete(GuestUser guestUser){
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(guestUser);
//    }
//
//    public void edit(GuestUser guestUser) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(guestUser);
//    }
//
//    public GuestUser getById(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(GuestUser.class, id);
//    }
//
//    public GuestUser findByUsername(String username){
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(GuestUser.class, username);
//    }
}
