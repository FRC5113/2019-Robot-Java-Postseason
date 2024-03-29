package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ReduceDriveSpeed extends Command {
  private final double multiplier;

  public ReduceDriveSpeed(double speed) {
    multiplier = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveBase.slowSpeed(multiplier);
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
    Robot.driveBase.normalSpeed();
  }
}
