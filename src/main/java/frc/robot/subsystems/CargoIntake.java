package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class CargoIntake extends Subsystem {
  private WPI_TalonSRX intakeMotor = new WPI_TalonSRX(RobotMap.intakeMotorCAN);
  private DoubleSolenoid pivot = new DoubleSolenoid(RobotMap.pivotSolenoid0, RobotMap.pivotSolenoid1);

  public CargoIntake() {
    intakeMotor.setInverted(true); // Set as inverted because it spins the wrong direction.
    pivot.set(Value.kForward); // Initialized as kForward because that is its starting configuration.
  }

  /**
   * True for intake, false for outtake.
   */
  public void intakeSpinDirection(boolean dir) {
    intakeMotor.set(dir ? RobotMap.intakeSpeed : RobotMap.outputSpeed);
  }

  public void intakeOff() {
    intakeMotor.set(0);
  }

  public void togglePivot() {
    if (pivot.get() == Value.kForward) {
      pivot.set(Value.kReverse);
    } else {
      pivot.set(Value.kForward);
    }
  }

  @Override
  public void initDefaultCommand() {
    // This subsystem has no default command.
  }
}
