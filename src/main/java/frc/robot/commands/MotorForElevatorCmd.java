// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorForElevator;

import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class MotorForElevatorCmd extends Command {
    private final MotorForElevator motorForElevator;
    private final double speed;
    public double time;
    public double startTime;
  
    public MotorForElevatorCmd(MotorForElevator motorForElevator, double speed, double time) {
      this.motorForElevator = motorForElevator;
      this.speed = speed;
      this.time = time;

    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(motorForElevator, motorForElevatorTwo);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motorForElevator.setSpeed(speed);
  }

  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  public boolean isFinished() {
    return (Timer.getFPGATimestamp() > startTime + time);
    // basically what this is saying is that when the hardware clock is greater than the start time and
    // inputted time, the command will end

  }



}
