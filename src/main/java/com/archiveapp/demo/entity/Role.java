package com.archiveapp.demo.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(String role) {
        this.name = ERole.valueOf(role);
    }

    // getters and setters
}