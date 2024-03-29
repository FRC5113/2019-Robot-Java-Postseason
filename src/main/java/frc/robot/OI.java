package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.TestAuton;
import frc.robot.commands.ToggleCargoPivot;
import frc.robot.commands.ToggleClimbPistons;
import frc.robot.commands.ToggleCompressor;
import frc.robot.commands.ToggleHatchPanelBar;
import frc.robot.commands.ToggleHatchPanelClamp;
import frc.robot.commands.CargoControl;
import frc.robot.commands.ElevatorControl;
import frc.robot.commands.ReduceDriveSpeed;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private final Joystick mainGamepad = new Joystick(0);
  private final Joystick secondaryGamepad = new Joystick(1);

  public OI() {
    /*
     * Technically we should use .close() on all of these when they are no longer
     * being used, but these are used until the robot reboots, so for sake of
     * laziness, I am going to leave them as is.
     */
    final JoystickButton compressorButton = new JoystickButton(mainGamepad, RobotMap.compressorButton);
    final JoystickButton pivotToggleButton = new JoystickButton(secondaryGamepad, RobotMap.pivotToggleButton);
    final JoystickButton clampButton = new JoystickButton(secondaryGamepad, RobotMap.clampButton);
    final JoystickButton barButton = new JoystickButton(secondaryGamepad, RobotMap.barButton);
    final JoystickButton climbToggleButton = new JoystickButton(mainGamepad, RobotMap.climbToggleButton);
    final JoystickButton driveSlowButton = new JoystickButton(mainGamepad, RobotMap.driveSlow);
    final JoystickButton cargoInButton = new JoystickButton(secondaryGamepad, RobotMap.cargoIntakeButton);
    final JoystickButton cargoOutButton = new JoystickButton(secondaryGamepad, RobotMap.cargoOutputButton);
    final JoystickButton elevatorUpButton = new JoystickButton(secondaryGamepad, RobotMap.elevatorUpButton);
    final JoystickButton elevatorDownButton = new JoystickButton(secondaryGamepad, RobotMap.elevatorDownButton);
    final POVButton autonButton = new POVButton(mainGamepad, 0);

    compressorButton.whenPressed(new ToggleCompressor());
    pivotToggleButton.whenPressed(new ToggleCargoPivot());
    clampButton.whenPressed(new ToggleHatchPanelClamp());
    barButton.whenPressed(new ToggleHatchPanelBar());
    climbToggleButton.whenPressed(new ToggleClimbPistons());
    driveSlowButton.toggleWhenPressed(new ReduceDriveSpeed(RobotMap.slowSpeed));
    cargoInButton.whileHeld(new CargoControl(true));
    cargoOutButton.whileHeld(new CargoControl(false));
    elevatorUpButton.whileHeld(new ElevatorControl(true));
    elevatorDownButton.whileHeld(new ElevatorControl(false));
    autonButton.whileHeld(new TestAuton());
  }

  public double getDriveX() {
    return mainGamepad.getRawAxis(RobotMap.driveXStick);
  }

  public double getDriveY() {
    return mainGamepad.getRawAxis(RobotMap.driveYStick);
  }

  public double getDriveZ() {
    return mainGamepad.getRawAxis(RobotMap.driveZStick);
  }

  public boolean getAutonForwardButton() {
    return mainGamepad.getRawButton(RobotMap.autonForwardButton);
  }

}
