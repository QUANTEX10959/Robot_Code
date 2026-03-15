package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.DriveConstants;
import frc.robot.commands.AutonomusCmd;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer 
{
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();

  private final DriveCommand DriveCommand = new DriveCommand(driveSubsystem);
  private final AutonomusCmd autonomusCmd = new AutonomusCmd(driveSubsystem);

  public static Joystick kontrol = new Joystick(DriveConstants.kontrolPORT);
  public static Joystick firlatma = new Joystick(DriveConstants.firlatmaPORT);

  public RobotContainer() 
  {
    configureBindings();
    driveSubsystem.setDefaultCommand(DriveCommand);
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() 
  {
    return autonomusCmd;
  }
}
