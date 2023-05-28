public class Fila {
  class No {
    int info;
    No proximo;

    public No (int i) {
      info = i;
      proximo = null; //por clareza
    }
  }

  private int tamanho;
  private No primeiro;
  private No ultimo;

  public Fila () {
    tamanho = 0;
    primeiro = null;
    ultimo = null;
  }
  public int getTamanho () {
    return tamanho;
  }
  public int consultaPrimeiro () { //elemento da primeira posição
    return primeiro.info;
  }
  public int consultaUltimo () { //elemento da ultima posição
    return ultimo.info;
  }
  public boolean estaVazia () {
    return tamanho == 0;
  }
  public void enfileira (int i) {
    No novo = new No(i); //insere o i em um novo nó
    if (estaVazia()) {
      primeiro = novo;
    }
    else {
      ultimo.proximo = novo;
    }
    ultimo = novo;
    tamanho++;
  }
  public int desenfileira () {
    int temp = primeiro.info;
    primeiro = primeiro.proximo;
    if (tamanho == 1) {
      ultimo = null;
    }
    tamanho--;
    return temp;
  }

  @Override //sobrepoe o hashcode, define o que vc quer que a classe exiba (assinatura)
  public String toString() {
    String s = "fila: ";
    if (estaVazia()) {
      s+= "vazia";
    }
    else {
      No runner = primeiro; //runner = no auxiliar
      while (runner != null) {
        s+= runner.info + " ";
        runner = runner.proximo;
      }
    }
    return s;
  }
}