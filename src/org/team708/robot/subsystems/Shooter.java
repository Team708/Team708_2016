package org.team708.robot.subsystems;

import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
//import org.team708.robot.commands.arm.JoystickMoveArm;
import org.team708.robot.commands.shooter.SpinShooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class represents the Shooter, the part of the robot that takes
 * the ball from the loader wheel and uses a flywheel to launch it.
 * @author Nick Iannarone, Jillan Wang, Thomas Zhao
 */
public class Shooter extends Subsystem {
	// Put methods for controlling this subsystem here. Call these
	// from Commands.
	
	
	private Encoder shooterEncoder;			// Encoder for intermediate travel

	private Talon shooterMotor;
	/**
	 * Constructor
	 */
	public Shooter() {
		// Initializes the encoder
        shooterEncoder = new Encoder(RobotMap.shooterEncoderA, RobotMap.shooterEncoderB);
        
		
		// Initializes the motor
        shooterMotor = new Talon(RobotMap.SHOOTER_PWM);

		
	}

	public void initDefaultCommand() {
//		setDefaultCommand(new SpinShooter());
    }
	
	
	/**
	 * Resets the encoder
	 */
	public void resetEncoder() {
		shooterEncoder.reset();
	}
	

	
	/**
	 * Returns the raw encoder count
	 * @return
	 */
	public double getEncoderCount() {
		return shooterEncoder.get();
	}
	
	public double getSpeedRPMs(){
		return shooterEncoder.getRate() * 60;
	}
	
	
	public void manualSpeed(double speed) {
		
			shooterMotor.set(speed);
	}
	

	
	/**
	 * Sends data to the Smart Dashboard
	 */
	public void sendToDashboard() {
		
		SmartDashboard.putNumber("Encoder Count", getEncoderCount());
		
		SmartDashboard.putNumber("Encoder RPM", getSpeedRPMs());
//		if (Constants.DEBUG) {
//			SmartDashboard.putNumber("Shooter Encoder Count", getEncoderCount());
//
//		}
	}
}

