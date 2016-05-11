package org.team708.robot.commands.shooter;
import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.subsystems.Loader;
import org.team708.robot.util.Gamepad;
import org.team708.robot.commands.shooter.Fire;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoStopSL extends Command {


    public AutoStopSL() {
    	requires(Robot.loader);
    	requires(Robot.shooter);
    	requires(Robot.intake);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.loader.stop(); 	
		Robot.shooter.stop();
		Robot.intake.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.loader.stop(); 	
		Robot.shooter.stop();
		Robot.intake.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.loader.stop();
    	Robot.shooter.stop();
    	Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
