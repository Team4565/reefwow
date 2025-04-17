// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.MotorForElevator;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.HatchSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Command;

public class Autos {
  /** Example static factory for an autonomous command. */

  public XboxController controller = new XboxController(0);


  public static Command getExampleCommand(ExampleSubsystem exampleSubsystem) {
    return new ExampleCommand(exampleSubsystem);
  }

  public static Command exampleCommand(ExampleSubsystem exampleSubsystem) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new ExampleCommand(exampleSubsystem),
      new ExampleCommand(exampleSubsystem)
    );

    return group;
  }

  //First command, drive straight for 2 seconds at 0.5 speed to score points when crossing the line
  public static Command driveStraight(DrivetrainSubsystem drivetrainSubsystem, HatchSubsystem hatchSubsystem) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new RunForTime(drivetrainSubsystem, 2, -0.5),
      new Release(hatchSubsystem)
    );

    return group;
  }
  
  //Second command, scoring mechanism for the robot
  public Command teleopAutoCommand(MotorForElevator motorForElevator, HatchSubsystem hatchSubsystem) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new MotorForElevatorCmd(motorForElevator,  2.5, 0.7),
      new Release(hatchSubsystem),
      new MotorForElevatorCmd(motorForElevator, 2.5 , -0.7)
    );
    return group;
  }

  //Third command, running forward and scoring mechanism for the robot
  public static Command driveAndScore( MotorForElevator motorForElevator, DrivetrainSubsystem drivetrainSubsystem, HatchSubsystem hatchSubsystem) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new RunForTime(drivetrainSubsystem, 2, -0.5),
      new MotorForElevatorCmd(motorForElevator, 2.5, 0.7),
      new Release(hatchSubsystem),
      new MotorForElevatorCmd(motorForElevator, 2.5, -0.7)
    );
    return group;
  }

  public void autonomousInit(){
    
  }


  /**public Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }**/


}
