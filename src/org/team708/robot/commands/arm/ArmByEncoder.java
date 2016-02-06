package org.team708.robot.commands.arm;

import org.team708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmByEncoder extends Command {
	
	private double targetDistance;
	
	private boolean up;
	private boolean atLimit;

    public ArmByEncoder(double targetDistance, boolean up) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
        
        this.targetDistance = targetDistance;
        this.up = up;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (up) {
    		Robot.arm.moveUp();
    		atLimit = Robot.clawElevator.getUpperSwitch();
    	} else {
    		Robot.arm.moveDown();
    		atLimit = Robot.clawElevator.getLowerSwitch();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return atLimit || (Math.abs(Robot.clawElevator.getTravelDistance()) >= targetDistance);
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
