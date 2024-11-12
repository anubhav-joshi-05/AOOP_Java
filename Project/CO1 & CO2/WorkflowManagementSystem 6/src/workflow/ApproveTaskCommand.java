package workflow;

public class ApproveTaskCommand implements Command {
    private ApprovalHandler handler;
    private Task task;

    public ApproveTaskCommand(ApprovalHandler handler, Task task) {
        this.handler = handler;
        this.task = task;
    }

    @Override
    public void execute() {
        handler.approveTask(task);
    }
}
