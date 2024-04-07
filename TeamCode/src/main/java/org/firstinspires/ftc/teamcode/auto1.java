//Created by Jacob Kaiserman
//Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Disabled
@Autonomous(name="auto1", group="Linear Opmode")
//Auto for red alliance back
// @Disabled
public class auto1 extends LinearOpMode {
    Hardware robot = new Hardware(this);
    @Override
    public void runOpMode() throws InterruptedException {
        //waits for player to press start
        waitForStart();
        if (opModeIsActive()) {
            robot.init();
            robot.drive("forward",0.5,200);
            robot.stop();
            robot.drive("right",1,200);
            robot.stop();
            robot.drive("forward",1,500);
            robot.stop();
            robot.turn("right",1,600);
            robot.stop();
            robot.drive("forward",0.75,1200);
            robot.stop();
            robot.drive("backward",0.75,500);
            robot.stop();
            robot.drive("right",1,800);
            robot.stop();
            robot.drive("forward",0.75,700);
            robot.stop();
        }
    }
}