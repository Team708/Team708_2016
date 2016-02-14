package org.team708.robot.commands.intake;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

/**
 *@author James_Makovics
 */
public class IntakeOut extends Command {

	public static final Relay.Value INTAKE_REVERSE 		= Constants.INTAKE_REVERSE;
	
    public IntakeOut() {
    	
    	Relay intakeMotor = new Relay(RobotMap.INTAKE_SPIKE); // Spike for the intake motor
    	intakeMotor.set(INTAKE_REVERSE);
    	
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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
