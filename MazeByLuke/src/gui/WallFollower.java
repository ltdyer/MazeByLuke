package gui;

import generation.Distance;
import gui.Robot.Turn;

public class WallFollower implements RobotDriver{
	
	private Robot brobot;
	private int width;
	private int height;
	private Distance distance;
	//hopefully this works
	
	public WallFollower() {
		//nothing?
	}
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
			
			boolean rightWall = brobot.hasWallInThisDirection(brobot.getCurrentDirection().rotateClockwise());
			boolean frontWall = brobot.hasWallInThisDirection(brobot.getCurrentDirection());
			boolean leftWall = brobot.hasWallInThisDirection(brobot.getCurrentDirection().rotateClockwise().rotateClockwise().rotateClockwise());
			
			//there is no wall in front and no wall to the left
			if (frontWall == false && leftWall == false) {
					
				System.out.println("No wall in front and no wall to the left, turn left");
				brobot.rotate(Turn.LEFT);
			}
			
			//there is a wall in front and a wall to the left
			else if (frontWall == true && leftWall == true) {
				
					System.out.println("Wall in front and wall to the left, turn right");
					brobot.rotate(Turn.RIGHT);
			}
			
			//there is a wall in front and no wall to the left
			else if (frontWall == true && leftWall == false) {
				
					System.out.println("Wall in front and no wall to the left, turn left");
					brobot.rotate(Turn.LEFT);
			}
			
			//there is a wall in front and a wall to the left and a wall to the right

			
			if (!brobot.hasWallInThisDirection(brobot.getCurrentDirection())) {
				
				System.out.println("No wall in this direction, move");
				System.out.println(brobot.getCurrentDirection());
				brobot.move(1, false);
				System.out.println("brobot has moved");
			}
			
			if (brobot.hasStopped()) {
				System.out.println("Brobot stopped for some reason");
				return false;
			}
			System.out.println("Is Brobot at the exit?: " + brobot.isAtExit());
		}
		System.out.println("Brobot's direction at termination is: " + brobot.getCurrentDirection());
		System.out.println("while loop has terminated");
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
