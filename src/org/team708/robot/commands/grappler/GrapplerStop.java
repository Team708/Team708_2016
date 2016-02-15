package org.team708.robot.commands.grappler;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Thomas Zhao
 *@author Alex Tysak
 */
public class GrapplerStop extends Command {
	

    
    public GrapplerStop(boolean useSmoothing) {
    	// Use requires() here to declare subsystem dependencies
    	requires(Robot.grappler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grappler.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.grappler.stop();
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.grappler.stop();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}