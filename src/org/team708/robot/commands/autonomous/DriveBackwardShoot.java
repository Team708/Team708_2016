package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.arm.ArmDown;
import org.team708.robot.commands.arm.ArmUp;
import org.team708.robot.commands.drivetrain.DriveStraightForTime;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.RotateAndDriveToTarget;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.shooter.AutoLoaderSpin;
import org.team708.robot.commands.shooter.AutoShooterSpin;
import org.team708.robot.commands.shooter.AutoStopSL;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class DriveBackwardShoot extends CommandGroup {
	
	public  DriveBackwardShoot() {
		addSequential(new DriveStraightForTime(-AutoConstants.ROBOT_TIME_DRIVE_SPEED, 1.0));
		addSequential(new ArmDown());
		

		//addSequential(new ArmUp());
		
		//addSequential(new ArmDown());
		//addParallel(new DriveStraightForTime(-AutoConstants.ROBOT_TIME_DRIVE_SPEED, 2.0));
		
		//addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, 130.0));
    	addSequential(new RotateAndDriveToTarget(AutoConstants.SHOOTING_SONAR_DISTANCE_CLOSE));
		

    	//Shooting Sequence
    	addSequential(new AutoShooterSpin());
		addSequential(new WaitCommand(AutoConstants.SHOOTER_MOTOR_SPINUP_TIME));
		addParallel(new AutoLoaderSpin());
		addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME));
		addSequential(new AutoStopSL());

   

    }
}
