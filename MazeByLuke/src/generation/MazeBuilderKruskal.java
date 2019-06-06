package generation;

import java.util.ArrayList;

public class MazeBuilderKruskal extends MazeBuilder implements Runnable {
	
	
	
	
	public MazeBuilderKruskal() {
		super();
		System.out.println("MazeBuilderKruskal uses Kruskal's algorithm to generate maze.");
		
	}
	
	public MazeBuilderKruskal(boolean determinate) {
		super(determinate);
		System.out.println("MazeBuilderKruskal uses Kruskal's algorithm to generate maze.");
	}
	
	@Override
	protected void generatePathways() {
		//need to initially put a place down in the maze
		int x = random.nextIntWithinInterval(0, width-1);
		int y = random.nextIntWithinInterval(0, height-1);
		
		//could make a test for seeing, when an edge is chosen, does it contain a node already seen?
		// if so this a cycle and we should not delete this edge/tear down this wall
		
		//maybe we could use an array for each set within a larger array to contain them and check 
		
	}
	
	
	
	
	
	
	
	

}
