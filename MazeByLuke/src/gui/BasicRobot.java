package gui;

import generation.CardinalDirection;
import generation.Cells;
import generation.MazeConfiguration;
import gui.Constants.UserInput;

public class BasicRobot implements Robot {

	private int odometer;
	public Controller controller;
	protected CardinalDirection facingThisDirection;
	private boolean stopped;
	

	/**
	 * Constructor to set up a Robot object
	 * Takes a controller as input, initializes odometer to 0, sets robot and driver, sets direction to east, and makes hasStopped 		 * false.
	 *
	 * @author Luke Dyer
	 * @params controller, creates controller variable to set robot
	 */
	public BasicRobot(Controller controller) {
		this.controller = controller;
		this.odometer = 0;
		this.stopped = false;
		this.facingThisDirection = CardinalDirection.East;	
		
		this.setMaze(controller);

	}

	@Override
	public void rotate(Turn turn) {
		if (stopped == true) {
			return;
		}
		if (turn == Turn.RIGHT) {
			controller.keyDown(UserInput.Right, 0);
			this.facingThisDirection = facingThisDirection.rotateClockwise();
		}
		else if (turn == Turn.LEFT) {
			controller.keyDown(UserInput.Left, 0);
			this.facingThisDirection = facingThisDirection.rotateClockwise();
		}
		else if (turn == Turn.AROUND) {
			controller.keyDown(UserInput.Right, 0);
			controller.keyDown(UserInput.Right, 0);
		}
	}

	@Override
	public void move(int distance, boolean manual) {
		
//		MazeConfiguration mazeConfig = this.controller.getMazeConfiguration();
//		
//		if (stopped == true) {
//			return;
//		}
//		
//		for (int d = 0; d < distance; d++) {
//			int currentPosition[] = this.getCurrentPosition();
//			
//			int xPosition = currentPosition[0];
//			int yPosition = currentPosition[1];
//
//			
//			if (mazeConfig.hasWall(xPosition, yPosition, facingThisDirection) == false) {
//				controller.keyDown(UserInput.Up, 0);
//			}
////			
//			//work on this at home, at work fill in the more trivial methods
//			
//		}
//		
	}

	@Override
	public int[] getCurrentPosition() throws Exception {
		// TODO Auto-generated method stub
		MazeConfiguration mazeConfig = this.controller.getMazeConfiguration();
		int currentPosition[] = this.getCurrentPosition();
		int xPosition = currentPosition[0];
		int yPosition = currentPosition[1];
		if (mazeConfig.isValidPosition(xPosition, yPosition) == false) {
			throw new Exception();
		}
		else {
			return currentPosition;
		}
		
	}

	@Override
	public void setMaze(Controller controller) {
		this.controller = controller;
	}

	@Override
	public boolean isAtExit() {
		return false;
		
	}

	@Override
	public boolean canSeeExit(Direction direction) throws UnsupportedOperationException {

		//if the direction is north and distance is like a million or something then this is true
		return false;
	}

	@Override
	public boolean isInsideRoom() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRoomSensor() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public CardinalDirection getCurrentDirection() {
		return this.facingThisDirection;
	}

	@Override
	public float getBatteryLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBatteryLevel(float level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getOdometerReading() {
		// TODO Auto-generated method stub
		return this.odometer;
	}

	@Override
	public void resetOdometer() {
		// TODO Auto-generated method stub
		this.odometer = 0;
	}

	@Override
	public float getEnergyForFullRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getEnergyForStepForward() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStopped() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int distanceToObstacle(Direction direction) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasDistanceSensor(Direction direction) {
		// TODO Auto-generated method stub
		return false;
	}

}
