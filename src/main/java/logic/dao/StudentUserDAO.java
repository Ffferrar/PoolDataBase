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

}
