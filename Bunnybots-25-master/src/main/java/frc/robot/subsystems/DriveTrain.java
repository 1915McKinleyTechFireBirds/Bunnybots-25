// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;



import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;




public class DriveTrain extends SubsystemBase {

    public static final MotorController TalonFX = null;
        private final TalonFX m_frontLeftMotor = new TalonFX(1);
        private final TalonFX m_frontRightMotor = new TalonFX(2);
        private final TalonFX m_backLeftMotor = new TalonFX(3);
        private final TalonFX m_backRightMotor = new TalonFX(4);
        private final MecanumDrive m_robotDrive;

        

    // This code above defines the motors
    


  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    // creates new configuration object
    
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    // applies the config to motor
    m_frontLeftMotor.getConfigurator().apply(config);
    m_frontRightMotor.getConfigurator().apply(config);
    m_backLeftMotor.getConfigurator().apply(config);
    m_backRightMotor.getConfigurator().apply(config);

    m_robotDrive = new MecanumDrive(
    (double output) -> m_frontLeftMotor.set(output),
    (double output) -> m_backLeftMotor.set(output),
    (double output) -> m_frontRightMotor.set(output),
    (double output) -> m_backRightMotor.set(output));

    
  }

  public void drive(double xSpeed, double ySpeed, double rot) {
    m_robotDrive.driveCartesian(ySpeed, xSpeed, rot); // Note: WPILib's MecanumDrive uses Y for forward/backward
}

  

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
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
