import java.io.*;
import java.util.*;
public class gamehelper{
	private static final String alphabet="abcdefg";
	private int gridlength=7;
	private int gridsize=49;
	private int[]  grid=new int[gridsize];
	private int shipcount=0;
	public String getuserinput(String prompt){
	String inputLine=null;
	System.out.print(prompt+" ");
	try{
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	inputLine=input.readLine();
	if(inputLine.length()==0) return null;
	} catch (IOException e){
	System.out.println("IOException: "+ e);
	}
	return inputLine.toLowerCase();
	}
	public ArrayList<String> placeship(int shipsize){
	ArrayList<String> alphacells=new ArrayList<String>();
	String temp=null;
	int[] coords=new int[shipsize];
	int attempts=0;
	boolean success=false;
	int location=0;
	shipcount++;
	int incr=1;
	if((shipcount%2)==1){incr=gridlength;}
	while(!success & attempts++<200){
	location=(int)(Math.random()*gridsize);
	int x=0;
	success=true;
	while(success && x<shipsize){
	if(grid[location]==0){
	coords[x++]=location;
	location+=incr;
	if(location>=gridsize){success=false;}
	if(x>0 && (location%gridlength==0)){
	success=false;
	}
	}else{
	success=false;
	}
	}
	}
	int x=0;
	int row=0;
	int column=0;
	while(x<shipsize){
	grid[coords[x]]=1;
	row=(int)(coords[x]/gridlength);
	column=coords[x]%gridlength;
	temp=String.valueOf(alphabet.charAt(column));
	alphacells.add(temp.concat(Integer.toString(row)));
	x++;
	}
	return alphacells;
	}
}