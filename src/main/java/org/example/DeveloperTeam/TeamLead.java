package org.example.DeveloperTeam;

import org.example.entityBacklog.ProductBacklog;
import org.example.entityTask.Status;
import org.example.entityTask.Task;
import org.example.sprintBacklog.SprintBacklog;

public class TeamLead extends Programist {
    Position position = Position.TEAM_LEAD;

    public TeamLead(){}
    public TeamLead(String name, String lastName, int salary) {
        super(name, lastName, salary);
    }

    public void moveTasksFromProductBacklogToSprintBacklog(ProductBacklog productBacklog, SprintBacklog sprintBacklog) {
        productBacklog.move(sprintBacklog);
    }

    public void markTaskAsDone(SprintBacklog sprintBacklog){
        sprintBacklog.peek().setStatus(Status.DONE);
    }
    public void inspectSprintBacklog(SprintBacklog sprintBacklog){
        if (sprintBacklog.peek().getStatus() == Status.DONE){
            sprintBacklog.delete();
        }
    }
}
