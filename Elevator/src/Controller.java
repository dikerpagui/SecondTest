
public class Controller implements Observer {

	int elvCurPos=0;
	@Override
	public void updateElevatorPosition(int pos) {
		// TODO Auto-generated method stub
		this.elvCurPos=pos;
	}

	public void handleFloorButtonRequest(FPButton fpb)
	{
		fpb.pressed();
	}
	
	public void handleElevatorButtonRequest(EPButton epb)
	{
		epb.pressed();
	}
}
