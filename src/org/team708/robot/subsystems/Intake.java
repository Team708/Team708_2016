package org.team708.robot.subsystems;

import org.team708.robot.Constants;
import org.team708.robot.RobotMap;
import org.team708.robot.util.IRSensor;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem that carries up totes on a chain system.
 * @author jlwang
 * @author omn0mn0m
 */
public class Intake extends Subsystem {

	private CANTalon indexerMotorLeft;		// Spike for the indexer motor
//	private CANTalon indexerMotorRight;
	
	//Whether elevator has been lowered
	public boolean indexerDown = false;
	
	//number of tote heights/totes indexed
	public int toteCount;
	
	//Encoder
	private Encoder indexerEncoder;
	private double distancePerPulse;
	
	//IR Sensor
	private IRSensor indexerIR;
	
	public Intake() {
		//Creates motors that run elevator
//SMP		indexerMotorLeft = new CANTalon(RobotMap.indexerMotor);
//		indexerMotorRight = new CANTalon(RobotMap.indexerMotorRight);
		
		//Creates encoders for elevator motors
//SMP		indexerEncoder = new Encoder(RobotMap.indexerEncoderA, RobotMap.indexerEncoderB);

//SMP		distancePerPulse = (Constants.INDEXER_SPROCKET_DIAMETER * Math.PI) / (Constants.GRAYHILL_ENCODER_PULSES_PER_REVOLUTION);

		indexerEncoder.setDistancePerPulse(distancePerPulse);
		indexerEncoder.setReverseDirection(true);
		
//SMP		indexerIR = new IRSensor(RobotMap.indexerIRSensor, IRSensor.GP2Y0A21YK0F);
	}
	
	/*
	 * Gets the distance the elevator has moved
	 */
	public double getEncoderDistance() {
		return indexerEncoder.getDistance();
	}
	
	/*
	 * Gets the speed the encoder measures
	 */
	public double getEncoderRate() {
		return indexerEncoder.getRate();
	}
	
	public double getEncoderCount() {
		return indexerEncoder.get();
	}
	
	/*
	 * Resets the encoder count
	 */
	public void resetEncoder() {
		indexerEncoder.reset();
	}
	
	public double getIRDistance() {
		return indexerIR.getClippedAverageDistance();
	}

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    /**
     * Sends data about the subsystem to the Smart Dashboard
     */
    public void sendToDashboard() {
    	if (Constants.DEBUG) {
    		SmartDashboard.putNumber("indexer Encoder Count", getEncoderCount());
    	}
    	
    	SmartDashboard.putNumber("indexer Encoder Distance", 	getEncoderDistance());
    	SmartDashboard.putNumber("indexer IR Distance", 	getIRDistance());
    }
}

