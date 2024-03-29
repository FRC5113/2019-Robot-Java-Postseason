package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Climber extends Subsystem {
  private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(RobotMap.elevatorMotorCAN);
  private DoubleSolenoid climb = new DoubleSolenoid(RobotMap.climbSolenoid0, RobotMap.climbSolenoid1);

  public Climber() {
    elevatorMotor.setNeutralMode(NeutralMode.Brake);
    elevatorMotor.setInverted(true);
    climb.set(Value.kReverse); // Initialized as kReverse because that is it's starting configuration.
  }

  /**
   * True for up, false for down.
   */
  public void elevatorDirection(boolean dir) {
    elevatorMotor.set(RobotMap.elevatorSpeed * (dir ? 1 : -1));
  }

  public void elevatorOff() {
    elevatorMotor.set(0);
  }

  public void toggleClimb() {
    if (climb.get() == Value.kReverse) {
      climb.set(Value.kForward);
    } else {
      climb.set(Value.kReverse);
    }
  }

  @Override
  public void initDefaultCommand() {
    // This subsystem has no default command
  }
}
