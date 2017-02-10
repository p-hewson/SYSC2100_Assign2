import java.util.*;
import java.io.*;

public class countSubstrings{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    String fileName;
    String pattern;
    long startTime;
    ArrayList<Character> patternArr = new ArrayList<Character>();
    LinkedList<Character> patternLst = new LinkedList<Character>();

    System.out.println("Please enter the path for the input file: ");
    fileName = input.next();

    System.out.println("Enter the pattern to look for: ");
    pattern = input.next();

    startTime = System.currentTimeMillis();
    for(int i = 0; i < pattern.length(); i++){
      patternArr.add(pattern.charAt(i));
    }
    readFile(fileName, patternArr, startTime);

    startTime = System.currentTimeMillis();
    for(int i = 0; i < pattern.length(); i++){
      patternLst.addLast(pattern.charAt(i));
    }
    readFile(fileName, patternLst, startTime);



    /*
    System.out.println("Using ArrayLists: " + matches + " matches, derived in " + timeElapsed + " milliseconds.");
    System.out.println("Using LinkedLists: " + matches + " matches, derived in " + timeElapsed + " milliseconds.");*/
  }

  public static void readFile(String name, ArrayList<Character> pattern, Long startTime){
    ArrayList<Character> list = new ArrayList<Character>();
    Scanner sc2 = null;
    int matches = 0;
    try {
      sc2 = new Scanner(new File(name));
    }
    catch (FileNotFoundException e) {
      System.out.println("cant find file");
    }
    while (sc2.hasNextLine()) {
      Scanner s2 = new Scanner(sc2.nextLine());
      while (s2.hasNext()) {
      String s = s2.next();
      for (int i = 0; i < s.length();i++){
				list.add(s.charAt(i));
			}
      if(findBrute(list,pattern) != -1){
        matches += 1;
      }
      list.clear();
      }
    }
    Long endTime = System.currentTimeMillis();
    Long timeElapsed = endTime - startTime;
    System.out.println("Using ArrayLists: " + matches + " matches, derived in " + timeElapsed + " milliseconds.");
  }

  public static void readFile(String name, LinkedList<Character> pattern, Long startTime){
    LinkedList<Character> list = new LinkedList<Character>();
    Scanner sc2 = null;
    int matches = 0;
    try {
      sc2 = new Scanner(new File(name));
    }
    catch (FileNotFoundException e) {
      System.out.println("cant find file");
    }
    while (sc2.hasNextLine()) {
      Scanner s2 = new Scanner(sc2.nextLine());
      while (s2.hasNext()) {
      String s = s2.next();
      for (int i = 0; i < s.length();i++){
        list.addLast(s.charAt(i));
      }
      if(findBrute(list,pattern) != -1){
        matches += 1;
      }
      list.clear();
      }
    }
    Long endTime = System.currentTimeMillis();
    Long timeElapsed = endTime - startTime;
    System.out.println("Using LinkedLists: " + matches + " matches, derived in " + timeElapsed + " milliseconds.");
  }

  /*
   * Returns the lowest index at which substring pattern begins in text (or
   * else -1).
   */
  private static int findBrute(ArrayList<Character> text, ArrayList<Character> pattern) {
    int n = text.size();
    int m = pattern.size();
    for (int i = 0; i <= n - m; i++) { // try every starting index within text
      int k = 0; // k is index into pattern
      while (k < m && text.get(i + k) == pattern.get(k)){
        k++;
      }
      if (k == m){ // if we reach the end of the pattern,
        return i; // substring text[i..i+m-1] is a match
      }
    }
    return -1; // search failed
  }

  private static int findBrute(LinkedList<Character> text, LinkedList<Character> pattern) {
    int n = text.size();
    int m = pattern.size();
    for (int i = 0; i <= n - m; i++) { // try every starting index within text
      int k = 0; // k is index into pattern
      while (k < m && text.get(i + k) == pattern.get(k)){
        k++;
      }
      if (k == m){ // if we reach the end of the pattern,
        return i; // substring text[i..i+m-1] is a match
      }
    }
    return -1; // search failed
  }
}
