package ru.griffin.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.griffin.entity.help.enumtype.Language;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Report")
public class Report {
    /**
     * Идентификатор отчета
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * Название отчета
     */
    @Column(name = "name")
    private String name;
    /**
     * Язык отчета
     */
    @Column(name = "language")
    private Language language;
    /**
     * Дата создания
     */
    @Column(name = "createDate")
    private Date createDate;
    /**
     * Дата обновления
     */
    @Column(name = "updateDate")
    private Date updateDate;

    /**
     * Опросник
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="questionnaire_id")
    private Questionnaire questionnaire;
    /**
     * Пользователь, создавший отчет
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userCreate_id")
    private User userCreate;
}
