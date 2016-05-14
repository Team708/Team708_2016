package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.arm.ArmDown;
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
public class OnlyShoot extends CommandGroup {
	
	public  OnlyShoot() {
		
		//Shooting Sequence
		addSequential(new AutoShooterSpin());
		addSequential(new WaitCommand(AutoConstants.SHOOTER_MOTOR_SPINUP_TIME));
		addSequential(new AutoLoaderSpin());
		addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME));
		addSequential(new AutoStopSL());
		
		
    	//addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, AutoConstants.NINETY_DEGREE_TURN));

    }
}
