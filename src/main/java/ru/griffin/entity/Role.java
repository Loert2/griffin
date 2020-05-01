package ru.griffin.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "Role")
public class Role {
    /**
     * Идентификатор роли
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * Название роли
     */
    @Column(name = "name")
    private String name;
}
