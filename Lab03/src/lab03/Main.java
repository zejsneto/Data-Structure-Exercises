package lab03;

/**
 * @author      : gwachs (gwachs@$HOSTNAME)
 * @file        : Main
 * @created     : quinta set 16, 2021 14:46:40 -03
 */

class No {
    public int valor;
    public No anterior;
    public No proximo;
}

interface ILista {
    boolean insere(int valor);
    boolean remove(int idx);
    void imprime();
    void imprimeReverso();
    int busca(int valor);
}

class Ldde implements ILista {
    private No primeiro = null;
    private No ultimo = null;
    private int n = 0;

    @Override
    public boolean insere(int valor) {
        //Declarando valores
        No atual = primeiro;
        No anterior = null;
        No novo = new No();
        novo.valor = valor;
        novo.proximo = null;
        novo.anterior = null;
        
        //Percorrer a lista
        while(atual != null && atual.valor < valor){//
        anterior = atual;   
        atual = atual.proximo;
        }

        //1 caso) lista vazia, anterior = null e atual = null
        if (anterior == null && atual == null) {
            primeiro = novo;
            ultimo = novo;
            novo.anterior = null;
            novo.proximo = null;
            n++;
            return true;
        }
        //2 caso) insere no começo, anterior = null e atual != null
        if (anterior == null && atual != null) {
            primeiro = novo;
            novo.anterior = null;
            novo.proximo = atual;
            atual.anterior = novo;
            n++;
            return true;
        }
        //3 caso) insere no final, anterior != null e atual = null
        if (anterior != null && atual == null) {
            ultimo = novo;
            novo.proximo = null;
            novo.anterior = anterior;
            anterior.proximo = novo;
            n++;
            return true;
        }
        //4 caso) insere no meio, anterior != null e atual != null
        if (anterior != null && atual != null) {
            anterior.proximo = novo;
            novo.proximo = atual;
            atual.anterior = novo;
            novo.anterior = anterior;
            n++;
            return true;
        }
        return false;

    }

    @Override
    public boolean remove(int idx) {
        //Declarando valores
        No atual = primeiro;
        int x = 0;
        if (idx <0 || idx >= n) {
            return false;
        }
        
        //Percorrer a lista
        while(atual != null && idx != x){//
        atual = atual.proximo;
        x++;
        }
        
        //1 caso) remove unico item, anterior = null e atual = null
        if (atual.anterior == null && atual.proximo == null) {
            primeiro = null;
            ultimo = null;
            n--;
            return true;
        }
        //2 caso) remove no começo, anterior = null e atual != null
        if (atual.anterior == null && atual.proximo != null) {
            primeiro = atual.proximo;
            atual.proximo.anterior = null;
            n--;
            return true;
        }
        //3 caso) remove no final, anterior != null e atual = null
        if (atual.anterior != null && atual.proximo == null) {
            ultimo = atual.anterior;
            atual.anterior.proximo = null;
            n--;
            return true;
        }
        //4 caso) remove no meio, anterior != null e atual != null
        if (atual.anterior != null && atual.proximo != null) {
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
            n--;
            return true;
        }
        return false;
    }

    @Override
    public void imprime() {
        No atual = primeiro;
        while(atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }

    @Override
    public void imprimeReverso() {
        No atual = ultimo;
        while(atual != null) {
            System.out.println(atual.valor);
            atual = atual.anterior;
        }
    }

    @Override
    public int busca(int valor) {
        No atual = primeiro;
        int i;
        for (i = 0; atual != null && atual.valor != valor; i++) {
            atual = atual.proximo;
        }
        if (atual != null) {
            return i;
        } else {
            return -1;
        }
    }

}

public class Main {
    public static void imprime(ILista l, String titulo) {
        System.out.println("==" + titulo + "==");
        l.imprime();
        System.out.println("=====Reverso====");
        l.imprimeReverso();
        System.out.println("======FIM=======");
    }
    public static void main(String[] args) {
        ILista l = new Ldde();
        l.insere(20);
        l.insere(10);
        l.insere(5);
        l.insere(35);
        l.insere(200);
        imprime(l, "Após Inserções");

        l.remove(3);
        imprime(l, "Após Remove indice 3");

        l.remove(l.busca(10));
        imprime(l, "Após Remove número 10");

        while(l.remove(0));

        imprime(l, "Após Remover todos");
    }
}