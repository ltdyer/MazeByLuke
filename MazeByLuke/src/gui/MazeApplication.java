/**
 * 
 */
package gui;

import generation.Order;

import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;


/**
 * This class is a wrapper class to startup the Maze game as a Java application
 * 
 * This code is refactored code from Maze.java by Paul Falstad, www.falstad.com, Copyright (C) 1998, all rights reserved
 * Paul Falstad granted permission to modify and use code for teaching purposes.
 * Refactored by Peter Kemper
 * 
 * TODO: use logger for output instead of Sys.out
 */
public class MazeApplication extends JFrame {

	// not used, just to make the compiler, static code checker happy
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Constructor
	 */
	public MazeApplication() {
		init(null);
	}

	/**
	 * Constructor that loads a maze from a given file or uses a particular method to generate a maze
	 * @param parameter can identify a generation method (Prim, Kruskal, Eller)
     * or a filename that stores an already generated maze that is then loaded, or can be null
	 */
	public MazeApplication(String[] parameter) {
		init(parameter);
	}

	/**
	 * Instantiates a controller with settings according to the given parameter.
	 * @param parameter can identify a generation method (Prim, Kruskal, Eller)
	 * or a filename that contains a generated maze that is then loaded,
	 * or can be null
	 * @return the newly instantiated and configured controller
	 */
	 Controller createController(String[] parameter) {
	    // need to instantiate a controller to return as a result in any case
	    Controller result = new Controller() ;
	    String msg = null; // message for feedback
	    
	    int i = 0;

	    String parse = null;
	    
	    //System.out.println(i < parameter.length);
	    //System.out.println(parameter[i].startsWith("-"));
	    if (parameter != null) {
		    while (i < parameter.length && parameter[i].startsWith("-")) {

		    	parse = parameter[i++];
		    	System.out.println(parse);
		    	
	
		    	
		    	if (parse.equals("-g")) {
		    		System.out.println("parse is -g");
		    		parse = parameter[i++];
		    		
		    		System.out.println("parse is now: " + parse);
		    		
		    		if (parse.equals("Kruskal")) {
		    			msg = "MazeApplication: generating random maze with Kruskal's Algorithm.";
		    	        result.setBuilder(Order.Builder.Kruskal);
		    		}
		    		
		    		else if (parse.equals("Prim")) {
		    			msg = "MazeApplication: generating random maze with Prim's algorithm.";
		    	        result.setBuilder(Order.Builder.Prim);
		    		}
		    		
//		    		if (parameter.length > 2) {
//		    			parse = parameter[i++];
//			    		
//			    		System.out.println("parse is now: " + parse);
//		    		}

		    	}
		    	
		    	if (parse.equals("-d")) {
		    		System.out.println("parse is -d");
		    		parse = parameter[i++];
		    		
		    		System.out.println("parse is now: " + parse);
		    		
		    		if (parse.equals("Wallfollower")) {
		    			msg = "MazeApplication: Maze will be solved by a wall following robot";
		    			//returns a controller variable
		    			//figure out how to do this tomorrow 
		    			RobotDriver robotdriver = new WallFollower();
		    			Robot robot = new BasicRobot(result);
		    			robotdriver.setRobot(robot);
		    			result.setRobotAndDriver(robot, robotdriver);


		    			//the issue with this whole thing is that robotdriver is still null
		    			//maybe the issue also is that there isnt a maze built when we call these guys?
		    			
		    		}
		    		
		    		else if (parse.equals("Wizard")) {
		    			msg = "I didn't do the extra credit but I still had enough time to write this message";
		    			
		    		}
		    	}
		    	
		    	
		    	if (parse.equals("-f")) {
		    		System.out.println("parse is -f");
		    		parse = parameter[i++];
		    		
		    		System.out.println("parse is now: " + parse);
		    		File f = new File(parse) ;
			        if (f.exists() && f.canRead())
			        {
			            msg = "MazeApplication: loading maze from file: " + parse;
			            result.setFileName(parse);
			            return result;
			        }
			        else {
			            // None of the predefined strings and not a filename either: 
			            msg = "MazeApplication: unknown parameter value: " + parse + " ignored, operating in default mode.";
			        }
		    	}
		    }
	    }
	    
	    
	    else if (parameter == null || parse == "Wallfollower" || parse == "Wizard") {
	    	msg = "MazeApplication: maze will be generated with a randomized algorithm.";
	    }
	    
	    
	    System.out.println(msg);
	    return result;
	    
//	    // Case 1: no input
//	    if (parameter == null) {
//	        msg = "MazeApplication: maze will be generated with a randomized algorithm."; 
//	    }
//	    // Case 2: Prim
//	    else if ("Prim".equalsIgnoreCase(parameter))
//	    {
//	        msg = "MazeApplication: generating random maze with Prim's algorithm.";
//	        result.setBuilder(Order.Builder.Prim);
//	    }
//	    // Case 3 a and b: Eller, Kruskal or some other generation algorithm
//	    else if ("Kruskal".equalsIgnoreCase(parameter))
//	    {
//	    	// TODO: for P2 assignment, please add code to set the builder accordingly
//	        msg = "MazeApplication: generating random maze with Kruskal's Algorithm.";
//	        result.setBuilder(Order.Builder.Kruskal);
//	    }
//	    else if ("Eller".equalsIgnoreCase(parameter))
//	    {
//	    	// TODO: for P2 assignment, please add code to set the builder accordingly
//	        throw new RuntimeException("Don't know anybody named Eller ...");
//	    }
//	    // Case 4: a file
//	    else {
//	        File f = new File(parameter) ;
//	        if (f.exists() && f.canRead())
//	        {
//	            msg = "MazeApplication: loading maze from file: " + parameter;
//	            result.setFileName(parameter);
//	            return result;
//	        }
//	        else {
//	            // None of the predefined strings and not a filename either: 
//	            msg = "MazeApplication: unknown parameter value: " + parameter + " ignored, operating in default mode.";
//	        }
//	    }
	    // controller instanted and attributes set according to given input parameter
	    // output message and return controller

	}

