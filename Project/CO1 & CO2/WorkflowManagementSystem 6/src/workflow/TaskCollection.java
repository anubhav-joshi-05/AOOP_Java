package workflow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskCollection implements Iterable<Task> {
    private List<Task> tasks;

    public TaskCollection() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }
}
