package org.team708.robot;


import edu.wpi.first.wpilibj.buttons.*;

import org.team708.robot.commands.drivetrain.*;
import org.team708.robot.commands.intake.*;
import org.team708.robot.commands.shooter.*;
import org.team708.robot.commands.loader.*;
import org.team708.robot.commands.arm.*;
import org.team708.robot.commands.grappler.*;
import org.team708.robot.util.*;
import org.team708.robot.util.triggers.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	// Gamepads
	public final static Gamepad driverGamepad 	= new Gamepad(RobotMap.driverGamepad);	// Driver gamepad
	public final static Gamepad operatorGamepad = new Gamepad(RobotMap.operatorGamepad);// Operator gamepad
	
	// look in Gamepad.java for button constants
	
	/*
	 * Driver Button Assignment
	 */
	
	// Drivetrain Buttons
	private static final int INTAKE_OUT_HOLD_BUTTON	 	= Gamepad.button_L_Shoulder;
	private static final int INTAKE_IN_HOLD_BUTTON		= Gamepad.button_R_Shoulder;
	
	
	/*
	 * Operator Button Assignment
	 */
	// Shooter
	private static final int SPIN_LOADER_BUTTON		= Gamepad.button_R_Shoulder;
	private static final int SPIN_SHOOTER_BUTTON	= Gamepad.button_L_Shoulder;
	private static final int SPIN_SHOOTER_BACK_BUTTON	= Gamepad.button_A;
	
	// ARM
	private static final int OPERATE_ARM_BUTTON		= Gamepad.leftStick_Y;
	private static final int OPERATE_GRAPPLER_BUTTON= Gamepad.rightStick_X;
	
	// LOADER Buttons
	public static final int LOADER_IN_BUTTON 	= Gamepad.button_X;
	public static final int LOADER_OUT_BUTTON 	= Gamepad.button_B;
	
	
	/*
	 * Driver Button Commands
	 */
	public static final Button intakeOut 	= new JoystickButton(driverGamepad, INTAKE_OUT_HOLD_BUTTON);
	public static final Button intakeIn 	= new JoystickButton(driverGamepad, INTAKE_IN_HOLD_BUTTON);

	/*
	 * Operator Button Commands
	 */
	public static final Button spinShooter		= new JoystickButton(operatorGamepad, SPIN_SHOOTER_BUTTON);
	public static final Button spinShooterBack = new JoystickButton(operatorGamepad, SPIN_SHOOTER_BACK_BUTTON);
	public static final Button fire				= new JoystickButton(operatorGamepad, SPIN_LOADER_BUTTON);
	public static final Button loaderSpinIn		= new JoystickButton(operatorGamepad, LOADER_IN_BUTTON);
	public static final Button loaderSpinOut	= new JoystickButton(operatorGamepad, LOADER_OUT_BUTTON);

	private static final AxisUp 	armUp 		= new AxisUp(operatorGamepad, 	OPERATE_ARM_BUTTON);		
	private static final AxisDown 	armDown		= new AxisDown(operatorGamepad, OPERATE_ARM_BUTTON);
	private static final AxisUp 	grapplerIn 	= new AxisUp(operatorGamepad, 	OPERATE_GRAPPLER_BUTTON);		
	private static final AxisDown 	grapplerOut	= new AxisDown(operatorGamepad, OPERATE_GRAPPLER_BUTTON);

	
	/**
	 * Constructor
	 * Assigns commands to be called when each button is pressed.
	 */
	public OI() {
		/*
		 * Driver Commands to be called by button
		 */
		
		intakeIn.whileHeld(new IntakeIn());
//		intakeIn.whenPressed(new IntakeIn());
//		intakeIn.whenReleased(new IntakeStop());
		intakeOut.whileHeld(new IntakeOut());
		
		/*
		 * Operator Commands to be called by button
		 */
		loaderSpinIn.whileHeld(new LoaderSpinIn());
		loaderSpinOut.whileHeld(new LoaderSpinOut());

		spinShooterBack.whileHeld(new SpinShooterBack());
		spinShooter.whileHeld(new SpinShooter());
		fire.whileHeld(new Fire());
		}
}
