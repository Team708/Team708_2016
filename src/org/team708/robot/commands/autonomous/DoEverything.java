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
import org.team708.robot.commands.shooter.AutoShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class DoEverything extends CommandGroup {
	
	double turnDirection;
	
	
//	public  DoEverything(double defenceNumber, double turnDirection, double driveThroughDefenceTime){
	public  DoEverything(){
		turnDirection = Robot.turnDirection;
	//	addSequential(new ArmDown()); //always gonna happen
	//	addSequential(new DriveStraightToEncoderDistance(50 * defenceNumber, Constants.DRIVE_MOTOR_MAX_SPEED, true));
		
		addSequential(new DriveStraightForTime (1.0, 1));
		addSequential(new TurnToDegrees(Constants.ROTATE_MOTOR_MAX_SPEED, 90 * turnDirection));
	//	addSequential(new DriveStraightForTime(1.0, driveThroughDefenceTime));
	//	addSequential(new RotateAndDriveToTarget(44));
		addSequential(new AutoShoot());
		
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
