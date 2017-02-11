package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GoToPeg extends CommandGroup {

    public GoToPeg() {
    	
    	DriverStation.reportWarning("Entered PivotToTargets", true);
    	addSequential(new PivotToTargets());	//Rotate to targets
    	
    	DriverStation.reportWarning("Entered PivotToCenter", true);
    	addSequential(new PivotToCenter());		//Rotate to center of targets
    	
    	DriverStation.reportWarning("Entered DriveToTarget", true);
    	addSequential(new DriveToTarget());		//Drive to targets
    	
//    	addSequential(new PivotToCenter());
    	
    	return;
    }
}
