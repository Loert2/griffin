package ru.griffin.entity.language;

import lombok.Data;
import ru.griffin.entity.Field;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "LanguageField")
public class  LanguageField {
    /**
     * Идентификатор языка поля
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * Подпись поля
     */
    @Column(name = "labelText")
    private String labelText;
    /**
     * Помощь для пользователя, которая находиться под полем
     */
    @Column(name = "helpText")
    private String helpText;

    /**
     * Язык поля
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "languageQuestionnaire_id")
    private LanguageQuestionnaire languageQuestionnaire;
    /**
     * Поле к которому относиться язык
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="field_id")
    private Field field;
}
