package ru.griffin.entity.field;

import lombok.Data;
import ru.griffin.entity.Field;
import ru.griffin.entity.language.LanguageField;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "ItemFieldRadio")
public class ItemFieldRadio {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * Значение
     */
    @Column(name = "valueItem")
    private String valueItem;
    /**
     * Текст, который расположен рядом с вариантом
     */
    @Column(name = "text")
    private String text;
    /**
     * Значение по умолчанию
     */
    @Column(name = "checked")
    private Boolean checked;
    /**
     * Флаг отключения
     */
    @Column(name = "disabled")
    private Boolean disabled;

    /**
     * Язык поля
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="languageField_id")
    private LanguageField languageField;
    /**
     * Поле, к которому относиться один экземпляр radio-кнопки
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="field_id")
    private Field field;
}
