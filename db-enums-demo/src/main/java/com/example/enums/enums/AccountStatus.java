package com.example.enums.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * EDGE CASE 1 – EnumType.STRING (most common, recommended default)
 *
 * Stored in DB as the string literal: "ACTIVE", "INACTIVE", "SUSPENDED", "PENDING"
 *
 * ✅ Pros: renamed enum constants are a DB migration; adding new values is safe
 * ❌ Cons for EnumType.ORDINAL: inserting a constant in the middle silently
 *    corrupts existing rows (covered in UserStatus below)
 */
public enum AccountStatus {

    PENDING,
    ACTIVE,
    INACTIVE,
    SUSPENDED;

    // ── Jackson integration ──────────────────────────────────────────────────
    // @JsonValue → JSON output uses lowercase (e.g. "active" instead of "ACTIVE")
    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }

    // @JsonCreator → accepts both upper and lower-case from JSON input
    @JsonCreator
    public static AccountStatus fromJson(String value) {
        for (AccountStatus status : values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown AccountStatus: " + value);
    }
}
