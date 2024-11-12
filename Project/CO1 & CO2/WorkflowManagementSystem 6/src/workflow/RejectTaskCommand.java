package workflow;

public class RejectTaskCommand implements Command {
	private Task task;

    public RejectTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        System.out.println("Task rejected: " + task.getName());
    }
}
