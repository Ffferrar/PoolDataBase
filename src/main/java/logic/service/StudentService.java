package logic.service;

import logic.dao.StudentUserDAO;
import logic.user.AdminUser;
import logic.user.GuestUser;
import logic.user.Role;
import logic.user.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService implements UserDetailsService{
    private StudentUserDAO studentUserDAO;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void StudentService() {
        this.studentUserDAO = new StudentUserDAO();
    }

    @Transactional
    public List<StudentUser> allStudents() {
        return studentUserDAO.allStudents();
    }

    @Transactional
    public void add(StudentUser studentUser) {
        studentUserDAO.add(studentUser);
    }

    @Transactional
    public boolean delete(StudentUser studentUser) {
        studentUserDAO.delete(studentUser);
        return true;
    }

    @Transactional
    public void edit(StudentUser studentUser) {
        studentUserDAO.edit(studentUser);
    }

    @Transactional
    public StudentUser getById(String id) {
        return studentUserDAO.getById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StudentUser studentUser = studentUserDAO.findByUsername(username);
        if (studentUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return studentUser;
    }

    public boolean saveUser(StudentUser user) {
        StudentUser userFromDB = studentUserDAO.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        studentUserDAO.add(user);
        return true;
    }

    public List<GuestUser> usergtList(String idMin) {
        return em.createQuery("SELECT u FROM GuestUser u WHERE u.id > :paramId", GuestUser.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
