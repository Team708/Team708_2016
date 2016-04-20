package org.team708.robot;

public final class AutoConstants {

	/*
	 * Shared Constants
	 */
	public static final double NINETY_DEGREE_TURN 		= 85.0;
	public static final double TURN_SPEED     			= 0.75;
	public static final double TURN_LEFT     			= -85.0;
	public static final double TURN_RIGHT     			= 85.0;
	public static final double TURN_AROUND_FACE_TARGET  = 200;
	public static final double NEIN_TURN     			= 0.0;
	
	public static final double ROBOT_ENCODER_DRIVE_SPEED     		= -0.6;//Drives reverse
	public static final double ROBOT_TIME_DRIVE_SPEED	     		= -1.0;
	
	public static final double ROBOT_LENGTH 						= 31.0;
	
	/*
	 * Arm
	 */
	public static final double ARM_DOWN_SPEED     		= -1.0;
	public static final double ARM_DOWN_TIME     		= 0.65;
	
	/*
	 * Shooter
	 */
	public static final double SHOOTING_SONAR_DISTANCE_CLOSE     	= 35;  // 40 +- 5
	public static final double SHOOTING_SONAR_DISTANCE_FAR     		= 80;  // 80 +- 5
	public static final double SHOOTER_MOTOR_SPINUP_TIME     		= 2;
	public static final double LOADER_MOTOR_LOADING_TIME     		= 2;
	//Low Goal
	public static final double TURN_180_FACE_LOWGOAL    	= 167.0;
	public static final double LOWGOAL_TURN_SPEED  = 0.6;
	public static final double DRIVE_UP_RAMP_DISTANCE  = 18.0;
	
	/*
	 * Vision Processing
	 */
	public static final double X_THRESHOLD = 20;
	public static final double SONAR_DISTANCE_THRESHOLD     		= 5;
	
	public static final double Y_THRESHOLD							= 5;
	public static final double Y_TARGET 							= 190;
	
	/*
	 * Robot To Defense
	 */
	public static final double GO_TO_1_DEFENSES     		= 1;
	public static final double GO_TO_2_DEFENSES     		= 2;
	public static final double GO_TO_NO_DEFENSES     		= 0;
	
	public static final double ROBOT_TO_DEFENSE_DISTANCE 	= 52.0;
	public static final double ROBOT_TO_TARGET_DISTANCE 	= 52.0;
	public static final double ROBOT_THROUGH_LOW_BAR		= 210.0;
	public static final double ROBOT_TO_CHEVAL				= 44.0;
	public static final double ROBOT_TO_CHEVAL_SPEED		= 0.3;
	
	public static final double ROBOT_OVER_DEFENSE_TIME			= 1.25;
	
	
}
