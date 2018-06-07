package org.firstinspires.ftc.teamcode.threadopmode.examples;

import com.nolankuza.threadopmode.TaskThread;
import com.nolankuza.threadopmode.ThreadOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//Extend ThreadOpMode rather than OpMode
public class ExampleOpMode extends ThreadOpMode {

    //Define global variables
    private DcMotor dcMotor;

    @Override
    public void mainInit() {
        //Perform your normal init
        dcMotor = hardwareMap.dcMotor.get("dcMotor");

        //Below is a new thread
        registerThread(new TaskThread(new TaskThread.Actions() {
            @Override
            public void loop() {
                //The loop method should contain what to constantly run in the thread
                //For instance, this drives a single DcMotor
                dcMotor.setPower(gamepad1.left_stick_y);
            }
        }));
    }

    @Override
    public void mainLoop() {
        //Anything you want to constantly run in the MAIN thread goes here
    }
}
