package com.vertafore.swagger.controllers;

import com.vertafore.swagger.models.Contact;
import com.vertafore.swagger.services.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @GetMapping("/contacts/search/{id}")
    public Contact searchContact(@PathVariable String id) {
        return contactService.searchContact(id);
    }
}
