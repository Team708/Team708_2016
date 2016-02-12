//package org.team708.robot.subsystems;
//
//import org.team708.robot.Constants;
//import org.team708.robot.RobotMap;
//import org.team708.robot.commands.arm.JoystickMoveArm;
//
//import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
///**
// * Description:
// * @author 
// * @author 
// */
//public class Shooter extends Subsystem {
//	
//	
//	
//	private Encoder shooterEncoder;			// Encoder for intermediate travel
//
//	
//	/**
//	 * Constructor
//	 */
//	public Shooter() {
//		// Initializes the encoder
//
//
//		
//		// Initializes the motor
//
//
//		
//	}
//
//	public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//
//    }
//	
//	
//	/**
//	 * Resets the encoder on the claw elevator
//	 */
//	public void resetEncoder() {
//		shooterEncoder.reset();
//	}
//	
//
//	
//	/**
//	 * Returns the raw encoder count
//	 * @return
//	 */
//	public double getEncoderCount() {
//		return shooterEncoder.get();
//	}
//	
//
//	
//	/**
//	 * Sends data to the Smart Dashboard
//	 */
//	public void sendToDashboard() {
//
//		
////		if (Constants.DEBUG) {
////			SmartDashboard.putNumber("Shooter Encoder Count", getEncoderCount());
////
////		}
//	}
//}
//
