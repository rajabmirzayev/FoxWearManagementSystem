package com.library.foxwearmanagement.repository.siteContent;

import com.library.foxwearmanagement.entity.siteContent.ContactInfo;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<@NonNull ContactInfo, @NonNull Long> {
}
