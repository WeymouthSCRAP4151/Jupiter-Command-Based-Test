// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kDriverControllerPort2 = 1;
  }
  public static final class DriveConstants {
    public static final int leftWheelsPort = 4;
    public static final int rightWheelsPort = 1;
    public static final int kSolenoidForwardPort = 6;
    public static final int kSolenoidReversePort = 7;
  }
  public static final class ElevatorConstants {
    public static final int m_pulleyMotorPort = 0;
    public static final double defaultPulleySpeed = 1;
    public static final double halfPulleySpeed = 0.5;
  }
  public static final class ClawConstants {
    public static final int kSolenoidForwardPort = 6;
    public static final int kSolenoidReversePort = 7;
  }
}
