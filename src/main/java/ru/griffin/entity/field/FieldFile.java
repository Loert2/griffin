package ru.griffin.entity.field;

import lombok.Data;
import ru.griffin.entity.language.LanguageField;
import ru.griffin.entity.Report;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "FieldFile")
public class FieldFile {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * 	Адрес файла
     */
    @Column(name = "urlFile")
    private String urlFile;

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
