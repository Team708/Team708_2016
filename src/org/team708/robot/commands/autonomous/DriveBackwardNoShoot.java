package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.arm.ArmDown;
import org.team708.robot.commands.arm.ArmStop;
import org.team708.robot.commands.arm.ArmUp;
import org.team708.robot.commands.arm.AutoArmDown;
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
public class DriveBackwardNoShoot extends CommandGroup {
	
	public  DriveBackwardNoShoot() {
		
		addSequential(new AutoArmDown());
		addSequential(new WaitCommand(.2));
		addSequential(new ArmStop());
		
		//Drive Forward
		addSequential(new DriveStraightForTime(-(-.8), .75));
		
		//Arm Down Sequence
		addSequential(new AutoArmDown());
		addSequential(new WaitCommand(.5));
		addSequential(new ArmStop());
		
		//Drive Forward Again (Hopefully over defense)
		//addParallel(new DriveStraightForTime(-AutoConstants.ROBOT_TIME_DRIVE_SPEED, AutoConstants.ROBOT_OVER_DEFENSE_TIME));
		//Drive Forward Again
		addSequential(new DriveStraightForTime(-AutoConstants.ROBOT_TIME_DRIVE_SPEED, 0.5));
    }
}
