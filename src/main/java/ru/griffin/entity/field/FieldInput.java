package ru.griffin.entity.field;

import lombok.Data;
import ru.griffin.entity.Field;
import ru.griffin.entity.language.LanguageField;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "FieldInput")
public class FieldInput {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * 	Полупрозрачный текст внутри поля
     */
    @Column(name = "placeholder")
    private String placeholder;
    /**
     * Значение по умолчанию
     */
    @Column(name = "defaultValue")
    private String defaultValue;
    /**
     * Обязательность
     */
    @Column(name = "require")
    private String require;
    /**
     * Проверка на максимальную длину
     */
    @Column(name = "maxLength")
    private String maxLength;
    /**
     * Сообщение об ошибке при проверке на максимальную длину
     */
    @Column(name = "maxLengthMessage")
    private String maxLengthMessage;
    /**
     * Проверка на минимальную длину
     */
    @Column(name = "minLength")
    private String minLength;
    /**
     * Сообщение об ошибке при проверке на минимальную длину
     */
    @Column(name = "minLengthMessage")
    private String minLengthMessage;

    /**
     * Язык поля
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="languageField_id")
    private LanguageField languageField;
    /**
     * Связанное поле
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="field_id")
    private Field field;
}
