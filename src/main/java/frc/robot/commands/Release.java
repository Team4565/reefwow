// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HatchSubsystem;

/** An example command that uses an example subsystem. */
public class Release extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final HatchSubsystem m_hatchSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Release(HatchSubsystem hatchSubsystem) {
    m_hatchSubsystem = hatchSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_hatchSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //m_hatchSubsystem.releaseHatch();
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
}
