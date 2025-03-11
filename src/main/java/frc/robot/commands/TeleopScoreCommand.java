// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.HatchSubsystem;
import frc.robot.subsystems.MotorForElevator;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;

/** An example command that uses an example subsystem. */
public class TeleopScoreCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final MotorForElevator motorForElevator;
  public SparkMax motorForElevatorOne = new SparkMax(6, SparkMax.MotorType.kBrushless);
  public SparkMax motorForElevatorTwo = new SparkMax(7, SparkMax.MotorType.kBrushless);
  private final HatchSubsystem grab;
  private final HatchSubsystem release;
  private double time;
  private double startTime;
  public XboxController joystick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopScoreCommand(MotorForElevator motorForElevator, HatchSubsystem grab, HatchSubsystem release, double time) {
    this.motorForElevator = motorForElevator;
    this.grab = grab;
    this.release = release;
    this.time = time;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(motorForElevator, grab, release);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public void teleopPeriodic(){
    if (joystick.getAButtonPressed()) {


      motorForElevatorOne.set(0.5);
      motorForElevatorTwo.set(0.5);
      grab.grabHatch();
      grab.releaseHatch();

    }
  }
}
