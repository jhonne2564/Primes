package com.test;

/* package whatever; // don't place package name! */

import java.io.*;


/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		

		
		BufferedReader r = new BufferedReader (new InputStreamReader (System.in));
		String s;
		while (  (s=r.readLine()) != null)
                         {
                           System.out.println(process_input(s));
                        
                         }
	}
       
    
    //Su código va acá
      
    public static String process_input(String input)
    {
		    
       String[] parameters = input.split(":"); 
  		return board_next_step(parameters[0],parameters[1]); 
    } 
//    [1, 0, 0], [0, 1, 1],[1, 1, 0]:1 [0, 0, 0],[1, 0, 1],[0, 1, 1]
//    [1, 0, 0],[0, 1, 1],[1, 1, 0]:2 [0, 1, 0],[0, 0, 1],[1, 1, 1]
       public static String board_next_step(String initial_board, String steps)
    {
    	   
    	String   input=initial_board.replaceAll("\\s", "");
        input=input.substring(1,input.length()-1);
   		String parts[]=input.split("\\],\\[");
    	
    	String matrix[][]= new String[parts.length][];
		for (int i = 0; i < parts.length; i++) {
			matrix[i]=parts[i].split(",");
		}
				
    	
    	String matrixResult [][] = new String[matrix.length][];
    	showArray(matrix);
    	int stepsMatrix= Integer.parseInt(steps);
    	for(int a=0;a<stepsMatrix;a++){  
    		
    		for(int i=0;i<matrix.length;i++){
    			String[] arrayTemp=new String[matrix[i].length];
    			for(int j=0;j<matrix[i].length;j++){
    				
    					int ones=0;
    					//Preguntando por vecinas
    					try{ 
    						if(matrix[i][j+1].equals("1")){
    							ones++;
    						}
    					}catch(Exception e){}
    					
    					try{
    						if(matrix[i][j-1].equals("1")){
    							ones++;
    						}
    					}catch(Exception e){}
    					
    					//-->
    					try{
    						if(matrix[i+1][j].equals("1")){
    							ones++;
    						}    						
    					}catch(Exception e){}
    					try{
    						if(matrix[i-1][j].equals("1")){
    							ones++;
    						}    						
    					}catch(Exception e){}
    					
    					//-->
    					try{
    						if(matrix[i+1][j+1].equals("1")){
    							ones++;
    						}    						
    					}catch(Exception e){}
    					
    					
    					try{
    						if(matrix[i+1][j-1].equals("1")){
    							ones++;
    						}
    					}catch(Exception e){}
    					
    					try{
    						if(matrix[i-1][j+1].equals("1")){
    							ones++;
    						}
    					}catch(Exception e){}
    					try{
    						if(matrix[i-1][j-1].equals("1")){
    							ones++;
    						}
    					}catch(Exception e){}    					    			    		
    					
    					
    					
    				if(matrix[i][j].equals("0")){	
    					if(ones==3){
    						arrayTemp[j]="1";
    					}else{
    						arrayTemp[j]="0";
    					}
    				}else{
    					if(ones==2||ones==3){
    						arrayTemp[j]="1";
    					}else{
    						arrayTemp[j]="0";
    					}
    				}
    			}
    			
    			matrixResult[i]=arrayTemp;
    			
    		}
    		showArray(matrixResult);
    		matrix=copy(matrixResult);
    	}
    	
    	// mostrando resultado final
    	String output="[";
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[i].length;j++){
    			output+=matrix[i][j]+", ";
    		}
    		output=output.substring(0,output.length()-2)+"],[";
    	}
    	
    	return output.substring(0,output.length()-3)+"]";
    }
    
    public static String[][] copy(String [][] matrixResult){
    	String [][] newM= new String [matrixResult.length][];
    		for(int i=0;i<matrixResult.length;i++){
    			String temp[]= new String[matrixResult[i].length];
	    		for(int j=0;j<matrixResult[i].length;j++){
	    			temp[j]=matrixResult[i][j];
	    		}
	    		newM[i]=temp;
    	}
    	return newM;
    }
    public static void showArray(String matrix[][]) {
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
    	System.out.println();System.out.println();
    }
}