package org.usfirst.frc.team5414.robot.commands;

import java.util.Arrays;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PivotToCenter extends Command {
	
	double error = 0;
 	double max = 0;
	int maxind = 0;
	double centerX = 0;
   	double LeftPanel = 0;
   	double RightPanel = 0;
	double centerY = 0;
	int left = 0;
	int right = 1;
	double minspeed = .2;
	double maxspeed = .5;
	final double cameraWidthInPixels = 360;	
	double speed = 0;
	double kp;
	final double cameraViewCenter = 180;
	double[] CenterArray;
//	double[] AreaArray = Robot.table.getNumberArray("area", new double[0]);
	double CenterPanels;
	boolean CenteredDone = false;
	
    public PivotToCenter() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("AT", "PivToCenter");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	
    	//SELECT CENTERS
    	try{
    		CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
    		if(CenterArray.length > 2)	//Pick 2 largest, center onto those TODO
    		{
    			Arrays.sort(CenterArray);
    			double temp2 = CenterArray[CenterArray.length-1];
    			double temp1 = CenterArray[CenterArray.length-2];
    			CenterArray = new double[2];
    			CenterArray[0] = temp1;
    			CenterArray[1] = temp2;
    		}
    		SmartDashboard.putNumber("CX1", CenterArray[0]);
    		SmartDashboard.putNumber("CX2", CenterArray[1]);
	    	LeftPanel = Math.max(CenterArray[0], CenterArray[1]);
	    	RightPanel = Math.min(CenterArray[0], CenterArray[1]);
    	}catch(Exception e){
    		DriverStation.reportWarning("Error at PivotToCenter (Select Centers)", true);
    	}
	    
    	
    	//DESIGNATE SPEED BASED ON ERROR (PID)
    	CenterPanels = ((LeftPanel + RightPanel)/2.);
    	try {
    		SmartDashboard.putNumber("CenterPanels", CenterPanels);
        	SmartDashboard.putNumber("LeftPanel", CenterArray[0]);
        	SmartDashboard.putNumber("RightPanel", CenterArray[1]);
        	error = Math.abs(cameraViewCenter - CenterPanels);
        	kp = (maxspeed - minspeed)/129;
    		speed = error * kp +.3;
    		if(speed > maxspeed) {
    			speed = maxspeed;
    		}
    		else if(speed < minspeed) {
    			speed = minspeed;
    		}
    		kp = (maxspeed - minspeed)/129;
    		CenterPanels = (LeftPanel + RightPanel)/2;
    	}
    	catch(Exception e) 
    	{
    		DriverStation.reportWarning("Error at PivotToCenter (PID)", true);
    	}
    	//add pid closed loop TODO
    	
    	
    	
    	//ROTATE TO THE CENTER OF THE TARGET
    	try {
    		SmartDashboard.putString("Robot Moving", "trying to center");	
    		if(CenterPanels <= cameraViewCenter) {
    	   		Robot.drivetrain.drive(.375, -.375);
   			}
   			else if(CenterPanels > cameraViewCenter) { //Centering left
   	   			Robot.drivetrain.drive(-.375, .375); 
   	   			DriverStation.reportWarning("CenteringLeft", true);
    		}
    		else
   			{
    			DriverStation.reportWarning("PivotToCenter failed all ifs", true);
    		}
    	} 
    	catch (Exception e) {
    		DriverStation.reportWarning("Error at PivotToCenter (Rotate To Center)", true);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	DriverStation.reportWarning("PivotToCenter testing finished method", true);
    	DriverStation.reportWarning(CenterPanels + "", true);
    	if(CenterPanels < (cameraViewCenter + 15) && CenterPanels > (cameraViewCenter - 15)){
    		Robot.drivetrain.drive(0, 0);
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	DriverStation.reportWarning("PivotToCenter Interrupted", true);
    	Robot.drivetrain.drive(0, 0);
    }
}
