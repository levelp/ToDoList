package levelp.model.contacts;

import levelp.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Контакт
 */
@Entity
@Table(name = "CONTACT")
public class Contact {
    /**
     * E-mail'ы
     */
    @OneToMany(fetch = FetchType.LAZY)
    public List<Email> emails = new ArrayList<>();
    public String text;
    @Column(name = "id")
    @Id
    @GeneratedValue
    Long id;
    /**
     * Фамилия Имя Отчество
     */
    String surname;
    String name;
    String patronymic;
    /**
     * Дата рождения
     */
    Date dateOfBirth;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_CONTACT_USER"))
    private User user;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    public Contact(String fullName, String email) {
        String[] s = fullName.split("\\s+");
        surname = s[0];
        name = s[1];
        patronymic = s[2];

        Email e = new Email(email);
        e.setPrimary(true);
        emails.add(e);
    }


    public Contact() {
    }

    public Contact(User user, ContactType type, String text) {
        this.user = user;
        this.type = type;
        this.text = text;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
