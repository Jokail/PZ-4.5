package org.example.DeveloperTeam;

import org.example.entityTask.Status;
import org.example.entityTask.Task;
import org.example.sprintBacklog.SprintBacklog;

public class Developer extends Programist {
    private Position position;
    private int countOfDoneTask;
    private int scoreBasedOnCountOfDoneTaskWithTheirStoryPoints;
    private int sumPointDoneTask;

    public Developer() {}

    public Developer(String name, String lastName, int salary, Position position) {
        super(name, lastName, salary);
        ifATeamLid(position);
        this.position = position;
    }


    private void ifATeamLid(Position position) {
        if(position.equals(Position.TEAM_LEAD)){
            throw new DeveloperPositionTeamLead();
        }
    }

    public Task getTaskFromSprintBacklog(SprintBacklog sprintBacklog){
        return sprintBacklog.peek();
    }

    public void markTaskAsValidate(SprintBacklog sprintBacklog){
        Task taskThatDeveloping = getTaskFromSprintBacklog(sprintBacklog);
        taskThatDeveloping.setStatus(Status.VALIDATE);
        countOfDoneTask++;
        sumPointDoneTask += taskThatDeveloping.getStoryPoints().getPoint();
    }

    public int getScoreBasedOnCountOfDoneTaskWithTheirStoryPoints(){
        if (countOfDoneTask == 0){
            return 0;
        }
        return  sumPointDoneTask / countOfDoneTask;
    }
}
