
package frc2168_2013.commands.subSystems.ShooterAngle;

import frc2168_2013.CommandBaseRobot;
import frc2168_2013.commands.CommandBase;

/**
 *
 * @author Shriji
 */
public class ShooterAngleExtend extends CommandBase {

	/**
	 * Default constructor.
	 */
    public ShooterAngleExtend() {
    	requires(shooterAngle);
    }

    /**
     * Called just before this Command runs the first time.
     */
    
	protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    
	protected void execute() {
		CommandBaseRobot.setNumberOfDiscs(4);
    	shooterAngle.extend();
    	//extends the shooter solenoid 
    }

    /**
     * Returns true immediately after the stopper has been engaged.
     */
    
	protected boolean isFinished() {
        return true;
    }

    /**
     * Called once after isFinished returns true.
     */
    
	protected void end() {
    	//Nothing special to do here.
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    
	protected void interrupted() {
    	//Nothing special to do here.
    }
}
