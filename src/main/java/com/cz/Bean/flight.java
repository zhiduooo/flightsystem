package com.cz.Bean;

import java.util.Date;

public class flight {
    private Integer id;
    private  String fly_id;
    private  String fly_desc;
    private  String  destination;
    private  Date   fly_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFly_id() {
        return fly_id;
    }

    public void setFly_id(String fly_id) {
        this.fly_id = fly_id;
    }

    public String getFly_desc() {
        return fly_desc;
    }

    public void setFly_desc(String fly_desc) {
        this.fly_desc = fly_desc;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getFly_time() {
        return fly_time;
    }

    public void setFly_time(Date fly_time) {
        this.fly_time = fly_time;
    }
}
