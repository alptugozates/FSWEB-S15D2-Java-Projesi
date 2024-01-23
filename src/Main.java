import com.workintech.tasks.Task;
import com.workintech.tasks.TaskData;
import com.workintech.tasks.enums.Priority;
import com.workintech.tasks.enums.Status;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TaskData taskData = new TaskData();

        Task task1 = new Task("Project A", "Task 1", "Ann", Priority.HIGH, Status.IN_QUEUE);
        Task task2 = new Task("Project B", "Task 2", "Bob", Priority.MED, Status.ASSIGNED);
        Task task3 = new Task("Project C", "Task 3", "Carol", Priority.LOW, Status.IN_PROGRESS);

        taskData.addTask(task1);
        taskData.addTask(task2);
        taskData.addTask(task3);

        Set<Task> allTasks = taskData.getTasks("all");
        System.out.println("Tüm çalışanların taskleri: " + allTasks);

        Set<Task> annsTasks = taskData.getTasks("ann");
        Set<Task> bobsTasks = taskData.getTasks("bob");
        Set<Task> carolsTasks = taskData.getTasks("carol");

        Set<Task> unassignedTasks = taskData.getDifference(allTasks, taskData.getUnion(annsTasks, bobsTasks, carolsTasks));
        System.out.println("Herhangi bir çalışana atanmamış tasklar: " + unassignedTasks);

        Set<Task> intersectTasksAnnBob = taskData.getIntersect(annsTasks, bobsTasks);
        Set<Task> intersectTasksAnnCarol = taskData.getIntersect(annsTasks, carolsTasks);
        Set<Task> intersectTasksBobCarol = taskData.getIntersect(bobsTasks, carolsTasks);

        if(!intersectTasksAnnBob.isEmpty() || !intersectTasksAnnCarol.isEmpty() || !intersectTasksBobCarol.isEmpty()) {
            System.out.println("Birden fazla çalışana atanmış taskler var.");
            System.out.println("Ann ve Bob arasında kesişen taskler var." + intersectTasksAnnBob);
            System.out.println("Ann ve Carol arasında kesişen taskler var." + intersectTasksAnnCarol);
            System.out.println("Bob ve Carol arasında kesişen taskler var." + intersectTasksBobCarol);
        }
        else {
            System.out.println("Birden fazla çalışana atanmış task bulunamadı.");
        }
    }
}