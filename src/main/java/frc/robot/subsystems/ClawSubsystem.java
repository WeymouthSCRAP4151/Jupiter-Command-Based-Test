// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClawConstants;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
public class ClawSubsystem extends SubsystemBase {
    private final DoubleSolenoid m_clawSolenoid 
    = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 
    ClawConstants.kSolenoidForwardPort, 
    ClawConstants.kSolenoidReversePort);
    public static final Compressor m_compressor = new Compressor(PneumaticsModuleType.CTREPCM);
  public ClawSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public void openClaw() {
    m_clawSolenoid.set(Value.kForward);
  }
  public void closeClaw() {
    m_clawSolenoid.set(Value.kReverse);
  }
  public void toggleClaw() {
    m_clawSolenoid.toggle();
  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    // Publish the solenoid state to telemetry.
    builder.addBooleanProperty("clawClosed", () -> m_clawSolenoid.get() == Value.kForward, null);
    builder.addBooleanProperty("CompressorOn", () -> m_compressor.isEnabled()==true, null);
    builder.addBooleanProperty("CompressorValveOpen", () -> m_compressor.getPressureSwitchValue()==true, null);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
