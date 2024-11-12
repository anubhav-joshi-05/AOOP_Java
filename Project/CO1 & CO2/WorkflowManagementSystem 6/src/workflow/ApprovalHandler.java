package workflow;

public abstract class ApprovalHandler {


//Abstract handler in the chain of responsibility

 protected ApprovalHandler nextHandler;

 public void setNextHandler(ApprovalHandler nextHandler) {
     this.nextHandler = nextHandler;
 }

 public abstract void approveTask(Task task);
}