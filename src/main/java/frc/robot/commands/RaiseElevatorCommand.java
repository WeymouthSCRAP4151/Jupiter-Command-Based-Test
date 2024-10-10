// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.subsystems.ElevatorSubsystem;

public class RaiseElevatorCommand extends Command {
  /** Creates a new RaiseElevatorCommand. */
  ElevatorSubsystem elevatorsubsystem;
  double elevatorspeed = ElevatorConstants.defaultPulleySpeed;
  public RaiseElevatorCommand(ElevatorSubsystem elevatorsubsystem) {
    this.elevatorsubsystem = elevatorsubsystem;
    addRequirements(elevatorsubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevatorsubsystem.raiseElevator(elevatorspeed);
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
