package tk.devmello.mellolib.queuing;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import tk.devmello.mellolib.queuing.subsystems.LiftSubsystem;
import tk.devmello.mellolib.queuing.tasks.High;
import tk.devmello.mellolib.queuing.tasks.Medium;
import tk.devmello.mellolib.queuing.tasks.None;
import tk.devmello.mellolib.queuing.tasks.Low;
import tk.devmello.mellolib.queuing.tasks.TaskQueue;

@TeleOp
public class TestQueueSystem extends LinearOpMode {

    protected LiftSubsystem motorSubsystem;
    protected DcMotorEx motor;
    protected DcMotorSimple liftLeft;
    @Override
    public void runOpMode() throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        taskQueue.clear();
        motor = hardwareMap.get(DcMotorEx.class, "rightFront");
        liftLeft  = hardwareMap.get(DcMotorSimple.class, "slideL");
        waitForStart();

        motorSubsystem = new LiftSubsystem(motor,liftLeft);

        while (opModeIsActive()) {
            if(gamepad1.y) {
                taskQueue.add(new High(motorSubsystem));
            }
            if(gamepad1.b) {
//                taskQueue.stop();
                taskQueue.add(new Low(motorSubsystem));
            }
            if(gamepad1.a) {
                taskQueue.add(new None(motorSubsystem));
            }
            if(gamepad1.x) {
                taskQueue.add(new Medium(motorSubsystem));
            }
            taskQueue.tick();
        }
    }
}
