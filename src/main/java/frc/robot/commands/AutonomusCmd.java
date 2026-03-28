package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomusCmd extends Command {   
    private final DriveSubsystem driveSubsystem;
    private static double startTime = 0;

    public AutonomusCmd(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }
    
    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
        // Eğer sisteminde tanımlıysa güvenlik modunu kapatabilirsin. 
        // driveSubsystem.differentialDrive.setSafetyEnabled(false); 
    }

    @Override
    public void execute() {    
        double time = Timer.getFPGATimestamp();
        double elapsedTime = time - startTime;
        SmartDashboard.putNumber("Autonomous Time: ", elapsedTime);

        // ZAMAN ÇİZELGESİ (Süreleri ve Hızları robotunun ağırlığına göre sahada test ederek değiştirmelisin)
        
        if (elapsedTime < 2.0) {
            // 1. AŞAMA: Yeşil kutudan çıkış ve orta çizgiye kavisli yönelme
            // Sola göre daha hızlı dönen sol motor, robotun sağa doğru kavis yapmasını sağlar.
            driveSubsystem.differentialDrive.tankDrive(0.6, 0.4); 
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        else if (elapsedTime >= 2.0 && elapsedTime < 3.5) {
            // 2. AŞAMA: Not'a (halkaya) doğru düz ilerleme ve Intake çalıştırma
            driveSubsystem.differentialDrive.tankDrive(0.4, 0.4); 
            driveSubsystem.setIntakeMotors(0.6, 0.6, 0.6); // Intake'i içeri alacak şekilde çalıştır
        }
        else if (elapsedTime >= 3.5 && elapsedTime < 4.0) {
            // 3. AŞAMA: Notu tam olarak içeri aldığından emin olmak için kısa duraklama
            driveSubsystem.differentialDrive.tankDrive(0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0); 
        }
        else if (elapsedTime >= 4.0 && elapsedTime < 6.5) {
            // 4. AŞAMA: Kırmızı kutuya (Subwoofer) geriye doğru kavis çizerek dönme
            // Geri giderken sağ motorun daha hızlı (negatif olarak daha büyük) dönmesi yönünü ayarlar
            driveSubsystem.differentialDrive.tankDrive(-0.4, -0.6);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
        else if (elapsedTime >= 6.5 && elapsedTime < 8.0) {
            // 5. AŞAMA: Dur ve Fırlat (Shooter)
            driveSubsystem.differentialDrive.tankDrive(0, 0);
            driveSubsystem.setIntakeMotors(-1.0, -1.0, -1.0); // Fırlatma yönünde motorları çalıştır
        }
        else {
            // 6. AŞAMA: Otonom süresi bitti, her şeyi durdur
            driveSubsystem.differentialDrive.tankDrive(0, 0);
            driveSubsystem.setIntakeMotors(0, 0, 0);
        }
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.differentialDrive.tankDrive(0, 0);
        driveSubsystem.setIntakeMotors(0, 0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }   
}