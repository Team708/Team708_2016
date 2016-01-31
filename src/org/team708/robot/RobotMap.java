package org.team708.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author omn0mn0m
 */
public class RobotMap {
	
	// Gamepad USB ports
	public static final int driverGamepad   = 1;
	public static final int operatorGamepad = 2;
	
	// PWM Ports
	public static final int INTAKE_SPIKE 	= 0;
	public static final int LOADER_SPIKE 	= 1;
//	public static final int  			 	= 2;
//	public static final int  				= 3;
//	public static final int  				= 4;
//	public static final int  				= 5;
//	public static final int  				= 6;
//	public static final int  				= 7;
//	public static final int  				= 8;
//	public static final int  				= 9;
	
	// Drivetrain CAN Device IDs
	public static final int drivetrainLeftMotorMaster  = 11;
	public static final int drivetrainLeftMotorSlave   = 12;
	public static final int drivetrainRightMotorMaster = 13;
	public static final int drivetrainRightMotorSlave  = 14;
	
	// Shooter CAN Device IDs
	public static final int shooterMotorMaster	= 21;
	public static final int shooterMotorSlave	= 22;
	
	// Pivot Arm CAN Device ID
	public static final int clawElevatorMotor 	= 31;
	
	// Grapler Grabber CAN Device IDs
	public static final int gucciGrabberMotor  	= 41;
	
	
	// Digital IO
	public static final int drivetrainEncoderA		= 0;
	public static final int drivetrainEncoderB		= 1;
//	public static final int 						= 2;
//	public static final int      					= 3;
	public static final int shooterEncoderA			= 4;
	public static final int shooterEncoderB			= 5;
	public static final int pivotArmUpperSwitch		= 6;
	public static final int pivotArmLowerSwitch		= 7;
//	public static final int 						= 8;
//	public static final int 						= 9;
	
	// Analog sensor IDs
	public static final int gyro				= 0;
	public static final int DTSonar				= 1;
	public static final int ballInIRSensor		= 2;
//	public static final int 					= 3;
	
	// PCM Ports
	public static final int DoubleSolenoidA     = 0;
	public static final int DoubleSolenoidB     = 1;
//	public static final int  					= 2;
//	public static final int 					= 3;
//	public static final int 					= 4;
//	public static final int 					= 5;
//	public static final int						= 6;
//	public static final int 					= 7;
	
}
