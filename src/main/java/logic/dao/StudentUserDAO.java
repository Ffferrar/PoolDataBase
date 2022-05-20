package logic.dao;

import logic.docs.Document;
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


public interface StudentUserDAO extends JpaRepository<StudentUser, String> {

    StudentUser findByName(String name);

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory){
//        this.sessionFactory = sessionFactory;
//    }
//
//    public List<StudentUser> allStudents() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from StudentUser").list();
//    }
//
//    public void add(StudentUser studentUser){
//        Session session = sessionFactory.getCurrentSession();
//        session.merge(studentUser);
//    }
//
//    public void delete(StudentUser studentUser){
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(studentUser);
//    }
//
//    public void edit(StudentUser studentUser) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(studentUser);
//    }
//
//    public StudentUser getById(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(StudentUser.class, id);
//    }
//
//    //@Transactional
//    public StudentUser findByUsername(String name){
//        Session session = sessionFactory.
//                getCurrentSession();
//        return session.get(StudentUser.class, name);
//    }
}
