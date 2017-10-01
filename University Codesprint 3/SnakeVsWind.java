import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class SnakeVsWind {

	public static int x=0;
	public static int y=0;
	public static int i=1;
	
	public static boolean withinBounds(int[][] arr,int x,int y){
		if(x<0 || x>=arr.length){
			return false;
		}
		else if( y<0 || y>=arr.length)
			return false;
		else if(arr[x][y]!=0)
			return false;
		return true;
	}
	
	public static void working(int[][] arr,char dir){
		if(dir=='n'){
			if(withinBounds(arr,x-1,y)){
				arr[x-1][y] = i;
				i++;
				x=x-1;
			}
			else{
				if(withinBounds(arr,x,y-1)){
					arr[x][y-1] = i;
					i++;
					y=y-1;
				}
				else if(withinBounds(arr,x,y+1)){
					arr[x][y+1] = i;
					i++;
					y=y+1;
				}
				else{
					if(withinBounds(arr,x+1,y)){
						arr[x+1][y] = i;
						i++;
						x=x+1;
					}
				}
			}
		}
		else if(dir=='s'){
			if(withinBounds(arr,x+1,y)){
				arr[x+1][y] = i;
				i++;
				x=x+1;
			}
			else{
				if(withinBounds(arr,x,y+1)){
					arr[x][y+1] = i;
					i++;
					y=y+1;
				}
				else if(withinBounds(arr,x,y-1)){
					arr[x][y-1] = i;
					i++;
					y=y-1;
				}
				else{
					if(withinBounds(arr,x-1,y)){
						arr[x-1][y]=i;
						i++;
						x=x-1;
					}
				}
			}
		}
		else if(dir=='e'){
			if(withinBounds(arr,x,y+1)){
				arr[x][y+1] = i;
				i++;
				y=y+1;
			}
			else{ 
				if(withinBounds(arr,x-1,y)){
					arr[x-1][y] = i;
					i++;
					x=x-1;
				}
				else if(withinBounds(arr,x+1,y)){
					arr[x+1][y] = i;
					i++;
					x=x+1;
				}
				else{
					if(withinBounds(arr,x,y-1)){
						arr[x][y-1] = i;
						i++;
						y=y-1;
					}
				}
			}
			
		}
		else if(dir=='w'){
			if(withinBounds(arr,x,y-1)){
				arr[x][y-1] = i;
				i++;
				y=y-1;
			}
			else{
				if(withinBounds(arr,x-1,y)){
					arr[x-1][y] = i;
					i++;
					x=x-1;
				}
				else if(withinBounds(arr,x+1,y)){
					arr[x+1][y] = i;
					i++;
					x=x+1;
				}
				else{
					if(withinBounds(arr,x,y+1)){
						arr[x][y+1] = i;
						i++;
						y = y+1;
					}
				}
			}
		}

	}
	
	public static boolean allDone(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]==0)
					return false;
			}
		}
		return true;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char dir = in.next().charAt(0);
        x = in.nextInt();
        y = in.nextInt();
        
        int[][] arr = new int[n][n];
        
        arr[x][y] = i;
        i++;

        
        while(!allDone(arr)){
        	working(arr,dir);
        	//System.out.println("Main Working : "+x+" "+y+" "+i);
        }
        
        for(int q=0;q<arr.length;q++){
        	for(int j=0;j<arr[q].length;j++){
        		System.out.print(arr[q][j]+" ");
        	}
        	System.out.println();
        }
        
        in.close();
    }
}
