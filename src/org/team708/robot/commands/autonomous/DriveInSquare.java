package org.team708.robot.commands.autonomous;

import org.team708.robot.commands.drivetrain.DriveStraightForTime;
import org.team708.robot.commands.drivetrain.TurnToDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class DriveInSquare extends CommandGroup {

	private static final double driveStraightSpeed = 0.4;
	private static final double driveStraightTime = 5;
	
	private static final double turnSpeed = 0.4;
	private static final double turnDegrees = 90;
   
	
    public  DriveInSquare() {
    	addSequential(new WaitCommand(4.0));
    	addSequential(new DriveStraightForTime(driveStraightSpeed, driveStraightTime));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new TurnToDegrees(turnSpeed, turnDegrees));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new DriveStraightForTime(driveStraightSpeed, driveStraightTime));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new TurnToDegrees(turnSpeed, turnDegrees));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new DriveStraightForTime(driveStraightSpeed, driveStraightTime));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new TurnToDegrees(turnSpeed, turnDegrees));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new DriveStraightForTime(driveStraightSpeed, driveStraightTime));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new TurnToDegrees(turnSpeed, turnDegrees));
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
