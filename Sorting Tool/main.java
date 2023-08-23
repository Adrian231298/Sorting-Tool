import java.util.Scanner;


import java.util.List;
import java.util.ArrayList;

class Main {
  static final Scanner Sc = new Scanner(System.in);

  static List<String> Word = new ArrayList<>();
  static List<Long> Numbers = new ArrayList<>();
  static List<String> Lines = new ArrayList<>();
  
  public static void main(String[] args) {
    boolean sort = false;
    for(int i = 0; i < args.length; i++) {
      if (args[i].equals("-sortIntegers")) {
        sort = true;
      }
    }
    if (sort) {
      Numbers = TakeLongNumbersInput();
      System.out.println("Total numbers: "+Numbers.size() + ".");
      System.out.print("Sorted data: ");
      for (Long el : Numbers) {
        System.out.print(el + " ");
      }
    } else {
      SetInput(args[1]);
      if (Numbers.size() > 0) {
        System.out.println("Total numbers: " + Numbers.size() + ".");
        int count = 0;
        for (Long el : Numbers) {
          if (el.equals(Numbers.get(Numbers.size() - 1))) {
            count += 1;
          }
        }
        System.out.println("The greatest number: " + Numbers.get(Numbers.size() - 1) + "(" + count + " time(s), " + (int)((1f /Numbers.size()) * 100) + "%).");
      } else if(Word.size() > 0) {
        System.out.println("Total words: " + Word.size() + ".");
        int count = 0;
        for (String el : Word) {
          if (el.equals(Word.get(Word.size() - 1))) {
            count += 1;
          }
        }
        System.out.println("The longest word: " + Word.get(Word.size() - 1) + "(" + count + " time(s), " + (int)((1f /Word.size()) * 100) + "%).");
      } else {
        System.out.println("Total lines: " + Lines.size() + ".");
        System.out.println("The longest line: ");
        System.out.println(Lines.get(Lines.size() - 1));
        int count = 0;
        for (String el : Lines) {
          if (el.equals(Lines.get(Lines.size() - 1))) {
            count += 1;
          }
        }
        System.out.println("(" + count + " time(s), " + (int)((1f /Lines.size()) * 100) + "%).");
      }
    }
  }

  private static void SetInput(String arg)
  {
    if(arg.equals("long")) {
      Numbers = TakeLongNumbersInput();
    } else if (arg.equals("line")) {
      Lines = TakeLinesInput();
    } else {
      Word = TakeWordInput();
    }
  }

  private static List<String> TakeWordInput()
  {
    List<String> res = new ArrayList<>();
    while(Sc.hasNext()) {
      res.add(Sc.next());
    } 
    res.sort((w1, w2) -> (w1.length() == w2.length()) ?  0 : (w1.length() > w2.length()) ?  1 :  -1);
    return res;
  }

  private static List<Long> TakeLongNumbersInput() 
  {
    List<Long> res = new ArrayList<>();
    while(Sc.hasNextLong()) {
      res.add(Sc.nextLong());
    }
    res.sort((l1, l2) -> l1.compareTo(l2));
    return res;
  }

  private static List<String> TakeLinesInput()
  {
    List<String> res = new ArrayList<>();
      while(Sc.hasNextLine()) {
        res.add(Sc.nextLine());
    }
    res.sort((s1, s2) -> (s1.length() == s2.length()) ?  0 : (s1.length() > s2.length()) ?  1 :  -1);
    return res;
  }

  
  
}
