package com.workintech.tasks;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private  Set<Task> bobsTasks;
    private  Set<Task> carolsTasks;


    public TaskData() {
        this.annsTasks = new HashSet<>();
        this.bobsTasks = new HashSet<>();
        this.carolsTasks = new HashSet<>();
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public void addTask(Task task) {
        switch (task.getAssignee()){
            case "ann":
                annsTasks.add(task);
                break;
            case "bob":
                bobsTasks.add(task);
                break;
            case "carol":
                carolsTasks.add(task);
                break;
            default:
                System.out.println("Invalid asignee: " + task.getAssignee());
        }
    }
    public Set<Task> getTasks(String assignee) {
        switch (assignee) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                return allTasks;
            default:
                throw new IllegalArgumentException("Invalid assignee: " + assignee);
        }
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> set : sets) {
            unionSet.addAll(set);
        }
        return unionSet;
    }
    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersectSet = new HashSet<>(set1);
        intersectSet.retainAll(set2);
        return intersectSet;
    }
    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> differenceSet = new HashSet<>(set2);
        differenceSet.removeAll(set2);
        return differenceSet;
    }
}
