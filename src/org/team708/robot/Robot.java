
package org.team708.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.team708.robot.commands.autonomous.ChevalShootHigh;
import org.team708.robot.commands.autonomous.DoEverything;
import org.team708.robot.commands.autonomous.DoNothing;
import org.team708.robot.commands.autonomous.Drive1TurnLeftShoot;
import org.team708.robot.commands.autonomous.Drive1TurnRightShoot;
import org.team708.robot.commands.autonomous.Drive2TurnLeftShoot;
import org.team708.robot.commands.autonomous.Drive2TurnRightShoot;
import org.team708.robot.commands.autonomous.DriveBackwardNoShoot;
import org.team708.robot.commands.autonomous.DriveBackwardShoot;
import org.team708.robot.commands.autonomous.DriveBackwardShootLow;
import org.team708.robot.commands.autonomous.DriveInSquare;
import org.team708.robot.commands.autonomous.DriveForwardShoot;
import org.team708.robot.commands.autonomous.LowBarNoShoot;
import org.team708.robot.commands.autonomous.LowBarShootHigh;
import org.team708.robot.commands.autonomous.LowBarShootLow;
import org.team708.robot.commands.autonomous.OnlyShoot;
import org.team708.robot.commands.autonomous.DriveToTarget;
import org.team708.robot.subsystems.Drivetrain;
import org.team708.robot.subsystems.VisionProcessor;
import org.team708.robot.subsystems.Intake;
import org.team708.robot.subsystems.Loader;
import org.team708.robot.subsystems.Shooter;
import org.team708.robot.subsystems.Grappler;
import org.team708.robot.subsystems.Arm;
import org.team708.robot.util.CameraServer2;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * @author omn0mn0m
 */
public class Robot extends IterativeRobot {
    
    Timer statsTimer;										// Timer used for Smart Dash statistics
    
    public static Drivetrain 		drivetrain;
	public static VisionProcessor 	visionProcessor;

	public static Intake 			intake;
	public static Loader 			loader;
	public static Shooter 			shooter;
	public static Grappler 			grappler;
	public static Arm 				arm;
	public static OI 				oi;

	public static double defenceNumber;
	public static double turnDirection;
	public static double driveThroughDefenceTime;
 
	
    Command 			autonomousCommand;
    SendableChooser 	autonomousMode;
    Preferences			prefs;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
        statsTimer = new Timer();	// Initializes the timer for sending Smart Dashboard data
        statsTimer.start();		// Starts the timer for the Smart Dashboard
        
		
        
// Subsystem Initialization
    drivetrain 		= new Drivetrain();
	visionProcessor = new VisionProcessor();

	intake 			= new Intake();
	loader 			= new Loader();
	shooter 		= new Shooter();
	grappler 		= new Grappler();
	arm 			= new Arm();
	oi 				= new OI();		// Initializes the OI. 
									// This MUST BE LAST or a NullPointerException will be thrown
	
	CameraServer2 server1 = CameraServer2.getInstance();
	server1.setQuality(50);
	
	server1.startAutomaticCapture("cam1");
	sendDashboardSubsystems();		// Sends each subsystem's currently running command to the Smart Dashboard
		
	autonomousMode = new SendableChooser();	// Initializes the Autonomous selection box
	queueAutonomousModes();			// Adds autonomous modes to the selection box
        
    }
	
    /**
     * Runs periodically while the robot is enabled
     */
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		sendStatistics();
		prefs = Preferences.getInstance();
	}

	/**
	 * Runs at the start of autonomous mode
	 */
    	public void autonomousInit() {
    	
    	turnDirection = prefs.getDouble("TurnDirection", 4.0);
    		
    	// schedule the autonomous command (example)   		
    	autonomousCommand = (Command)autonomousMode.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {	
        Scheduler.getInstance().run();
        sendStatistics();
    }

    /**
     * Runs when teleop mode initializes
     */
    public void teleopInit() {
	    // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        sendStatistics();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        sendStatistics();
    }
    
    /**
     * Sends data from each subsystem periodically as set by sendStatsIntervalSec
     */
    
    
    
    private void sendStatistics() {
        if (statsTimer.get() >= Constants.SEND_STATS_INTERVAL) {
            statsTimer.reset();

            // Various debug information
            drivetrain.sendToDashboard();
            visionProcessor.sendToDashboard();
            intake.sendToDashboard();
            loader.sendToDashboard();
            shooter.sendToDashboard();
            grappler.sendToDashboard();
            arm.sendToDashboard();
        }
    }
    
    /**
     * Adds every autonomous mode to the selection box and adds the box to the Smart Dashboard
     */
    private void queueAutonomousModes() {
    	
    	
//		autonomousMode.addObject("Find Target", new DriveToTarget());
//		autonomousMode.addObject("Drive in Square", new DriveInSquare());

    	autonomousMode.addDefault("Low Bar Shoot Low", new LowBarShootLow());
    	autonomousMode.addObject("Low Bar Shoot High", new LowBarShootHigh());
		autonomousMode.addObject("Low Bar No Shoot", new LowBarNoShoot());
		
		autonomousMode.addObject("Backward LeftSide Low", new DriveBackwardShootLow(false));
		autonomousMode.addObject("Backward RightSide Low", new DriveBackwardShootLow(true));
    	autonomousMode.addObject("Backward LeftSide High", new DriveBackwardShoot(false));
		autonomousMode.addObject("Backward RightSide High", new DriveBackwardShoot(true));
		autonomousMode.addObject("DriveBackwardNoShoot", new DriveBackwardNoShoot());
		
		autonomousMode.addObject("Cheval High Left", new ChevalShootHigh(false));
		autonomousMode.addObject("Cheval High Right", new ChevalShootHigh(true));
		
		autonomousMode.addObject("DriveForwardShoot", new DriveForwardShoot());
		
		autonomousMode.addObject("Drive To Defense", new DriveToTarget());
		autonomousMode.addObject("Do Nothing", new DoNothing());
		
//		autonomousMode.addObject("Only Shoot", new OnlyShoot());
		
//		autonomousMode.addObject("Do Everything", new DoEverything(defenceNumber, turnDirection, driveThroughDefenceTime));
//		autonomousMode.addObject("Do Everything", new DoEverything());//need to change
//		autonomousMode.addObject("Drive1TurnLeftShoot", new Drive1TurnLeftShoot());
//		autonomousMode.addObject("Drive2TurnLeftShoot", new Drive2TurnLeftShoot());
//		autonomousMode.addObject("Drive1TurnRightShoot", new Drive1TurnRightShoot());
//		autonomousMode.addObject("Drive2TurnRightShoot", new Drive2TurnRightShoot());
		
    	SmartDashboard.putData("Autonomous Selection", autonomousMode);    	   	
    }
    
    /**
     * Sends every subsystem to the Smart Dashboard
     */
    private void sendDashboardSubsystems() {
    	SmartDashboard.putData(drivetrain);
		SmartDashboard.putData(intake);
		SmartDashboard.putData(loader);
		SmartDashboard.putData(shooter);
		SmartDashboard.putData(grappler);
		SmartDashboard.putData(arm);
		SmartDashboard.putData(visionProcessor);
    }
}
