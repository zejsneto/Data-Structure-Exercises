package lab10;

import java.util.*;

class EntradaProb4 {
    public String s = new String();
}

public class Main {

    public static char executa(EntradaProb4 p){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < p.s.length(); i++) {
            char c = p.s.charAt(i);
            if (hm.get(c) == null) {
                hm.put(c, 0);
            } else {
                hm.replace(c, 0, 1);
            }
        }
        for (char c : p.s.toCharArray()) {
                    
            if(hm.get(c)==1){
                return c;
            }
        }
        return 't';
       
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EntradaProb4 p = new EntradaProb4();
        p.s = s.next();

        System.out.println(executa(p));
    }



}