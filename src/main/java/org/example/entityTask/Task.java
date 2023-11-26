package org.example.entityTask;

public class Task implements Comparable<Task> {
    public static int id;
    public String name;
    Status status = Status.TO_DO;
    StoryPoints storyPoints;
    Priority priority = Priority.randomPriority();

    public Task(StoryPoints storyPoints){
        id++;
        name = "task#" + id;
        this.storyPoints = storyPoints;
    }

    public StoryPoints getStoryPoints() {
        return storyPoints;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    @Override
    public int compareTo(Task task) {
       return Integer.compare(priority.ordinal(), task.priority.ordinal());
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", storyPoints=" + storyPoints +
                ", priority=" + priority +
                '}';
    }
}
