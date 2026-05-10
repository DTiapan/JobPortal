package org.search.jobportal.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@AllArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private String logo;
    private String industry;
    private String size;
    private BigDecimal rating;
    private String description;
    private Integer employees;
    private String website;
    private Instant createdAt;


}
