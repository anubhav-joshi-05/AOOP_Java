package workflow;

public class Manager extends ApprovalHandler {
	@Override
    public void approveTask(Task task) {
        if (task.getComplexityLevel() <= 2) {
            System.out.println("Manager approved the task: " + task.getName());
        } else if (nextHandler != null) {
            nextHandler.approveTask(task);
        }
    }

}
