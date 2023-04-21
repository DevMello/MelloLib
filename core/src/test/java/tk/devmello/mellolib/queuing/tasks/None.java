package tk.devmello.mellolib.queuing.tasks;

import tk.devmello.mellolib.queuing.subsystems.LiftSubsystem;

public class None extends Task {

        private LiftSubsystem liftSubsystem;
        public None(LiftSubsystem liftSubsystem) {
            this.liftSubsystem = liftSubsystem;
            addSubsystem(liftSubsystem);
        }
        @Override
        public void run() {
            liftSubsystem.setNone();
        }

        @Override
        public boolean finished() {
            return liftSubsystem.isNone();
        }

}
