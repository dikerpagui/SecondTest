
//Author: Diker Pagui 1016
public class Client {

	public static void main(String[] args) {
		
		
		Building building=new Building("Hall de sa",10);
		
		/*Handling Multiple request...
		Elevator is at 0th floor
		Request from floor 4..(In main)
		While on 1st floor request comes from 3 floor.. (In elevator moving loop)(In the loop, condition is checked if floor is 1 the add request from floor 3)
		Request handler sorts the request and the elevator stops at 3rd floor and door is opened .and after that elevator moves to 4th floor.
		And at last from the elevator to go to 7th floor request comes (In main).
		*/
		Controller controller=new Controller();
		controller.handleFloorButtonRequest(building.getFloors().get(4).getFloorPanel().getUpButton());
		
		controller.handleElevatorButtonRequest(building.getElevator().getElevatorPanel().getButtonsToFloors().get(7));
		
	}

}
