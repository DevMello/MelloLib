package tk.devmello.mellolib.queuing.subsystems;

public abstract class Subsystem {
    protected String name = this.getClass().getSimpleName();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubsystem() {
        return getName();
    }

    public void setSubsystem(String subsystem) {
        setName(subsystem);
    }
}
