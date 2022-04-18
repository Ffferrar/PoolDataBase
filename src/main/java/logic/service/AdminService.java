package logic.service;

import logic.dao.AdminUserDAO;
import logic.user.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    private AdminUserDAO adminUserDAO;

    @Autowired
    public void setGuestUserDAO(AdminUserDAO adminUserDAO) {
        this.adminUserDAO = adminUserDAO;
    }

    @Transactional
    public List<AdminUser> allAdmins() {
        return adminUserDAO.allAdmins();
    }

    @Transactional
    public void add(AdminUser adminUser) {
        adminUserDAO.add(adminUser);
    }

    @Transactional
    public void delete(AdminUser adminUser) {
        adminUserDAO.delete(adminUser);
    }

    @Transactional
    public void edit(AdminUser adminUser) {
        adminUserDAO.edit(adminUser);
    }

    @Transactional
    public AdminUser getById(String id) {
        return adminUserDAO.getById(id);
    }
}
