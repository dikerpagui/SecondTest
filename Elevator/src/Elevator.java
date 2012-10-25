import java.util.ArrayList;

public class Elevator extends Part implements Publisher, Runnable{
	
		ElevatorPanel ep;
		int curPos;
		ArrayList<Floor> floors=new ArrayList<Floor>();
		ArrayList<Request> requests=new ArrayList<Request>();
		ElevatorState elavatorState;
		
		Elevator(int numFloors)
		{
			this.curPos=0;
			ep=new ElevatorPanel(this,numFloors);
			door=new ElevatorDoor(this);
			elavatorState=new Idle();
		}
		@Override
		public void attachFloors(ArrayList<Floor> floors)
		{
			this.floors=floors;
		}
		public ArrayList<Floor> getFloors()
		{
			return this.floors;
		}
		
		public ElevatorPanel getElevatorPanel()
		{
			return this.ep;
		}
		public void move()
		{	
			if(this.curPos > getRequest())
				moveDown();
			else
				moveUp();
			
		}
		protected void moveDown()
		{
			this.getElevatorPanel().getLED().changeDirection(Direction.DOWN);
		
			this.movingDown(); //Elevator is in moving Down State.
			for(int i=this.curPos; i >= getRequest(); i--)
			{
				this.curPos=i;
				System.out.println("Cur Pos: "+ this.curPos);
				
			}
		}
		protected void moveUp()
		{
			this.getElevatorPanel().getLED().changeDirection(Direction.UP);
			this.movingUp(); //Elevator is in moving Up State.
			
			for(int i=this.curPos; i <= getRequest(); i++)
			{
				this.curPos=i;
				System.out.println("Cur Pos: "+ this.curPos);
				
				////////////////////////////////////
				//Testing for multiple requests..
				/////////////////////////////////////
				if(this.curPos==1)
				{
					System.out.println("Request has come from floor no 3 while on floor no 1");
					this.curPos=i+1;
					this.getFloors().get(3).getFloorPanel().getUpButton().pressed();
					
				}
				if(this.getRequests().size()==0)break;
			}
		}
		public int getCurPos()
		{
			return this.curPos;
		}
		
		public void addRequest(int i, Direction direction)
		{
			//Sorting request..
			if(this.requests.size()!=0 && getRequest() > i)
			{
				this.requests.add(0, new Request(direction,i));
			}
			else
				this.requests.add(new Request(direction,i));
			
			this.handleRequest();
		}
		
		public void handleRequest()
		{
			while(this.getRequests().size()!=0)
			{
				this.move();
				if(!this.requests.isEmpty())
					setButtonStatusOff();
				
				System.out.println("Reached to Floor No: " + this.getCurPos());	
				this.removeRequest();
				
				this.getElevatorPanel().getLED().changeDirection(Direction.STATIONARY);
				
				this.idle(); //Elevator Idle State.
				
				processDoorFunctioning();			
			}
		}
		
		public void setButtonStatusOff()
		{

			if(getDirection()!=null)
			{
				if(getDirection()==Direction.UP)
					this.floors.get(getRequest()).getFloorPanel().getUpButton().changeStatus(false);
			
				if(getDirection()==Direction.DOWN)
					this.floors.get(getRequest()).getFloorPanel().getDownButton().changeStatus(false);
			}
			else
			{
				this.getElevatorPanel().getButtonsToFloors().get(getRequest()).changeStatus(false);
			}
		}
		private int getRequest() {
			return this.getRequests().get(0).getNo();
		}
		private Direction getDirection() {
			return this.getRequests().get(0).getDirection();
		}
		
		public void removeRequest()
		{
			if(requests.size()!=0)
				this.requests.remove(0);
		}
		
		public ArrayList<Request> getRequests()
		{
			return this.requests;
		}
		
		public void processDoorFunctioning()
		{
			//Opening and Closing Elevator and floor doors..
			this.getDoor().openDoor();
			
			this.getDoor().closeDoor();
		}
		
		public void changeState(ElevatorState eState) {
			this.elavatorState=eState;
		
		}
		
		public void movingUp()
		{
			this.elavatorState.movingUp(this);
		}
		public void movingDown()
		{
			this.elavatorState.movingDown(this);
		}
		public void idle()
		{
			this.elavatorState.idle(this);
		}
		
		@Override
		public void notifyFloors() {
			
			for(int i=0; i<this.floors.size();i++)
			{
				this.floors.get(i).updateElevatorPosition(this.getCurPos());
			}
		}
		@Override
		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}


