package workflow;

public class Director extends ApprovalHandler {
    @Override
    public void approveTask(Task task) {
        if (task.getComplexityLevel() <= 3) {
            System.out.println("Director approved the task: " + task.getName());
        } else {
            System.out.println("Task requires additional review: " + task.getName());
        }
    }
}
