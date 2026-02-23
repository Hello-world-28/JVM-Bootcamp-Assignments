-- V1: Initial schema
-- Matches all entity definitions exactly so Hibernate validate mode passes.

-- ── users table ──────────────────────────────────────────────────────────────
-- account_status → VARCHAR (EnumType.STRING) e.g. 'ACTIVE', 'PENDING'...
-- membership_tier → INT   (EnumType.ORDINAL) e.g. 0=BRONZE, 1=SILVER...
-- verified_status → VARCHAR, NULLABLE (demonstrates null enum edge case)
CREATE TABLE users (
    id              BIGINT          AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(100)    NOT NULL,
    email           VARCHAR(150)    NOT NULL UNIQUE,
    account_status  VARCHAR(20),
    membership_tier TINYINT,  -- Hibernate maps EnumType.ORDINAL to TINYINT
    verified_status VARCHAR(20)
);

-- ── user_roles join table (@ElementCollection) ───────────────────────────────
-- One row per role per user. role stored as VARCHAR (EnumType.STRING enforced).
CREATE TABLE user_roles (
    user_id BIGINT      NOT NULL,
    role    VARCHAR(30) NOT NULL,
    PRIMARY KEY (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- ── orders table ─────────────────────────────────────────────────────────────
-- status   → VARCHAR(3), stores custom codes via OrderStatusConverter
--            'NEW' / 'PRO' / 'SHP' / 'CAN' / 'DEL'
-- priority → INT, stores business codes via PriorityConverter
--            1=LOW | 5=MEDIUM | 10=HIGH | 20=CRITICAL
CREATE TABLE orders (
    id           BIGINT         AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(200)   NOT NULL,
    amount       DECIMAL(10,2)  NOT NULL,
    status       VARCHAR(3)     NOT NULL,
    priority     INT            NOT NULL,
    user_id      BIGINT
);
