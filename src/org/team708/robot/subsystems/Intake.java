package org.team708.robot.subsystems;

import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
import org.team708.robot.commands.arm.JoystickMoveArm;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Subsystem that intakes balls
 * @author James_Makovics
 * @author Michael_Steinberg
 * @author Thomas Zhao
 * @author Alex Tysak
 */

public class Intake extends Subsystem {
	
	public Talon intakeMotor;
	
	
    /**
      * Constructor
      */
	public Intake() {
	intakeMotor = new Talon(RobotMap.INTAKE_MOTOR);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
    }
	
	public void moveMotor(double speed) {
		intakeMotor.set(speed);
	}
	
	public void stop(){
		intakeMotor.set(Constants.INTAKE_OFF);
	}
    
    /**
     * Sends data about the subsystem to the Smart Dashboard
     */
    public void sendToDashboard() {
//		if (Constants.DEBUG) {
//		}
    }
    
    
}

