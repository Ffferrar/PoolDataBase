package logic.dao;

import logic.docs.Document;
import logic.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserDAO {
    List<User> allDocs();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(String id);
}
