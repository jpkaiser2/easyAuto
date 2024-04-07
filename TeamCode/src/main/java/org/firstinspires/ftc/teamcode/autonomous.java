package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//Created by Jacob Kaiserman
//@Autonomous
@Disabled
public class autonomous extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;

    //function for moving forward n ticks
    public void drive(String direction, int power) {
        //switch statement for different directions
        switch(direction){
            case "stop":
                //code to stop
                frontLeft.setPower(0);
                frontLeft.setPower(0);
                backLeft.setPower(0);
                frontRight.setPower(0);
                backRight.setPower(0);
                telemetry.addData(">", "stopped");
                break;
            case "forward":
                //code for forward
                frontLeft.setPower(power);
                frontLeft.setPower(power);
                backLeft.setPower(power);
                frontRight.setPower(power);
                backRight.setPower(power);
                telemetry.addData(">", "moved forward");
                break;
            case "backward":
                //code for backward
                frontLeft.setPower(-power);
                backLeft.setPower(-power);
                frontRight.setPower(-power);
                backRight.setPower(-power);
                break;
            case "left":
                //code for left
                frontLeft.setPower(-power);
                backLeft.setPower(power);
                frontRight.setPower(power);
                backRight.setPower(-power);
                break;
            case "right":
                //code for right
                frontLeft.setPower(power);
                backLeft.setPower(-power);
                frontRight.setPower(-power);
                backRight.setPower(power);
                break;
            default:
                telemetry.addData(">", "no direction set");
                telemetry.update();
        }

    }

    @Override
    public void runOpMode() throws InterruptedException{ //if broken delete throws
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);



        waitForStart();
        if (opModeIsActive()) {
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

                drive("forward",1);
                sleep(4000);
                drive("stop",0);

        }
    }
}
