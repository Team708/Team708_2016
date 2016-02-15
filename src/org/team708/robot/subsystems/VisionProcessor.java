package org.team708.robot.subsystems;

//import org.team708.robot.commands.visionProcessor.ProcessData;

import org.team708.robot.Constants;

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
	
	private final double 	imageWidth = 320;
	private final double 	targetWidth = 18; //width of target in inches

	private double 			centerX = 0.0;
	private double 			targetX = 0.0;

	private double thresholdX = 20.0;
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
			targetX= roboRealmInfo.getNumber("hcx", 0);
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
		
		if (hasTarget) 
		{
			double difference = centerX - (targetX);
			
			if (Math.abs(difference) <= thresholdX) {
				difference = 0.0;
			}
			
			rotate = difference / centerX;
			
			if (Math.abs(rotate) < Constants.VISION_ROTATE_MOTOR_SPEED && Math.abs(rotate) != 0.0) {
				if (rotate >= 0.0) {
					rotate = Constants.VISION_ROTATE_MOTOR_SPEED;
				} else {
					rotate = -Constants.VISION_ROTATE_MOTOR_SPEED;
				}
			}
		}
		
		else {
			rotate = 0.65;
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
	
	/**
	 * Returns if the robot sees a container
	 * @return
	 */
	public boolean isHasTarget() {
		return hasTarget;
	}
	

	public void sendToDashboard() {
		SmartDashboard.putBoolean("See Target", isHasTarget());
		SmartDashboard.putNumber("Center of Target", targetX);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new ProcessData());
    }
}

