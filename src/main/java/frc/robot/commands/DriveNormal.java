package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveNormal extends Command {
  private final DoubleSupplier x;
  private final DoubleSupplier y;
  private final DoubleSupplier z;

  public DriveNormal(DoubleSupplier xSpeed, DoubleSupplier ySpeed, DoubleSupplier zSpeed) {
    requires(Robot.driveBase);
    x = xSpeed;
    y = ySpeed;
    z = zSpeed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveBase.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.driveBase.driveCartesian(x.getAsDouble(), y.getAsDouble(), z.getAsDouble());
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
    Robot.driveBase.stop();
  }
}
