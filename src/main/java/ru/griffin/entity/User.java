package ru.griffin.entity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "SystemUser")
public class User {
    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    /**
     * Электронная почта пользователя
     */
    @Column(name = "eMail")
    private String eMail;
    /**
     * Имя пользователя
     */
    @Column(name = "fullName")
    private String fullName;
    /**
     * Пароль пользователя
     */
    @Column(name = "password")
    private String password;

    /**
     * Роль
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;

    /**
     * Список отчетов
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userCreate")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Report> reportList;

    /**
     * Список доступных опросников
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="Access",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="questionnaire_id", referencedColumnName="id")
    )
    private List<User> userAccessList;
}
