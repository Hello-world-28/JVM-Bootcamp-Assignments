package com.example.enums.repository;

import com.example.enums.entity.UserEntity;
import com.example.enums.enums.AccountStatus;
import com.example.enums.enums.MembershipTier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // ── EDGE CASE 8a: JPQL query with @Enumerated(STRING) enum parameter ────
    // Spring Data JPA compares the enum by its STRING name automatically.
    // You do NOT need to do .name() or toString() — just pass the enum value.
    List<UserEntity> findByAccountStatus(AccountStatus status);

    // ── EDGE CASE 8b: JPQL query with ORDINAL enum parameter ────────────────
    // Works the same way — JPA maps ordinal to int comparison internally.
    List<UserEntity> findByMembershipTier(MembershipTier tier);

    // ── EDGE CASE 8c: JPQL with IN clause of enum values ───────────────────
    @Query("SELECT u FROM UserEntity u WHERE u.accountStatus IN :statuses")
    List<UserEntity> findByStatusIn(@Param("statuses") List<AccountStatus> statuses);

    // ── EDGE CASE 8d: JPQL UPDATE using an enum ─────────────────────────────
    @Modifying
    @Query("UPDATE UserEntity u SET u.accountStatus = :newStatus WHERE u.accountStatus = :oldStatus")
    int bulkUpdateStatus(@Param("oldStatus") AccountStatus oldStatus,
            @Param("newStatus") AccountStatus newStatus);

    // ── EDGE CASE 8e: NATIVE query with enum ────────────────────────────────
    // In native queries, you must pass the RAW DB value yourself:
    // - For STRING enums: pass the string literal "ACTIVE"
    // - For ORDINAL enums: pass the integer 0, 1, 2…
    // JPA does NOT auto-convert enum parameters in native queries!
    @Query(value = "SELECT * FROM users WHERE account_status = :statusStr", nativeQuery = true)
    List<UserEntity> findByStatusNative(@Param("statusStr") String statusStr);

    // ── EDGE CASE 9: Checking for NULL enum fields ──────────────────────────
    List<UserEntity> findByVerifiedStatusIsNull();

    List<UserEntity> findByVerifiedStatusIsNotNull();
}
