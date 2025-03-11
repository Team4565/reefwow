// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.util.sendable.SendableBuilder;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

public class HatchSubsystem extends SubsystemBase {

  public DoubleSolenoid m_hatchDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

  public static XboxController joystick = new XboxController(0);


  
    public void grabHatch() {
      m_hatchDoubleSolenoid.set(kForward);
    }

    public void releaseHatch() {
      m_hatchDoubleSolenoid.set(kReverse);
    }

    public void stopHatch() {
      m_hatchDoubleSolenoid.set(DoubleSolenoid.Value.kOff);
    }

    //@Override
    /**public void initSendable(SendableBuilder builder){
        super.initSendable(builder);
    
        builder.addBooleanProperty("extended", () -> m_hatchDoubleSolenoid.get() == kForward, null);
        builder.addBooleanProperty("retracted", () -> m_hatchDoubleSolenoid.get() == kReverse, null);
    }

    /**public DoubleSolenoid.Value doubleSolenoidValue() {
      return m_hatchDoubleSolenoid.get();
    }

    public boolean isExtended() {
      return m_hatchDoubleSolenoid.isFwdSolenoidDisabled();
    }

    public boolean isRetracted() {
      return m_hatchDoubleSolenoid.isRevSolenoidDisabled();
    }

    /**public int getForward() {
      return m_hatchDoubleSolenoid.getFwdChannel();
    }

    public int getReverse() {
      return m_hatchDoubleSolenoid.getRevChannel();
    }

    public void periodic() {
      SmartDashboard.putBoolean("Is extended?", isExtended());
      SmartDashboard.putBoolean("Is retracted?", isRetracted());
      //SmartDashboard.putNumber("Forward Channel", getForward());
      //SmartDashboard.putNumber("Reverse Channel", getReverse());
    }**/

    public void teleopPeriodic() {
      if (joystick.getLeftBumperButtonReleased()) {
        grabHatch();
      }
      
      if (joystick.getRightBumperButtonReleased()) {
        releaseHatch();
      }

    }
}