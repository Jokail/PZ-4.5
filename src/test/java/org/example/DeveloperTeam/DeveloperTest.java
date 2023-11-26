package org.example.DeveloperTeam;

import org.example.entityTask.Status;
import org.example.entityTask.StoryPoints;
import org.example.entityTask.Task;
import org.example.sprintBacklog.SprintBacklog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeveloperTest {

    Task task;
    Developer developer;
    SprintBacklog sprintBacklog;

    @BeforeEach
    void init(){
        task = new Task(StoryPoints.TWENTY);
        sprintBacklog = new SprintBacklog();
        developer = new Developer();
        sprintBacklog.add(task);
    }

    @Test
    void getFirstTaskFromSprintBacklog(){
        assertEquals(developer.getTaskFromSprintBacklog(sprintBacklog), task);
    }

    @Test
    void markTaskInSprintBacklogAsValidate(){
        developer.markTaskAsValidate(sprintBacklog);
        assertEquals(sprintBacklog.peek().getStatus(), Status.VALIDATE);
    }

    @Test
    void developerPositionTeamLeadShouldThrowDeveloperPositionTeamLeadIf(){
        assertThrows(DeveloperPositionTeamLead.class, () -> {
            Developer teamLead =  new Developer("Ann", "Bolt", 10000, Position.TEAM_LEAD);
        });
    }

    @Test
    void defaultsGetScoreBasedOnCountOfDoneTaskWithTheirStoryPointsShouldBe_0(){
        assertEquals(0,developer.getScoreBasedOnCountOfDoneTaskWithTheirStoryPoints());
    }

    @Test
    void getScoreBasedOnCountOfDoneTaskWithTheirStoryPointsShouldBe_20(){
        developer.markTaskAsValidate(sprintBacklog);
        assertEquals(20,developer.getScoreBasedOnCountOfDoneTaskWithTheirStoryPoints());
    }
}
