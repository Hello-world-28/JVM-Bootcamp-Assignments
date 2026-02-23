package com.example.enums.enums;

/**
 * EDGE CASE 5 – Enum stored as a numeric CODE (not ordinal)
 *
 * This pattern is common in legacy systems where the DB stores integer codes
 * like 1, 2, 3 but those numbers are BUSINESS codes, not Java ordinals.
 *
 * Example: DB stores 1=LOW, 5=MEDIUM, 10=HIGH, 20=CRITICAL
 * (ordinals would be 0,1,2,3 — completely different!)
 *
 * Use PriorityConverter (AttributeConverter) to map int ↔ Priority safely.
 */
public enum Priority {
    LOW(1),
    MEDIUM(5),
    HIGH(10),
    CRITICAL(20);

    private final int dbCode;

    Priority(int dbCode) {
        this.dbCode = dbCode;
    }

    public int getDbCode() {
        return dbCode;
    }

    public static Priority fromDbCode(int code) {
        for (Priority p : values()) {
            if (p.dbCode == code)
                return p;
        }
        throw new IllegalArgumentException("Unknown Priority code: " + code);
    }
}
