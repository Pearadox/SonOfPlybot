package org.usfirst.frc.team5414.robot.subsystems;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;




public class Camera extends Subsystem {

//	UsbCamera cam0;
//	UsbCamera cam1;
//	UsbCamera selectedCam;
//	CvSink video;
//	MjpegServer stream;
//	CvSource outputStream;
	
	public Camera()
	{
//		cam0 = new UsbCamera("cam0", 0);
//    	cam1 = new UsbCamera("cam1", 1);
//    	selectedCam = cam0;
//    	video = CameraServer.getInstance().getVideo(selectedCam);
//    	stream = new MjpegServer("", 0);
//    	outputStream = CameraServer.getInstance().putVideo("Stream", 400, 300);
	}
	
    public void initDefaultCommand() {
    	
    }

    public void SwitchCam()
    {
    	
//    	if (selectedCam == cam0) {
//            selectedCam = cam1;
//              video.setSource(selectedCam);
//          } else {
//            selectedCam = cam0;
//            video.setSource(selectedCam);
//          }

    }
}

