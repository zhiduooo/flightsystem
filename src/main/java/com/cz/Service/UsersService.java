package com.cz.Service;

import com.cz.Bean.users;

import java.util.List;

public interface UsersService {
    public users login(String uname, String pwd);
    public  boolean register(users u);
    public List<users> getallusers();
    public List<users> getsomeusers(String username , Integer age);
    public List<users> getusernameusers(String username );
    public List<users> getageusers(Integer age);
    public  boolean adduser(String username, String password, String email, String gender ,Integer age,String job);
    public  boolean deleteuser(Integer userid);
    public users getuserbyid(Integer userid);
    public  boolean updateuser(Integer userid,String username, String password, String email, String gender ,Integer age,String job);

    public boolean updatepassword(String password,String username);
}
