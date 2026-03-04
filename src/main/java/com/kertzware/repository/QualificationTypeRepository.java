package com.kertzware.repository;

import com.kertzware.model.QualificationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationTypeRepository extends JpaRepository<QualificationType, Long> {
}
