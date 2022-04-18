package logic.service;

import logic.dao.GuestUserDAO;
import logic.user.GuestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GuestService {
    private GuestUserDAO guestUserDAO;

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
    public void delete(GuestUser guestUser) {
        guestUserDAO.delete(guestUser);
    }

    @Transactional
    public void edit(GuestUser guestUser) {
        guestUserDAO.edit(guestUser);
    }

    @Transactional
    public GuestUser getById(String id) {
        return guestUserDAO.getById(id);
    }
}
