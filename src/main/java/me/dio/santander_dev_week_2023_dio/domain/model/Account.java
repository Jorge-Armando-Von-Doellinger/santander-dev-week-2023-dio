package me.dio.santander_dev_week_2023_dio.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Entity(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;
    private String agency;
    @Column(precision = 13, scale = 2)
    private BigDecimal balance;
    @Column(precision = 13, scale = 2, name = "account_limit")
    private BigDecimal limit;
}
