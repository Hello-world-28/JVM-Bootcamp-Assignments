package com.example.enums.enums;

/**
 * EDGE CASE 2 – EnumType.ORDINAL (dangerous default in JPA!)
 *
 * Stored as integer in DB:  BRONZE=0, SILVER=1, GOLD=2, PLATINUM=3
 *
 * ⚠️  DANGER: If you ever INSERT a new value between BRONZE and SILVER
 *     (e.g. COPPER), every row with SILVER becomes COPPER in Java —
 *     silent data corruption without any DB/Java error!
 *
 * ✅ Only acceptable when the enum is final and will NEVER change order.
 * ✅ Slightly smaller storage footprint than a VARCHAR column.
 */
public enum MembershipTier {
    BRONZE,   // ordinal = 0
    SILVER,   // ordinal = 1
    GOLD,     // ordinal = 2
    PLATINUM  // ordinal = 3
    // ⚠️ Never insert COPPER here between BRONZE and SILVER!
}
