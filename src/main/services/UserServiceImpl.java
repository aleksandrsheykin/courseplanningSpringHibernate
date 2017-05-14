package main.services;

import main.exceptions.UserException;
import main.models.dao.UserDao;
import main.models.dao.UserDaoImpl;
import main.models.entity.User;
import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 21.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private UserDao userDao;
    private User user;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean userExist(String mail) {
        return userDao.userExist(mail);
    }

    @Override
    public User registration(String mail, String password, String firstName, String lastName, Integer limit) {
        user = new User(firstName, lastName, mail, password, limit, "ROLE_USER", false);
        userDao.save(user);
        return user;
    }
}
