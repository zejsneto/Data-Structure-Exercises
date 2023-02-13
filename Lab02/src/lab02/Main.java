package lab02;

/**
 * @author      : lopespt (lopespt@$HOSTNAME)
 * @file        : LDE
 * @created     : quarta set 08, 2021 21:22:01 -03
 */

class No{
  public int valor;
  public No proximo;
  public No(int valor){
    this.valor = valor;
    this.proximo = null;
  }

  public int getValor(){
    return valor;
  }

  public No getProximo(){
    return proximo;
  }
  //friend class
}
interface ILista{
  public boolean insere(int valor);
  public boolean remove(int idx);
  public int busca(int valor);
  public void imprime();
}


class LDE implements ILista{
  private No primeiro;
  private int n;
  public LDE(){
    primeiro = null;
    n = 0;
  }

  @Override
  public boolean insere(int valor){
    No temp = new No(valor);
    if(temp==null)
      return false;


    No anter = null;
    No atual = primeiro;
    while(atual != null && atual.valor < valor){
      anter = atual;
      atual = atual.proximo;
    }

    if(anter!=null)
      anter.proximo = temp;
    else
      primeiro = temp;

    temp.proximo = atual;
    n++;
    return true;
  }

  @Override
  public void imprime(){
    No temp = primeiro;
    while(temp != null){
      System.out.println(temp.valor);
      temp = temp.proximo;
    }
  }

  @Override
 public boolean remove(int idx) {
      //implementar  
      No anterior = null;
      No atual = primeiro;
      int aux = 0;
      
      while (aux < idx ){
          anterior = atual;
          atual = atual.proximo;
          aux = aux + 1;
      }
      //remover no inicio
      if (anterior == null) {
          primeiro = atual.proximo;
          n = n - 1;
          return true;
      }
      //remover no fim
      if (atual.proximo == null) {
          anterior.proximo = null;
          n = n -1;
          return true;
      }
      //remover no meio
      if (anterior != null && atual.proximo != null) {
          anterior.proximo = atual.proximo;
          n = n -1;
          return true;
      }
    
    return true;
  }

  @Override
  public int busca(int valor) {
    //implementar
    No atual = primeiro;
    //idx tipo n (indice da lista)
    int idx = 0;
      //&& atual != null
      while (idx < n && valor != atual.valor){
          atual = atual.proximo;        
          idx = idx + 1;
      }
    if (idx < n) {
        return idx;
    }
    return -1;
  }

}

public class Main
{
  public static void main(String[] args) {
      //Não alterar o main
    LDE l = new LDE();
    l.insere(1);
    l.insere(5);
    l.insere(3);
    l.insere(9);
    l.insere(2);
    l.insere(0);
    System.out.println("===================");
    l.imprime();
    l.remove(3);
    System.out.println("===================");
    l.imprime();
    l.remove(0);
    System.out.println("===================");
    l.imprime();
    l.remove(3);
    System.out.println("===================");
    l.imprime();
    l.insere(9);
    System.out.println("===================");
    l.imprime();
    System.out.println("Buscas:");
    for (int i = 0; i < 10; i++) {
      System.out.println(i + " = " + l.busca(i));
    }


  }
}