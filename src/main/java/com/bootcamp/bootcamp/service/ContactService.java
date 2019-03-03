package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.Contact;
import com.bootcamp.bootcamp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ContactService {
    @Autowired
    private ContactRepository conatactRepository;

    public void saveContact(Contact contact){
        contact.setData(LocalDateTime.now().plusHours(1));
        conatactRepository.save(contact);
    }


}
