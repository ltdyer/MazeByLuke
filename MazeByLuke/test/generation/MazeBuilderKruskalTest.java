package generation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


class MazeBuilderKruskalTest {

	//since we are testing for kruskal's algorithm, should probably make a kruskal variable
	MazeBuilderKruskal kruskalTest;
	
	//want to have a nested array so I can do some tests on my value placement
	int testBoard[][];
	
	@Before
	public void setUp() throws Exception
	{
		kruskalTest = new MazeBuilderKruskal();
		//will definitely need some other stuff here too
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void initializeMazeBoardValues() {
		
	}
	
	
	
	

}
