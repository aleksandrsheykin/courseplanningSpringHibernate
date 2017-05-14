package main.models.entity;

import javax.persistence.*;

/**
 * Created by admin on 19.04.2017.
 */
@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(name = "mail", nullable = false, unique = true)
    private String mail;
    private String password;
    private int mouthlimit;
    private String rolename;
    private boolean isblocked;

    public User() {
    }

    public User(String firstname, String lastname, String mail, String password, int mouthlimit, String rolename, boolean isblocked) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
        this.mouthlimit = mouthlimit;
        this.rolename = rolename;
        this.isblocked = isblocked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMouthlimit() {
        return mouthlimit;
    }

    public void setMouthlimit(int mouthlimit) {
        this.mouthlimit = mouthlimit;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public boolean getIsblocked() {
        return isblocked;
    }

    public void setIsblocked(boolean isblocked) {
        this.isblocked = isblocked;
    }

    @Override
    public String toString() {
        return "firstname="+firstname+" lastname="+lastname+" mail="+mail+"id="+id;
    }
}
