package contacts;

/**
 * Тип контакта
 */
public enum ContactType {
    HOME("Домашний"),
    WORK("Рабочий");

    public final String name;

    ContactType(String name) {
        this.name = name;
    }
}
