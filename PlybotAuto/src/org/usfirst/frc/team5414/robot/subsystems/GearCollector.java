package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearCollector extends Subsystem {

	private SpeedController gearwheels;
	public GearCollector() {
		super();
		gearwheels = new Spark(RobotMap.PWMGearWheels); 
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    }
    
    public void intake() {
    	gearwheels.set(RobotMap.intakeSpeed);
    }
    public void outtake() {
    	gearwheels.set(RobotMap.outtakeSpeed);
    }
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


