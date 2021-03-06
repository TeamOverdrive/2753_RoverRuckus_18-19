package com.team2753.archive.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.team2753.archive.Team753Linear;

/**
 * Created by David Zheng | FTC 2753 Team Overdrive on 12/3/2018.
 */

@Autonomous(name = "Land Only", group = "0_auto")
@Disabled
@Deprecated
public class Land extends Team753Linear{
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart("Crater Autonomous", true);

        //A Land only autonomous

        //Land
        Robot.getLift().setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        Robot.getLift().setTarget(0);
        Robot.getLift().setPower(-0.5);
        Robot.getLift().unlock();
        while(Robot.getLift().getAveragePosition() >= 25){}
        Robot.getLift().setPower(0);
        Robot.getLift().setTarget(3800);
        Robot.getLift().setPower(1);
        while(Robot.getLift().getAveragePosition() <= 3700){}
        Robot.getLift().setPower(0);

        //DriveBase Forward
        Robot.getDrive().encoderDrive(0.5, 6, 6, 4, this);

        //Lower lift
        Robot.getLift().setTarget(0);
        Robot.getLift().setPower(-0.75);
        while(opModeIsActive() && Robot.getLift().getAveragePosition() >= 100){}
        Robot.getLift().setPower(0);

        finalAction();
    }
}
