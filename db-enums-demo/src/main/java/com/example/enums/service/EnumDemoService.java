package com.example.enums.service;

import com.example.enums.entity.OrderEntity;
import com.example.enums.entity.UserEntity;
import com.example.enums.enums.*;
import com.example.enums.repository.OrderRepository;
import com.example.enums.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnumDemoService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    // ── Demo 1: EnumType.STRING – save & reload ─────────────────────────────
    @Transactional
    public void demoStringEnum() {
        log.info("═══ DEMO 1: EnumType.STRING ═══");

        UserEntity alice = UserEntity.builder()
                .name("Alice")
                .email("alice@example.com")
                .accountStatus(AccountStatus.ACTIVE) // stored as "ACTIVE" in DB
                .membershipTier(MembershipTier.GOLD) // stored as 2 (ordinal) in DB
                .verifiedStatus(AccountStatus.ACTIVE)
                .roles(Set.of(Role.USER, Role.BILLING_MANAGER))
                .build();
        userRepository.save(alice);

        UserEntity loaded = userRepository.findById(alice.getId()).orElseThrow();
        log.info("Loaded user: name={}, status={}, tier={}", loaded.getName(),
                loaded.getAccountStatus(), loaded.getMembershipTier());

        // Enum comparison works naturally after loading
        assert loaded.getAccountStatus() == AccountStatus.ACTIVE;
        assert loaded.getMembershipTier() == MembershipTier.GOLD;
        log.info("✅ Enum equality check passed");
    }

    // ── Demo 2: EnumType.ORDINAL danger illustration ────────────────────────
    @Transactional
    public void demoOrdinalDanger() {
        log.info("═══ DEMO 2: EnumType.ORDINAL ordinal values ═══");

        // The DB stores these as integers: BRONZE=0, SILVER=1, GOLD=2, PLATINUM=3
        for (MembershipTier tier : MembershipTier.values()) {
            log.info("  {} → ordinal {} stored in DB", tier.name(), tier.ordinal());
        }
        log.warn("⚠️  If you add a new value between BRONZE and SILVER, all SILVER");
        log.warn("⚠️  rows would read as the new value — silent data corruption!");
    }

    // ── Demo 3: Custom Converter (OrderStatus) ───────────────────────────────
    @Transactional
    public void demoCustomConverter() {
        log.info("═══ DEMO 3: Custom AttributeConverter (short code) ═══");

        OrderEntity order = OrderEntity.builder()
                .productName("Wireless Keyboard")
                .amount(new BigDecimal("49.99"))
                .status(OrderStatus.NEW_ORDER) // stored as "NEW" in DB
                .priority(Priority.HIGH) // stored as 10 in DB
                .userId(1L)
                .build();
        orderRepository.save(order);

        OrderEntity loaded = orderRepository.findById(order.getId()).orElseThrow();
        log.info("Order status: Java={} | DB code={} | Display={}",
                loaded.getStatus(),
                loaded.getStatus().getCode(),
                loaded.getStatus().getDisplayName());
        log.info("Order priority: Java={} | DB code={}",
                loaded.getPriority(), loaded.getPriority().getDbCode());

        assert loaded.getStatus() == OrderStatus.NEW_ORDER;
        assert loaded.getPriority() == Priority.HIGH;
        log.info("✅ Custom converter round-trip passed");
    }

    // ── Demo 4: Null enum handling ───────────────────────────────────────────
    @Transactional
    public void demoNullEnum() {
        log.info("═══ DEMO 4: Nullable enum field ═══");

        UserEntity bob = UserEntity.builder()
                .name("Bob")
                .email("bob@example.com")
                .accountStatus(AccountStatus.PENDING)
                .membershipTier(MembershipTier.BRONZE)
                .verifiedStatus(null) // intentionally null — user not yet verified
                .build();
        userRepository.save(bob);

        List<UserEntity> unverified = userRepository.findByVerifiedStatusIsNull();
        log.info("Unverified users count: {}", unverified.size());
        assert !unverified.isEmpty();
        log.info("✅ Null enum field correctly stored and queried");
    }

    // ── Demo 5: ElementCollection of enums ──────────────────────────────────
    @Transactional
    public void demoElementCollection() {
        log.info("═══ DEMO 5: @ElementCollection of enums ═══");

        UserEntity admin = UserEntity.builder()
                .name("Admin User")
                .email("admin@example.com")
                .accountStatus(AccountStatus.ACTIVE)
                .membershipTier(MembershipTier.PLATINUM)
                .verifiedStatus(AccountStatus.ACTIVE)
                .roles(Set.of(Role.ADMIN, Role.USER, Role.MODERATOR, Role.SUPPORT_AGENT))
                .build();
        userRepository.save(admin);

        UserEntity loaded = userRepository.findById(admin.getId()).orElseThrow();
        log.info("Admin roles: {}", loaded.getRoles());
        assert loaded.getRoles().contains(Role.ADMIN);
        assert loaded.getRoles().size() == 4;
        log.info("✅ ElementCollection of enums saved and loaded correctly");
    }

    // ── Demo 6: JPQL and native queries ─────────────────────────────────────
    @Transactional
    public void demoQueries() {
        log.info("═══ DEMO 6: Querying with enums ═══");

        // JPQL — pass enum directly
        List<UserEntity> active = userRepository.findByAccountStatus(AccountStatus.ACTIVE);
        log.info("Active users (JPQL): {}", active.stream().map(UserEntity::getName).toList());

        // JPQL IN clause
        List<UserEntity> activeOrPending = userRepository.findByStatusIn(
                List.of(AccountStatus.ACTIVE, AccountStatus.PENDING));
        log.info("Active or Pending users: {}", activeOrPending.stream().map(UserEntity::getName).toList());

        // Native query — must pass the raw DB string!
        List<UserEntity> nativeActive = userRepository.findByStatusNative("ACTIVE");
        log.info("Active users (native query): {}", nativeActive.stream().map(UserEntity::getName).toList());

        // Bulk update enum value via JPQL
        int updated = userRepository.bulkUpdateStatus(AccountStatus.PENDING, AccountStatus.ACTIVE);
        log.info("Bulk activated {} user(s) from PENDING", updated);

        // Orders with custom converter enum — JPQL
        List<OrderEntity> newOrders = orderRepository.findByStatus(OrderStatus.NEW_ORDER);
        log.info("New orders (JPQL, auto-converter): {}", newOrders.size());

        // Orders with custom converter enum — native query (pass raw code!)
        List<OrderEntity> nativeNew = orderRepository.findByStatusCodeNative("NEW");
        log.info("New orders (native, raw code 'NEW'): {}", nativeNew.size());

        // Priority with int code — native query (pass raw int!)
        List<OrderEntity> highPriority = orderRepository.findByMinPriorityCodeNative(10);
        log.info("Orders with priority >= HIGH (code 10): {}", highPriority.size());
    }

    // ── Demo 7: Jackson JSON serialization ──────────────────────────────────
    public void demoJacksonSerialization() throws Exception {
        log.info("═══ DEMO 7: Jackson JSON serialization of enums ═══");
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

        // Serialize: uses @JsonValue → lowercase
        String json = mapper.writeValueAsString(AccountStatus.ACTIVE);
        log.info("AccountStatus.ACTIVE serializes to JSON: {}", json); // "active"

        // Deserialize: uses @JsonCreator → case-insensitive
        AccountStatus fromLower = mapper.readValue("\"active\"", AccountStatus.class);
        AccountStatus fromUpper = mapper.readValue("\"ACTIVE\"", AccountStatus.class);
        log.info("Deserialized lower: {}, upper: {}", fromLower, fromUpper);
        assert fromLower == AccountStatus.ACTIVE;
        assert fromUpper == AccountStatus.ACTIVE;
        log.info("✅ Jackson round-trip (case-insensitive) passed");
    }
}
