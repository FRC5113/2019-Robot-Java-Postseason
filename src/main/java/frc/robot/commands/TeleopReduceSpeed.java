package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TeleopReduceSpeed extends Command {
  public TeleopReduceSpeed() {
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveBase.slowSpeed(RobotMap.slowSpeed);
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
