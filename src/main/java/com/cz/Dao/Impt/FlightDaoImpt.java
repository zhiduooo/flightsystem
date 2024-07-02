package com.cz.Dao.Impt;

import com.cz.Bean.flight;
import com.cz.Dao.FlightDao;
import com.cz.Util.DBUtils;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDaoImpt extends DBUtils implements FlightDao {
    @Override
    public List<flight> getallflights() {
        List allflights = new ArrayList<>();

        try {
            //操作数据库
            String sql = "select * from flight";
            resultSet =  query(sql,null);
            while(resultSet.next()){
                flight f = new flight();
                f.setId(resultSet.getInt("id"));
                f.setFly_id(resultSet.getString("fly_id"));
                f.setFly_desc(resultSet.getString("fly_desc"));
                f.setDestination(resultSet.getString("destination"));
                f.setFly_time(resultSet.getDate("fly_time"));
                allflights.add(f);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return allflights;
    }

    @Override
    public List<flight> getsomeflights(String dest , Date flytime) {
        List allflights = new ArrayList<>();

        try {
            //操作数据库
            System.out.println(flytime);
            String sql = "select * from flight where destination=? and fly_time=?";
            List params = new ArrayList<>();
            params.add(dest);
            params.add(flytime);
            resultSet =  query(sql,params);
            while(resultSet.next()){
                flight f = new flight();
                f.setId(resultSet.getInt("id"));
                f.setFly_id(resultSet.getString("fly_id"));
                f.setFly_desc(resultSet.getString("fly_desc"));
                f.setDestination(resultSet.getString("destination"));
                f.setFly_time(resultSet.getDate("fly_time"));
                allflights.add(f);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return allflights;
    }

    @Override
    public List<flight> getdestflights(String dest) {
        List allflights = new ArrayList<>();
        try {
            //操作数据库
            String sql = "select * from flight where destination=?";
            List params = new ArrayList<>();
            params.add(dest);
            //System.out.println(params.get(1));


            resultSet =  query(sql,params);
            while(resultSet.next()){
                flight f = new flight();
                f.setId(resultSet.getInt("id"));
                f.setFly_id(resultSet.getString("fly_id"));
                f.setFly_desc(resultSet.getString("fly_desc"));
                f.setDestination(resultSet.getString("destination"));
                f.setFly_time(resultSet.getDate("fly_time"));
                allflights.add(f);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return allflights;
    }

    @Override
    public List<flight> getflytimeflights(Date flytime) {
        List allflights = new ArrayList<>();

        try {
            //操作数据库
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = formatter.format(flytime);
            System.out.println(date);
            String sql = "select * from flight where fly_time=?";
            List params = new ArrayList<>();
            params.add(date);
            resultSet =  query(sql,params);
            while(resultSet.next()){
                flight f = new flight();
                f.setId(resultSet.getInt("id"));
                f.setFly_id(resultSet.getString("fly_id"));
                f.setFly_desc(resultSet.getString("fly_desc"));
                f.setDestination(resultSet.getString("destination"));
                f.setFly_time(resultSet.getDate("fly_time"));
                allflights.add(f);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return allflights;
    }

    @Override
    public boolean addflight(String flyid, String flydesc, String destination, String flytime) {

        /*Date flydatetime = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
           simpleDateFormat.parse(flytime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }*/
        boolean b = false;

        try {
            //操作数据库
            String sql = "insert into flight (fly_id,fly_desc,destination,fly_time) values(?,?,?,?)";
            List params = new ArrayList<>();
            params.add(flyid);
            params.add(flydesc);
            params.add(destination);
            params.add(flytime);
            int count = update(sql,params);
            if(count==1){
                b = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return  b;
    }

    @Override
    public boolean deleteflight(Integer id) {
        boolean b = false;
        try {
            //操作数据库
            String  sql = "delete from flight where id=?";
            List params = new ArrayList<>();
            params.add(id);
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
    public flight getflightbyid(Integer id) {
        flight  f = new flight();
        try {
            //操作数据库
            String sql = "select * from flight where id=?";
            List params = new ArrayList<>();
            params.add(id);
            //System.out.println(params.get(1));


            resultSet =  query(sql,params);
            while(resultSet.next()){
                f.setId(resultSet.getInt("id"));
                f.setFly_id(resultSet.getString("fly_id"));
                f.setFly_desc(resultSet.getString("fly_desc"));
                f.setDestination(resultSet.getString("destination"));
                f.setFly_time(resultSet.getDate("fly_time"));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return f;
    }

    @Override
    public boolean updateflight(Integer id, String flyid, String flydesc, String destination, String flytime) {
        boolean b = false;
        try {
            //操作数据库
            String  sql = "update flight set fly_id=? ,fly_desc=?,destination=?,fly_time=? where id=?";
            List params = new ArrayList<>();
            params.add(flyid);
            params.add(flydesc);
            params.add(destination);
            params.add(flytime);
            params.add(id);
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
}
