package gui;

import generation.Distance;
import gui.Robot.Turn;

public class WallFollower implements RobotDriver{
	
	private Robot brobot;
	private int width;
	private int height;
	private Distance distance;
	//hopefully this works
	

	@Override
	public void setRobot(Robot r) {
		this.brobot = r;
		
	}

	@Override
	public void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
		
	}

	@Override
	public void setDistance(Distance distance) {
		this.distance = distance;
		
	}

	@Override
	public boolean drive2Exit() throws Exception {
		while (brobot.isAtExit() == false) {
			
			//there is no wall in front and no wall to the left
			if (!brobot.hasWallInThisDirection(brobot.getCurrentDirection()) && 
				!brobot.hasWallInThisDirection(brobot.getCurrentDirection().rotateClockwise().rotateClockwise().rotateClockwise())) {
				
				brobot.rotate(Turn.LEFT);
			}
			
			//there is a wall in front and a wall to the left
			else if (brobot.hasWallInThisDirection(brobot.getCurrentDirection()) && 
				brobot.hasWallInThisDirection(brobot.getCurrentDirection().rotateClockwise().rotateClockwise().rotateClockwise())) {
					
				brobot.rotate(Turn.RIGHT);
			}
			
			//there is a wall in front and no wall to the left
			else if (brobot.hasWallInThisDirection(brobot.getCurrentDirection()) && 
				!brobot.hasWallInThisDirection(brobot.getCurrentDirection().rotateClockwise().rotateClockwise().rotateClockwise())) {
					
				brobot.rotate(Turn.LEFT);
			}
			
			if (!brobot.hasWallInThisDirection(brobot.getCurrentDirection())) {
				brobot.move(1, false);
			}
			
			if (brobot.hasStopped()) {
				return false;
			}
		}
		return brobot.stepTowardsExit();
	}

	@Override
	public float getEnergyConsumption() {
		//default
		return 0;
	}

	@Override
	public int getPathLength() {
		// TODO Auto-generated method stub
		return brobot.getOdometerReading();
	}

}
