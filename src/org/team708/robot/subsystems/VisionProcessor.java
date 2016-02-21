package org.team708.robot.subsystems;

//import org.team708.robot.commands.visionProcessor.ProcessData;

import org.team708.robot.Constants;
import org.team708.robot.util.Math708;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 *
 */
public class VisionProcessor extends Subsystem {
    
	private NetworkTable roboRealmInfo;
	private NumberArray targetCrosshair;
	private boolean hasTarget;
	private boolean wasCentered;
	
	private final double 	imageWidth = 320;
	private final double 	targetWidth = 18; //width of target in inches

	private double 			centerX = 0.0;
	private double 			targetX = 0.0;

	private double thresholdX = 25.0;
	private double thresholdY = 0.1;
	
    // High goal aspect ratio (11ft6in/3ft1in) in inches (3.729 repeating)
    private final double targetAspectRatio = 3.73; 
    
    // Distance related measurements from the network table
    private double 			distanceToTarget 	= 0.0;
    private int 			differencePx 		= 0;
    private final double 	targetDiameterIn 	= 24;
    
    // Data sent from the network table
    private double currentAspectRatio = 0.0;
    private double upper_left_x = 0;
    private double upper_left_y = 0;
    private double upper_right_x = 0;
    private double upper_right_y = 0;
    private double lower_left_x = 0;
    private double lower_left_y = 0;
    private double radius = 0;
    private double blob_count = 0;
    
    private double lowerLengthX;
    private double setProportion;
    	
    //daisy says to set this to 43.5 deg
    private final double cameraFOVRads = Math.toRadians(47);
//    private double cameraFOVRads = Math.toRadians(43.5);
    
	public VisionProcessor() {
		super("Vision Processor");
		roboRealmInfo = NetworkTable.getTable("vision");

		targetCrosshair = new NumberArray();
		centerX = imageWidth / 2;
	}
	
	public void processData() {
		try {
			targetX= roboRealmInfo.getNumber("cx", 0);
//			upper_left_x = (double) roboRealmInfo.getNumber("p1x");
//            upper_left_y = (double) roboRealmInfo.getNumber("p1y");
//            upper_right_x = (double)roboRealmInfo.getNumber("p2x");
//            upper_right_y = (double)roboRealmInfo.getNumber("p2y");
//            lower_left_x = (double) roboRealmInfo.getNumber("p3x");
//            lower_left_y = (double) roboRealmInfo.getNumber("p3y");
			
			if (targetX > 0) {
				hasTarget = true;
			} else {
				hasTarget = false;
			}
			
            
		} catch (TableKeyNotDefinedException e) {
			e.printStackTrace();
		}
	}
	
	public double getRotate() {
		double rotate;
		int lastSeenSide = 1; //1 is right, -1 is left
		
		if (hasTarget) 
		{
			
			double difference = centerX - (targetX);
			
			if (Math.abs(difference) <= thresholdX) {
				difference = 0.0;
				rotate = 0.0;
				wasCentered = true;
			}
			else if (Math.abs(difference) > thresholdX) {
				wasCentered = false;
			}
			
			//changes the lastSeenSide to positive or negative depending on last recorded difference
			if (difference >= 0.0){
				lastSeenSide = -1;
			}
			
//			rotate = difference / centerX;
			rotate = Math708.getSignClippedPercentError(targetX, centerX, .5, 1.0);
			
			
			//makes vision rotate speed the max speed
//			if (Math.abs(rotate) > Constants.VISION_ROTATE_MOTOR_SPEED) {
//				rotate = Constants.VISION_ROTATE_MOTOR_SPEED * Math.signum(rotate);
//			}
			
			//keeps rotate as the speed so it slows down when approaching the center
			/*
				if (rotate >= 0.0) {
					//reverses the sign to turn left, when target is left
					rotate = -Constants.VISION_ROTATE_MOTOR_SPEED;
				}
				else {
					rotate = Constants.VISION_ROTATE_MOTOR_SPEED;
				}
				*/
		}
		
		else {
			//rotates in lastSeenSide's direction (default is right) if loses/doesn't have target
			rotate = 0.5 * lastSeenSide;
			
		}
		
		return rotate;
	}
	
	//Returns how to move to get to target distance (targetAmount = target ratio)
	
	public double getMove(double targetAmount) {
		double move;
		
		if (hasTarget) 
		{
			double ratio = targetWidth / imageWidth;
			
			double difference = ratio - targetAmount;
			
			if (Math.abs(difference) <= thresholdY) {
				difference = 0.0;
			}
			
			move = difference / targetAmount;
			
			if (Math.abs(move) < 0.65 && Math.abs(move) != 0.0) {
				if (move >= 0.0) {
					move = 0.65;
				} else {
					move = -0.65;
				}
			}	
		} else {
			move = 0.0;
		}
		
		return move;
	}
	
	public double distanceToTarget(){
		return lowerLengthX * setProportion;
	}
	
	/**
	 * Returns if the robot sees a container
	 * @return
	 */
	public boolean isHasTarget() {
		return hasTarget;
	}
	
	public boolean wasCentered() {
		return wasCentered;
	}

	public void sendToDashboard() {
		SmartDashboard.putBoolean("See Target", isHasTarget());
		SmartDashboard.putBoolean("Was Centered", wasCentered());
		SmartDashboard.putNumber("Center of Target", targetX);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new ProcessData());
    }
}

