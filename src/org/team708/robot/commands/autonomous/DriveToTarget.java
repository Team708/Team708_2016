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

	private static final double driveStraightSpeed = -0.6;
	private static final double driveStraightTime = 2;
	
	private static final double turnSpeed = 0.5;
	private static final double turnDegrees = 90;
   
	
    public  DriveToTarget() {
		addSequential(new RotateAndDriveToTarget(44));
    }
}
