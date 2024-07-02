package com.cz.Dao;

import com.cz.Bean.flight;

import java.util.Date;
import java.util.List;

public interface FlightDao {
    public List<flight> getallflights();
    public List<flight> getsomeflights(String dest , Date flytime);
    public List<flight> getdestflights(String dest );
    public List<flight> getflytimeflights(Date flytime);
    public  boolean addflight(String flyid,String flydesc,String destination, String flytime);
    public  boolean deleteflight(Integer id);
    public flight getflightbyid(Integer id);
    public  boolean updateflight(Integer id,String flyid,String flydesc,String destination, String flytime);


}
