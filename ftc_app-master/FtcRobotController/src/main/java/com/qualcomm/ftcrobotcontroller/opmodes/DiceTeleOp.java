package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.lang.Math;


public class DiceTeleOp extends OpMode{

    DcMotor leftMotor;
    DcMotor rightMotor;

    float rightScaled;
    float leftScaled;

    public void start() {
        leftMotor = hardwareMap.dcMotor.get("motorLeft");
        rightMotor = hardwareMap.dcMotor.get("motorRight");
    }

    public void loop() {
        rightScaled = (float)scaleInput (gamepad1.right_stick_y);
        leftScaled = (float)scaleInput (gamepad1.left_stick_y);

        rightMotor.setPower(rightScaled);
        leftMotor.setPower(leftScaled);
    }

    public void stop() {

    }

    double scaleInput (double initVal)
    {
        return (0.8 * Math.pow (initVal, 3)) + (.2 * initVal);
    }
}

