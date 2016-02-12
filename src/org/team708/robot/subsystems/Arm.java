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
 * @author wutnut
 * @author 
 */
public class Arm extends Subsystem {
	
	private Potentiometer pot;
	
	private DigitalInput upperSwitch, lowerSwitch;	// Limit switches for the top and bottom of the travel
	
	private static CANTalon pivotArmMotor; //Motor to pivot the arm
	
	
	/**
	 * Constructor
	 */
	public Arm() {
		
		pot = new Potentiometer(RobotMap.armPotentiometer, 1);
		
		// Initializes the switches
		upperSwitch = new DigitalInput(RobotMap.pivotArmUpperSwitch);
		lowerSwitch = new DigitalInput(RobotMap.pivotArmLowerSwitch);
		// Initializes the motor
		pivotArmMotor = new CANTalon(RobotMap.pivotArmMotor);
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
		pivotArmMotor.set(speed);
	}
	
	public void stop(){
		pivotArmMotor.set(Constants.MOTOR_OFF);
	}
	
	public double getPot(){
		return pot.getAngle();
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

