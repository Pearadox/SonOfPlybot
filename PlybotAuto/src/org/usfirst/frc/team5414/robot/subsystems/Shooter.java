package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem{
	
	private SpeedController shooterwheels;
	
	
	public Shooter() {
		super();
		shooterwheels = new Spark(RobotMap.PWMShooter);
	}
//     Put methods for controlling this subsystem
//     here. Call these from Commands.

    public void initDefaultCommand() {
    }
    
    public void shoot() {
    	
    	shooterwheels.set(RobotMap.shootSpeed);
    }
}



