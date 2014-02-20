package com.fessor.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EquationDecoder {

	static Random random = new Random();
	
	public static int equationDecoder(String equation){
		
		int lenght = equation.length();
		
		char firstChar,secondChar,thirdChar,fourthChar,operation;
		String sNumber1, sNumber2,sNumber3,sNumber4;
		int number1, number2, number3, number4;
		int value1, value2;
		int result = 0;
		String sOperation;
		
		
		// if it's a single digit equation
		switch (lenght) {
		case 3:
			firstChar = equation.charAt(0);
			
			operation = equation.charAt(1);
			
			secondChar = equation.charAt(2);
			
			sNumber1=Character.toString(firstChar);
			sNumber2=Character.toString(secondChar);
			sOperation=Character.toString(operation);
			
					
			number1 = Integer.parseInt(sNumber1);
			number2 = Integer.parseInt(sNumber2);
			
			
			if (sOperation.equals("+")){
				result = number1+number2;
			
			}
			
			if (sOperation.equals("-")){
				result = number1-number2;
			
			}
			break;

		case 4:
			
			//if it's a single and a double digit equation
			
			firstChar = equation.charAt(1);
			secondChar = equation.charAt(2);
			
			//if first char is single digit number
			/*		if (Character.toString(firstChar)=="+" || Character.toString(firstChar)=="-"){
				
				firstChar = equation.charAt(0);
				
				operation = equation.charAt(1);
				
				thirdChar = equation.charAt(2);
				fourthChar = equation.charAt(3);
				
				sNumber1=Character.toString(firstChar);
				
				sNumber3=Character.toString(thirdChar);
				sNumber4=Character.toString(fourthChar);
				
				sOperation=Character.toString(operation);
				
						
				number1 = Integer.parseInt(sNumber1);
				
				number3 = Integer.parseInt(sNumber3);
				number4 = Integer.parseInt(sNumber4);
				
				value2 = number3*10+number4;
				
				sOperation=Character.toString(operation);
				
				if (sOperation.equals("+")){
					result = number1+value2;
				
				}
				
				if (sOperation.equals("-")){
					result = number1-value2;
				
				}
				
				
				
			}//if first char is a double digit number
			else{
			*/	
				firstChar = equation.charAt(0);
				secondChar = equation.charAt(1);
				
				operation = equation.charAt(2);
				
				thirdChar = equation.charAt(3);
				
				sNumber1=Character.toString(firstChar);
				sNumber2 = Character.toString(secondChar);
				sNumber3=Character.toString(thirdChar);
				sOperation=Character.toString(operation);
				
						
				number1 = Integer.parseInt(sNumber1);
				number2 = Integer.parseInt(sNumber2);
				
				value1 = number1*10+number2;
				
				number3 = Integer.parseInt(sNumber3);
				
				
				
				sOperation=Character.toString(operation);
				
				if (sOperation.equals("+")){
					result = value1+number3;
				
				}
				
				if (sOperation.equals("-")){
					result = value1-number3;
				
				}
				
				
				
		//	}
			
			
			break;
			
		case 5: 
			
			//if there are 2 double digit numbers in the equation
			
			firstChar = equation.charAt(0);
			secondChar = equation.charAt(1);
			operation = equation.charAt(2);
			thirdChar = equation.charAt(3);
			fourthChar = equation.charAt(4);
			
			sNumber1=Character.toString(firstChar);
			sNumber2=Character.toString(secondChar);
			sNumber3=Character.toString(thirdChar);
			sNumber4=Character.toString(fourthChar);
			sOperation=Character.toString(operation);
			
					
			number1 = Integer.parseInt(sNumber1);
			number2 = Integer.parseInt(sNumber2);
			value1 = number1*10+number2;
			
			number3 = Integer.parseInt(sNumber3);
			number4 = Integer.parseInt(sNumber4);
			value2 = number3*10+number4;
			
			sOperation=Character.toString(operation);
			
			if (sOperation.equals("+")){
				result = value1+value2;
			
			}
			
			if (sOperation.equals("-")){
				result = value2-value1;
			
			}
			break;	
		}
		
		return result;
		
	}

	public static String equationMaker(int result, int operation){
		
		
		int value1;
		int value2;
		double doubleRand;
		String output = "error";
		
		
			switch (operation) {
			case 1:
				value1 = random.nextInt(result-1)+1;
				value2 = result-value1;
				output = ""+value1+"+"+value2;
				break;
			
			case 2:
				doubleRand = 5 + (int)(Math.random() * ((result - 5) ));
				value1 = (int)doubleRand;
				value2 = result+value1;
				output = ""+value2+"-"+value1;
			break;

			default:
				break;
			}
			
		
		
		
		return output;
	}
	
	public static List<String> equationListMaker(int listSize, int operation){
		
		List<String> equationsList = new ArrayList<String>();
		
		for (int i = 2; i<listSize+2; i++){
			equationsList.add(equationMaker(i, operation));
		}
		
		for(int i=2;i<listSize+2;i++){
			
			int arrIndex = (int)((double)equationsList.size() * Math.random());
			String random = equationsList.get(arrIndex);
			equationsList.remove(arrIndex);	
			equationsList.add(random);
		}
		
		
		return equationsList;
		
	}
 
	













}
