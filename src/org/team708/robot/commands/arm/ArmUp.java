package org.team708.robot.commands.arm;

import org.team708.robot.Constants;
import org.team708.robot.Robot;
import org.team708.robot.util.Math708;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmUp extends Command {
	
	private boolean isAtLimit;
	
	private boolean useSmoothing;

    public ArmUp() {
        this(false);
    }
    
    public ArmUp(boolean useSmoothing) {
    	// Use requires() here to declare subsystem dependencies
    	requires(Robot.arm);
    	
    	this.useSmoothing = useSmoothing;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isAtLimit = Robot.arm.getUpperSwitch();
    	
    	if (isAtLimit) {
    		cancel();
    	} else {

    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return Robot.arm.getUpperSwitch();
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (Robot.arm.getUpperSwitch()) {
    	
    	}

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
