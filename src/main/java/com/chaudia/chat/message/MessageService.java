package com.chaudia.chat.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired private MessageRepository repo;

    public List<Message>listAll() {
        return (List<Message>) repo.findAll();
    }

    public void save(Message message) {
        repo.save(message);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
