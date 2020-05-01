package ru.griffin.entity;

import lombok.Data;
import ru.griffin.entity.language.LanguageField;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Field")
public class Field {
    /**
     * Идентификатор поля
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * Название поля
     */
    @Column(name = "name")
    private String name;
    /**
     * Обязательность заполнения
     */
    @Column(name = "require")
    private String require;

    /**
     * Список полей на определенном языке
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "field")
    private List<LanguageField> languageFieldList;
}
