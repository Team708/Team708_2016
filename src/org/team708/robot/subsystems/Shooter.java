package org.team708.robot.subsystems;

import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
//import org.team708.robot.commands.arm.JoystickMoveArm;
import org.team708.robot.commands.shooter.SpinShooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class represents the Shooter, the part of the robot that takes
 * the ball from the loader wheel and uses a flywheel to launch it.
 * @author Nick Iannarone, Jialin Wang, Thomas Zhao
 */
public class Shooter extends Subsystem {
	// Put methods for controlling this subsystem here. Call these
	// from Commands.
	
	
	private Encoder shooterEncoder;			// Encoder for intermediate travel
	public boolean motorIsHigh = false;

	public static CANTalon shooterMotor;
	/**
	 * Constructor
	 */
	public Shooter() {
		// Initializes the encoder
        shooterEncoder = new Encoder(RobotMap.shooterEncoderA, RobotMap.shooterEncoderB);
        
		
		// Initializes the motor
        shooterMotor = new CANTalon(RobotMap.shooterMotor);
        shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        shooterMotor.reverseSensor(false);
        shooterMotor.configEncoderCodesPerRev(128);
        
        /* set the peak and nominal outputs, 12V means full */
        shooterMotor.configNominalOutputVoltage(+0.0, -0.0);
        shooterMotor.configPeakOutputVoltage(+12.0, 0.0);
        /* set closed loop gains in slot1 */
        shooterMotor.setProfile(1);
        shooterMotor.setF(0.2398);
        shooterMotor.setP(0.5);
        shooterMotor.setI(0);
        shooterMotor.setD(0);
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
	
	
	public void manualSpeed(double speed) {
		shooterMotor.changeControlMode(TalonControlMode.PercentVbus);
		shooterMotor.set(speed);
	}
	
	public void manualRPM(double rpm){
		shooterMotor.changeControlMode(TalonControlMode.Speed);
		shooterMotor.set(rpm);
	}
	
	public void stop(){
			shooterMotor.set(Constants.MOTOR_OFF);
	}
	

	
	/**
	 * Sends data to the Smart Dashboard
	 */
	public void sendToDashboard() {
		
//		if (Constants.DEBUG) {
			SmartDashboard.putNumber("Shooter Encoder Count", getEncoderCount());
			SmartDashboard.putNumber("T error", shooterMotor.getClosedLoopError());
//			}
		SmartDashboard.putNumber("T Output", shooterMotor.getOutputVoltage()/shooterMotor.getBusVoltage());
		SmartDashboard.putNumber("T Speed", shooterMotor.getSpeed());
		SmartDashboard.putBoolean("Shooter is High", motorIsHigh);
	}
}

