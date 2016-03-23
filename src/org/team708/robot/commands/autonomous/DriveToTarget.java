package org.team708.robot.commands.autonomous;

import org.team708.robot.commands.drivetrain.DriveStraightForTime;
import org.team708.robot.commands.drivetrain.DriveToUltrasonic;
import org.team708.robot.commands.drivetrain.RotateAndDriveToTarget;
import org.team708.robot.commands.drivetrain.DriveToIRDistance;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.visionProcessor.FindTarget;


import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class DriveToTarget extends CommandGroup {

   
	
    public  DriveToTarget() {
		addSequential(new RotateAndDriveToTarget(44));
    }
}
