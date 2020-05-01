package ru.griffin.entity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.griffin.entity.language.LanguageQuestionnaire;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Questionnaire")
public class Questionnaire {
    /**
     * Идентификатор опросника
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * Название опросника
     */
    @Column(name = "name")
    private String name;
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
     * Пользователь
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userCreate_id")
    private User user;

    /**
     * Список отчетов
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionnaire")
    private List<Report> reportList;

    /**
     * Список языков
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionnaire")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<LanguageQuestionnaire> languageQuestionnaireList;
}
