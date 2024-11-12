package workflow;

public class Supervisor extends ApprovalHandler {
    @Override
    public void approveTask(Task task) {
        if (task.getComplexityLevel() <= 1) {
            System.out.println("Supervisor approved the task: " + task.getName());
        } else if (nextHandler != null) {
            nextHandler.approveTask(task);
        }
    }
}



