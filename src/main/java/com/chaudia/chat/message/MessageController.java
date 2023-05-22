package com.chaudia.chat.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MessageController {
    @Autowired private MessageService service;
    @GetMapping("/messages")
    public String showMessagesList(Model model){
        List<Message> listMessages = service.listAll();
        model.addAttribute("listMessages",listMessages);
        return "messages";
    }
    @GetMapping("/messages/new")
    public String showNewMessageForm(Model model){
        Message message = new Message();
        model.addAttribute("message",message);
        return "new_message";
    }
    @PostMapping("/messages/save")
    public String saveMessage(Message message){
        service.save(message);
        return "redirect:/messages";
    }
    @GetMapping("/messages/delete/{id}")
    public String deleteMessage(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/messages";
    }
}
