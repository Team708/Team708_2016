package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.drivetrain.DriveStraightForTime;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.DriveToUltrasonic;
import org.team708.robot.commands.drivetrain.RotateAndDriveToTarget;
import org.team708.robot.commands.drivetrain.DriveToIRDistance;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.shooter.AutoLoaderSpin;
import org.team708.robot.commands.shooter.AutoShooterSpin;
import org.team708.robot.commands.shooter.AutoStopSL;
import org.team708.robot.commands.visionProcessor.FindTarget;
import org.team708.robot.commands.arm.AutoArmDown;
import org.team708.robot.commands.arm.ArmStop;
import org.team708.robot.commands.arm.ArmUp;


import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class DriveToTarget extends CommandGroup {

   
	
    public  DriveToTarget() {

		//Arm Down Sequence
		addSequential(new AutoArmDown());
		
		addSequential(new WaitCommand(.65)); 
		addSequential(new ArmStop());

		addSequential(new DriveStraightToEncoderDistance(46, -AutoConstants.ROBOT_TO_CHEVAL_SPEED));
    }
}
