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

    protected void execute() {
    	serv.setAngle(degrees);
    	changed = true;
    }
//dsfadsf/as/dasf/fasd/fas/d/fads
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
