package slidingwindow.fixed;

import java.util.HashMap;

public class countOccurenceOfanagrams {
    public static void main(String[] args){
        String str="aabaabaa";
        String patern="aaba";

        counttotalAnagrams(str,patern);
    }

    private static void counttotalAnagrams(String str, String patern) {
        int totalAnagrams=0;

        int i=0;int j=0;
        StringBuilder toCheck= new StringBuilder();

        while(j<str.length()){
             toCheck.append(str.charAt(j));


              if(j-i+1==patern.length()){
                 boolean checkAnagram=isAnagram(toCheck.toString(),patern);
                 if(checkAnagram){
                     totalAnagrams++;
                 }
                 toCheck.deleteCharAt(0);
                 i++;

             }j++;

        }
        System.out.println(totalAnagrams);
    }

    private static boolean isAnagram(String string, String patern) {
        System.out.println("first combination " +string + " "+patern);
        if(string.length()!=patern.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();

       for(char c: string.toCharArray()){
           map.put(c,map.getOrDefault(c,0)+1);
       }

       for(char c:patern.toCharArray()){
           if(!map.containsKey(c)){
               return false;
           }
           map.put(c,map.get(c)-1);
           if(map.get(c)==0){
               map.remove(c);
           }
       }
       System.out.println(map.isEmpty());
        return map.isEmpty();
    }
}
