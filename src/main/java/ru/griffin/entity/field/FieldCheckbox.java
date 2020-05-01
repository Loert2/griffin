package ru.griffin.entity.field;

import lombok.Data;
import ru.griffin.entity.Field;
import ru.griffin.entity.language.LanguageField;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "FieldCheckbox")
public class FieldCheckbox {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * 	Значение
     */
    @Column(name = "valueCheck")
    private String valueCheck;

    /**
     * Язык поля
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="languageField_id")
    private LanguageField languageField;
    /**
     * Список полей
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="field_id")
    private Field field;
}
