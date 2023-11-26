package org.example.sprintBacklog;

import org.example.DeveloperTeam.Programist;
import org.example.entityTask.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SprintBacklog {
    private final Queue<Task> sprintBacklog = new PriorityQueue<>();
    private int sumStoryPoint;

    public void add(Task task){
        sprintBacklog.add(task);
        sumStoryPoint += task.getStoryPoints().getPoint();
    }
    public Task delete(){
        return sprintBacklog.poll();
    }
    public Task peek(){
        return sprintBacklog.peek();
    }

    public int getCapacity() {
        if (sumStoryPoint == 0){
            return 0;
        }
        if (Programist.countProgramist == 0){
            return 0;
        }
        return  sumStoryPoint / Programist.countProgramist;
    }
}
