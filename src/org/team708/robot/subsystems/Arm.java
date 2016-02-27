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
	
	private static CANTalon pivotArmMotor;
	
	private boolean upperLimit = false;
	private boolean lowerLimit= false;
	
	
	/**
	 * Constructor
	 */
	public Arm() {
		
		pot = new Potentiometer(RobotMap.armPotentiometer, 0.75);
		
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
		//pivotArmMotor.enableLimitSwitch(upperLimit, lowerLimit);
		return pivotArmMotor.isFwdLimitSwitchClosed();
	}
	
	
	/**
	 * Returns true if the lower switch is pressed
	 * @return At lower limit
	 * 
	 */
	public boolean getLowerSwitch() {
		//pivotArmMotor.enableLimitSwitch(upperLimit, lowerLimit);
		return pivotArmMotor.isRevLimitSwitchClosed();
	}
		
	//Sets the motor speed to whatever the variable speed is
	public void manualMove(double speed) {
		pivotArmMotor.set(speed);
	}
	
	public void stop(){
		pivotArmMotor.set(Constants.MOTOR_OFF);
	}
	
	
	public double getPot(){
		return pot.getAngle(); //gets arm angle hopefully
	}
	
	
	/**
	 * Sends data to the Smart Dashboard
	 */
	public void sendToDashboard() {
		SmartDashboard.putBoolean("Arm Lower Switch", getLowerSwitch());
		SmartDashboard.putBoolean("Arm Upper Switch", getUpperSwitch());

		SmartDashboard.putNumber("Arm Angle", pot.getAngle());
		SmartDashboard.putNumber("Pot Voltage",  pot.getVoltage());
		
//		if (Constants.DEBUG) {
//		}
	}
}

