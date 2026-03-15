  package frc.robot.subsystems;


  import com.studica.frc.AHRS;
  import com.revrobotics.spark.SparkMax;
  import com.revrobotics.spark.SparkBase;
  import com.studica.frc.AHRS.NavXComType;

//import com.revrobotics.SparkMaxPIDController;
  //import com.revrobotics.spark.SparkLowLevel;
  //import com.revrobotics.spark.Motor
  // import edu.wpi.first.wpilibj.SPI;
  //import edu.wpi.first.wpilibj.CAN;
  //import edu.wpi.first.wpilibj.CAN;
  import edu.wpi.first.wpilibj.drive.DifferentialDrive;
  import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
  import edu.wpi.first.wpilibj2.command.SubsystemBase;
  //import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
  //import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

  //import com.ctre.phoenix.motorcontrol.ControlMode;
  //import com.ctre.phoenix.motorcontrol.can.VictorSPX;

  import frc.robot.Constants.DriveConstants;
  // import frc.robot.RobotContainer;

  public class DriveSubsystem extends SubsystemBase 
  {
    
    SparkMax m_leftMotor = new SparkMax(DriveConstants.kLeftMotorID, SparkBase.MotorType.kBrushed);
    SparkMax m_leftMotor1 = new SparkMax(DriveConstants.kLeftMotorrID,SparkBase.MotorType.kBrushed);
    SparkMax m_rightMotor = new SparkMax(DriveConstants.kRightMotorID, SparkBase.MotorType.kBrushed);
    SparkMax m_rightMotor1 = new SparkMax(DriveConstants.kRightMotorrID, SparkBase.MotorType.kBrushed);
    SparkMax Lfirlatma = new SparkMax(DriveConstants.LfirlatmaID, SparkBase.MotorType.kBrushed);
    SparkMax Rfirlatma = new SparkMax(DriveConstants.RfirlatmaID, SparkBase.MotorType.kBrushed);
    
    AHRS navx; 

  public void setFirlatmaMotors(double leftPower, double rightPower) {
      Lfirlatma.set(leftPower);
      Rfirlatma.set(rightPower);
  }

    
    

    
  /* 
    public CANSparkMax swerveaci = new CANSparkMax(DriveConstants.swerveaci, MotorType.kBrushless);
    public CANSparkMax swervetork = new CANSparkMax(DriveConstants.swervetork, MotorType.kBrushless);

    public CANSparkMax intake = new CANSparkMax(DriveConstants.intakeID, MotorType.kBrushed);
    public VictorSPX mVictorSPX = new VictorSPX(DriveConstants.mVictorSPXID);
    public VictorSP victor = new VictorSP(DriveConstants.victorPIN);

    public VictorSP asansor = new VictorSP(DriveConstants.asansorPIN); 
    public PWMSparkMax aPwmSparkMax = new PWMSparkMax(DriveConstants.pwmSparkMaxPIN);
  */  
    public DifferentialDrive differentialDrive = new DifferentialDrive(m_rightMotor, m_leftMotor);
    public DifferentialDrive differentialDrive1 = new DifferentialDrive(m_rightMotor1, m_leftMotor1);

    public  DriveSubsystem() 
    {
    navx = new AHRS(NavXComType.kMXP_SPI);
    // m_leftMotor.restoreFactoryDefaults();
      //m_leftMotor1.restoreFactoryDefaults();
    // m_rightMotor.restoreFactoryDefaults();
    // m_rightMotor1.restoreFactoryDefaults();

      //intake.restoreFactoryDefaults();

      //m_leftMotor1.follow(m_leftMotor);
    // m_rightMotor1.follow(m_rightMotor);
      navx.zeroYaw();
      differentialDrive.setMaxOutput(DriveConstants.maxOutput);
      differentialDrive1.setMaxOutput(DriveConstants.maxOutput);
    }
    public double getGyroAngle() {
    return navx.getYaw();
  }

  public void resetGyro() {
    navx.zeroYaw();
  }
    /*public void initialize(){
      m_leftMotor1.follow(m_leftMotor);
      m_rightMotor1.follow(m_rightMotor);




    }
    */
  @Override
  public void periodic() {

  if (!navx.isCalibrating()) {
    double angle = getGyroAngle();
    SmartDashboard.putNumber("Gyro Angle", angle);
  } else {
    SmartDashboard.putString("NavX Status", "Calibrating...");
  }

  }

    public void setDriveMotors(double leftMotor, double leftMotor1, double rightMotor, double rightMotor1) 
    {
    m_leftMotor.set(leftMotor);
    m_leftMotor1.set(leftMotor1);
    m_rightMotor.set(rightMotor);
    m_rightMotor1.set(rightMotor1);
      

    }

    public void setIntakeMotors(double intake_, double mVictorSPX_, double victor_) 
    {
    // intake.set(intake_);
      //mVictorSPX.set(ControlMode.PercentOutput, mVictorSPX_);
      //victor.set(victor_);
    }

    public void setSwervemotors(double swerveaci_,double swervetork_)
    {
    //swerveaci.set(swerveaci_);
  // swervetork.set(swervetork_);


  
    }
  }
