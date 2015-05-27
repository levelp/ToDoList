package tasks;

import java.util.ArrayList;
import java.util.List;


/**
 * Задача: выполяется за один раз
 */
public class Task {
    /**
     * Название задачи
     */
    public enum TaskPriority {HIGH, MEDIUM,LOW}
    private final String name;
    private String description;


    /**
     * Пункты задачи (подзадачи)
     */
    List<Task> subTasks = new ArrayList<>();

    /**
     * Теги задачи
     */
    List<String> tags = new ArrayList<>();

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
