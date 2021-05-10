import java.util.*;
public class shipbust{
	private gamehelper helper=new gamehelper();
	private ArrayList<ship> shiplist=new ArrayList<ship>();
	private int numofguesses=0;
	public void setupgame()
	{ship one=new ship();
	one.setname("INS Vikrant");
	ship two=new ship();
	two.setname("INS shiva");
	ship three=new ship();
	three.setname("INS paramvir");
	shiplist.add(one);
	shiplist.add(two);
	shiplist.add(three);
	System.out.println("Your goal is to sink the ships in the grid");
	System.out.println("INS Vikrant,INS shiva,INS paramvir");
	System.out.println("Try to sink them all");
	for(ship s : shiplist)
	{
		ArrayList<String> newlocation=helper.placeship(3);
		s.setlocationcells(newlocation);
	}
    }
    private void startplaying(){
    	while(!shiplist.isEmpty())
    		{String userguess=helper.getuserinput("Enter a guess");
            checkuserguess(userguess);}
            finishgame();
    }
    private void checkuserguess(String userguess)
    {
    	numofguesses++;
    	String result="miss";
    	for(int x=0;x<shiplist.size();x++)
    	{	
    	result=shiplist.get(x).checkyourself(userguess);
    	if(result.equals("hit")){
    		break;
    	  }
    	  if(result.equals("kill"))
          {  shiplist.remove(x);
        	 break;
          }   
       }
       System.out.println(result);
    }
    private void finishgame(){
    	System.out.println("All ships are busted , the coast is clear");
    	if(numofguesses<=18){
    		System.out.println("You only took "+numofguesses+" guesses");
    		System.out.println("Your a nice shot");
    	}
    	else{
    		System.out.println("Took you so long we thought you were fried with "+numofguesses+" shots" );
    	}
    }
    public static void main(String[] args) {
    shipbust game=new shipbust();
    game.setupgame();
    game.startplaying();	
    }
}