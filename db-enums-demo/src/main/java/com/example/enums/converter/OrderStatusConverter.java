package com.example.enums.converter;

import com.example.enums.enums.OrderStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * EDGE CASE 3 (continued) – Custom AttributeConverter for OrderStatus
 *
 * Maps the Java enum ↔ a short DB code string ("NEW", "PRO", "SHP"…)
 *
 * @Converter(autoApply = true) → JPA automatically uses this converter for
 *                      every entity field of type OrderStatus without
 *                      needing @Convert on each field.
 *
 *                      If you set autoApply = false, you must annotate each
 *                      field explicitly:
 * @Convert(converter = OrderStatusConverter.class)
 *                    private OrderStatus status;
 */
@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {

    @Override
    public String convertToDatabaseColumn(OrderStatus attribute) {
        // EDGE CASE: null safety — JPA may call this with null (nullable column)
        if (attribute == null)
            return null;
        return attribute.getCode(); // e.g. NEW_ORDER → "NEW"
    }

    @Override
    public OrderStatus convertToEntityAttribute(String dbData) {
        // EDGE CASE: null safety — nullable column returns null from DB
        if (dbData == null)
            return null;
        return OrderStatus.fromCode(dbData); // e.g. "NEW" → OrderStatus.NEW_ORDER
    }
}
