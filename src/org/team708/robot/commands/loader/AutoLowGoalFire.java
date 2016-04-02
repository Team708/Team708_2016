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
public class AutoLowGoalFire extends Command {


    public AutoLowGoalFire() {
    	requires(Robot.intake);
    	requires(Robot.loader);

    }
    

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.loader.manualMove(Constants.LOADER_MOTOR_REVERSE);
    	Robot.intake.moveMotor(Constants.INTAKE_REVERSE);
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
    	Robot.intake.stop();
    	Robot.loader.stop();
    	end();
    }
}
