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
 *@author Thomas Zhao
 */
public class ChevalShootHigh extends CommandGroup {
	
	public  ChevalShootHigh(boolean rightSide) {
		//Drive Slowly to Cheval
		addSequential(new DriveStraightToEncoderDistance(AutoConstants.ROBOT_TO_CHEVAL, AutoConstants.ROBOT_TO_CHEVAL_SPEED));
				
		//Arm Down Sequence
		addSequential(new AutoArmDown());
		addSequential(new WaitCommand(AutoConstants.ARM_DOWN_TIME));
		addSequential(new ArmStop());
		
		//Drive Forward Again
		addSequential(new DriveStraightToEncoderDistance(AutoConstants.ROBOT_TO_DEFENSE_DISTANCE, -AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));
		
		
		//Turn To to Target
		if (rightSide){
			addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, -AutoConstants.TURN_AROUND_FACE_TARGET));
		} else {
			addSequential(new TurnToDegrees(-AutoConstants.TURN_SPEED, AutoConstants.TURN_AROUND_FACE_TARGET));
		}
				
		//Track and Drive to Target
		addSequential(new RotateAndDriveToTarget(AutoConstants.SHOOTING_SONAR_DISTANCE_CLOSE));
		
		//Shooting Sequence
		addSequential(new AutoShooterSpin());
		addSequential(new WaitCommand(AutoConstants.SHOOTER_MOTOR_SPINUP_TIME));
		addParallel(new AutoLoaderSpin());
		addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME));
		addSequential(new AutoStopSL());

    }
}
