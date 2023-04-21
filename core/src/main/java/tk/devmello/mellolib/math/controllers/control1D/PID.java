package tk.devmello.mellolib.math.controllers.control1D;


import tk.devmello.mellolib.math.controllers.AbstractController;
import tk.devmello.mellolib.math.misc.MinMax;

public class PID extends AbstractController {
    private final MiniPID pid;

    public PID(double p, double i, double d) {
        this(p, i, d, 0.02);
    }

    public PID(double p, double i, double d, double f) {
        pid = new MiniPID(p, i, d, f);
    }

    @Override
    public double calculate(double value) {
        return MinMax.clip(
                pid.getOutput(value, getTarget()),
                getMin(),
                getMax()
        );
    }

    public PID setP(double p) {
        pid.setP(p);

        return this;
    }

    public PID setI(double i) {
        pid.setI(i);

        return this;
    }

    public PID setD(double d) {
        pid.setDerivative(d);

        return this;
    }

    public PID setF(double f) {
        pid.setFeedForward(f);

        return this;
    }
}
