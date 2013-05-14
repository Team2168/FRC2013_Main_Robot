package frc2168_2013.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc2168_2013.CommandBaseRobot;
import frc2168_2013.commands.Sleep;
import frc2168_2013.commands.subSystems.Hopper.ShootSingleDisc;
import frc2168_2013.commands.subSystems.ShooterAngle.ShooterAngleExtend;
import frc2168_2013.commands.subSystems.ShooterAngle.ShooterAngleStow;
import frc2168_2013.commands.subSystems.ShooterWheel.DriveShooterWithConstant;
import frc2168_2013.commands.subSystems.ShooterWheel.PID_ShooterPause;

/**
 * Auto command. Sits still and shoots discs from close range at the three point goal.
 * 
 * @author James
 *
 */
public class FrontOfPyramid_3pt extends CommandGroup {
	
	public FrontOfPyramid_3pt() {
		this(CommandBaseRobot.getDiscDelay(1),
             CommandBaseRobot.getDiscDelay(2),
             CommandBaseRobot.getDiscDelay(3));
	}
	
	public FrontOfPyramid_3pt(double firstDiscTime, double secondDiscTime, double thirdDiscTime) {
		//set shooter angle to Extend position
		
		addParallel(new ShooterAngleExtend());
		
		//driver both shooterwheels at full speed
		addParallel(new DriveShooterWithConstant(1, 1));
		
		//Shoot three discs
		addSequential(new Sleep(), firstDiscTime);
		addSequential(new ShootSingleDisc());
		addSequential(new Sleep(), secondDiscTime);
		addSequential(new ShootSingleDisc());
		addSequential(new Sleep(), thirdDiscTime);
		addSequential(new ShootSingleDisc());
		
//		//using at speed
//		addSequential(new PID_ShooterAtSpeed());
//		addSequential(new ShootSingleDisc());
//		addSequential(new PID_ShooterAtSpeed());
//		addSequential(new ShootSingleDisc());
//		addSequential(new PID_ShooterAtSpeed());
//		addSequential(new ShootSingleDisc());
//		
		//Shoot a few more times in case the disc wasn't shot
		addSequential(new Sleep(), 1);
		addSequential(new ShootSingleDisc());
		//Stop the shooter
		//TODO: Should these be sequential? Shooter doesn't seem to stop so something isn't working right here
		addSequential(new Sleep(), 0.2);
		addSequential(new PID_ShooterPause());
	}
}
