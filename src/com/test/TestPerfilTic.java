package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class TestPerfilTic {

	public static void main5(String[] args) {
		String a="[1,0,0],[0,1,1],[1,1,0]:2";
		String [] parameters=a.split(":");
		String output=parameters[0];
		int b=Integer.parseInt(parameters[1]);
		for (int i = 0; i < b; i++) {
			output=nextStep(output);
		}
		System.out.println(output);
	}
	
	public static String nextStep(String a) {
		
		String matrix[][]= new String[][] {{a.charAt(1)+"",a.charAt(3)+"",a.charAt(5)+""},
			{a.charAt(9)+"",a.charAt(11)+"",a.charAt(13)+""},
			{a.charAt(17)+"",a.charAt(19)+"",a.charAt(21)+""}};
		String result[][]= new String [3][3];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
				if(matrix[i][j].equals("0")) {
					int unos=0;
					try {
						if(matrix[i+1][j].equals("1")) {
							unos++;
						}} catch (Exception e) {}
						
					try {
						if(matrix[i+1][j+1].equals("1")) {
							unos++;
						}} catch (Exception e) {}				
					try {
						if(matrix[i+1][j-1].equals("1")) {
							unos++;
						}					} catch (Exception e) {}
					try {
						if(matrix[i-1][j].equals("1")) {
							unos++;
						}
					} catch (Exception e) {
						
					}
						
					try {
						if(matrix[i-1][j+1].equals("1")) {
							unos++;
						}
					} catch (Exception e) {
						
					}				
					try {
						if(matrix[i-1][j-1].equals("1")) {
							unos++;
						}
					} catch (Exception e) {
						
					}
					
					
					
					
					try {
						if(matrix[i][j+1].equals("1")) {
							unos++;
						}
					} catch (Exception e) {
						
					}

					try {
						if(matrix[i][j-1].equals("1")) {
							unos++;
						}
					} catch (Exception e) {
						
					}
					
					if(unos==3) {
						result[i][j]="1";
					}else {
						result[i][j]="0";
					}
				}else {
					int unos=0;
					try {if(matrix[i+1][j].equals("1")) {
							unos++;}} catch (Exception e) {}
						
					try {if(matrix[i+1][j+1].equals("1")) {
							unos++;	}} catch (Exception e) {}
					
					try {if(matrix[i+1][j-1].equals("1")) {
							unos++;	}					} catch (Exception e) {}
					
					try {if(matrix[i-1][j].equals("1")) {
							unos++;}} catch (Exception e) {}
						
					try {if(matrix[i-1][j+1].equals("1")) {
							unos++;}} catch (Exception e) {}
					
					try {if(matrix[i-1][j-1].equals("1")) {
							unos++;    }} catch (Exception e) {}
																				
					try {if(matrix[i][j+1].equals("1")) {
							unos++;}} catch (Exception e) {}

					try {   if(matrix[i][j-1].equals("1")) {
							unos++;    }  } catch (Exception e) {}
					
					if(unos==2||unos==3) {
						result[i][j]="1";
					}else {
						result[i][j]="0";
					}				}		}						System.out.println();
		}
		String output="[";
		for (int k = 0; k < result.length; k++) {
			for (int k2 = 0; k2 < result.length; k2++) {
				output+=result[k][k2]+",";
			}
			output=output.substring(0,output.length()-1);
			output+="],[";
		}		
		return output.substring(0,output.length()-3)+"]";
	}
	
	public static void main11(String[] args) {
		TestPerfilTic tic= new TestPerfilTic();		
//		System.out.println(binaryNumber);
		int numStep=6 ;int sum=0;
		int count=0; String number="1";
		do {
			number=tic.add(number);
			System.out.println(number);
			sum=tic.suma(number);
			if(sum==numStep) {
				count++;		
				
			}	
			
		}
		while ( !(sum==numStep&&number.matches("1+"))); 
			
		
		System.out.println(count);
	}
	public int suma(String  input) {
		int suma=0;
		for (int i = 0; i < input.length(); i++) {
			suma+=Integer.parseInt(""+input.charAt(i));
		}
		return suma;
	}
	public String add(String  input) {
		char[] array=input.toCharArray();
		for (int i = input.length()-1; i >=0 ; i--) {
			if(array[i]=='1') {
				array[i]='2';
				return new String(array);
			}else {
				array[i]='1';
			}
		}
		return "1"+new String(array);
	}
	public static void main1(String[] args) {
		//Entrada del programa				
//		String input="++* jtggg";
		String input="+++++* abcdehhhhhh";
		
		
		String parts[]=input.split("\\s");
		String patternString="";
		for (int i = 0; i < parts[0].length(); i++) {
			if(parts[0].charAt(i)=='+') {
				patternString+="[a-zA-Z]";
			}else if(parts[0].charAt(i)=='$') {
				patternString+="\\d";
			}else if(parts[0].charAt(i)=='*') {
				if(i!=parts[0].length()-1&&parts[0].charAt(i+1)=='{') {
					patternString+=".{"+parts[0].charAt(i+2)+"}";
				}else {
					patternString+=".{3}";
				}
				
			}
		}
		
		Pattern pattern=Pattern.compile(patternString);
		System.out.println(pattern.matcher(parts[1]).matches());
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		String s="camaPerro,001,100.00,2.00";
		System.out.println(process_input(s));
		s="juguete,001,300.00,8.00";
		System.out.println(process_input(s));
		s="piano,003,100.00,2.00";
		System.out.println(process_input(s));
		s="guitarra,003,300.00,8.00";
		System.out.println(process_input(s));
		s="anillo,000,100.00,2.00";
		System.out.println(process_input(s));
		s="otro,000,300.00,8.00";
		System.out.println(process_input(s));
	}
       
    
    //Su código va acá
      
    public static String process_input(String input)
    {
    
       String[] parameters = input.split(","); 
  		return calculate_price(parameters[0],parameters[1],parameters[2],parameters[3]); 

    } 
    
    public static String calculate_price1(String product_name,String category,String cost,String weight)

    {
    	Double weightProduct=Double.parseDouble(weight);
    	Double costProduct=Double.parseDouble(cost);
    	Double costSending=0.0;
    	Double costTotal=0.0;
    	if(weightProduct<=4f){
    		costSending=10.0;
    	}else{
    		costSending+=(weightProduct)*2;
    	}
    	Double tariff=costProduct*10/100;
    	Double iva=0.0;
    	if(costProduct>200f){
    		costSending=0.0;
    		iva=(costProduct+tariff)*19f/100f;
    	}
    	costTotal=costProduct+costSending+iva+tariff;
    	Double interes=0.0;
    	if(category.equals("001")){
    		interes=(0.1/(1-0.1));
    	}else if(category.equals("002")){
    		interes=(0.05/(1-0.05));
    	}else if(category.equals("003")){
    		interes=(0.15/(1-0.15));
    	}
    	
    	Double costVentaConGanancia=(costTotal*10.0/100.0)+costTotal;
    	Double costConComision=costVentaConGanancia*interes+costVentaConGanancia;
    	    	
    	return product_name+","+String.format("%.2f",costConComision).replace(',', '.');
    }
    /**
		camaPerro,146.67
		juguete,425.33
		piano,155.29
		guitarra,450.35
		anillo,132.00
		otro,382.80
*/
       public static String calculate_price(String product_name,String category,String cost,String weight)

    {
    	Double weightProduct=Double.parseDouble(weight);
    	Double costProduct=Double.parseDouble(cost);
    	Double costSending=0.0;
    	Double costTotal=0.0;
    	if(weightProduct<=4f){
    		costSending=10.0;
    	}else{
    		costSending+=(weightProduct-4)*2+10;
    	}
    	Double tariff=costProduct*10/100;
    	Double iva=0.0;
    	if(costProduct>200f){
    		iva=(costProduct+costSending+tariff)*19f/100f;
    	}
    	costTotal=costProduct+costSending+iva+tariff;
    	Double interes=0.0;
    	if(category.equals("001")){
    		interes=(0.1/(1-0.1));
    	}else if(category.equals("002")){
    		interes=(0.05/(1-0.05));
    	}else if(category.equals("003")){
    		interes=(0.15/(1-0.15));
    	}
    	Double costConComision=costTotal*interes+costTotal;
    	Double costVentaConGanancia=(costConComision*10.0/100.0)+costConComision;
    	
    	    	
    	return product_name+","+String.format("%.2f",costVentaConGanancia).replace(',', '.');
    }
    
    



}



/* package whatever; // don't place package name! */




	