package tk.devmello.mellolib.queuing.subsystems;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import tk.devmello.mellolib.math.controllers.control1D.PIDController;


public class LiftSubsystem extends Subsystem {
    public DcMotorEx encoder;
    private final DcMotorSimple motor;
    public static int none = 50;
    public static int ground = 150;
    public static int low = 800; // 837
    public static int medium = 1650;
    public static int high = 2350;

    public static int fifth = 250;
    public static int fourth = 200;
    public static int third = 150; // 837
    public static int second = 100;
    public static int first = 50;

    public static double kP = 0.005;
    public static double kI = 0;
    public static double kD = 0;
    public static double kG = 0.041;

    public static double power = 1;
    public static int threshold = 20;

    public static double slowFactor = 1.5;
    private int currentTarget;

    private double output;

    public final double ticks_in_degree = 700/180.0;

    protected PIDController controller;


    public LiftSubsystem(DcMotorEx encoder, DcMotorSimple motor) {
        controller = new PIDController(kP, kI, kD);
        this.encoder = encoder;
        this.motor = motor;
    }

    public void setHigh() {
        currentTarget = high;
        int currentPos = encoder.getCurrentPosition();
        double pid = controller.calculate(currentPos, currentTarget);
        double ff = Math.cos(Math.toRadians(currentTarget/ticks_in_degree)) * kG;
        double output = pid + ff;
        motor.setPower(output);
    }

    public void setMedium() {
        currentTarget = medium;
        int currentPos = encoder.getCurrentPosition();
        double pid = controller.calculate(currentPos, currentTarget);
        double ff = Math.cos(Math.toRadians(currentTarget/ticks_in_degree)) * kG;
        double output = pid + ff;
        motor.setPower(output);
    }

    public void setLow() {
        currentTarget = low;
        int currentPos = encoder.getCurrentPosition();
        double pid = controller.calculate(currentPos, currentTarget);
        double ff = Math.cos(Math.toRadians(currentTarget/ticks_in_degree)) * kG;
        double output = pid + ff;
        motor.setPower(output);
    }


    public void setNone() {
        currentTarget = none;
        int currentPos = encoder.getCurrentPosition();
        double pid = controller.calculate(currentPos, currentTarget);
        double ff = Math.cos(Math.toRadians(currentTarget/ticks_in_degree)) * kG;
        double output = pid + ff;
        motor.setPower(output);
    }

    public boolean isHigh() {
        return Math.abs(encoder.getCurrentPosition() - high) < threshold;
    }

    public boolean isMedium() {
        return Math.abs(encoder.getCurrentPosition() - medium) < threshold;
    }

    public boolean isLow() {
        return Math.abs(encoder.getCurrentPosition() - low) < threshold;
    }

    public boolean isNone() {
        return Math.abs(encoder.getCurrentPosition() - none) < threshold;
    }

    public void stopMotor() {
        motor.setPower(0);
    }

}
