package org.team708.robot.subsystems;


import org.team708.robot.util.Potentiometer;
import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
import org.team708.robot.commands.arm.JoystickMoveArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Description
 * @Thomas Zhao 
 * @Alex Tysak
 */
public class Arm extends Subsystem {
	
	private Potentiometer pot;
	
	private DigitalInput upperSwitch, lowerSwitch;	// Limit switches for the top and bottom of the travel
	
	private static CANTalon pivotArmMotorMaster; //Motor to pivot the arm
	
	private static CANTalon pivotArmMotorSlave;
	
	
	/**
	 * Constructor
	 */
	public Arm() {
		
		pot = new Potentiometer(RobotMap.armPotentiometer, 0.75);
		
		// Initializes the switches
		upperSwitch = new DigitalInput(RobotMap.pivotArmUpperSwitch);
		lowerSwitch = new DigitalInput(RobotMap.pivotArmLowerSwitch);
		// Initializes the motor
		pivotArmMotorMaster = new CANTalon(RobotMap.pivotArmMotorMaster);
		pivotArmMotorSlave = new CANTalon (RobotMap.pivotArmMotorSlave);
		
		setupMasterSlave();
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickMoveArm());
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
		pivotArmMotorMaster.set(speed);
	}
	
	public void stop(){
		pivotArmMotorMaster.set(Constants.MOTOR_OFF);
		pivotArmMotorSlave.set(Constants.MOTOR_OFF);
	}
	
	//Makes slave motor follow master motor
	public void setupMasterSlave(){
		pivotArmMotorSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		
		pivotArmMotorSlave.set(pivotArmMotorMaster.getDeviceID());
	}
	
	public double getPot(){
		return pot.getAngle(); //gets arm angle hopefully
	}
	
	
	/**
	 * Sends data to the Smart Dashboard
	 */
	public void sendToDashboard() {
		SmartDashboard.putBoolean("Lower Switch", getLowerSwitch());
		SmartDashboard.putBoolean("Upper Switch", getUpperSwitch());

		SmartDashboard.putNumber("Arm Angle", pot.getAngle());
//		if (Constants.DEBUG) {

//		}
	}
}

