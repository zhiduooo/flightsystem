package com.cz.Dao.Impt;

import com.cz.Bean.flight;
import com.cz.Bean.users;
import com.cz.Dao.UsersDao;
import com.cz.Util.DBUtils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersDaoImpt extends DBUtils implements UsersDao {
    @Override
    public users login(String uname, String pwd) {
        users u = null;
        try {
            //操作数据库


            String sql = "select * from users where username=? and password=?";
            List params = new ArrayList<>();
            params.add(uname);
            params.add(pwd);

            resultSet = query(sql,params);
            while (resultSet.next()){
                u = new users();
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return u;

    }

    @Override
    public boolean register(users u) {
        boolean b = false;
        //操作数据库
        try {
            String sql = "insert into users (username,password,email,gender,age,job) values(?,?,?,?,?,? )";
            List params = new ArrayList<>();
            params.add(u.getUsername());
            params.add(u.getPassword());
            params.add(u.getEmali());
            params.add(u.getGender());
            params.add(u.getAge());
            params.add(u.getJob());

            int count = update(sql,params);
            if(count==1){
                b = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return b;
    }

    @Override
    public List<users> getallusers() {
        List allusers = new ArrayList<>();

        try {
            //操作数据库
            String sql = "select * from users";
            resultSet =  query(sql,null);
            while(resultSet.next()){
                users u = new users();
                u.setUserid(resultSet.getInt("userid"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setEmali(resultSet.getString("email"));
                u.setJob(resultSet.getString("job"));
                u.setAge(resultSet.getInt("age"));
                u.setGender(resultSet.getString("gender"));

                allusers.add(u);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return allusers;
    }

    @Override
    public List<users> getsomeusers(String username , Integer age) {
        List allusers = new ArrayList<>();

        try {
            //操作数据库
            String sql = "select * from users where username=? and age=?";
            List params = new ArrayList<>();
            params.add(username);
            params.add(age);
            resultSet =  query(sql,params);
            while(resultSet.next()){
                users u = new users();
                u.setUserid(resultSet.getInt("userid"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setEmali(resultSet.getString("email"));
                u.setJob(resultSet.getString("job"));
                u.setAge(resultSet.getInt("age"));
                u.setGender(resultSet.getString("gender"));

                allusers.add(u);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return allusers;
    }

    @Override
    public List<users> getusernameusers(String username) {
        List allusers = new ArrayList<>();
        try {
            //操作数据库
            String sql = "select * from users where username=?";
            List params = new ArrayList<>();
            params.add(username);
            //System.out.println(params.get(1));

            resultSet =  query(sql,params);
            while(resultSet.next()){
                users u = new users();
                u.setUserid(resultSet.getInt("userid"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setEmali(resultSet.getString("email"));
                u.setJob(resultSet.getString("job"));
                u.setAge(resultSet.getInt("age"));
                u.setGender(resultSet.getString("gender"));

                allusers.add(u);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return allusers;
    }

    @Override
    public List<users> getageusers(Integer age) {
        List allusers = new ArrayList<>();

        try {
            //操作数据库
            String sql = "select * from users where age=?";
            List params = new ArrayList<>();
            params.add(age);
            resultSet =  query(sql,params);
            while(resultSet.next()){
                users u = new users();
                u.setUserid(resultSet.getInt("userid"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setEmali(resultSet.getString("email"));
                u.setJob(resultSet.getString("job"));
                u.setAge(resultSet.getInt("age"));
                u.setGender(resultSet.getString("gender"));

                allusers.add(u);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return allusers;
    }

    @Override
    public boolean adduser(String username, String password, String email, String gender ,Integer age,String job) {

        boolean b = false;

        try {
            //操作数据库
            String sql = "insert into users (username,password,email,gender,age,job) values(?,?,?,?,?,?)";
            List params = new ArrayList<>();
            params.add(username);
            params.add(password);
            params.add(email);
            params.add(gender);
            params.add(age);
            params.add(job);
            int count = update(sql,params);
            if(count==1){
                b = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return b;
    }

    @Override
    public boolean deleteuser(Integer userid) {
        boolean b = false;
        try {
            //操作数据库
            String  sql = "delete from users where userid=?";
            List params = new ArrayList<>();
            params.add(userid);
            int count = update(sql,params);
            if(count == 1){
                b = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return b;
    }

    @Override
    public users getuserbyid(Integer userid) {
        users  u = new users();
        try {
            //操作数据库
            String sql = "select * from users where userid=?";
            List params = new ArrayList<>();
            params.add(userid);
            //System.out.println(params.get(1));


            resultSet =  query(sql,params);
            while(resultSet.next()){
                u.setUserid(resultSet.getInt("userid"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setEmali(resultSet.getString("email"));
                u.setJob(resultSet.getString("job"));
                u.setAge(resultSet.getInt("age"));
                u.setGender(resultSet.getString("gender"));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return u;
    }

    @Override
    public boolean updateuser(Integer userid,String username, String password, String email, String gender ,Integer age,String job) {
        boolean b = false;
        try {
            //操作数据库
            String  sql = "update users set username=? ,password=?,email=?,gender=?,age=?,job=? where userid=?";
            List params = new ArrayList<>();
            params.add(username);
            params.add(password);
            params.add(email);
            params.add(gender);
            params.add(age);
            params.add(job);
            params.add(userid);
            int count = update(sql,params);
            if(count == 1){
                b = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return b;
    }
    @Override
    public boolean updatepassword(String password,String username) {
        boolean b = false;
        try {
            //操作数据库
            String  sql = "update users set password=? where username=?";
            List params = new ArrayList<>();
            params.add(password);
            params.add(username);
            int count = update(sql,params);
            if(count !=0){
                b = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return b;
    }
}
