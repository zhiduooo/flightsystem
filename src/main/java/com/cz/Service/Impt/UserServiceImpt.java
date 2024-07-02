package com.cz.Service.Impt;

import com.cz.Bean.users;
import com.cz.Dao.Impt.FlightDaoImpt;
import com.cz.Dao.Impt.UsersDaoImpt;
import com.cz.Service.UsersService;

import java.util.List;

public class UserServiceImpt implements UsersService {
    @Override
    public users login(String uname, String pwd) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        users u = usersDaoImpt.login(uname,pwd);
        return u;
    }

    @Override
    public boolean register(users u) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        boolean b =  usersDaoImpt.register(u);
        return  b;
    }

    @Override
    public List<users> getallusers() {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        List allusers  = usersDaoImpt.getallusers();
        return  allusers;
    }

    @Override
    public List<users> getsomeusers(String username, Integer age) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        List allusers  = usersDaoImpt.getsomeusers(username,age);
        return  allusers;
    }

    @Override
    public List<users> getusernameusers(String username) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        List allusers  = usersDaoImpt.getusernameusers(username);
        return  allusers;
    }

    @Override
    public List<users> getageusers(Integer age) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        List allusers  = usersDaoImpt.getageusers(age);
        return  allusers;
    }

    @Override
    public boolean adduser(String username, String password, String email, String gender, Integer age, String job) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        Boolean b  = usersDaoImpt.adduser(username,password,email,gender,age,job);
        return  b;
    }

    @Override
    public boolean deleteuser(Integer userid) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        Boolean b  = usersDaoImpt.deleteuser(userid);
        return  b;
    }

    @Override
    public users getuserbyid(Integer userid) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        users u  = usersDaoImpt.getuserbyid(userid);
        return u;
    }

    @Override
    public boolean updateuser(Integer userid, String username, String password, String email, String gender, Integer age, String job) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        Boolean b  = usersDaoImpt.updateuser(userid,username,password,email,gender,age,job);
        return  b;
    }

    @Override
    public boolean updatepassword(String password, String username) {
        UsersDaoImpt usersDaoImpt = new UsersDaoImpt();
        Boolean b  = usersDaoImpt.updatepassword(password,username);
        return  b;
    }
}
