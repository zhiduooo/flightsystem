package com.cz.Bean;

import org.apache.derby.client.am.DateTime;

import java.sql.Timestamp;
import java.util.Date;

public class message {
    private  Integer m_id;
    private  String message_body;
    private Timestamp m_date;


    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getMessage_body() {
        return message_body;
    }

    public void setMessage_body(String message_body) {
        this.message_body = message_body;
    }

    public Timestamp getM_date() {
        return m_date;
    }

    public void setM_date(Timestamp m_date) {
        this.m_date = m_date;
    }
}
