package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorControl extends Command {
  boolean direction;

  /**
   * True for up, false for down.
   */
  public ElevatorControl(boolean dir) {
    requires(Robot.climber);
    direction = dir;
  }

  // Called once when this Command is scheduled to run
  @Override
  protected void initialize() {
    Robot.climber.elevatorDirection(direction);
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
    Robot.climber.elevatorOff();
  }
}