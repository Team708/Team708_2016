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
import org.team708.robot.commands.loader.AutoLowGoalFire;
import org.team708.robot.commands.loader.LowGoalFire;



import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowBarShootLow extends CommandGroup {
	
	public  LowBarShootLow() {
		
		//addSequential(new DriveStraightToEncoderDistance(172));
		addSequential(new ArmDown());
		addSequential(new DriveStraightToEncoderDistance(AutoConstants.ROBOT_THROUGH_LOW_BAR, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));
		addSequential(new TurnToDegrees(-AutoConstants.TURN_SPEED, 50.0));
		addSequential(new DriveStraightToEncoderDistance(18, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));

		addSequential(new RotateAndDriveToTarget(42));
		
		addSequential(new TurnToDegrees(-AutoConstants.TURN_SPEED, 170.0));
		addSequential(new DriveStraightToEncoderDistance(-12, -AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));
		
		addSequential(new AutoLowGoalFire());
		addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME+2));
		addSequential(new AutoStopSL());

		//Shooting Sequence
//		addSequential(new AutoShooterSpin());
//		addSequential(new WaitCommand(AutoConstants.SHOOTER_MOTOR_SPINUP_TIME));
//		addParallel(new AutoLoaderSpin());
//		addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME));
//		addSequential(new AutoStopSL());
		
    }
}
