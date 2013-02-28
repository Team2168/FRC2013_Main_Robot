
package frc2168_2013.commands;

/**
 *
 * @author Shriji
 */
public class StopperEngage extends CommandBase {

	/**
	 * Default constructor.
	 */
    public StopperEngage() {
    	requires(hardStop);
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
    	hardStop.engageStopper();
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
