package org.search.jobportal.contact.service;

import org.search.jobportal.contact.dto.ContactRequestDto;

public interface IContactService {
    boolean saveContact(ContactRequestDto contactRequestDto);
}
