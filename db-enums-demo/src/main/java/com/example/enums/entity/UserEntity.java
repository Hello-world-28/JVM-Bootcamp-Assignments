package com.example.enums.entity;

import com.example.enums.enums.AccountStatus;
import com.example.enums.enums.MembershipTier;
import com.example.enums.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Demonstrates:
 * - EDGE CASE 1: @Enumerated(EnumType.STRING) → stores "ACTIVE", "PENDING"…
 * - EDGE CASE 2: @Enumerated(EnumType.ORDINAL) → stores 0, 1, 2, 3
 * - EDGE CASE 4: @ElementCollection of enums (Set<Role>)
 * - EDGE CASE 6: Nullable enum column (accountStatus can be null)
 * - EDGE CASE 7: @Column constraints on enum columns
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    // ── EDGE CASE 1: EnumType.STRING ────────────────────────────────────────
    // DB column: VARCHAR(20), stores "ACTIVE" / "PENDING" / "INACTIVE" /
    // "SUSPENDED"
    // ✅ Recommended: safe when enum constants are renamed via a DB migration
    // ✅ Adding new constants at any position is safe — ordinal position doesn't
    // matter
    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", length = 20)
    private AccountStatus accountStatus;

    // ── EDGE CASE 2: EnumType.ORDINAL ───────────────────────────────────────
    // DB column: INT, stores 0 (BRONZE), 1 (SILVER), 2 (GOLD), 3 (PLATINUM)
    // ⚠️ DANGER: Adding an enum constant between existing ones = silent data
    // corruption
    // ⚠️ Use ONLY for truly immutable, ordered enums
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "membership_tier")
    private MembershipTier membershipTier;

    // ── EDGE CASE 6: Nullable enum ──────────────────────────────────────────
    // When a user hasn't verified their email yet, verifiedStatus is NULL in DB.
    // JPA handles null correctly for both EnumType.STRING and AttributeConverter.
    // ⚠️ @Enumerated fields are nullable by default — no special config needed.
    @Enumerated(EnumType.STRING)
    @Column(name = "verified_status", length = 20)
    private AccountStatus verifiedStatus; // null = "not verified yet"

    // ── EDGE CASE 4: @ElementCollection of enums ────────────────────────────
    // Stored in a separate "user_roles" join table:
    // user_id | role
    // 1 | ADMIN
    // 1 | BILLING_MANAGER
    //
    // ⚠️ Must use @Enumerated(EnumType.STRING) on the collection too!
    // Without it, JPA defaults to ORDINAL for collection elements.
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 30)
    @Builder.Default
    private Set<Role> roles = new HashSet<>();
}
