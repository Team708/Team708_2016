package org.team708.robot.subsystems;


import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
//import org.team708.robot.commands.arm.JoystickMoveArm;
import org.team708.robot.commands.loader.ManualLoader;
import org.team708.robot.util.IRSensor;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Leaders
 * @Jialin Wang 
 * @Nick Iannarone
 * @Thomas Zhao
 * @Alex Tysak
 */
public class Loader extends Subsystem {
	
	//private static IRSensor irSensor;
	
	private CANTalon loadMotor;
	/**
	 * Constructor
	 */
	public Loader() {
		
		//irSensor = new IRSensor(RobotMap.DTIRSensor, IRSensor.GP2Y0A02YK0F); //Two models of infrared sensors in the IRSensor class
		
		loadMotor = new CANTalon(RobotMap.loaderMotor); //initializes the loading motor
		
	}
	
	public void initDefaultCommand() {
        setDefaultCommand(new ManualLoader());
    }
	
	public void manualMove(double speed){
		loadMotor.set(speed);
	}
	
//	public static double irGetDistance() {
//		return irSensor.getDistance();
//	}
	
	public void stop(){
		loadMotor.set(Constants.MOTOR_OFF);
	}
	
	public void sendToDashboard() {

//		SmartDashboard.putNumber("IR Distance", irGetDistance());
	}
}