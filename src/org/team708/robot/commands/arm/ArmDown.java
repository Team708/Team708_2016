package org.team708.robot.commands.arm;

import org.team708.robot.AutoConstants;
import org.team708.robot.Constants;
import org.team708.robot.Robot;
import org.team708.robot.util.Math708;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

/*
 *
 */
public class ArmDown extends Command {
	
	private boolean isAtLimit;
	private boolean armStopped = false;
	
	private double moveSpeed = AutoConstants.ARM_DOWN_SPEED;
	
	private double oldPot;
	private double newPot;
	private double tolerance = 0.1;
    
    public ArmDown() {
    	// Use requires() here to declare subsystem dependencies
    	requires(Robot.arm);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isAtLimit = Robot.arm.getLowerSwitch();
    	
    	if(isAtLimit){

    		cancel();
    	}
    	
    	Robot.arm.manualMove(moveSpeed);
    	
//    	new WaitCommand(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	oldPot = Robot.arm.getPot();
    	Robot.arm.manualMove(moveSpeed);
//    	new WaitCommand(.5);
//    	newPot = Robot.arm.getPot();
    	
//    	if ((newPot <= (oldPot + tolerance)) && (newPot >= (oldPot - tolerance))){
//    		armStopped = true;
//    	}
//    	else {
//    		armStopped = false;
//    	}
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
 		return Robot.arm.getLowerSwitch();
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

