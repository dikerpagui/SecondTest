
public class FPButton extends Button {
	
	Direction dir;
	FloorPanel floorPanel;
	
	public FPButton(Direction dir, FloorPanel floorPanel)
	{
		this.dir=dir;
		this.floorPanel=floorPanel;

	}
	public void pressed()
	{
		changeStatus(true);
		System.out.println("Request Floor No : " + this.getFloorPanel().getFloor().getID());
		this.getFloorPanel().getElevator().addRequest(this.getFloorPanel().getFloor().getID(),this.dir);
	}
	public FloorPanel getFloorPanel()
	{
		return this.floorPanel;
	}
	
}
