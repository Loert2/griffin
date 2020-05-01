package ru.griffin.entity.language;

import lombok.Data;
import ru.griffin.entity.Questionnaire;
import ru.griffin.entity.Role;
import ru.griffin.entity.help.enumtype.Language;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "LanguageQuestionnaire")
public class LanguageQuestionnaire {
    /**
     * Идентификатор языка опросника
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * Название языка
     */
    @Column(name = "name")
    private Language name;

    /**
     * Опросник
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="questionnaire_id")
    private Questionnaire questionnaire;
}
