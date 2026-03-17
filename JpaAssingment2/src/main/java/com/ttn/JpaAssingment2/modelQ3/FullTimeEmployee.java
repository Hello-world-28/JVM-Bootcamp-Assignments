package com.ttn.JpaAssingment2.modelQ3;

import com.ttn.JpaAssingment2.model.Employee;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FullTimeEmployee extends Employee {

    private Double salary;
}
