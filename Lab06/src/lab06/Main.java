package lab06;

/**
 * @author      : lopespt (lopespt@$HOSTNAME)
 * @file        : prob4
 * @created     : segunda set 26, 2022 08:04:56 -03
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

class DnaProblem {
  public ArrayList<Character> b = new ArrayList<>();
  public ArrayList<Character> e = new ArrayList<>();
}

public class Main {

  public static ArrayList<Character> process(DnaProblem spec) {
    Deque<Character> d = new ArrayDeque<Character>(spec.b.size());
    for (char c : spec.e) {
      //Fila não altera a ordem
      if (c == 'P') {
        //empilha
        spec.b.forEach((x) -> {
          d.push(x);
        });

        spec.b.clear();
        //desempilha e enfileira
        while(!d.isEmpty()){
          spec.b.add(d.pop());
        }
      }
    }
    return spec.b;
  }

  public static void main(String[] args) {
    DnaProblem spec = new DnaProblem();
    try (Scanner s = new Scanner(System.in)) {
      int nb = s.nextInt();
      int ne = s.nextInt();
      spec.b.ensureCapacity(nb);
      spec.e.ensureCapacity(ne);
      while (nb-- > 0) {
        spec.b.add(s.next().charAt(0));
      }
      while (ne-- > 0) {
        spec.e.add(s.next().charAt(0));
      }
    }
    ArrayList<Character> result = Main.process(spec);
    result.forEach((x) -> {
      System.out.println(x);
    });
  }
}