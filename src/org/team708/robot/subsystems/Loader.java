package org.team708.robot.subsystems;


import org.team708.robot.Constants;
import org.team708.robot.Robot;
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
	
	private IRSensor irSensor;
	
	private CANTalon loadMotor;
	/**
	 * Constructor
	 */
	public Loader() {
		
		irSensor = new IRSensor(RobotMap.LoaderIRSensor, IRSensor.GP2Y0A21YK0F); //Two models of infrared sensors in the IRSensor class
		
		loadMotor = new CANTalon(RobotMap.loaderMotor); //initializes the loading motor
		
	}
	
	public void initDefaultCommand() {
        setDefaultCommand(new ManualLoader());
    }
	
	public void manualMove(double speed){
		loadMotor.set(speed);
	}
	
	public double GetIRDistance() {
		return irSensor.getDistance();
	}
	
	public boolean HasBall() {
		return GetIRDistance() < Constants.IR_HAS_BALL_DISTANCE;
	}
	
	public void stop(){
		loadMotor.set(Constants.MOTOR_OFF);
	}
	
	public void sendToDashboard() {
		SmartDashboard.putNumber("Loader IR Distance", GetIRDistance());
		SmartDashboard.putBoolean("Has Ball", HasBall());
	}
}