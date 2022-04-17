package logic.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "guestuser")
public class GuestUser extends User{
}
