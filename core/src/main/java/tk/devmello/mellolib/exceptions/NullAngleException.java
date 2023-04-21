package tk.devmello.mellolib.exceptions;


import tk.devmello.mellolib.math.geometry.Angle;
import tk.devmello.mellolib.queuing.tasks.TaskQueue;

public class NullAngleException extends RuntimeException {

    public NullAngleException(String message) {
        TaskQueue.exceptionLogger.consoleLogError(message);
    }

    public static void throwIfInvalid(String message, Angle angle) {
        if (angle == null) {
            throw new NullAngleException(message);
        }
    }
}