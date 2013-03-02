package frc2168_2013.commands;

import frc2168_2013.OI;
import frc2168_2013.RobotMap;


public class DriveArmHome extends CommandBase {
	
	public DriveArmHome(){
		requires(arm);
	}

	protected void end() {
		// TODO Auto-generated method stub
		arm.setArmPWM(0.0);
	}

	protected void execute() {
		if(arm.armPosController.getSensorPos() > 23 )
		arm.setArmPWM(RobotMap.armConstVoltageHome); //Oh so fast!
		else if (arm.armPosController.getSensorPos() > 10 )
			arm.setArmPWM(RobotMap.armConstVoltageHome); //Oh so fast!
	}

	protected void initialize() {
		// TODO Auto-generated method stub
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

	protected boolean isFinished() {
		return arm.armPosController.getSensorPos() <= 10;
	}

}