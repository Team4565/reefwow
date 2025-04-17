// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GrabHatch;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.HatchSubsystem;
import frc.robot.subsystems.MotorForElevator;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private final MotorForElevator m_motorForElevator = new MotorForElevator();
  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  private final HatchSubsystem m_hatchSubsystem = new HatchSubsystem();
  private final Command driveStraight = Autos.driveStraight(m_drivetrainSubsystem, m_hatchSubsystem);
  private final Command driveAndScore = Autos.driveAndScore(m_motorForElevator, m_drivetrainSubsystem, m_hatchSubsystem);

  public SendableChooser<Command> m_chooser = new SendableChooser<>();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static XboxController m_driverController =
      new XboxController(0);


  private final XboxController m_driverControllerTwo =
      new XboxController(1);


  public RobotContainer() {

    configureBindings();

    //m_drivetrainSubsystem.setDefaultCommand(new RunCommand(() ->
    //m_drivetrainSubsystem.teleopDrive(m_driverController.getLeftY(), m_driverController.getRightX()), m_drivetrainSubsystem));
    //m_drivetrainSubsystem.teleopDrive(m_driverController.getLeftY(), m_driverController.getLeftX()), m_drivetrainSubsystem));
    
    m_chooser.addOption("Drive Straight", driveStraight);
    m_chooser.addOption("Drive and Score", driveAndScore);
    m_chooser.setDefaultOption("Drive Straight", driveStraight);
    SmartDashboard.putData(m_chooser);
  
  }
  
  private void configureBindings() {
    
    //new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value).onTrue(new GrabHatch(m_hatchSubsystem));
    //new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value).onTrue(new ReleaseHatch(m_hatchSubsystem));

    
  }
  
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return m_chooser.getSelected();
    return Autos.driveStraight(m_drivetrainSubsystem, m_hatchSubsystem);
  }
}


