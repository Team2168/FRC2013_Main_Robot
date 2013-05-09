package frc2168_2013.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc2168_2013.RobotMap;
import frc2168_2013.commands.subSystems.Intake.DriveIntakeConstant;

public class Intake extends Subsystem {		
	
	DoubleSolenoid actuatorHopper;
	DoubleSolenoid actuatorFloorload;
	Talon intakeMotorR;
	Talon intakeMotorL;
	DigitalInput intakeLimitSensorR;
	DigitalInput intakeLimitSensorL;
	
	double left = 0.0;
	double right = 0.0;
	
	public Intake() {
		//TODO: If an intake is added, flesh this stuff out.
		actuatorHopper = new DoubleSolenoid(2, RobotMap.intakeHopperExtend,
               RobotMap.intakeHopperRetract);
		actuatorFloorload = new DoubleSolenoid(2, RobotMap.intakeFloorloadExtend,
	               RobotMap.intakeFloorloadRetract);
		intakeMotorR = new Talon(RobotMap.intakeMotorR);
		intakeMotorL = new Talon(RobotMap.intakeMotorL);
		intakeLimitSensorR = new DigitalInput(RobotMap.intakeLimitSensorR);
		intakeLimitSensorL = new DigitalInput(RobotMap.intakeLimitSensorL);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveIntakeConstant(0.0, 0.0));
		//TODO: Should probably also stow the intake.
    }
	
	public boolean intakeRFull(){
		return !intakeLimitSensorR.get();
	}
	
	public boolean intakeLFull(){
		return !intakeLimitSensorL.get();
	}
    
	public void driveIntake(double left, double right){
		System.out.println(intakeLimitSensorR);
		driveIntakeRight(right);
		driveIntakeLeft(left);
	}
	
	/**
	 * drive the right side of the intake.
	 * @param right speed of the right side rollers on intake.
	 */
	public void driveIntakeLeft(double left) {
		
		if(intakeLFull()){
			intakeMotorL.set(0.0);
		} else {		
    	left = -left; //invert the right side because of the mount.
    	this.left = left; 	
    	intakeMotorL.set(left);
		}
    }
	
	/**
	 * drive the left side of the intake.
	 * @param left speed of the left side rollers on intake.
	 */
	public void driveIntakeRight(double right) {
		
		if(intakeRFull()){
			intakeMotorR.set(0.0);
		} else {
    	intakeMotorR.set(right);
		}
    }
	
    /**
     * Lower the intake mechanism to floorload position.
     */
	public void Load(){
		//TODO: Verify that kForward disengages the hanger
		actuatorHopper.set(DoubleSolenoid.Value.kForward);
		actuatorFloorload.set(DoubleSolenoid.Value.kForward);
	}
    
    /**
     * Raise the intake mechanism to hopper position.
     */
	public void Hopper() {
		//TODO: Verify that kForward engages the hanger
		actuatorFloorload.set(DoubleSolenoid.Value.kReverse);
		actuatorHopper.set(DoubleSolenoid.Value.kForward);
	}
	
	/**
	 * Raise the intake mechanism to stow position.
	 */
	public void Stow(){
		actuatorHopper.set(DoubleSolenoid.Value.kReverse);
		actuatorFloorload.set(DoubleSolenoid.Value.kReverse);
	}
}
