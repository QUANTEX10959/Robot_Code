package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomusCmd extends Command
{   
    private final DriveSubsystem driveSubsystem;

    private static double startTime = 0;

    public AutonomusCmd(DriveSubsystem driveSubsystem)
    {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }
    
  
    @Override
    public void initialize() 
    {
        startTime = Timer.getFPGATimestamp();
        driveSubsystem.differentialDrive1.setSafetyEnabled(false);
    }

    @Override
    public void execute() 
    {    
        double time = Timer.getFPGATimestamp();
        SmartDashboard.putNumber("Autonomous Time: ", time - startTime);

        if (time - startTime < 1)
        {   
            driveSubsystem.differentialDrive.arcadeDrive(0, 1);
        }
        else
        {
            driveSubsystem.differentialDrive.arcadeDrive(0, 0);
        }
         
        // if (time - startTime >= 0.5 && time - startTime < 2)
        // {   
        //    driveSubsystem.differentialDrive.arcadeDrive(0, 0);
        // }
        
        // if (time - startTime >= 2 && time - startTime < 2.5)
        // {
        //     if (driveSubsystem.getGyroAngle() < 90) {
        //         driveSubsystem.differentialDrive.arcadeDrive(0, 0.5);
        //     } else {
        //         driveSubsystem.differentialDrive.arcadeDrive(0, 0);
        //     }
        // }
        // if (time - startTime >= 2.5 && time - startTime < 10000)
        // {
        //     driveSubsystem.differentialDrive.arcadeDrive(0, 0);
        // }
        /*  
        if (time - startTime >= 6 && time - startTime < 7)
        {   
            driveSubsystem.setDriveMotors(-0.5, -0.5, 0.5, 0.5);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        } 
        if (time - startTime >= 7)
        {   
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }     
        */

        // sadece firlatma
        /* 
        if (time - startTime < 2)
        {   
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0.6, 0.6, 0.6);
        } 
        if (time - startTime >= 2 && time - startTime < 3)
        {   
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        if (time - startTime >= 3 && time - startTime < 5)
        {
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(-1, -1, -1);
        }
        if (time - startTime >= 5)
        {
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        
        /*
        // kirmizi
        if (time - startTime < 2)
        {   
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0.5, 0.5, 0.5);
        } 
        if (time - startTime >= 2 && time - startTime < 3)
        {   
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        if (time - startTime >= 3 && time - startTime < 5)
        {
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(-1, -1, -1);           
        }
        if (time - startTime >= 5 && time - startTime < 6)
        {   
            driveSubsystem.setDriveMotors(-0.2, -0.2, 0.2, 0.2);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        } 
        if (time - startTime >= 6 && time - startTime < 7)
        {
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        if (time - startTime >= 7 && time - startTime < 8)
        {   
            driveSubsystem.setDriveMotors(-0.3, -0.3, -0.3, -0.3);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        } 
        if (time - startTime >= 8)
        {   
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
      
        if (time - startTime >= 9 && time - startTime < 10)
        {
            driveSubsystem.setDriveMotors(0.4, 0.4, -0.4, -0.4);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        if (time - startTime >= 10 && time - startTime < 11)
        {
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        if (time - startTime >= 11 && time - startTime < 12)
        {   
            driveSubsystem.setDriveMotors(-0.2, -0.2, -0.2, -0.2);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        } 
        if (time - startTime >= 12)
        {   
            driveSubsystem.setDriveMotors(0, 0, 0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        */
    }

    @Override
    public void end(boolean interrupted) 
    {
        driveSubsystem.setDriveMotors(0, 0, 0, 0);
        driveSubsystem.setIntakeMotors(0, 0, 0);
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }   
}
