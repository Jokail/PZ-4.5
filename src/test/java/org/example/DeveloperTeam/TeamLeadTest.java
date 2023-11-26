package org.example.DeveloperTeam;

import org.example.entityBacklog.ProductBacklog;
import org.example.entityTask.Status;
import org.example.entityTask.StoryPoints;
import org.example.entityTask.Task;
import org.example.sprintBacklog.SprintBacklog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class TeamLeadTest {

    Task task;
    SprintBacklog sprintBacklog;
    ProductBacklog productBacklog;
    TeamLead teamLead;

    @BeforeEach
    void init(){
        task = new Task(StoryPoints.TWENTY);
        sprintBacklog = new SprintBacklog();
        productBacklog = new ProductBacklog();
        productBacklog.add(task);
        teamLead = new TeamLead();
    }

    @Test
    void moveTasksFromProductBacklogToSprintBacklogTest() {
        teamLead.moveTasksFromProductBacklogToSprintBacklog(productBacklog, sprintBacklog);
        assertEquals(task, sprintBacklog.peek());
    }

    @Test
    void markTaskAsDoneTest() {
        teamLead.moveTasksFromProductBacklogToSprintBacklog(productBacklog, sprintBacklog);
        teamLead.markTaskAsDone(sprintBacklog);
        assertEquals(sprintBacklog.peek().getStatus(), Status.DONE);
    }

    @Test
    void inspectSprintBacklogIfNotDone() {
        teamLead.moveTasksFromProductBacklogToSprintBacklog(productBacklog, sprintBacklog);
        teamLead.inspectSprintBacklog(sprintBacklog);
        assertEquals(sprintBacklog.peek(), task);
    }

    @Test
    void inspectSprintBacklogIfItIsDone() {
        teamLead.moveTasksFromProductBacklogToSprintBacklog(productBacklog, sprintBacklog);
        teamLead.markTaskAsDone(sprintBacklog);
        teamLead.inspectSprintBacklog(sprintBacklog);
        assertNull(sprintBacklog.peek());
    }
}