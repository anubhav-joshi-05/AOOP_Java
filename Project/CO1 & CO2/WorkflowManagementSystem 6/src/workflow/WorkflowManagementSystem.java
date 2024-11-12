package workflow;

public class WorkflowManagementSystem {

	 public static void main(String[] args) {
	        // Step 1: Set up the Chain of Responsibility for approvals
	        ApprovalHandler supervisor = new Supervisor();
	        ApprovalHandler manager = new Manager();
	        ApprovalHandler director = new Director();

	        supervisor.setNextHandler(manager);
	        manager.setNextHandler(director);

	        // Step 2: Create a collection of tasks
	        TaskCollection taskCollection = new TaskCollection();
	        taskCollection.addTask(new Task("Task 1", 1));
	        taskCollection.addTask(new Task("Task 2", 2));
	        taskCollection.addTask(new Task("Task 3", 3));
	        taskCollection.addTask(new Task("Task 4", 4));

	        // Step 3: Set up the WorkflowInvoker to execute commands
	        WorkflowInvoker invoker = new WorkflowInvoker();

	        // Step 4: Process each task using the Command pattern
	        for (Task task : taskCollection) {
	            Command approveCommand = new ApproveTaskCommand(supervisor, task);
	            invoker.setCommand(approveCommand);
	            invoker.executeCommand();
	        }
	    }

}

