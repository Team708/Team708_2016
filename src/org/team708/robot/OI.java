package org.team708.robot;


import edu.wpi.first.wpilibj.buttons.*;

import org.team708.robot.commands.drivetrain.*;
import org.team708.robot.commands.intake.*;
import org.team708.robot.commands.shooter.*;
import org.team708.robot.commands.loader.*;
import org.team708.robot.commands.arm.*;
import org.team708.robot.commands.grappler;

import org.team708.robot.util.*;
import org.team708.robot.util.triggers.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	// Gamepads
	public final static Gamepad driverGamepad 	= new Gamepad(RobotMap.driverGamepad);	// Driver 	gamepad
	public final static Gamepad operatorGamepad = new Gamepad(RobotMap.operatorGamepad);// Operator gamepad
	
	// look in Gamepad.java for button constants
	
	/*
	 * Driver Button Assignment
	 */
	
	// Drivetrain Buttons
	private static final int INTAKE_OUT_HOLD	 	= Gamepad.button_L_Shoulder;
	private static final int INTAKE_IN_HOLD	 		= Gamepad.button_R_Shoulder;
	
	
	/*
	 * Operator Button Assignment
	 */
	// Shooter
	private static final int SHOOT			 	= Gamepad.button_R_Shoulder;
	
	// ARM
	private static final int OPERATE_ARM		= Gamepad.leftStick_Y;
	private static final int OPERATE_GRAPPLER	= Gamepad.rightStick_Y;
	
	
	// LOADER Buttons
	public static final int LOAD_IN 	= Gamepad.button_X;
	public static final int LOAD_OUT 	= Gamepad.button_B;
	
	
	/*
	 * Driver Button Commands
	 */
	private static final Button intakeout 	= new JoystickButton(driverGamepad, INTAKE_OUT_HOLD);
	private static final Button intakein 	= new JoystickButton(driverGamepad, INTAKE_IN_HOLD);

	/*
	 * Operator Button Commands
	 */
	public static final Button shoot				= new JoystickButton(operatorGamepad, SHOOT);
	public static final Button clawHeightIncrement	= new JoystickButton(operatorGamepad, clawHeightIncrementButton);
	public static final Button clawHeightDecrement	= new JoystickButton(operatorGamepad, clawHeightDecrementButton);

	private static final AxisUp armup 			= new AxisUp(operatorGamepad, 	OPERATE_ARM);		
	private static final AxisDown armDown		= new AxisDown(operatorGamepad, OPERATE_ARM);
	private static final AxisUp grapplerin 		= new AxisUp(operatorGamepad, 	OPERATE_GRAPPLER);		
	private static final AxisDown grapplerout	= new AxisDown(operatorGamepad, OPERATE_GRAPPLER);

	
	
	/**
	 * Constructor
	 * Assigns commands to be called when each button is pressed.
	 */
	public OI() {
		/*
		 * Driver Commands to be called by button
		 */
		adjustDown.whenPressed(new AdjustIndexer(false));
//		holdForNoPID.whileHeld(new HoldDisablePID());
		adjustUp.whenPressed(new AdjustIndexer(true));
		
		/*
		 * Operator Commands to be called by button
		 */
		toggleClawOpen.whenPressed(new ToggleClawOpen());
//		interruptClaw.whenPressed(new StopClawElevator());
		toteUp.whenActive(new IndexerUp(false));
		toteDown.whenActive(new IndexerDown());
//		clawHeightIncrement.whenPressed(new HoldClawMove(true));
//		clawHeightDecrement.whenPressed(new HoldClawMove(false));
		gucciGrabberToggle.whenPressed(new ToggleGucciGrabber());
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
