package levelp.model;

import levelp.model.tasks.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Тег - словарь тегов
 */
@Entity
@Table(name = "TAG")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tags")
    private List<Task> tasks = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }
}
