package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.arm.ArmDown;
import org.team708.robot.commands.arm.ArmStop;
import org.team708.robot.commands.arm.AutoArmDown;
import org.team708.robot.commands.drivetrain.DriveStraightForTime;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.RotateAndDriveToTarget;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.shooter.AutoLoaderSpin;
import org.team708.robot.commands.shooter.AutoShooterSpin;
import org.team708.robot.commands.shooter.AutoStopSL;
import org.team708.robot.commands.intake.AutoIntakeIn;
import org.team708.robot.commands.loader.AutoLowGoalFire;
import org.team708.robot.commands.loader.LowGoalFire;




import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowBarShootLow extends CommandGroup {
	
	public  LowBarShootLow() {
		
		//Arm Down Sequence
		addSequential(new AutoArmDown());
		addSequential(new WaitCommand(0.7));
		addSequential(new ArmStop());
		
		//Drive Through Low Bar
		addSequential(new DriveStraightToEncoderDistance(AutoConstants.ROBOT_THROUGH_LOW_BAR, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));
		
		//Find and Drive to Target
		addSequential(new TurnToDegrees(-AutoConstants.TURN_SPEED, 50.0));
		addSequential(new DriveStraightToEncoderDistance(18, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));
		addSequential(new RotateAndDriveToTarget(42));
		
		//Rotate nearly 180 degrees
		addSequential(new TurnToDegrees(-0.6, 167.0));
		addSequential(new DriveStraightToEncoderDistance(18, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED, false));
		
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
