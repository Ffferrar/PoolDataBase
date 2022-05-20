package logic.service;

import logic.dao.GuestUserDAO;
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

    public List<GuestUser> allGuests() {
        return guestUserDAO.findAll();
    }

    public GuestUser getById(String id) {
        Optional<GuestUser> userFromDb = guestUserDAO.findById(id);
        return userFromDb.orElse(new GuestUser());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GuestUser guestUser = guestUserDAO.findByName(username);
        if (guestUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return guestUser;
    }

    public boolean saveUser(GuestUser user) {
        GuestUser userFromDB = guestUserDAO.findByName(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        guestUserDAO.save(user);
        return true;
    }

    public List<GuestUser> usergtList(String idMin) {
        return em.createQuery("SELECT u FROM GuestUser u WHERE u.id > :paramId", GuestUser.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
