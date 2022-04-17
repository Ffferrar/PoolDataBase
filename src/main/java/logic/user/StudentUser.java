package logic.user;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "studentuser")

public class StudentUser extends User{

    @Column(name = "course")
    private int course;

    @Column(name = "department")
    private int department;

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
