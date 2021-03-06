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
public class AutoShooterSpin extends Command {

	private double speed;
	
	public AutoShooterSpin() {
		this(Constants.SHOOTER_MOTOR_SPEED_LOW);
    }
    
    public AutoShooterSpin(double speed) {
    	requires(Robot.shooter);
    	
    	this.speed = speed;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.shooter.manualRPM(speed);    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	Robot.shooter.stop();
    }
}
