package com.vertafore.swagger.services;

import com.vertafore.swagger.models.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact addContact(Contact contact) {
        contacts.add(contact);
        return contact;
    }

    public Contact searchContact(String id) {
        List<Contact> resultList = contacts.stream().filter((contact -> contact.getId().equals(id))).toList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
