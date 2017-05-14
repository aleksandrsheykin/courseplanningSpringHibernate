package main.services;

import main.exceptions.UserException;
import main.models.entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 21.04.2017.
 */
public interface UserService {
    boolean userExist(String mail) throws UserException;
    User registration(String mail, String password, String firstName, String lastName, Integer limit);
}
