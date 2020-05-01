package ru.griffin.entity.field;

import lombok.Data;
import ru.griffin.entity.Report;
import ru.griffin.entity.language.LanguageField;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "FieldValue")
public class FieldValue {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * 	Введенное/выбранное значение поля
     */
    @Column(name = "value")
    private String value;

    /**
     * Язык поля
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="languageField_id")
    private LanguageField languageField;
    /**
     * Отчет
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="report_id")
    private Report report;
}
