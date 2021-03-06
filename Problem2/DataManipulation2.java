package dataDog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * produces a list of triples of
 * teams for which at least 50 players have played for all three teams.
 * For instance, Alex Rodriguez has played for the Mariners, Rangers, and Yankees, 
 * and thus he would count once for the Mariners/Rangers/Yankees triple.
 * Please include a brief analysis of the run-time and space complexity of your algorithm.
*/


public class DataManipulation2 {
	
    static String FILETEAM= "/Users/nr/Desktop/dataDog/Problem1/uniqueTeam.csv";
    static String FILEPLAYER = "/Users/nr/Desktop/dataDog/Problem1/playerTeams.csv";
	
    public static void main(String[] args) throws IOException {
      
        HashSet<String> uniqueTeamsList = getListTeams(FILETEAM);

        Map<String, ArrayList<String>> teamUniqueTriples= getTeamUniqueTriples(uniqueTeamsList);
        
        Map<String,ArrayList<String>> playerInTeams = getListPlayers(FILEPLAYER);
        
        Map<String,ArrayList<String>> playerteamsTriples= getPlayersTeamsTriples(playerInTeams);
        
        Map<String,ArrayList<String>> finalOutput = getTripleTeamswith50Players(teamUniqueTriples,playerteamsTriples);
        
        

   }

   private static HashSet<String> getListTeams(String FILETEAM) throws FileNotFoundException, IOException{
	   
       //System.out.println(new File("").getAbsoluteFile());
       File file= new File(FILETEAM);

       HashSet<String> listTeams = new HashSet<String>();       		
       
	    Scanner inputStream = new Scanner(file);
	
	       while(inputStream.hasNext()){
	           String teamName= inputStream.next();
	           // this adds the currently parsed line to a Hashset with unique team name values
	          	listTeams.add(teamName.replaceAll("\\p{P}",""));
	          	 //System.out.println(teamName);
	          }
	          
	       //System.out.println("length: "+listTeams.size()); // list with unique team names
	       
	      inputStream.close();  
	      return listTeams;

   }
      
   private static Map<String, ArrayList<String>> getTeamUniqueTriples(HashSet<String> uniqueTeamSet) throws FileNotFoundException, IOException{
          
    	  Map<String,ArrayList<String>> lines = new HashMap<String,ArrayList<String>>();
		  List<String> listTeams = new ArrayList<String>(uniqueTeamSet);
           
           for(int i=0; i<listTeams.size();i++){
           	for(int j=i+1;j<listTeams.size();j++){
           		if (listTeams.get(j).equals(listTeams.get(i)))
   		            continue;
           		
           		for(int k=j+1;k<listTeams.size();k++){
           			
           			if (listTeams.get(k).equals(listTeams.get(i)) || listTeams.get(k).equals(listTeams.get(j)))
   		                continue;
           			String str = listTeams.get(i)+"_"+listTeams.get(j)+"_"+listTeams.get(k);
           			//System.out.println(str);
           			lines.put(str,new ArrayList<String>());          		
           		}
           	}          	
           }
       
          //System.out.println("Triples Size: "+lines.size());
       return lines;
      }

   private static Map<String,ArrayList<String>> getListPlayers(String fileName) throws FileNotFoundException, IOException{
	   
	   Map<String,ArrayList<String>> hMap = new HashMap<String,ArrayList<String>>();
       BufferedReader in = new BufferedReader(new FileReader(fileName));
       String line;

       while ((line = in.readLine()) != null) {
    	   
    	   String columns[] = line.split(",");
    	   String key = columns[0];            // player Name   
    	   ArrayList<String> list = new ArrayList<String>();
    	   
    	   for(int i=1;i<columns.length;i++ ) // teams they've played for in tempList
    	   {
    		   //System.out.println((columns[i].replaceAll("\\p{P}","")).trim());

    		   String s = (columns[i].replaceAll("\\p{P}","")).trim();
    		   if(!list.contains(s))
    			   list.add(s);        	   
    	   }
    	   
		   hMap.put(key, list);
		   
    	   // Creating triples of teams and storing them in a HashMap where player name is the key and triples are as a list of string values
    	   

    	        	// putting or adding key-value into the hashmap
       }
       in.close();
       
       for (Map.Entry<String, ArrayList<String>> entry : hMap.entrySet()) {
    	    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    	}
       
	    //System.out.println(hMap.size());

       return hMap;
    }
       
   private static Map<String,ArrayList<String>> getPlayersTeamsTriples(Map<String, ArrayList<String>> playerTeam){
	   
   	   HashMap<String, ArrayList<String>> hMap = new HashMap<String, ArrayList<String>>();
   	   
	   	for (Map.Entry<String,ArrayList<String>> entry : playerTeam.entrySet()){
	   	    String key = entry.getKey();
	   	    ArrayList<String> pT = entry.getValue();
	   	    
	   	    //System.out.println(key+": "+ pT + ", "+pT.size());
	   	    
	   	    ArrayList<String> list = new ArrayList<String>();
    	  
	   	    for(int i=0; i<pT.size();i++){
             	for(int j=i+1;j<pT.size();j++){
             		if (pT.get(j).equals(pT.get(i)))
     		            continue;
             		for(int k=j+1;k<pT.size();k++){
             			if (pT.get(k).equals(pT.get(i)) || pT.get(k).equals(pT.get(j)))
     		                continue;
             			String str = pT.get(i)+"_"+pT.get(j)+"_"+pT.get(k);
             			//System.out.println(str.trim());
             			//System.out.println(tempList.get(i));
             			list.add(str.trim());	          			
             		}
             	 }           	
             } 
    	  
    	  hMap.put(key,list);
    	  
      }
	   	for (Map.Entry<String, ArrayList<String>> entry1 : hMap.entrySet()) {
      	    //System.out.println("Key = " + entry1.getKey() + ", Value = " + entry1.getValue());
      	}
	   	
	   	//System.out.println(hMap.size());
	   	return hMap;
   }
   
   private static Map<String,ArrayList<String>> getTripleTeamswith50Players(Map<String,ArrayList<String>> teams, Map<String,ArrayList<String>> players){
   
   
       System.out.println("Players List size in: "+players.size());
       System.out.println("teams List size in: "+teams.size());


       Iterator it = players.entrySet().iterator();
       while (it.hasNext()) {
           Map.Entry pair = (Map.Entry)it.next();
           String key1 = (String)pair.getKey();
           ArrayList<String> value1= (ArrayList)pair.getValue();
            
           //System.out.println("value: "+value1);
   
           for (int x=0; x<value1.size(); x++){
       	   
        	   if (teams.containsKey(value1.get(x))) {
        		   ArrayList<String> temp = teams.get(value1.get(x));
        		   temp.add(key1);
        		   teams.put(value1.get(x),temp);
        		   
        	   }
        	   
        	    //System.out.println(value1.get(x));
           }
       
       }
       
       Map<String,ArrayList<String>> result = new HashMap<String,ArrayList<String>>();
       // the following code lets you iterate through the HashMap
       Iterator it1 = teams.entrySet().iterator();
       while (it1.hasNext()) {
           Map.Entry pair2 = (Map.Entry)it1.next();
           ArrayList<String> countList = (ArrayList)pair2.getValue();
           if(countList.size()>=45){
        	   System.out.println(pair2.getKey() + " = " + pair2.getValue());
        	   result.put((String)pair2.getKey(),(ArrayList)pair2.getValue());
           }
           it1.remove(); // avoids a ConcurrentModificationException
       }
       
       return result;
   
   }
}
