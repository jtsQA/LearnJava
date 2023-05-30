package org.tasks;

import java.util.concurrent.TimeUnit;

public class ExecutionFunctions {
    public static void pauseExecution(int seconds) {
        try {
            // Convert seconds to milliseconds
            long milliseconds = TimeUnit.SECONDS.toMillis(seconds);

            // Pause the execution
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
