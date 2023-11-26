package org.example.sprintBacklog;

import org.example.DeveloperTeam.Developer;
import org.example.DeveloperTeam.Programist;
import org.example.entityTask.StoryPoints;
import org.example.entityTask.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SprintBacklogTest {
    SprintBacklog sprintBacklog;
    Task task;


    @BeforeEach
    void init(){
        sprintBacklog = new SprintBacklog();
        task = new Task(StoryPoints.TWENTY);
    }

    @Test
    void peekTask() {
        sprintBacklog.add(task);
        assertEquals(sprintBacklog.peek(), task);
    }
    @Test
    void peekTaskIfSprintIsEmpty() {
        assertEquals(sprintBacklog.peek(), null);
    }

    @Test
    void addInSprintBacklog() {
        sprintBacklog.add(task);
        assertNotNull(sprintBacklog.peek());
    }

    @Test
    void deleteTaskFromSprintBacklog() {
        sprintBacklog.add(task);
        sprintBacklog.delete();
        assertNull(sprintBacklog.peek());
    }

    @Test
    void capacityDefault_0(){
        assertEquals(0,sprintBacklog.getCapacity());
    }

    @Test
    void capacityShouldBe_20(){
        Programist programist = new Programist();
        sprintBacklog.add(task);
        assertEquals(20,sprintBacklog.getCapacity());
        Programist.countProgramist--;
    }

    @Test
    void capacityShouldBe_10(){
        Programist programist = new Programist();
        Programist programist2 = new Programist();
        sprintBacklog.add(task);
        assertEquals(10,sprintBacklog.getCapacity());
        Programist.countProgramist--;
        Programist.countProgramist--;
    }
}