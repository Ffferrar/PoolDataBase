package logic.user;

import javax.persistence.Entity;

@Entity
public class AdminUser extends User{
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
