package com.codeup.adlister.dao;

import java.util.List;
import com.codeup.adlister.models.Message;

public interface Messages {
    // get a list of all the messages
    List<Message> all();
    // insert a new message and return the new message's id
    Long insert(Message message);

    List<Message>limit(long limit, long offset);

    List<Message>addToMessages(long limit, long offset, List<Message> previousMessages);
}
}
