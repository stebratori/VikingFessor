package com.fessor.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

	static Random random = new Random();
	static int rand;
	
	public static List<String> populateList(int list_size){
		
		final List<String> list = new ArrayList<String>();
		
		for(int i=2;i<list_size+2;i++){
			list.add(""+i);
		}
		for(int i=2;i<list_size+2;i++){
			
			int arrIndex = (int)((double)list.size() * Math.random());
			String random = list.get(arrIndex);
			list.remove(arrIndex);	
			list.add(random);
		}  
		
		return list;
		
		
	}
	
	public static String generateRandom(int result, int from, int to){
		
		rand = random.nextInt(to - from)+from;
		
			while (rand == result){
				rand = random.nextInt(to - from)+from;
			}	
			
		return rand+"";
		
	}
	
	public static String generateRandom(int result, String random1, int from, int to){
		
		rand = random.nextInt(to - from)+from;
		while (rand == Integer.parseInt(random1) || rand == result){
			rand = random.nextInt(to - from)+from;		}
		return rand+"";
		
	}

	public static String generateRandom(int result,String random1, String random2, int from, int to){
	
		rand = random.nextInt(to - from)+from;
		while (rand == Integer.parseInt(random2) || rand == Integer.parseInt(random1) || rand == result){
			rand = random.nextInt(to - from)+from;		}
		return rand+"";
	
	
	}
	
}
