package org.team708.robot.commands.drivetrain;

import org.team708.robot.Robot;
import org.team708.robot.util.Math708;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateAndDriveToTarget extends Command {
	
	private double 		targetDistance;
	private double 		tolerance;
	private double 		minValue;
	private double 		maxValue;
	private double		moveSpeed;
	private double		rotate;
	
	/**
	 * Constructor
	 * @param rotationSpeed
	 * @param goalDegrees
	 */
    public RotateAndDriveToTarget(int targetDistance, double minValue, double maxValue, double tolerance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.visionProcessor);
        
        this.targetDistance = targetDistance;
        this.tolerance = tolerance;
        this.minValue = minValue;
        this.maxValue = maxValue;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	rotate = Robot.visionProcessor.getRotate();
    	Robot.visionProcessor.processData();
    	if (Robot.visionProcessor.isHasTarget()){
    	moveSpeed = Robot.drivetrain.moveByUltrasonic(targetDistance, minValue, maxValue, tolerance);
    	}
    	else {
    		moveSpeed = 0.0;
    	}
    	Robot.drivetrain.haloDrive(moveSpeed, rotate, true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	if (Robot.drivetrain.getSonarDistance() < 54 && Robot.drivetrain.getSonarDistance() > 34){
//    		return true;
//    	}
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
