package com.example.enums.repository;

import com.example.enums.entity.OrderEntity;
import com.example.enums.enums.OrderStatus;
import com.example.enums.enums.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    // ── EDGE CASE 8f: JPQL with custom-converter enum ───────────────────────
    // OrderStatus uses AttributeConverter (autoApply=true).
    // JPQL treats the field as its Java type (OrderStatus), NOT the DB code.
    // ✅ Just pass the enum — JPA calls the converter for you.
    List<OrderEntity> findByStatus(OrderStatus status);

    List<OrderEntity> findByPriority(Priority priority);

    // ── EDGE CASE 8g: Native query with custom-converter enum ───────────────
    // ⚠️ Native queries bypass the converter — pass the raw DB value manually!
    // For OrderStatus: pass the code string "NEW", "PRO", "SHP" etc.
    // For Priority: pass the int 1, 5, 10, or 20
    @Query(value = "SELECT * FROM orders WHERE status = :code", nativeQuery = true)
    List<OrderEntity> findByStatusCodeNative(@Param("code") String code);

    @Query(value = "SELECT * FROM orders WHERE priority >= :minCode", nativeQuery = true)
    List<OrderEntity> findByMinPriorityCodeNative(@Param("minCode") int minCode);

    // JPQL using enum in comparison (works with custom converter)
    @Query("SELECT o FROM OrderEntity o WHERE o.status = :status AND o.userId = :userId")
    List<OrderEntity> findByStatusAndUser(@Param("status") OrderStatus status,
            @Param("userId") Long userId);
}
