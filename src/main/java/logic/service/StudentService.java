package logic.service;

import logic.dao.StudentUserDAO;
import logic.user.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    private StudentUserDAO studentUserDAO;

    @Autowired
    public void setStudentUserDAO(StudentUserDAO studentUserDAO) {
        this.studentUserDAO = studentUserDAO;
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
    public void delete(StudentUser studentUser) {
        studentUserDAO.delete(studentUser);
    }

    @Transactional
    public void edit(StudentUser studentUser) {
        studentUserDAO.edit(studentUser);
    }

    @Transactional
    public StudentUser getById(String id) {
        return studentUserDAO.getById(id);
    }
}
