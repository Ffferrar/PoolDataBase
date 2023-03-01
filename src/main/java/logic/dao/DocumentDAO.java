package logic.dao;

import logic.docs.Document;
import logic.user.StudentUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentDAO extends JpaRepository<Document, String> {

    StudentUser findByName(String name);

}
