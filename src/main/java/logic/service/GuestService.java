package logic.service;

import logic.dao.GuestUserDAO;
import logic.user.AdminUser;
import logic.user.GuestUser;
import logic.user.Role;
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
public class GuestService implements UserDetailsService{
    @Autowired
    private GuestUserDAO guestUserDAO;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setGuestUserDAO(GuestUserDAO guestUserDAO) {
        this.guestUserDAO = guestUserDAO;
    }

    @Transactional
    public List<GuestUser> allGuests() {
        return guestUserDAO.allGuests();
    }

    @Transactional
    public void add(GuestUser guestUser) {
        guestUserDAO.add(guestUser);
    }

    @Transactional
    public boolean delete(GuestUser guestUser) {
        guestUserDAO.delete(guestUser);
        return true;
    }

    @Transactional
    public void edit(GuestUser guestUser) {
        guestUserDAO.edit(guestUser);
    }

    @Transactional
    public GuestUser getById(String id) {
        return guestUserDAO.getById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GuestUser guestUser = guestUserDAO.findByUsername(username);
        if (guestUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return guestUser;
    }

    @Transactional
    public boolean saveUser(GuestUser user) {
        GuestUser userFromDB = guestUserDAO.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        guestUserDAO.add(user);
        return true;
    }

    @Transactional
    public List<GuestUser> usergtList(String idMin) {
        return em.createQuery("SELECT u FROM GuestUser u WHERE u.id > :paramId", GuestUser.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
