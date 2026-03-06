package com.kertzware.repository;

import com.kertzware.model.Member;
import com.kertzware.model.QualificationIssuance;
import com.kertzware.model.RoleRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserUsername(String username);

    @Query("SELECT rec FROM RoleRecord rec WHERE rec.user.id = :userId AND (rec.until IS NULL OR rec.until > CURRENT_DATE)")
    List<RoleRecord> findActiveRolesByUserId(@Param("userId") Long userId);

    @Query("SELECT qi FROM QualificationIssuance qi " +
            "WHERE qi.member.id = :memberId AND (qi.expirationDate IS NULL OR qi.expirationDate >= CURRENT_DATE )")
    List<QualificationIssuance> findActiveQualificationsByMemberId(@Param("memberId") Long memberId);
}
