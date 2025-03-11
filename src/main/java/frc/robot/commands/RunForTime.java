// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DrivetrainSubsystem;

/** An example command that uses an example subsystem. */
public class RunForTime extends Command {

  private static DrivetrainSubsystem m_DrivetrainSubsystem;
  private double time;
  private double startTime;
  private double speed;

  public RunForTime(DrivetrainSubsystem subsystem, double time, double speed) {
    m_DrivetrainSubsystem = subsystem;
    this.time = time;
    this.speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  public void initialization() {
    startTime = Timer.getFPGATimestamp();
  }

  public void execute() {
    m_DrivetrainSubsystem.teleopDrive(0.5,0);
  }

  public void end() {
    m_DrivetrainSubsystem.teleopDrive(0,0);
  }

  public void teleopPeriodic() {

  }

  public boolean isFinished() {
    return (Timer.getFPGATimestamp() > startTime + time);
  }


  
}
