package org.example.entityBacklog;

import org.example.entityTask.Task;
import org.example.sprintBacklog.SprintBacklog;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProductBacklog {
    private final Queue<Task> productBacklog = new PriorityQueue<>();


    public void add(Task task) {
        productBacklog.add(task);
    }

    public Task delete() {
        return productBacklog.poll();
    }

    public int size(){
        return productBacklog.size();
    }

    public void move(SprintBacklog sprintBacklog) {
        sprintBacklog.add(productBacklog.poll());
    }
}
