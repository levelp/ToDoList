package tasks;

import java.util.ArrayList;
import java.util.List;


/**
 * Задача: выполяется за один раз
 */
public class Task {

    /**
     * Задача имеет следующие свойства:
     * имя, описание, приоритет, подзадачи, тэги
     *
     */
    private String name;
    private String description;
    public enum TaskPriority {
        HIGH, MEDIUM, LOW
    }
    private TaskPriority priority;
    private List<Task> subTasks = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    /**
     * При создании экземпляра, мы передаем конструктору имя задачи.
     * Остальные свойства дописываем по умолчанию
     */
    public Task(String name) {

        this.name = name;
        this.tags.add("#todo");
        this.priority = TaskPriority.HIGH;
        this.description = "You need something to do!";
    }

    /**
     * Добавляем геттеры/сеттеры к свойствам
     * + два метода: добавить тэг, добавить подзадачу.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addSubTasks(List<Task> subTasks) {
        this.subTasks.addAll(subTasks);
    }

    public void addTags(List<String> tags) {
        this.tags.addAll(tags);
    }

    /**
     * Переопределяем методы equals, hashCode, toString для нашего класса
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!name.equals(task.name)) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (priority != task.priority) return false;
        if (subTasks != null ? !subTasks.equals(task.subTasks) : task.subTasks != null) return false;
        return !(tags != null ? !tags.equals(task.tags) : task.tags != null);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + priority.hashCode();
        result = 31 * result + (subTasks != null ? subTasks.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Необходимо выполнить" +
                "задачу '" + name + '\'' +
                ", тэги: " + tags +
                ", приоритет задачи: " + priority +
                ", подзадачи: " + subTasks +
                ", описание задачи: '" + description + '\'' +
                '}';
    }

}
