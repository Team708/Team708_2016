package org.team708.robot.commands.intake;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeIn extends Command {


    public IntakeIn() {

    	 = Relay.Value.kForward;
    	
    	return;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
return;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
return;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
 
    	return(true);
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
