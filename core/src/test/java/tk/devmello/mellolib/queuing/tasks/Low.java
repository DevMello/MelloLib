package tk.devmello.mellolib.queuing.tasks;

import tk.devmello.mellolib.queuing.subsystems.LiftSubsystem;

public class Low extends Task {
    private LiftSubsystem liftSubsystem;
    public Low(LiftSubsystem liftSubsystem) {
        this.liftSubsystem = liftSubsystem;
        addSubsystem(liftSubsystem);
    }
    @Override
    public void run() {
        liftSubsystem.setLow();
    }

    @Override
    public boolean finished() {
        return liftSubsystem.isLow();
    }


}
