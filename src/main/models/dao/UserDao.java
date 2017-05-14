package main.models.dao;

import main.exceptions.UserException;
import main.models.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public interface UserDao {

    void save(User u);
    boolean userExist(String mail);

}