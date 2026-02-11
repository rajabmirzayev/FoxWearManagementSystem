package com.library.foxwearmanagement.entity.siteContent;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "offer", schema = "site_content")
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String offerText;
}
