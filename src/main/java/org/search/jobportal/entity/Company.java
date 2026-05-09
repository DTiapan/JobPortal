package org.search.jobportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="COMPANIES")
public class Company {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name = "ID", nullable = false)
   private Long id;

   @Column(name="NAME", nullable = false, unique = true)
   private String name;

   @Column(name = "LOGO", length = 500)
   private String logo;

   @Column(name="INDUSTRY",  length = 100, nullable = false)
   private String industry;

   @Column(name = "SIZE", length = 50, nullable = false)
   private String size;

   @Column(name = "locations", length = 1000)
   private String locations;

   @Column(name="founded", nullable = false)
   private int founded;

   @Column(name = "RATING",nullable = false, precision = 3, scale = 2)
   private BigDecimal rating;

   @Lob
   @Column(name = "DESCRIPTION")
   private String description;

   @Column(name = "EMPLOYEES")
   private Integer employees;

   @Column(name = "WEBSITE", length = 500)
   private String website;

   @Column(name = "CREATED_AT", nullable = false)
   private Instant createdAt;

   @Column(name = "CREATED_BY", length = 20, nullable = false)
   private String createdBy;

   @Column(name = "UPDATED_AT")
   private Instant updatedAt;

   @Column(name = "UPDATED_BY", length = 20)
   private String updatedBy;
}
