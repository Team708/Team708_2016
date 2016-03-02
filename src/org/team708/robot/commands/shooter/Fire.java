package org.team708.robot.commands.shooter;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.subsystems.Shooter;
import org.team708.robot.util.Gamepad;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Fire extends Command {


    public Fire() {
    	requires(Robot.loader);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	//if the spin shooter button is not activated, cancel
//    	if (OI.spinShooter.get() == false){ 
//    		cancel();
//    	}

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	//if the spinshooter button is activated, and the fire button is activated, load the ball
    	if(Shooter.shooterMotor.getSpeed() == Constants.SHOOTER_MOTOR_FORWARD) {
    		Robot.loader.manualMove(Constants.LOADER_MOTOR_FORWARD);
    	}
    	else {
    		Robot.loader.manualMove(Constants.LOADER_OFF);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {   	
    	return(false);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.loader.manualMove(Constants.MOTOR_OFF);
    	Robot.shooter.manualSpeed(Constants.MOTOR_OFF);
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
