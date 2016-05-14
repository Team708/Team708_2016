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

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowBarNoShoot extends CommandGroup {
	
	public  LowBarNoShoot() {
		
		//Arm Down Sequence
		addSequential(new AutoArmDown());
		addSequential(new WaitCommand(AutoConstants.ARM_DOWN_TIME));
		addSequential(new ArmStop());
		
		//Drive Through LowBar
		addSequential(new DriveStraightToEncoderDistance(AutoConstants.ROBOT_THROUGH_LOW_BAR, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));
	
    }
}
