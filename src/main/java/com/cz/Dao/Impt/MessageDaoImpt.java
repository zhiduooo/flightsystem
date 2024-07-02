package com.cz.Dao.Impt;
import com.cz.Bean.message;
import com.cz.Dao.MessageDao;
import com.cz.Util.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpt  extends DBUtils implements MessageDao {
    @Override
    public List<message> getallmessages() {
        List allmessages = null;
        try {
            allmessages = new ArrayList<>();
            String sql = "select * from message";
            resultSet = query(sql,null);
            while(resultSet.next()){
                message m = new message();
                m.setMessage_body(resultSet.getString("message_body"));
                m.setM_date(resultSet.getTimestamp("m_date"));
                allmessages.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return  allmessages;
    }
}