	/**
	 * Initializes some internals and puts the game on display.
	 * @param parameter can identify a generation method (Prim, Kruskal, Eller)
     * or a filename that contains a generated maze that is then loaded, or can be null
	 */
	private void init(String[] parameter) {
	    // instantiate a game controller and add it to the JFrame
	    Controller controller = createController(parameter);
		add(controller.getPanel()) ;
		// instantiate a key listener that feeds keyboard input into the controller
		// and add it to the JFrame
		KeyListener kl = new SimpleKeyListener(this, controller) ;
		addKeyListener(kl) ;
		// set the frame to a fixed size for its width and height and put it on display
		setSize(400, 400) ;
		setVisible(true) ;
		// focus should be on the JFrame of the MazeApplication and not on the maze panel
		// such that the SimpleKeyListener kl is used
		setFocusable(true) ;
		// start the game, hand over control to the game controller
		controller.start();
	}
	
	/**
	 * Main method to launch Maze game as a java application.
	 * The application can be operated in three ways. 
	 * 1) The intended normal operation is to provide no parameters
	 * and the maze will be generated by a randomized DFS algorithm (default). 
	 * 2) If a filename is given that contains a maze stored in xml format. 
	 * The maze will be loaded from that file. 
	 * This option is useful during development to test with a particular maze.
	 * 3) A predefined constant string is given to select a maze
	 * generation algorithm, currently supported is "Prim".
	 * @param args is optional, first string can be a fixed constant like Prim or
	 * the name of a file that stores a maze in XML format
	 */
	public static void main(String[] args) {
	    JFrame app;

	    if(args.length == 0) {
	    	app = new MazeApplication();
	    }
	    
	    else if(args.length > 0) {
	    	app = new MazeApplication(args);
	    }
	    else {
	    	app = new MazeApplication();
	    }
//		switch (args.length) {
//		case 1 : app = new MazeApplication(args);
//		break ;
//		case 0 : 
//		default : app = new MazeApplication() ;
//		break ;
//		}
		app.repaint() ;
	}

}
