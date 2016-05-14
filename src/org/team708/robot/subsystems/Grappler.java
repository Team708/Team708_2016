package org.team708.robot.subsystems;


import org.team708.robot.util.Potentiometer;
import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
import org.team708.robot.commands.grappler.JoystickMoveGrappler;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Description
 * @author Thomas Zhao 
 * @author Alex Tysak
 * @author Michael Gipson
 */
public class Grappler extends Subsystem {
	
	
	private DigitalInput upperSwitch, lowerSwitch;	// Limit switches for the top and bottom of the travel
	
	private static CANTalon grapplerMotorMaster; //Motor to move extend the grappler
	
	private static CANTalon grapplerMotorSlave;
	
	
	/**
	 * Constructor
	 */
	public Grappler() {
		
		
		// Initializes the switches
		upperSwitch = new DigitalInput(RobotMap.grapplerUpperSwitch);
		lowerSwitch = new DigitalInput(RobotMap.grapplerLowerSwitch);
		// Initializes the motor
		grapplerMotorMaster = new CANTalon(RobotMap.grapplerMotorMaster);
		grapplerMotorSlave 	= new CANTalon (RobotMap.grapplerMotorSlave);
		
		setupMasterSlave();
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickMoveGrappler());
    }
	
	/**
	 * Returns true if the upper switch is pressed
	 * @return At upper limit
	 */
	public boolean getUpperSwitch() {
		return !upperSwitch.get();   // not because default is closed, stops if circuit is broken
	}
	
	/**
	 * Returns true if the lower switch is pressed
	 * @return At lower limit
	 */
	public boolean getLowerSwitch() {
		return !lowerSwitch.get(); // not because default is closed, stops if circuit is broken
	}
		
	//Sets the motor speed to whatever the variable speed is
	public void manualMove(double speed) {
		grapplerMotorMaster.set(speed);
	}
	
	public void stop(){
		grapplerMotorMaster.set(Constants.MOTOR_OFF);
		grapplerMotorSlave.set(Constants.MOTOR_OFF);
	}
	
	//Makes slave motor follow master motor
	public void setupMasterSlave(){
		grapplerMotorSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		
		grapplerMotorSlave.set(grapplerMotorMaster.getDeviceID());
	}

	
	
	/**
	 * Sends data to the Smart Dashboard
	 */
	public void sendToDashboard() {
//		SmartDashboard.putBoolean("Grappler Lower Switch", getLowerSwitch());
//		SmartDashboard.putBoolean("Grappler Upper Switch", getUpperSwitch());
//		
		if (Constants.DEBUG) {
		}
	}
}
