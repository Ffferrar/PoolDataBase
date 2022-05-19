//package logic.service;
//
//import logic.dao.AdminUserDAO;
//import logic.user.AdminUser;
//import logic.user.Role;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class AdminService implements UserDetailsService {
//    private AdminUserDAO adminUserDAO;
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public void setAdminUserDAO(AdminUserDAO adminUserDAO) {
//        this.adminUserDAO = adminUserDAO;
//    }
//
//    public List<AdminUser> allAdmins() {
//        return adminUserDAO.allAdmins();
//    }
//
//    public void add(AdminUser adminUser) {
//        adminUserDAO.add(adminUser);
//    }
//
//    public boolean delete(AdminUser adminUser) {
//        adminUserDAO.delete(adminUser);
//        return true;
//    }
//
//    public void edit(AdminUser adminUser) {
//        adminUserDAO.edit(adminUser);
//    }
//
//    public AdminUser getById(String id) {
//
//        return adminUserDAO.getById(id);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AdminUser adminUser = adminUserDAO.findByUsername(username);
//        if (adminUser == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return adminUser;
//    }
//
//    public boolean saveUser(AdminUser user) {
//        AdminUser userFromDB = adminUserDAO.findByUsername(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        adminUserDAO.add(user);
//        return true;
//    }
//
//    public List<AdminUser> usergtList(String idMin) {
//        return em.createQuery("SELECT u FROM AdminUser u WHERE u.id > :paramId", AdminUser.class)
//                .setParameter("paramId", idMin).getResultList();
//    }
//}
