package org.team708.robot.subsystems;

import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
import org.team708.robot.commands.arm.JoystickMoveArm;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Subsystem that intakes balls
 * @author James_Makovics
 * @author Michael_Steinberg
 * @author
 */

public class Intake extends Subsystem {
	
	public static final Relay.Value INTAKE_Forward = Constants.INTAKE_FORWARD; 	
	public static final Relay.Value INTAKE_REVERSE 		= Constants.INTAKE_REVERSE;
	
	
	
    /**
      * Constructor
      */
	public Intake() {
		
		
		
		  
		
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
    }
    
    /**
     * Sends data about the subsystem to the Smart Dashboard
     */
    public void sendToDashboard() {
    	
    }
    
    
}

