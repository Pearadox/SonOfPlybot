package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousDrive extends CommandGroup {

    public AutonomousDrive() {
    
    	addSequential(new DriveEncDist(10));
//    	addSequential(new RotateLeft(720));
//    	addSequential(new DriveEncDist(.2));

    	
    }
}
