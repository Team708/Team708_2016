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
	
	private double moveSpeed = Constants.MOTOR_FORWARD;

    public ArmUp() {
    	requires(Robot.arm);
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
    		Robot.arm.manualMove(moveSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return Robot.arm.getUpperSwitch();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}