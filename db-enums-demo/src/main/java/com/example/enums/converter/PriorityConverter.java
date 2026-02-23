package com.example.enums.converter;

import com.example.enums.enums.Priority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * EDGE CASE 5 (continued) – Custom AttributeConverter for Priority (int codes)
 *
 * Maps Priority enum ↔ non-sequential integer codes (1, 5, 10, 20).
 * Using @Enumerated(EnumType.ORDINAL) would store 0,1,2,3 — completely
 * wrong and would break queries against the legacy DB column.
 */
@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Priority, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Priority attribute) {
        if (attribute == null)
            return null;
        return attribute.getDbCode(); // e.g. HIGH → 10
    }

    @Override
    public Priority convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;
        return Priority.fromDbCode(dbData); // e.g. 10 → HIGH
    }
}
