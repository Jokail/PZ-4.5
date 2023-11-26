package org.example.DeveloperTeam;

public class Programist {

    private String name;
    private String lastName;
    private int salary;
    public static int countProgramist;

    public Programist(){
        countProgramist++;
    }

    public Programist(String name, String lastName, int salary) {
        countProgramist++;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }
}
