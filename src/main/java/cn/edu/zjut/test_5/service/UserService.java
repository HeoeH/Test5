package cn.edu.zjut.test_5.service;
import cn.edu.zjut.test_5.entity.User;
import cn.edu.zjut.test_5.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    private final UserMapper userDao;

    public UserService(UserMapper userDao) {
        this.userDao = userDao;
    }

    public Integer register(String username, String password) {
        return userDao.insert(username, password);
    }

    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
