//Created by Jacob Kaiserman
//Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
//@Autonomous(name="mainAuto", group="Linear Opmode")
@Disabled
public class newAuto extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;

    public void drive(String direction, double power, long time) {
        //switch statement for different directions
        switch(direction){
            case "stop":
                //code to stop
                frontLeft.setPower(0);
                frontLeft.setPower(0);
                backLeft.setPower(0);
                frontRight.setPower(0);
                backRight.setPower(0);
                sleep(time);
                telemetry.addData(">", "stopped");
                break;
            case "forward":
                //code for forward
                frontLeft.setPower(power);
                frontLeft.setPower(power);
                backLeft.setPower(power);
                frontRight.setPower(power);
                backRight.setPower(power);
                sleep(time);
                telemetry.addData(">", "moved forward");
                break;
            case "backward":
                //code for backward
                frontLeft.setPower(-power);
                backLeft.setPower(-power);
                frontRight.setPower(-power);
                backRight.setPower(-power);
                sleep(time);
                break;
            case "left":
                //code for left
                frontLeft.setPower(-power);
                backLeft.setPower(power);
                frontRight.setPower(power);
                backRight.setPower(-power);
                sleep(time);
                break;
            case "right":
                //code for right
                frontLeft.setPower(power);
                backLeft.setPower(-power);
                frontRight.setPower(-power);
                backRight.setPower(power);
                sleep(time);
                break;
            default:
                telemetry.addData(">", "no direction set");
                telemetry.update();
        }

    }

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        //if (opModeIsActive()) {
            //frontLeft.setPower(0.5);
            //frontRight.setPower(0.5);
            //backRight.setPower(0.5);
            //backLeft.setPower(0.5);
            drive("forward",0.5,200);
            drive("stop",0,200);
            drive("left",1,10000);
            drive("stop",0,200);
            //drive("forward",0.5);
            //sleep(1000);
            //drive("stop",0);
            //drive("right",0.5);

            //frontLeft.setPower(0);
            //frontRight.setPower(0);
            //backRight.setPower(0);
            //backLeft.setPower(0);
        //}
    }
}