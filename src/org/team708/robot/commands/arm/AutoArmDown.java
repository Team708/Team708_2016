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
public class AutoArmDown extends Command {
    
    public AutoArmDown() {
    	// Use requires() here to declare subsystem dependencies
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.manualMove(AutoConstants.ARM_DOWN_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
 		return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

