package generation;

public class OrderStub implements Order{
	//first we need to make field variables that will be returned by the methods on the Order interface
	Builder builder;
	MazeConfiguration mazeconfig;
	int percentdone;
	boolean perf;
	int skillLevel;
	
	OrderStub (int skillLevel, boolean perf, Builder builder) {
		this.skillLevel = skillLevel;
		this.perf = perf;
		this.builder = builder;
	}
	
	@Override
	public int getSkillLevel() {
		return skillLevel;
	}
	
	@Override
	public Builder getBuilder() {
		return builder;
	}
	
	@Override
	public boolean isPerfect() {
		return perf;
	}
	
	@Override
	public void deliver(MazeConfiguration mazeConfig) {
		this.mazeconfig = mazeConfig;
	}
	
	@Override
	public void updateProgress(int percentage) {
		this.percentdone = percentage;
	}
	
	public MazeConfiguration returnmazeConfig() {
		return mazeconfig;
	}
}
