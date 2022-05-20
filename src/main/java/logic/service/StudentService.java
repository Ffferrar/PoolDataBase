package logic.service;

import logic.dao.DocumentDAO;
import logic.dao.StudentUserDAO;
//import logic.user.AdminUser;
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
import java.util.Optional;

@Service
public class StudentService implements UserDetailsService{

    @Autowired
    private StudentUserDAO studentUserDAO;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setStudentUserDAO(StudentUserDAO studentUserDAO) {
        this.studentUserDAO = studentUserDAO;
    }

    public List<StudentUser> allStudents() {
        return studentUserDAO.findAll();
    }

    public boolean delete(StudentUser studentUser) {
        studentUserDAO.delete(studentUser);
        return true;
    }

    public StudentUser getById(String id) {
        Optional<StudentUser> userFromDb = studentUserDAO.findById(id);
        return userFromDb.orElse(new StudentUser());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StudentUser studentUser = studentUserDAO.findByName(username);
        if (studentUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return studentUser;
    }

    public boolean saveUser(StudentUser user) {
        StudentUser userFromDB = studentUserDAO.findByName(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        studentUserDAO.save(user);
        return true;
    }

    public List<StudentUser> usergtList(String idMin) {
        return em.createQuery("SELECT u FROM GuestUser u WHERE u.id > :paramId", StudentUser.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
