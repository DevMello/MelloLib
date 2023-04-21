package tk.devmello.mellolib.exceptions;

import tk.devmello.mellolib.queuing.tasks.TaskQueue;

public class InvalidToleranceException extends RuntimeException {

    public InvalidToleranceException(String s) {
        TaskQueue.exceptionLogger.consoleLogError(s);
    }

    public static void throwIfInvalid(String message, double tolerance) {
        if (tolerance < 0) throw new InvalidToleranceException(message);
    }
}