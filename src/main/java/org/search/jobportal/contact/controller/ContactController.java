package org.search.jobportal.contact.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.search.jobportal.contact.dto.ContactRequestDto;
import org.search.jobportal.contact.service.IContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final IContactService contactService;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMsg(@RequestBody @Valid ContactRequestDto contactRequestDto) {
        boolean isSaved = contactService.saveContact(contactRequestDto);

        if (isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Contact Created");
        } else  {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Contact Not Saved");
        }
    }

    @GetMapping
    public ResponseEntity<String> fetchOpenContacts(
            @RequestParam
            @Validated
            @NotBlank(message = "status cant be blank")
            @Size(min = 4, message = "status length should be of minimum 4 chars")
            @Pattern(regexp = "open|closed", message = "Status should be one of: open, closed")
            String status) {
            return ResponseEntity.ok("These are the contacts with given status: " + status);
    }
}
