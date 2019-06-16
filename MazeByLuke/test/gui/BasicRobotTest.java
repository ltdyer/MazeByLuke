package gui;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import generation.Order.Builder;
import generation.OrderStub;
import generation.CardinalDirection;
import generation.MazeConfiguration;
import generation.MazeFactory;



import org.junit.Before;
import org.junit.Test;

public class BasicRobotTest extends BasicRobot {

	public BasicRobotTest() {
		super(new Controller());
	}

	private MazeApplication maze;
	private MazeFactory mazefactory;
	private OrderStub orderStub;
	private MazeConfiguration mazeConfig;
	
	@Before
	public void setup() {
		Robot brobot = new BasicRobot(controller);
		mazefactory = new MazeFactory(true);
		orderStub = new OrderStub(1, true, Builder.DFS);
		mazefactory.order(orderStub);
		mazefactory.waitTillDelivered();
		mazeConfig = orderStub.returnmazeConfig();
		
	}
	
	@Test
	public void rotateLeftFacingNorth() {
		this.facingThisDirection = CardinalDirection.North;
		this.rotate(Turn.LEFT);
		assertEquals(this.facingThisDirection, CardinalDirection.West);
	}
	
	@Test
	public void rotateClockwiseDoesNotAffectCardinalDirection() {
		this.facingThisDirection = CardinalDirection.North;
		this.facingThisDirection.rotateClockwise();
		assertEquals(this.facingThisDirection, CardinalDirection.North);
	}
	
	@Test
	public void rotateLeftFacingWest() {
		this.facingThisDirection = CardinalDirection.West;
		this.rotate(Turn.LEFT);
		assertEquals(this.facingThisDirection, CardinalDirection.South);
	}
	
	@Test
	public void rotateLeftFacingSouth() {
		this.facingThisDirection = CardinalDirection.South;
		this.rotate(Turn.LEFT);
		assertEquals(this.facingThisDirection, CardinalDirection.East);
	}
	
	@Test
	public void rotateLeftFacingEast() {
		this.facingThisDirection = CardinalDirection.East;
		this.rotate(Turn.LEFT);
		assertEquals(this.facingThisDirection, CardinalDirection.North);
	}
	
	@Test
	public void rotateRightFacingNorth() {
		this.facingThisDirection = CardinalDirection.North;
		this.rotate(Turn.LEFT);
		assertEquals(this.facingThisDirection, CardinalDirection.West);
	}
	
	@Test
	public void rotateRightFacingWest() {
		this.facingThisDirection = CardinalDirection.West;
		this.rotate(Turn.LEFT);
		assertEquals(this.facingThisDirection, CardinalDirection.South);
	}
	
	@Test
	public void rotateRightFacingSouth() {
		this.facingThisDirection = CardinalDirection.South;
		this.rotate(Turn.LEFT);
		assertEquals(this.facingThisDirection, CardinalDirection.East);
	}
	
	@Test
	public void rotateRightFacingEast() {
		this.facingThisDirection = CardinalDirection.East;
		this.rotate(Turn.LEFT);
		assertEquals(this.facingThisDirection, CardinalDirection.North);
	}
	
	@Test
	public void getCurrentDirectionReturnsCorrectDirection() {
		this.facingThisDirection = CardinalDirection.North;
		assertEquals(this.facingThisDirection, getCurrentDirection());
	}
	
	@Test
	public void directionTranslatorWhenDirectionIsForward() {
		Direction direction = Direction.FORWARD;
		this.facingThisDirection = CardinalDirection.North;
		assertEquals(this.facingThisDirection, directionTranslator(direction));
	}
	
	@Test
	public void directionTranslatorWhenDirectionIsRight() {
		Direction direction = Direction.RIGHT;
		this.facingThisDirection = CardinalDirection.North;
		assertEquals(CardinalDirection.East, directionTranslator(direction));
	}
	
	@Test
	public void directionTranslatorWhenDirectionisLeft() {
		Direction direction = Direction.LEFT;
		this.facingThisDirection = CardinalDirection.North;
		assertEquals(CardinalDirection.West, directionTranslator(direction));
	}
	
	@Test
	public void directionTranslatorWhenDirectionisBackwards() {
		Direction direction = Direction.BACKWARD;
		this.facingThisDirection = CardinalDirection.North;
		assertEquals(CardinalDirection.South, directionTranslator(direction));
	}
	
	
	
	
	
	
	
	
	
	
	
}
