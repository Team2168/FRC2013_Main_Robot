package frc2168_2013.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc2168_2013.commands.*;
import frc2168_2013.commands.Presets.Preset_FrontOfPyramid_3pt;
import frc2168_2013.commands.Presets.Preset_RearOfPyramid_3pt;
import frc2168_2013.commands.subSystems.Arm.DriveArmHome;
import frc2168_2013.commands.subSystems.DriveTrain.DriveDrivetrainStraight;
import frc2168_2013.commands.subSystems.Shooter.ShooterPIDPause;

/**
 * Auto command. Sits still and shoots discs from close range at the three point goal.
 * 
 * @author James
 *
 */
public class RearOfPyramid_3pt_Side extends CommandGroup {
	public RearOfPyramid_3pt_Side() {
		addParallel(new Preset_RearOfPyramid_3pt());
		addSequential(new Sleep(), 8 );
		//Shoot three discs
		addSequential(new ShootSingleFrisbee());
		addSequential(new Sleep(),1 );
		addSequential(new ShootSingleFrisbee());
		addSequential(new Sleep(),1 );
		addSequential(new ShootSingleFrisbee());
		//addSequential(new Sleep(),1 );
		//addSequential(new DriveDrivetrainStraight(-((8*12)-8)));
		
		//stop wheel
		addSequential(new ShooterPIDPause());
		//lower arm
		addSequential(new DriveArmHome());
		
		


		
		//Drive to the mid-field line
		//  drive backward

	}
}
