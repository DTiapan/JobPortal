package org.search.jobportal.contact.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactRequestDto {

    private String email;
    private String message;
    private String name;
    private String subject;
    private String userType;

}
