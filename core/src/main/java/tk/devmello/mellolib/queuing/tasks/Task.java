package tk.devmello.mellolib.queuing.tasks;



import tk.devmello.mellolib.queuing.subsystems.Subsystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Task {

    protected Set<Subsystem> subsystems = new HashSet<>();
    public abstract void run();
    
    public final void addSubsystem(Subsystem... subsystem){
        subsystems.addAll(Arrays.asList(subsystem));
    }

    public final Subsystem getSubsystem(Class<? extends Subsystem> subsystem){
        for(Subsystem s : subsystems){
            if(s.getClass().equals(subsystem)){
                return s;
            }
        }
        return null;
    }

    public abstract boolean finished();

    public void stop(){
    };

    public Subsystem[] getSubsystems() {
        return subsystems.toArray(new Subsystem[10]);
    }
}
