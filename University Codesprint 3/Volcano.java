import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Volcano {

    public static void makeChange(int[][] arr,int x1,int x2,int y1,int y2,int w){
       
    	if(w==0){}
    	else{
    		for(int i=x1;i<=x2;i++){
    			for(int j=y1;j<=y2;j++){
    				if(i>=0 && i<=(arr.length-1) && j>=0 && j<=(arr.length-1)){
    					if(w>arr[i][j]){
    						arr[i][j] = w;
    					}
    				}
    			}
    		}
    		makeChange(arr,x1-1,x2+1,y1-1,y2+1,w-1);
    	}
    	
    	/*//System.out.println("Power : "+w);
        if(w==0){}
        else{
            for(int dx=-1;dx<=1;++dx){
                for(int dy=-1;dy<=1;++dy){
                    if(x1+dx>=0 && x1+dx<=(arr.length-1) && y1+dy>=0 && y1+dy<=(arr.length-1)){
                        if(w>arr[x1+dx][y1+dy]){
                            System.out.println((x1+dx)+" "+(y1+dy)+" "+w);
                            arr[x1+dx][y1+dy] = w;
                        }     
                        makeChange(arr,(x1+dx),(y1+dy),(w-1));
                    }
                }
            }
        }*/
    }
    
    public static void writeToFile(int[][] arr){
        try{
            FileWriter fw = new FileWriter("out.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    bw.write(arr[i][j]+" ");
                }
                bw.write("\n");
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void reInitialize(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = 0;
            }
        }       
    }
    
    public static void display(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }           	
    }
    
    public static int[][] readFromFile(int len){
        int[][] readArr = new int[len][len];
        String line = null;
        String[] splitArr;
        int i=0,j=0;
        try{
            FileReader fr = new FileReader("out.txt");
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine())!=null){
                splitArr = line.split(" ");
                for(String s1 : splitArr){
                    readArr[i][j] = Integer.parseInt(s1);
                    j++;
                }
                i++;
                j=0;
            }
            br.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        } 
        return readArr;
    }
    
    public static int[][] addArrays(int[][] arr1,int[][] arr2){
    	/*System.out.println("Array 1");
    	display(arr1);
    	System.out.println();
    	System.out.println("Array 2");
    	display(arr2);
    	System.out.println();*/
        int[][] res = new int[arr1.length][arr1.length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                res[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
    	/*System.out.println("Result Array IS");
    	display(res);
    	System.out.println();*/
        return res;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][n];
        int[][] temp = new int[n][n];
        int x1=0,y1=0;
        int q = 0;
        for(int a0 = 0; a0 < m; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            
            arr[x][y] = w;
            w--;
          
            makeChange(arr,x-1,x+1,y-1,y+1,w);
            if(q==0){
            	writeToFile(arr);
            	reInitialize(arr);
            }
            else{
            	temp = readFromFile(arr.length);
            	temp = addArrays(arr,temp);
            	writeToFile(temp);
            	reInitialize(arr);
            }
            q++;
        }
        
        temp = readFromFile(arr.length);
        //System.out.println("Final Array IS: ");
        //display(temp);
        
        int max = -99;
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].length;j++){
                if(max<temp[i][j])
                    max = temp[i][j];
            }
        }
        
        System.out.println(max);
        
        in.close();
    }
}
