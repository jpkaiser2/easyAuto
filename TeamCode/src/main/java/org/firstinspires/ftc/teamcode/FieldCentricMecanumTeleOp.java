package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

//@TeleOp
@Disabled
public class FieldCentricMecanumTeleOp extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor hanger;

    @Override
    public void runOpMode() {
        float x;
        float y;
        float clockwise;
        double fl;
        double fr;
        double bl;
        double br;
        int speed = 1;
        double heading, rotX, rotY, denominator;

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        hanger = hardwareMap.get(DcMotor.class, "hanger");

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        IMU imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        imu.initialize(parameters);

        waitForStart();
        if (opModeIsActive()) {
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            while (opModeIsActive()) {
                imu.resetYaw();
                x = gamepad1.left_stick_x;
                y = -gamepad1.left_stick_y;
                clockwise = gamepad1.right_stick_x;

                if (gamepad1.dpad_up) {
                    imu.resetYaw();
                    y = (float) -1.0;
                } else if (gamepad1.dpad_down) {
                    imu.resetYaw();
                    y = (float) 1.0;
                }

                if (gamepad1.dpad_right) {
                    imu.resetYaw();
                    x = (float) 1.0;
                } else if (gamepad1.dpad_left) {
                    imu.resetYaw();
                    x = (float) -1.0;
                }

                if (gamepad1.ps) {
                    imu.resetYaw();
                    imu.resetYaw();
                }

                if(gamepad1.a){

                    hanger.setPower(1);
                }
                else if(gamepad1.b){
                    hanger.setPower(-1);
                }
                else{
                    hanger.setPower(0);
                }

                heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
                rotX = (x * Math.cos(-heading) - y * Math.sin(-heading)) * 1.1;
                rotY = x * Math.sin(-heading) + y * Math.cos(-heading);
                denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(clockwise), 1);
                fl = (rotY + rotX + clockwise) / denominator;
                fr = (rotY - rotX - clockwise) / denominator;
                bl = (rotY - rotX + clockwise) / denominator;
                br = (rotY + rotX - clockwise) / denominator;

                fl /= speed;
                fr /= speed;
                bl /= speed;
                br /= speed;

                frontLeft.setPower(fl);
                frontRight.setPower(fr);
                backLeft.setPower(bl);
                backRight.setPower(br);

                telemetry.update();
            }
        }
    }
}