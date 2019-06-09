package generation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import generation.Order.Builder;


public class MazeBuilderKruskalTest extends MazeBuilderKruskal {

	private MazeFactory mazeFactoryTest;
	private OrderStub orderStub;
	private MazeConfiguration mazeConfigTest;
	
	
	
	
	@Before
	public void setUp() throws Exception
	{
		//make a new random kruskal maze
		boolean bool = true;
		mazeFactoryTest = new MazeFactory(bool);
		orderStub = new OrderStub(1, bool, Builder.Kruskal);
		mazeFactoryTest.order(orderStub);
		mazeFactoryTest.waitTillDelivered();
		mazeConfigTest = orderStub.returnmazeConfig();
//		width = 8;
//		height = 8;
//		cells = new Cells(width, height);
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	//This test serves a similar purpose as the setUpTest from MazeFactoryTest
	@Test
	public void setUpTest() {
		assertNotNull(mazeFactoryTest);
		assertNotNull(orderStub);
	}
	
	//I want to make sure the mazeBoard in Kruskal's algorithm actually gets values. We know it has a value
	//if the grid spot contains a value greater than 0
	@Test
	public void initializeMazeBoardValues() {
		
		for (int i = 0; i < mazeConfigTest.getWidth(); i++) {
			for (int j = 0; j < mazeConfigTest.getHeight(); j++) {
				assertTrue(MazeBuilderKruskal.mazeBoard[i][j]>0);
			}
			
		}
	}
	
	@Test
	public void allValuesAreTheSame() {
		
		System.out.println("Is Candidates empty?" + MazeBuilderKruskal.candidates.isEmpty());
		for (int i = 1; i < mazeConfigTest.getWidth(); i++) {
			for (int j = 1; j < mazeConfigTest.getHeight(); j++) {
				assertEquals(MazeBuilderKruskal.mazeBoard[i][j], MazeBuilderKruskal.mazeBoard[i-1][j-1]);
				
			}
		}
		
			
	}
	
	@Test
	public void doesMazeConfigEqualMazeBoard() {
		int configCount = 0;
		int boardCount = 0;
		for (int i = 0; i < mazeConfigTest.getWidth(); i++) {
			for (int j = 0; j < mazeConfigTest.getHeight(); j++) {
				configCount++;
			}
		}
		for (int i = 0; i < MazeBuilderKruskal.mazeBoard.length; i++) {
			for (int j = 0; j < MazeBuilderKruskal.mazeBoard.length; j++) {
				boardCount++;
			}
		}

		assertEquals(boardCount, configCount);
	}
	
	
	@Test
	public void noMultipleExits()
	{
		
		int exits = 0;
		//again we need the distance varibale from above as this should be a very similar test
		Distance dist = mazeConfigTest.getMazedists();
		
		//now I think we should be able to make sure there is only one exit if we make the exits number more than 1.
		//So if we find a distance as we are iterating through the width height matrix that is 1, we can add it
		//to the exits variable. But we should not find more than one of these and we can check that with
		//an assert statement at the end
		for (int width = 0; width < mazeConfigTest.getWidth(); width++) 
		{
			for (int height = 0; height < mazeConfigTest.getHeight(); height++)
			{
				if (dist.getDistanceValue(width, height)== 1) 
				{
					exits = exits + 1;
				}
			}
		}
		
		//now we should only have 1 exit, but if there is more than one then we should raise the error
		assertTrue(exits == 1);
		
	}
	
	@Test
	public void reachExitFromAnywhere() 
	{
		//I think I want to use getMazedists because it can give us a distance object that tells us
		//for every position how many steps we are away from the exit
		Distance dist = mazeConfigTest.getMazedists();
		
		//since using the getMazedists() method returns a distance type variable, we need to store the result in a distance
		//type variable. Distance variables have a matrix that you can loop through to get width and height
		//through the getDistance(width, height) method so we can use that to get the distance at every location
		for (int width = 0; width < mazeConfigTest.getWidth(); width++) 
		{
			for (int height = 0; height < mazeConfigTest.getHeight(); height++)
			{
				int num = dist.getDistanceValue(width, height);
				assertTrue(num > 0);
			}
		}
	}
	


	
	
	

}
