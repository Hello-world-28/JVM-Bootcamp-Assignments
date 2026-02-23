package com.example.enums.enums;

/**
 * EDGE CASE 3 – Enum with extra fields + custom AttributeConverter
 *
 * Problem: You need a short "code" stored in DB (e.g. "NEW", "PRO", "SHP")
 * instead of the full Java name or an ordinal number.
 *
 * Solution: Add a `code` field to the enum and use an AttributeConverter
 * (see OrderStatusConverter) to map code ↔ enum.
 *
 * ✅ DB column stores "NEW"/"PRO"/"SHP"/"CAN"/"DEL" – stable & compact
 * ✅ Java name (NEW_ORDER, PROCESSING …) can be refactored freely
 * ✅ Displaying human-readable labels is trivial via displayName field
 */
public enum OrderStatus {

    NEW_ORDER("NEW", "New Order"),
    PROCESSING("PRO", "Processing"),
    SHIPPED("SHP", "Shipped"),
    CANCELLED("CAN", "Cancelled"),
    DELIVERED("DEL", "Delivered");

    private final String code; // what goes into the DB column
    private final String displayName; // human-readable label for UI

    OrderStatus(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    /** Reverse-lookup by DB code – used in the AttributeConverter */
    public static OrderStatus fromCode(String code) {
        for (OrderStatus status : values()) {
            if (status.code.equals(code))
                return status;
        }
        throw new IllegalArgumentException("Unknown OrderStatus code: " + code);
    }
}
