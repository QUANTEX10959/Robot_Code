package frc.robot.commands;

//import com.revrobotics.spark.SparkBase;
//import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
//import frc.robot.Constants.DriveConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

//fff import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveCommand extends Command
{   
    private final DriveSubsystem driveSubsystem;
    // SparkMax Lfirlatma = new SparkMax(DriveConstants.kRightMotorID, SparkBase.MotorType.kBrushed);
    // SparkMax Rfirlatma = new SparkMax(DriveConstants.kRightMotorrID, SparkBase.MotorType.kBrushed);
  

    public DriveCommand(DriveSubsystem driveSubsystem)
    {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }
  
    @Override
    public void initialize() 
    {
        driveSubsystem.differentialDrive1.setSafetyEnabled(false);
        driveSubsystem.differentialDrive.setSafetyEnabled(false);
    }

    @Override
    public void execute() 
    {    
        
    // driveSubsystem.differentialDrive1.arcadeDrive(-RobotContainer.kontrol.getX(), -RobotContainer.kontrol.getY());

        // swerweACi
        /*if (RobotContainer.kontrol.getRawButtonPressed(1))
        {
         //   driveSubsystem.swerveaci.set(0.95);
        }
        */

        
        if (RobotContainer.kontrol.getRawButton(1)) {
            driveSubsystem.setFirlatmaMotors(-1, 1);
        } 
        else if (RobotContainer.kontrol.getRawButton(3))
        {
            driveSubsystem.setFirlatmaMotors(-1, -1);
        } 
        else {
            
            driveSubsystem.setFirlatmaMotors(0, 0);
        }

        // swerweTORK
        /*if (RobotContainer.kontrol.getRawButton(2)) {
            driveSubsystem.setFirlatmaMotors(0.5, 0.5);
        } 
        else {
            
            driveSubsystem.setFirlatmaMotors(0, 0);
        }*/

        // if (RobotContainer.kontrol.getRawButtonReleased(2))
        // {
            //driveSubsystem.swervetork.set(0);
        // }
        

        driveSubsystem.differentialDrive.arcadeDrive(-RobotContainer.kontrol.getX()/1.5, -RobotContainer.kontrol.getY());
        // if (RobotContainer.kontrol.getRawButtonReleased(3))
        // {
        //     //driveSubsystem.swerveaci.set(0);
        // }

        /* 
        // buton 2
        if (RobotContainer.firlatma.getRawButtonPressed(2))
        {         
            driveSubsystem.intake.set(0.6);
            driveSubsystem.mVictorSPX.set(ControlMode.PercentOutput, 0.6);
        } 
        if (RobotContainer.firlatma.getRawButtonReleased(2))
            driveSubsystem.setIntakeMotors(0, 0, 0);


        // buton 3
        if (RobotContainer.firlatma.getRawButtonPressed(3))       
            driveSubsystem.victor.set(-1);
 
        if (RobotContainer.firlatma.getRawButtonReleased(3))
            driveSubsystem.setIntakeMotors(0, 0, 0);


        // buton 12
        if (RobotContainer.firlatma.getRawButtonPressed(12))       
            driveSubsystem.victor.set(0.6);

        if (RobotContainer.firlatma.getRawButtonReleased(12))
            driveSubsystem.setIntakeMotors(0, 0, 0);  
        */       
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() 
    {
        return false;
    }   
}
