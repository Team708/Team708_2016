package org.team708.robot.subsystems;

import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
import org.team708.robot.util.IRSensor;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem that carries up totes on a chain system.
 * @author jlwang
 * @author omn0mn0m
 */
public class Intake extends Subsystem {

	private Relay intakeMotor;		// Spike for the intake motor
	
	
	public Intake() {
		
		intakeMotor = new Relay(RobotMap.INTAKE_SPIKE);
		
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

