package me.dio.santander_dev_week_2023_dio.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Version
    private Integer version;
    @OneToOne(cascade =  CascadeType.ALL)
    private Account account;
    @OneToOne(cascade =  CascadeType.ALL)
    private Card card;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;
}
