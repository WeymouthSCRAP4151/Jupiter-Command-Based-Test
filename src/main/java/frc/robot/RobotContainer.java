// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.Autos;
import frc.robot.commands.CloseClawCommand;
import frc.robot.commands.Move;
import frc.robot.commands.OpenClawCommand;
import frc.robot.commands.TankDrive;
import frc.robot.commands.ToggleClawCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  CommandJoystick m_driverJoystick1 = new CommandJoystick(OperatorConstants.kDriverControllerPort);
  CommandJoystick m_driverJoystick2 = new CommandJoystick(OperatorConstants.kDriverControllerPort2);
  DriveTrain drivetrain = new DriveTrain();
  ClawSubsystem clawsubsystem = new ClawSubsystem();
  TankDrive tankdrive = new TankDrive(drivetrain, m_driverJoystick1, m_driverJoystick2);
  CloseClawCommand closeClawCommand = new CloseClawCommand(clawsubsystem);
  OpenClawCommand openClawCommand = new OpenClawCommand(clawsubsystem);
  Trigger halfSpeedTrigger = m_driverJoystick1.button(1);
  Trigger moveTrigger = m_driverJoystick1.button(4);
  Trigger clawTrigger = m_driverJoystick2.button(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    drivetrain.setDefaultCommand(tankdrive);
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    moveTrigger.whileTrue(new Move(0.5, 0.5));
    clawTrigger.onTrue(new ToggleClawCommand(clawsubsystem));
    halfSpeedTrigger.whileTrue(new StartEndCommand(tankdrive::setHalfSpeed, tankdrive::setDefaultSpeed, new Subsystem[0]));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
