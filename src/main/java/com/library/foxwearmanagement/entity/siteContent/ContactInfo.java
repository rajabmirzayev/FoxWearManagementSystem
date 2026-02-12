package com.library.foxwearmanagement.entity.siteContent;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "contact_info", schema = "site_content")
@Data
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String value;
    String icon;
}
