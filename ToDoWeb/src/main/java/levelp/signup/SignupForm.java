package levelp.signup;

import levelp.model.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SignupForm {

    private static final String NOT_BLANK_MESSAGE =
            "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";
    String surname, name, middleName;
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Email(message = SignupForm.EMAIL_MESSAGE)
    private String email;
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String password;
    /**
     * Подтверждение пароля
     */
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String retypePassword;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User createAccount() {
        return new User(getEmail(), getPassword(), "ROLE_USER");
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    /**
     * @return Пароль и его повторение совпадают
     */
    public boolean checkPasswordEquals() {
        return password.equals(retypePassword);
    }
}
