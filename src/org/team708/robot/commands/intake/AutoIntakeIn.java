package org.team708.robot.commands.intake;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.RobotMap;
//import org.team708.robot.subsystems.*;
import org.team708.robot.subsystems.Loader;


import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;



/**
 *@author James Alex Thomas Mikhael
 */
public class AutoIntakeIn extends Command {

	private boolean hasBall;

    public AutoIntakeIn() {
    	requires(Robot.intake);
    	requires(Robot.loader);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.loader.HasBall()){
        	Robot.loader.stop();
        	cancel();
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.moveMotor(Constants.INTAKE_FORWARD);
    	Robot.loader.manualMove(0.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return(Robot.loader.HasBall());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    	Robot.loader.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
