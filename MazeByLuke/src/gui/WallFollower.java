package gui;

import generation.Distance;

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
			
			//need to write a helper method to determine if there are walls
			//there also exists a method hasWalls in MazeConfig jsyk
			//since WallFollower only knows Robot
			//boolean frontWall = brobot.hasWall()
		}
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
