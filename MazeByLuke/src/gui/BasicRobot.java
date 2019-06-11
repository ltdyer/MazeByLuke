package gui;

import generation.CardinalDirection;
import generation.Cells;
import generation.MazeConfiguration;

public class BasicRobot implements Robot {

	private int odometer;
	public Controller controller;
	protected CardinalDirection facingThisDirection;

	/**
	 * Constructor to set up a Robot object
	 * Takes a controller as input, initializes odometer to 0, sets robot and driver, sets direction to east, and makes hasStopped 		 * false.
	 *
	 * @author Luke Dyer
	 * @params controller, creates controller variable to set robot
	 */
	public BasicRobot(Controller controller) {
		this.controller = controller;
		//will need to add something like controller.setRobotandDriver(this, driver)
		this.odometer = 0;
		this.hasStopped = false;
		this.facingThisDirection = CardinalDirection.east;	

	}

	@Override
	public void rotate(Turn turn) {
		//we want the robot to turn either left, right, or around.
		//if we call with turn.left
	}

	@Override
	public void move(int distance, boolean manual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getCurrentPosition() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaze(Controller controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAtExit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSeeExit(Direction direction) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
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
		return false;
	}

	@Override
	public CardinalDirection getCurrentDirection() {
		// TODO Auto-generated method stub
		return null;
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
		return 0;
	}

	@Override
	public void resetOdometer() {
		// TODO Auto-generated method stub
		
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
