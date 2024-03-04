package com.example.retail.infrastructure.dbo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="currency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    String name;

}
