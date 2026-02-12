package com.library.foxwearmanagement.entity.siteContent;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "homepage_hero_section", schema = "site_content")
@Data
public class HomepageHeroSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Size(min = 10, max = 40)
    String title;

    @NotBlank
    @Size(min = 70, max = 600)
    @Column(length = 600)
    String subtitle;

    @NotBlank
    @Size(min = 3, max = 15)
    String button1Name;

    @NotBlank
    @Size(max = 255)
    String button1Url;

    @Size(min = 3, max = 15)
    String button2Name;

    @Size(max = 255)
    String button2Url;
}
