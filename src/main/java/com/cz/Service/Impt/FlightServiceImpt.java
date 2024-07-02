package com.cz.Service.Impt;

import com.cz.Bean.flight;
import com.cz.Dao.FlightDao;
import com.cz.Dao.Impt.FlightDaoImpt;
import com.cz.Service.FlightService;

import java.util.Date;
import java.util.List;

public class FlightServiceImpt implements FlightService {
    @Override
    public List<flight> getallflights() {
        FlightDaoImpt flightDaoImpt = new FlightDaoImpt();
        List allflights  = flightDaoImpt.getallflights();
        return  allflights;
    }

    @Override
    public List<flight> getsomeflights(String dest, Date flytime) {
        FlightDaoImpt flightDaoImpt = new FlightDaoImpt();
        List allflights  = flightDaoImpt.getsomeflights(dest,flytime);
        return  allflights;
    }

    @Override
    public List<flight> getdestflights(String dest) {
        FlightDaoImpt flightDaoImpt = new FlightDaoImpt();
        List allflights  = flightDaoImpt.getdestflights(dest);
        return  allflights;
    }

    @Override
    public List<flight> getflytimeflights(Date flytime) {
        FlightDaoImpt flightDaoImpt = new FlightDaoImpt();
        List allflights  = flightDaoImpt.getflytimeflights(flytime);
        return  allflights;
    }

    @Override
    public boolean addflight(String flyid, String flydesc, String destination, String flytime) {
        FlightDaoImpt flightDaoImpt = new FlightDaoImpt();
        boolean b = flightDaoImpt.addflight(flyid, flydesc,destination,flytime);
        return  b;
    }

    @Override
    public boolean deleteflight(Integer id) {
        FlightDaoImpt flightDaoImpt = new FlightDaoImpt();
        boolean b = flightDaoImpt.deleteflight(id);
        return  b;
    }

    @Override
    public flight getflightbyid(Integer id) {
        FlightDaoImpt flightDaoImpt = new FlightDaoImpt();
        flight t = flightDaoImpt.getflightbyid(id);
        return  t;
    }

    @Override
    public boolean updateflight(Integer id, String flyid, String flydesc, String destination, String flytime) {
        FlightDaoImpt flightDaoImpt = new FlightDaoImpt();
        boolean b = flightDaoImpt.updateflight(id,flyid, flydesc,destination,flytime);
        return  b;
    }
}
