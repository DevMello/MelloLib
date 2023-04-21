package tk.devmello.mellolib.queuing.tasks;

import tk.devmello.mellolib.queuing.subsystems.LiftSubsystem;

public class Medium extends Task {
    private LiftSubsystem liftSubsystem;
    public Medium(LiftSubsystem liftSubsystem) {
        this.liftSubsystem = liftSubsystem;
        addSubsystem(liftSubsystem);
    }
    @Override
    public void run() {
        liftSubsystem.setMedium();
    }

    @Override
    public boolean finished() {
        return liftSubsystem.isMedium();
    }


}
