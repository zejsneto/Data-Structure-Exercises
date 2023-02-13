package lab04;

class No {

    public int valor;
    public No proximo;
}

class ListaEncadeada {

    public No primeiro = null;

    public void print() {
        No atual = primeiro;
        while (atual != null) {
            System.out.printf("%d ", atual.valor);
            atual = atual.proximo;
        }
        System.out.println();
    }

    public No elementoCentral() {
        No atual = primeiro;
        No proximo = null;
        No central = atual;
        int count = 0;

        while (atual != null) {
            count += 1;
            atual = atual.proximo;
        }
        //PAR - 0 1 2 3 4 5 6 7    
        if (count %2 == 0) {
            System.out.println("count par: "+count);
            atual = primeiro;
            int aux = (count / 2 );// - 1;
            System.out.println("aux par: "+aux);
            
            int temp = 0;
            while(atual != null) {
                temp++;
                if (temp == aux) {
                    central =  atual;
                    System.out.println("atual.valor: "+atual.valor);
                    break;
                }
                atual = atual.proximo;        
            }
        } 
        //IMPAR - 0 1 2 3 4 5 6 
        else if (count %2 != 0){
            atual = primeiro;
            System.out.println("count impar: "+count);
            //double aux = (count / 2 );// - 0.5;
            int aux = Math.round(count / 2 )+1;// - 0.5);
            System.out.println("aux impar: "+aux);
            int temp = 0;  
            while(atual != null) {
                temp++;
                if (temp == aux) {
                    atual.valor = Math.round(atual.valor);
                    central =  atual;
                    System.out.println("atual.valor: "+atual.valor);
                    break;
                }
                atual = atual.proximo;        
            }
        }
        return central;
    }
}

public class Main {

    public static ListaEncadeada criaListaTeste(int nmax) {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = null;
        No ultimo = null;
        for (int i = 0; i < nmax; i++) {
            No novo = new No();
            novo.proximo = null;
            novo.valor = i;
            if (primeiro == null) {
                primeiro = novo;
            } else {
                ultimo.proximo = novo;
            }
            ultimo = novo;
        }
        lista.primeiro = primeiro;
        return lista;
    }

    public static void main(String[] args) {
        int exemplos[] = {6, 2, 7, 8, 12, 3};
        for (int i = 0; i < exemplos.length; i++) {
            ListaEncadeada l = criaListaTeste(exemplos[i]);
            l.print();
            No central = l.elementoCentral();
            System.out.println(central.valor);
        }
    }
}