package org.search.jobportal.contact.service.impl;

import lombok.RequiredArgsConstructor;
import org.search.jobportal.contact.dto.ContactRequestDto;
import org.search.jobportal.contact.entity.Contact;
import org.search.jobportal.contact.repository.ContactRepository;
import org.search.jobportal.contact.service.IContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {
    private final ContactRepository contactRepository;

//    @Autowired
//    public ContactServiceImpl(ContactRepository contactRepository) {
//        this.contactRepository = contactRepository;
//    }

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        Contact contact = contactRepository.save(transformToEntity(contactRequestDto));
        return contact.getId() != null;
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        contact.setCreatedAt(Instant.now());
        contact.setCreatedBy("System");
        contact.setStatus("New");
        return contact;
    }
}
