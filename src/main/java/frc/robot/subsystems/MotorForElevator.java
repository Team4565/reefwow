// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.Timer;

public class MotorForElevator extends SubsystemBase {

  public static SparkMax elevatorMotor = new SparkMax(6, SparkMax.MotorType.kBrushed);
  public static SparkMax elevatorFollowerMotor = new SparkMax(7, SparkMax.MotorType.kBrushed); 
  public static XboxController joystick = new XboxController(0);
  public double startTime;

  
  
  public MotorForElevator() {
    SparkMaxConfig config = new SparkMaxConfig();

    config.inverted(true);
    
    elevatorFollowerMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  public void setSpeed(double speed){
    elevatorMotor.set(speed);
    elevatorFollowerMotor.set(speed);
  }

  public void teleopPeriodic() {
    if (joystick.getAButton() == true) {
      elevatorMotor.set(0.45);
      elevatorFollowerMotor.set(-0.45);
    } else if (joystick.getBButton() == true) {
      elevatorMotor.set(-0.45);
      elevatorFollowerMotor.set(0.45);
    } else {
      elevatorMotor.set(0);
      elevatorFollowerMotor.set(0);
    }
    
    /**
    if (joystick.getBackButton() == true) {
      elevatorMotor.set(0.45);
      elevatorFollowerMotor.set(-0.45);
    } else if (joystick.getStartButton() == true) {
      elevatorMotor.set(-0.45);
      elevatorFollowerMotor.set(0.45);
    } else if (joystick.getBButtonReleased() == true){
      startTime = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp() < 1.5) {
          elevatorMotor.set(0.6);
          elevatorFollowerMotor.set(-0.6);
        }
    } else {
      elevatorMotor.set(0);
      elevatorFollowerMotor.set(0);
    }**/
  }

}

