package com.cz.Service.Impt;

import com.cz.Bean.message;
import com.cz.Dao.Impt.MessageDaoImpt;
import com.cz.Service.MessageService;

import java.util.List;

public class MessageServiceImpt implements MessageService {
    @Override
    public List<message> getallmessages() {
        MessageDaoImpt mimpt = new MessageDaoImpt();
        List<message> allmessages = mimpt.getallmessages();
        return  allmessages;
    }
}
