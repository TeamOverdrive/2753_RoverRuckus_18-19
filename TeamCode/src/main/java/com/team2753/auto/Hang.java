package com.team2753.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.team2753.Team753Linear;

/**
 * Created by David Zheng | FTC 2753 Team Overdrive on 12/3/2018.
 */

@Autonomous(name = "Land Only")
public class Hang extends Team753Linear{
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart("Crater Autonomous", true);
        while(opModeIsActive() && !isStopRequested()) {

            //A Land only autonomous

            Robot.getLift().setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
            Robot.getLift().setTarget(0);
            Robot.getLift().setPower(-0.25);
            while(Robot.getLift().getAveragePosition() >= 75){}
            Robot.getLift().unlock();
            Robot.getLift().setPower(0);
            Robot.getLift().setTarget(3800);
            Robot.getLift().setPower(1);
            while(Robot.getLift().getAveragePosition() <= 3700){}
            Robot.getLift().setPower(0);
            Robot.getDrive().encoderDrive(0.5, 6, 6, 4, this);
            Robot.getLift().setTarget(0);
            Robot.getLift().setPower(-0.75);
            while(Robot.getLift().getAveragePosition() >= 100){}
            Robot.getLift().setPower(0);


            finalAction();
        }
    }
}
