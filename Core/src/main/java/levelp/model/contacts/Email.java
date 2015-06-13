package levelp.model.contacts;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Адрес электронной почты
 */
@Entity
@Table(name = "EMAIL")
public class Email {
    @Column(name = "id")
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Contact contact;
    /**
     * Сам адрес
     */
    private String address;
    /**
     * Основной ли это e-mail?
     */
    @Column(nullable = false)
    @Type(type = "yes_no")
    private boolean isPrimary = false;
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
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        this.isPrimary = primary;
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
