package org.example.entityTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;

    @BeforeEach
    void init(){
        task = new Task(StoryPoints.TWENTY);
    }

    @Test
    void newNameShouldBeTask1(){
        assertEquals("task#1",task.name);
    }

    @Test
    void newNameShouldBeTask2(){
        Task.id--;
        Task task2 = new Task(StoryPoints.TWENTY);
        assertEquals("task#2",task2.name);
    }

    @Test
    void newStatusShouldBeToDo(){
        assertEquals(Status.TO_DO,task.status);
    }

    @Test
    void storyPointsShouldBe_20(){
        assertEquals(StoryPoints.TWENTY,task.storyPoints);
    }
    @Test
    void priorityShouldBeCreatedRandomValue(){
        assertNotNull(task.priority);
    }

}