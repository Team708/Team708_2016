package org.team708.robot.commands.loader;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.util.Gamepad;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualLoader extends Command {


    public ManualLoader() {
    	
    	requires(Robot.loader);

    }
    

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	boolean Bpressed = OI.operatorGamepad.getButton(Gamepad.button_B);
    	boolean Xpressed = OI.operatorGamepad.getButton(Gamepad.button_X);
    	
    	if (Xpressed == true){
    		Robot.loader.manualMove(Constants.MOTOR_FORWARD);
    	}
    	
    	if (Bpressed == true){
    		Robot.loader.manualMove(Constants.MOTOR_REVERSE);
    	}
    	
    	else {
    		Robot.loader.manualMove(Constants.MOTOR_OFF);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return(false);
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
