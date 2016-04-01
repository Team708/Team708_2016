package org.team708.robot.commands.intake;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

/**
 *@author James_Makovics
 *@author Alex Tysak
 *@author Thomas Zhao
 */
public class AutoLowGoal extends Command {

	
    public AutoLowGoal() {
    	requires(Robot.intake);
    	requires(Robot.loader);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.loader.manualMove(Constants.LOADER_MOTOR_REVERSE);
    	Robot.intake.moveMotor(Constants.INTAKE_REVERSE);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return(true);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
