import java.util.*;
public class ship{
	private ArrayList<String> locationcells;
	private String name;
	public void setlocationcells(ArrayList<String> loc){
	locationcells=loc;
	}
	public void setname(String n){
	name=n;
	}
	public String checkyourself(String userinput){
	String result="miss";
	int index=locationcells.indexOf(userinput);
	if(index>=0)
	{
	locationcells.remove(index);
	if(locationcells.isEmpty())
	{result="kill";
	System.out.println("yipee, you sunk "+ name);
    }
    else{result="hit";}
    }
	return result;
	}
}