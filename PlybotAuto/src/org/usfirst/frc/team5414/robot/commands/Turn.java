package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Turn extends Command {

	private final int left = 0;
	private final int right = 1;
	private int direction;
	private double speed;
	private boolean on;
	
    public Turn(int direc, double sp) {
        direction = direc;
        speed = sp;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	on = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	on = true;
    	try{
    		if(direction == left) //invesion problem? - trying to switch - orignally this was left
    		{
    			Robot.drivetrain.drive(-speed, speed);
    		}
    		else if(direction == right)
    		{
    			Robot.drivetrain.drive(speed, -speed);
    		}
    	}
    	catch(Exception e)
    	{
    		SmartDashboard.putBoolean("Errored", true);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return on;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
