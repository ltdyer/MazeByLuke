package generation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import generation.Order.Builder;

import org.junit.Before;
import org.junit.After;

public class MazeFactoryTest {

	//we are going to want to make a new MazeFactory object to test on
	private MazeFactory mazeFactory;
	
	//we also need a mock object for an Order object to operate the MazeFactory
	private OrderStub orderstub;
	
	//I want to do some tests involving distance, such as making sure the exit can be reached from anywhere in the maze
	//so I will need a MazeConfiguration type variable.
	//We also need the MazeConfiguartion to have all the relevant maze information regarding that instance
	private MazeConfiguration mazeConfig;
	
	
	//Also want a list of Mazeconfigs and Orders so I can test out different skill levels
	
	private MazeConfiguration mazeConfigList[];
	private OrderStub orderStubList[];
	//as per usual, we will need to set up whatever we are going to be building like we did with the Puzzle.
	//this time it is the maze
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("we made a maze facotry");
		//It said in the specification that we want to make our maze deterministic for debugging
		boolean bool = true;
		//now we want to make a new MazeFactory object with the deterministic quality
		mazeFactory = new MazeFactory(bool);
		mazeConfigList = new MazeConfiguration[9];
		orderStubList = new OrderStub[9];
		//we need an order object to start the maze
		for (int i = 0; i < 9; i++) {
			orderstub = new OrderStub(i, bool, Builder.DFS);
			mazeFactory.order(orderstub);
			mazeFactory.waitTillDelivered();
			mazeConfig = orderstub.returnmazeConfig();
			mazeConfigList[i] = mazeConfig;
		}
		
	}
	

	//JUnit calls tearDown() automatically every time a test is exited so don't need to include it
	@After
	public void tearDown() throws Exception {
		
	}
	
	//I would like to make sure everything was created properly
	@Test
	public void setUpTest() {
		assertNotNull(mazeFactory);
		assertNotNull(mazeConfigList);
		for (int i = 0; i < 9; i++) {
			assertNotNull(mazeConfigList[i]);
		}
		assertNotNull(orderstub);
		assertNotNull(orderStubList);
		
	}
	
	
	//the next thing we should test for is whether or not you can get to the exit from anywhere in the maze
	//as said in the specs
	@Test
	public void reachExitFromAnywhere() 
	{
		//I think I want to use getMazedists because it can give us a distance object that tells us
		//for every position how many steps we are away from the exit
		Distance dist = mazeConfig.getMazedists();
		
		//since using the getMazedists() method returns a distance type variable, we need to store the result in a distance
		//type variable. Distance variables have a matrix that you can loop through to get width and height
		//through the getDistance(width, height) method so we can use that to get the distance at every location
		for (int width = 0; width < mazeConfig.getWidth(); width++) 
		{
			for (int height = 0; height < mazeConfig.getHeight(); height++)
			{
				int num = dist.getDistanceValue(width, height);
				assertTrue("It is not true that every position has a path to the exit", num > 0);
			}
		}
	}
	
	//the next thing we should test for is that every maze has only one exit. We know that a maze has more than 
	//one exit if it has more than 1 cell right by an exit
	@Test
	public void noMultipleExits()
	{
		
		int exits = 0;
		//again we need the distance varibale from above as this should be a very similar test
		Distance dist = mazeConfig.getMazedists();
		
		//now I think we should be able to make sure there is only one exit if we make the exits number more than 1.
		//So if we find a distance as we are iterating through the width height matrix that is 1, we can add it
		//to the exits variable. But we should not find more than one of these and we can check that with
		//an assert statement at the end
		for (int width = 0; width < mazeConfig.getWidth(); width++) 
		{
			for (int height = 0; height < mazeConfig.getHeight(); height++)
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
	



	
	
	
	
}








