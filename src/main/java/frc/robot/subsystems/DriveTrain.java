// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {
  private PWMSparkMax m_leftWheels = new PWMSparkMax(DriveConstants.leftWheelsPort);
  private PWMSparkMax m_rightWheels = new PWMSparkMax(DriveConstants.rightWheelsPort);
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    m_rightWheels.setInverted(true);
  }
  
  public void setLeftWheels(double speed) {
    m_leftWheels.set(-speed);
  }
  public void setRightWheels(double speed) {
    m_rightWheels.set(-speed);
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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
