package org.team708.robot.commands.drivetrain;

import org.team708.robot.Robot;

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
    	moveSpeed = Robot.drivetrain.moveByUltrasonic(targetDistance, minValue, maxValue, tolerance);
    	Robot.drivetrain.haloDrive(moveSpeed, Robot.visionProcessor.getRotate(), true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
