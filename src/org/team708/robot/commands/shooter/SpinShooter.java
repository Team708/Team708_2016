package org.team708.robot.commands.shooter;
import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.subsystems.Loader;
import org.team708.robot.util.Gamepad;
import org.team708.robot.commands.shooter.Fire;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class SpinShooter extends Command {


    public SpinShooter() {
    	requires(Robot.shooter);
    }
    
    boolean Lpressed;
    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.drivetrain.sonarOverride == 1){
		Robot.shooter.manualSpeed(Constants.SHOOTER_MOTOR_POWER_FORWARD_HIGH);
		Robot.shooter.motorIsHigh = true;
    	} else if (Robot.drivetrain.sonarOverride == 2) {
    		Robot.shooter.manualSpeed(Constants.SHOOTER_MOTOR_POWER_FORWARD_LOW);
    		Robot.shooter.motorIsHigh = false;
    	}
    	if (Robot.drivetrain.getSonarDistance() < Constants.SONAR_CLOSE){
    		Robot.shooter.manualSpeed(Constants.SHOOTER_MOTOR_SPEED_HIGH);
    		Robot.shooter.motorIsHigh = true;
    	} else {
    		Robot.shooter.manualSpeed(Constants.SHOOTER_MOTOR_SPEED_LOW);
    		Robot.shooter.motorIsHigh = false;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
