package tk.devmello.mellolib.queuing.tasks;

import tk.devmello.mellolib.queuing.subsystems.LiftSubsystem;

public class High extends Task {
    private LiftSubsystem liftSubsystem;
    public High(LiftSubsystem liftSubsystem) {
        this.liftSubsystem = liftSubsystem;
        addSubsystem(liftSubsystem);
    }
    @Override
    public void run() {
        liftSubsystem.setHigh();
    }

    @Override
    public boolean finished() {
        return liftSubsystem.isHigh();
    }



}
