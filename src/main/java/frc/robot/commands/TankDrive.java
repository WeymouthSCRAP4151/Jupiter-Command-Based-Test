// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends Command {
  /** Creates a new TankDrive. */
  DriveTrain drivetrain;
  CommandJoystick m_driverJoystick1;
  CommandJoystick m_driverJoystick2;
  double drivespeed = 1;
  public TankDrive(DriveTrain drivetrain, CommandJoystick m_driverJoystick1, CommandJoystick m_driverJoystick2) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.m_driverJoystick1 = m_driverJoystick1;
    this.m_driverJoystick2 = m_driverJoystick2;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  public void setHalfSpeed () {
    drivespeed = 0.5;
  }
  public void setDefaultSpeed () {
    drivespeed = 1;
  }
  @Override
  public void execute() {
    drivetrain.setLeftWheels(drivespeed * m_driverJoystick1.getY());
    drivetrain.setRightWheels(drivespeed * m_driverJoystick2.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setLeftWheels(0);
    drivetrain.setRightWheels(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
