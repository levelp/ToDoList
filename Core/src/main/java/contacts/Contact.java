package contacts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Контакт
 */
public class Contact {
    /**
     * E-mail'ы
     */
    public List<Email> emails = new ArrayList<>();
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

    public Contact(String fullName, String email) {
        String[] s = fullName.split("\\s+");
        surname = s[0];
        name = s[1];
        patronymic = s[2];

        Email e = new Email(email);
        e.setPrimary(true);
        emails.add(e);
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
