package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearCollector extends Subsystem {

	private SpeedController gearwheels;
	DigitalInput limitSwitch = new DigitalInput(2);
    Counter counter = new Counter(limitSwitch);
	
	public GearCollector() {
		super();
		gearwheels = new Spark(RobotMap.PWMGearWheels); 
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    }
    
    public void StartIntake() {
    	gearwheels.set(RobotMap.intakeSpeed);
    }
    public void StartOuttake() {
    	gearwheels.set(RobotMap.outtakeSpeed);
    }
    
    public boolean isSwitchSet()
    {
    	return counter.get() > 0;
    }
    
    public double currentSwitchValue()
    {
    	return counter.get();
    }
    
    public void Stop() {
    	gearwheels.set(0);
    }
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


