package levelp.model;

import levelp.model.tasks.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity // Данный класс соответствует таблице в Базе Данных
@Table(name = "`user`")
@NamedQuery(name = User.FIND_BY_EMAIL, query = "select a from User a where a.email = :email")
public class User implements java.io.Serializable {

    public static final String FIND_BY_EMAIL = "User.findByEmail";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    //@JsonIgnore
    private String password;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    private String role = "ROLE_USER";

    @Enumerated(EnumType.STRING) // Хранить элементы перечисления в БД как строки (для наглядности)
    @Column(name = "SEX")
    private Sex sex = Sex.MALE;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    protected User() {

    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Task> getResumes() {
        return tasks;
    }

    public void setResumes(List<Task> resumes) {
        this.tasks = resumes;
    }
}
