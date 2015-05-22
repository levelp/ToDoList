package contacts;

/**
 * Адрес электронной почты
 */
public class Email {
    /**
     * Сам адрес
     */
    private String address;

    /**
     * Основной ли это e-mail?
     */
    private boolean primary;

    /**
     * Тип e-mail'а
     */
    private ContactType type;

    public Email() {
    }

    public Email(String address) {
        this.address = address;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return String.format("<a href=\"mailto:%s\">%s</a>", address, address);
    }
}
