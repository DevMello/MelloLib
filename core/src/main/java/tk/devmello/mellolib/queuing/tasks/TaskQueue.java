package tk.devmello.mellolib.queuing.tasks;

import tk.devmello.mellolib.devlogger.Logger;
import tk.devmello.mellolib.queuing.subsystems.Subsystem;
import tk.devmello.mellolib.util.time.ElapsedTimer;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue {

    public static Logger logger = new Logger("General");
    public static Logger taskLogger = new Logger("Tasks");

    public static Logger exceptionLogger = new Logger("Exceptions");
    public List<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        //checks if the task is already in the queue. If it is return. If it isn't  check if the task is using the same subsystem as another task. If it is, remove the other task.
        if (tasks.contains(task)) {
            taskLogger.consoleLogWarn("Task " + task.getClass().getSimpleName() + " is already in the queue");
            return;
        }
        for (Subsystem subsystem : task.subsystems) {
            for (Task task1 : tasks) {
                if (task1.subsystems.contains(subsystem)) {
                    taskLogger.consoleLogWarn("Removing task " + task1.getClass().getSimpleName() + " because it is using the same subsystem as " + task.getClass().getSimpleName());
                    remove(task1);
                }
            }
        }
        tasks.add(task);
    }

    public void queueTasks(List<Task> tasks) {
        taskLogger.consoleLogInfo("Adding " + tasks.size() + " tasks to the queue");
        this.tasks.addAll(tasks);
    }


    public void tick() {
        if (tasks.isEmpty()) {
            return;
        }
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            task.run();
            if (task.finished()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
    }
    public void tickUntil(double durationMs) {
        ElapsedTimer timer = new ElapsedTimer(true);
        while (timer.elapsedMs() <= durationMs) {
            tick();
        }
    }

    public void run(Task task) {
        tasks.add(0, task);
    }

    public void stop() {
        for (Task task : tasks) {
            task.stop();
            taskLogger.consoleLogWarn("Stopping task " + task.getClass().getSimpleName());
        }
        tasks.clear();
    }

    public void clear() {
        taskLogger.consoleLogWarn("Clearing task queue");
        tasks.clear();
    }

    public void remove(Task task) {
        taskLogger.consoleLogInfo("Removing task " + task.getClass().getSimpleName());
        tasks.remove(task);
    }

}
