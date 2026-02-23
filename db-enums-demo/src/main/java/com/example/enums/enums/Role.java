package com.example.enums.enums;

/**
 * EDGE CASE 4 – Enum used in @ElementCollection (Set/List of enum values per
 * row)
 *
 * Common for multi-value attributes like roles, permissions, tags, features.
 * Stored in a separate join table, one row per enum value.
 *
 * ⚠️ Use EnumType.STRING in the @Enumerated on the @ElementCollection,
 * otherwise you'll hit the ordinal-corruption problem at scale.
 */
public enum Role {
    ADMIN,
    USER,
    MODERATOR,
    BILLING_MANAGER,
    SUPPORT_AGENT
}
