package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CargoControl extends Command {
  private final boolean direction;

  /**
   * True for intake, false for outtake.
   */
  public CargoControl(boolean dir) {
    requires(Robot.cargoIntake);
    direction = dir;
  }

  // Called once when this Command is scheduled to run
  @Override
  protected void initialize() {
    Robot.cargoIntake.intakeSpinDirection(direction);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.cargoIntake.intakeOff();
  }
}
