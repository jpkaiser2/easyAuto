package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
//Created by Jacob Kaiserman
//@TeleOp
@Disabled
public class testBotCode extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    @Override
    public void runOpMode() throws InterruptedException { //if broken delete throws
        float x;
        float y;
        float clockwise;
        double fl;
        double fr;
        double bl;
        double br;
        double speed = 1;

        //maps hardware
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        //arm = hardwareMap.get(DcMotor.class, "arm");
        //claw = hardwareMap.get(Servo.class, "claw");

        //reverse direction of motors since diagonal axles are reversed
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        if (opModeIsActive()) {
            //set motors to brake
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            //arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


            while (opModeIsActive()) {
                //sets x & y axis of movement
                x = gamepad1.left_stick_x;
                y = -gamepad1.left_stick_y;
                //sets rotation
                clockwise = gamepad1.right_stick_x;

                telemetry.addData("A", gamepad1.dpad_up);
                //y-axis movement
                if (gamepad1.dpad_up) {
                    y = (float) 1.0;
                } else if (gamepad1.dpad_down) {
                    y = (float) -1.0;
                }

                //x-axis movement
                if (gamepad1.dpad_right) {
                    x = (float) 1.0;
                } else if (gamepad1.dpad_left) {
                    x = (float) -1.0;
                }

                //rotation
                if (gamepad1.back) {
                    clockwise = (float) -1.0;
                } else if (gamepad1.guide) {
                    clockwise = (float) 1.0;
                }
                clockwise /= 2;
                fl = y + x + clockwise;
                fr = y - x - clockwise;
                bl = y - x + clockwise;
                br = y + x - clockwise;

                //arm movement
                /*if (gamepad1.left_trigger > 0) {
                    //arm.setPower(gamepad1.left_trigger);
                    //while (gamepad1.left_trigger > 0) {
                        //arm.setTargetPosition(100);
                    //}
                    arm.setTargetPosition((arm.getCurrentPosition())-10);
                    arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    arm.setPower(0.75);
                }
                else if (gamepad1.right_trigger > 0) {
                    //arm.setPower(-gamepad1.right_trigger);
                    //while (gamepad1.left_trigger > 0) {
                        //arm.setTargetPosition(-100);
                    //}
                    arm.setTargetPosition((arm.getCurrentPosition())+10);
                    arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    arm.setPower(0.75);
                }
                else {
                    arm.setPower(0);
                }


                    //claw movement
                if (gamepad1.left_bumper) {
                    // move to 180 degrees.
                    claw.setPosition(0);
                } else if (gamepad1.right_bumper) {
                    // move to 90 degrees.
                    claw.setPosition(1);
                }*/
                speed = 0.5;
                fl /= speed;
                fr /= speed;
                bl /= speed;
                br /= speed;


                telemetry.addData("SPEED", speed);
                telemetry.addData("FLP", fl);
                telemetry.addData("FRP", fr);
                telemetry.addData("BLP", bl);
                telemetry.addData("BRP", br);
                telemetry.addData("Clockwise", clockwise);
                telemetry.addData("Arm-L", gamepad1.left_trigger);
                telemetry.addData("Arm-R", gamepad1.right_trigger);
                //telemetry.addData("Claw Position", claw.getPosition());

                frontLeft.setPower(fl);
                frontRight.setPower(fr);
                backLeft.setPower(bl);
                backRight.setPower(br);

                telemetry.update();
            }
            // arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }
}
