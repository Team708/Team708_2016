package org.team708.robot.commands.autonomous;
import edu.wpi.first.wpilibj.Preferences;

import org.team708.robot.AutoConstants;
import org.team708.robot.Constants;
import org.team708.robot.Robot;
import org.team708.robot.commands.arm.ArmDown;
import org.team708.robot.commands.arm.JoystickMoveArm;
import org.team708.robot.commands.drivetrain.DriveStraightForTime;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.RotateAndDriveToTarget;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.shooter.AutoShooterSpin;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Drive2TurnRightShoot extends CommandGroup {
	

	
	
	public  Drive2TurnRightShoot(){
		
		addSequential(new ArmDown()); //always gonna happen
		addSequential(new DriveStraightToEncoderDistance(AutoConstants.ROBOT_TO_DEFENSE_DISTANCE * AutoConstants.GO_TO_2_DEFENSES, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED, false));
		
		addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, 90 * AutoConstants.TURN_RIGHT));
		addSequential(new DriveStraightForTime(AutoConstants.ROBOT_TIME_DRIVE_SPEED, AutoConstants.ROBOT_OVER_DEFENSE_TIME));
		addSequential(new RotateAndDriveToTarget(AutoConstants.SHOOTING_SONAR_DISTANCE));
		addSequential(new AutoShooterSpin());
		
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
	
	
}
