package tk.devmello.mellolib.exceptions;

import tk.devmello.mellolib.queuing.tasks.TaskQueue;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        TaskQueue.exceptionLogger.consoleLogError(message);
    }
}
