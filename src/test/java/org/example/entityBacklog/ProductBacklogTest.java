package org.example.entityBacklog;

import org.example.entityTask.StoryPoints;
import org.example.entityTask.Task;
import org.example.sprintBacklog.SprintBacklog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductBacklogTest {
    Task task1;
    Task task2;
    ProductBacklog productBacklog;

    @BeforeEach
    void init(){
        task1 = new Task(StoryPoints.TWENTY);
        task2 = new Task(StoryPoints.ONE);
        productBacklog = new ProductBacklog();
    }

    @Test
    void addTaskInProductBacklog(){
        productBacklog.add(task1);
        assertNotNull(productBacklog);
    }

    @Test
    void poolTaskInProductBacklog(){
        productBacklog.add(task1);
        assertSame(productBacklog.delete(), task1);
    }

    @Test
    void moveTaskInSprint(){
        SprintBacklog sprintBacklog = new SprintBacklog();
        productBacklog.add(task1);
        productBacklog.move(sprintBacklog);
        assertNotNull(sprintBacklog.peek());
    }

}