package org.howard.edu.lsp.midterm.crccards.doc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TaskManager manages a collection of Task objects.
 * * @author Saleh Z. AbdurRahman
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the manager.
     * * @param task The Task object to add
     * @throws IllegalArgumentException if a task with the same ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID detected.");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Locates a task by its unique ID.
     * * @param taskId The ID of the task to find
     * @return The Task object if found, or null if it does not exist
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Retrieves a list of all tasks that match the specified status.
     * * @param status The status to filter by
     * @return A List of Task objects with the matching status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}