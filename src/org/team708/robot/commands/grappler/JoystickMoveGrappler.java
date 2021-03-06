package org.team708.robot.commands.grappler;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.util.Gamepad;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@Thomas Zhao
 *@Alex Tysak
 */
public class JoystickMoveGrappler extends Command {

	public JoystickMoveGrappler() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.grappler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double moveSpeed = OI.operatorGamepad.getAxis(Gamepad.rightStick_Y);
    	
    	//check if joystick axis is in deadzone. Change movespeed to 0 if it is
    	if(moveSpeed <= .25 && moveSpeed >= -.25){
    		moveSpeed = 0.0;
    	}
    	
    	//check limit switches
    	if(Robot.grappler.getUpperSwitch()){
    		if(moveSpeed >= 0.0){
    			moveSpeed = Constants.MOTOR_OFF;
    		} 
    	}	
    	
    	else if (Robot.grappler.getLowerSwitch()){
    			if (moveSpeed <= 0.0){
    				moveSpeed = Constants.MOTOR_OFF;
    			}
    	}
    	
    	Robot.grappler.manualMove(moveSpeed * Constants.GRAPPLER_MOTOR_MINIMUM);

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
