package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PivotToTargets extends Command {
	
	double error = 0;
 	double max = 0;
	int maxind = 0;
	double centerX = 0;
	double centerY = 0;
	int left = 0;
	int right = 1;
	double minspeed = .4;
	double maxspeed = .6;
	double cameraWidthInPixels = 320;
	double speed = 0;
	double kp = (maxspeed - minspeed)/129;
	double[] CenterArray;

    public PivotToTargets() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("AT", "PivToTargets");
    	SmartDashboard.putBoolean("TOO MANY TARGETS", false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try {
    		CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
    		double cameraViewCenter = cameraWidthInPixels / 2;
    		//print blob #	
    		//check if 2 blobs 
//    		error = Math.abs(cameraViewCenter - CenterPanels);
//    		speed = error * kp +.3;
    		speed = .4;
    		if(speed > maxspeed) {
    			speed = maxspeed;
    		}
    		else if(speed < minspeed) {
    			speed = minspeed;
    		}
	    	if(CenterArray.length > 2){
	    		SmartDashboard.putBoolean("TOO MANY TARGETS", true);
    		return;
	    	}
	    	if(CenterArray.length < 2){
		 	    if (CenterArray.length == 0){
		 	    	Robot.drivetrain.drive(-speed, speed);
		    		SmartDashboard.putString("Robot Moving", "searching");
		    		
		    	}
		    	else if(CenterArray.length == 1){
		    		if(CenterArray[0] < cameraViewCenter){
		    			Robot.drivetrain.drive(speed, -speed);
		    			SmartDashboard.putString("Robot Moving", "searching right");
		    		}
		    		else {
		    			Robot.drivetrain.drive(-speed, speed);
		    			SmartDashboard.putString("Robot Moving", "searching left");
		    		}
		    	}	
	    	}
	    	
		} catch (Exception e) {
			DriverStation.reportWarning("Error at PivotToTargets", true);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(CenterArray.length >= 2){ //TODO >=
    		return true;
    	}
//    	DriverStation.reportError("No targets found", CenterArray.length == 0);
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	DriverStation.reportWarning("PivotToTargets Finished", true);
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	DriverStation.reportWarning("PivotToTargets Interrupted", true);
    	Robot.drivetrain.drive(0, 0);
    }
}
