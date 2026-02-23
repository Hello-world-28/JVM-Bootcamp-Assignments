package com.example.enums.entity;

import com.example.enums.enums.OrderStatus;
import com.example.enums.enums.Priority;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Demonstrates:
 * - EDGE CASE 3: Custom AttributeConverter (OrderStatus ↔ short DB code)
 * - EDGE CASE 5: Custom AttributeConverter with integer codes (Priority)
 * - EDGE CASE 8: Enum in JPQL and native queries
 * - EDGE CASE 9: @Column(columnDefinition) for tighter DB-level constraints
 *
 * Notice: NO @Enumerated annotation on the fields below.
 * When an AttributeConverter with autoApply=true is present, JPA uses it
 * automatically. Adding @Enumerated would CONFLICT and cause an error.
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private BigDecimal amount;

    // ── EDGE CASE 3: Custom converter (String code) ─────────────────────────
    // DB stores "NEW", "PRO", "SHP", "CAN", "DEL" (via OrderStatusConverter)
    // Java uses OrderStatus.NEW_ORDER, PROCESSING, SHIPPED, CANCELLED, DELIVERED
    // ✅ DB column is stable even if Java enum constants are renamed
    // ✅ autoApply=true means NO @Convert annotation needed here
    @Column(name = "status", length = 3, nullable = false)
    private OrderStatus status;

    // ── EDGE CASE 5: Custom converter (int code) ────────────────────────────
    // DB stores 1 (LOW), 5 (MEDIUM), 10 (HIGH), 20 (CRITICAL)
    // Java uses Priority.LOW, MEDIUM, HIGH, CRITICAL
    // ⚠️ EnumType.ORDINAL would store 0,1,2,3 — completely wrong for legacy codes
    @Column(name = "priority", nullable = false)
    private Priority priority;

    // Owning user
    private Long userId;
}
