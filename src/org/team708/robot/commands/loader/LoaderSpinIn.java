package org.team708.robot.commands.loader;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.subsystems.Loader;
import org.team708.robot.util.Gamepad;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoaderSpinIn extends Command {


    public LoaderSpinIn() {
    	
    	requires(Robot.loader);

    }
    

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //	double distance = Robot.loader.GetIRDistance();
    	
    //	if (distance >=Constants.IR_HAS_BALL_DISTANCE) {
    		Robot.loader.manualMove(Constants.LOADER_MOTOR_FORWARD);
    //	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//if the loader spin in button is no longer pressed, stop loop
//    	if (!OI.loaderSpinIn.get()){
//    		return true;
//    	}
    	
    	return(false);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.loader.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
