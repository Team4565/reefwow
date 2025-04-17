package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  public SparkMax m_leftMotor = new SparkMax(1, SparkMax.MotorType.kBrushed);
  public SparkMax m_rightMotor = new SparkMax(4,SparkMax.MotorType.kBrushed);
  public SparkMax m_leftFollowerMotor = new SparkMax(2, SparkMax.MotorType.kBrushed);
  public SparkMax m_rightFollowerMotor = new SparkMax(3, SparkMax.MotorType.kBrushed);
  public DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  public XboxController joystick = new XboxController(0);
  /**
  public void robotInit() {
    public SparkMax m_leftMotor = new SparkMax(1, SparkMax.MotorType.kBrushed);
    public SparkMax m_rightMotor = new SparkMax(4,SparkMax.MotorType.kBrushed);
    public SparkMax m_leftFollowerMotor = new SparkMax(2, SparkMax.MotorType.kBrushed);
    public SparkMax m_rightFollowerMotor = new SparkMax(3, SparkMax.MotorType.kBrushed);
    public DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  }**/

  public DrivetrainSubsystem() {
    SparkMaxConfig config = new SparkMaxConfig();

    config
    .inverted(true);
    
    m_leftFollowerMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_rightFollowerMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    //m_leftFollowerMotor.setInverted(true);
    //m_rightFollowerMotor.setInverted(true);


  }


  @Override
  public void periodic() {
    m_drive.feed();
  }

  public void teleopDrive(double fwd, double rot) {
      m_drive.arcadeDrive(fwd, rot);
  }
  
  /**
  public void teleopPeriodic() {
  if (joystick.getLeftY() > 0.35 || joystick.getLeftY() < -0.35) {
    teleopDrive(joystick.getLeftY(), 0.0);
  } else if (joystick.getRightX() > 0.35 || joystick.getRightX() < -0.35) {
    this.teleopDrive(0, joystick.getRightX());
  } else {
    this.teleopDrive(0, 0);
  }
  **/

  /**
  if (joystick.getLeftY() > 0.35 || joystick.getLeftY() < -0.35) {
    DrivetrainSubsystem.teleopDrive(joystick.getLeftY(), joystick.getRightX());
  } else if (joystick.getRightX() > 0.35 || joystick.getRightX() < -0.35) {
    DrivetrainSubsystem.teleopDrive(joystick.getLeftY(), joystick.getRightX());
  } else {
    DrivetrainSubsystem.teleopDrive(0, 0);
  }
  **/

  /**
  DrivetrainSubsystem.m_leftMotor.set(joystick.getLeftY());
  DrivetrainSubsystem.m_leftMotor.set(-joystick.getRightX());
  DrivetrainSubsystem.m_rightMotor.set(joystick.getLeftY());
  DrivetrainSubsystem.m_rightMotor.set(joystick.getRightX());
  DrivetrainSubsystem.m_leftFollowerMotor.set(joystick.getLeftY());
  DrivetrainSubsystem.m_leftFollowerMotor.set(joystick.getRightX());
  DrivetrainSubsystem.m_rightFollowerMotor.set(-joystick.getLeftY());
  DrivetrainSubsystem.m_rightFollowerMotor.set(joystick.getRightX());
  } 
  **/

  /**
  public void setDefaultCommand(RunCommand runCommand, Object teleopDrive, DrivetrainSubsystem drivetrainSubsystem) {
  } */

}
