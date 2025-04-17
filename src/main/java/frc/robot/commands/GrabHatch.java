// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HatchSubsystem;

public class GrabHatch extends Command {
  private final HatchSubsystem m_hatchSubsystem;

    public GrabHatch(HatchSubsystem hatchSubsystem) {
        m_hatchSubsystem = hatchSubsystem;
        addRequirements(hatchSubsystem);
    }

    @Override
    public void initialize() {
        //m_hatchSubsystem.grabHatch();
    }
}