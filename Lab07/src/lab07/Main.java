package lab07;

import java.util.ArrayList;
import java.util.Scanner;

//FILA
interface IFila {

    public boolean enfileira(char valor);

    public char desenfileira();

    public int capacidade();

    public int tamanho();
}

class FilaEstaticaCircular implements IFila {

    char v[];
    int i = 0;
    int f = 0;
    int n = 0;
    int cap;

    public FilaEstaticaCircular(int Capacidade) {
        cap = Capacidade + 1; //Sentinela
        v = new char[cap];
    }

    @Override
    public boolean enfileira(char valor) {
        //Deve retornar true em caso de sucesso na inserção ou false em caso de erro
        if ((f + 1) % cap == i) {
            return false;
            //fila cheia
        }
        if ((f + 1) % cap == 0) {
            f = 0;
        }
        //v[f%cap] = valor;
        v[f] = valor;
        f++;
        n++;
        return true;
    }

    @Override
    public char desenfileira(){
       

        //Fazer o desenfileira a partir dessa linha
        char aux = v[i];
        i++;
        i = i % cap;
        n--;
        return aux;
    }

    @Override
    public int capacidade() {
        return cap;
    }

    @Override
    public int tamanho() {
        return n;
    }

}

//PILHA
class No {

    //Não alterar essa classe
    public char valor;
    public No proximo;

    public No(char valor) {
        this.valor = valor;
        this.proximo = null;
        //System.out.println("No " + valor + " criado");
    }
}

interface IPilha {

    boolean insere(char valor);

    char remove();

    void imprime();
}

class PilhaEncadeada implements IPilha {

    private No topo;

    public PilhaEncadeada() {
        topo = null;
    }

    @Override
    public boolean insere(char valor) {
        No novo = new No(valor);
        novo.proximo = topo;
        topo = novo;
        return true;
    }

    @Override
    public char remove() {

        char valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    @Override
    public void imprime() {
        No c = topo;
        while (c != null) {
            System.out.println(c);
            c = c.proximo;
        }
    }
}

//DNA
class DnaProblem {

    public ArrayList<Character> b = new ArrayList<>();
    public ArrayList<Character> e = new ArrayList<>();
}
//entradas
/*
int 8 //quantidade de letras codigo genetico, tamanho
int 3 // quantidade de metodos chamados P ou F (pilha ou fila)
entrada f ou p , fila ou pilha nessa ordem
epserado q vc leia a string, dps q leu coloca numa fila, dps pilha dps fila
 */
public class Main {

    public static ArrayList<Character> process(DnaProblem spec) {
        ArrayList<Character> temp = new ArrayList<>();
        temp = spec.b;
        for (char aux : temp) {
            if (aux == 'F') {
                FilaEstaticaCircular f1 = new FilaEstaticaCircular(spec.b.size());

                for (char count : spec.b) {
                    f1.enfileira(count);
                }
                temp.clear();
                for (int i = 0; i < spec.b.size(); i++) {
                    temp.add(f1.desenfileira());
                }
            }

            if (aux == 'P') {
                System.out.println("print pilha");
                PilhaEncadeada p1 = new PilhaEncadeada();
                
                for (char num : temp) {
                    p1.insere(num);
                }
                temp.clear();
                for (int number = 0; number < spec.b.size(); number++) {
                    temp.add(p1.remove());
                }
            }

        }
        return temp;

    }

    //Não alterar o Main
    public static void main(String[] args) {
        DnaProblem spec = new DnaProblem();
        try ( Scanner s = new Scanner(System.in)) {
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