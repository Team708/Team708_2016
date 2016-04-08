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
import org.team708.robot.commands.intake.AutoIntakeIn;
import org.team708.robot.commands.loader.AutoLowGoalFire;
import org.team708.robot.commands.shooter.AutoLoaderSpin;
import org.team708.robot.commands.shooter.AutoShooterSpin;
import org.team708.robot.commands.shooter.AutoStopSL;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *@author Thomas Zhao
 */
public class DriveBackwardShootLow extends CommandGroup {
	
	public  DriveBackwardShootLow(boolean rightSide) {
		
		//Drive Forward
		addSequential(new DriveStraightForTime(-AutoConstants.ROBOT_TIME_DRIVE_SPEED, AutoConstants.ROBOT_OVER_DEFENSE_TIME));
		
		//Arm Down Sequence
		addSequential(new AutoArmDown());
		addSequential(new WaitCommand(AutoConstants.ARM_DOWN_TIME));
		addSequential(new ArmStop());
		
		//Drive Forward Again (Hopefully over defense)
		addParallel(new DriveStraightForTime(-AutoConstants.ROBOT_TIME_DRIVE_SPEED, AutoConstants.ROBOT_OVER_DEFENSE_TIME));
		
		//Once Over Defense, turn towards target (Depends on which side of field)
		if (rightSide){
			addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, -AutoConstants.TURN_AROUND_FACE_TARGET));
		} else {
			addSequential(new TurnToDegrees(-AutoConstants.TURN_SPEED, AutoConstants.TURN_AROUND_FACE_TARGET));
		}
		
		//Track and Drive To Target
    	addSequential(new RotateAndDriveToTarget(AutoConstants.SHOOTING_SONAR_DISTANCE_CLOSE));
		
    	//Rotate nearly 180 degrees (direction depends on side of field) and Drive Up Ramp
    	if (rightSide){
    		addSequential(new TurnToDegrees(AutoConstants.LOWGOAL_TURN_SPEED, -AutoConstants.TURN_180_FACE_LOWGOAL));
    	}
    	else {
    		addSequential(new TurnToDegrees(AutoConstants.LOWGOAL_TURN_SPEED, -AutoConstants.TURN_180_FACE_LOWGOAL));
    	}
    	addSequential(new DriveStraightToEncoderDistance(AutoConstants.DRIVE_UP_RAMP_DISTANCE, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED, false));
    	
    	//Spits Ball Out Intake
    	addSequential(new AutoLowGoalFire());
    	addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME));
    	addSequential(new AutoStopSL());
    	
    	//Check if Ball came back (didn't make it in)
    	addSequential(new AutoIntakeIn());
    	addSequential(new WaitCommand(1));
    	
    	//Turn Slightly and Fire Again
    	addSequential(new TurnToDegrees(0.6, -2.0));
    	addSequential(new AutoLowGoalFire());
    	addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME));
    	addSequential(new AutoStopSL());
    	
    }
}
