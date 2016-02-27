package org.team708.robot.commands.drivetrain;

import org.team708.robot.Robot;
import org.team708.robot.util.Math708;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RotateAndDriveToTarget extends Command {
	
	private double 		targetDistance;
	private double		moveSpeed;
	private double		rotate;
	
	/**
	 * Constructor
	 * @param rotationSpeed
	 * @param goalDegrees
	 */
    public RotateAndDriveToTarget(double targetDistance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.visionProcessor);
        
        this.targetDistance = targetDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.visionProcessor.processData();
    	rotate = Robot.visionProcessor.getRotate();
    	if (Robot.visionProcessor.isHasTarget() || Robot.visionProcessor.wasCentered()){
    		moveSpeed = 0.6;
    	}
    	else {
    		moveSpeed = 0.0;
    	}
    	if (Robot.visionProcessor.wasCentered()){
    		rotate = 0.0;
    	}
    	
    	Robot.drivetrain.haloDrive(-moveSpeed, -rotate, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	if (Robot.drivetrain.getSonarDistance() < targetDistance  && Robot.visionProcessor.wasCentered()){
    		return true;
    	}
    	else if (Robot.drivetrain.getSonarDistance() < targetDistance && Robot.visionProcessor.isHasTarget()) {
    		return true;
    	}
    	
    	return false;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
