package org.team708.robot.commands.grappler;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Thomas Zhao
 *@author Alex Tysak
 */
public class GrapplerOut extends Command {
	
	private boolean isAtLimit;
	
	private double moveSpeed = Constants.MOTOR_FORWARD;
    
    public GrapplerOut() {
    	// Use requires() here to declare subsystem dependencies
    	requires(Robot.grappler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isAtLimit = Robot.grappler.getUpperSwitch();
    	
    	if(isAtLimit){
    		cancel();
    	}

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.grappler.manualMove(moveSpeed);
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return Robot.grappler.getUpperSwitch();
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (Robot.grappler.getUpperSwitch()) {
    		
    	}
    	Robot.grappler.stop();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}