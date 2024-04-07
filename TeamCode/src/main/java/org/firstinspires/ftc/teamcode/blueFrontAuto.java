//Created by Jacob Kaiserman
//Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name="blueFrontAuto", group="Linear Opmode")
//Auto for red alliance back
// @Disabled
public class blueFrontAuto extends LinearOpMode {
    Hardware robot = new Hardware(this);
    @Override
    public void runOpMode() throws InterruptedException {
        //waits for player to press start
        waitForStart();
        if (opModeIsActive()) {
            robot.init();
            robot.drive("right",0.5,100);
            robot.drive("forward",0.5,2000);
            robot.stop();
            robot.drive("backward",0.5,200);
        }
    }
}