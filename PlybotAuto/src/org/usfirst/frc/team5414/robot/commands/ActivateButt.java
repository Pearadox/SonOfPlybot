//package org.usfirst.frc.team5414.robot.commands;
//
//import org.usfirst.frc.team5414.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class ActivateButt extends Command {
//
//    public ActivateButt() {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	requires(Robot.drivetrain);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	Robot.drivetrain.FullButterfly();
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//
//    	Robot.drivetrain.arcadeDrive(Robot.oi.getJoystick1());
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	Robot.drivetrain.FullTraction();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
