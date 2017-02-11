package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ServoTest extends Command {

	
	public static Servo serv;
	boolean changed;
	private double degrees;
	
    public ServoTest() {
    	degrees = 90;
    	serv = new Servo(9);
    }

    // ore this Command runs the first time
    protected void initialize() {
    	if(degrees == 90)
    	{
    		degrees = 0;
    	}
    	else
    	{
    		degrees = 90;
    	}
    	changed = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	serv.setAngle(degrees);
    	changed = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return changed;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
