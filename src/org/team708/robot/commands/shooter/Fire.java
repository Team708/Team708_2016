package org.team708.robot.commands.shooter;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.util.Gamepad;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Fire extends Command {


    public Fire() {
    	requires(Robot.shooter);
    	requires(Robot.loader);
    }
    
public static boolean fire_pressed = false;

    // Called just before this Command runs the first time
    protected void initialize() {
    	Fire.fire_pressed = false;
    	//if the spin shooter button is not activated, cancel
//    	if (OI.spinShooter.get() == false){ 
//    		cancel();
//    	}

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	//if the spinshooter button is activated, and the fire button is activated, load the ball
//    	if (OI.spinShooter.get() == true) {
//    		if (OI.fire.get() == true) {
    			Robot.loader.manualMove(Constants.LOADER_MOTOR_FORWARD);
    	    	new WaitCommand(2.0);
    	    	fire_pressed = true;
//    		}
//    	}
//    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//stops the loop after ball leaves holding position (thus, is shot out of the robot)
//    	if (Robot.loader.irGetDistance()> 3){

    	return true;
//    	}
    	
//    	return(false);
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (fire_pressed)
    		Robot.loader.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
