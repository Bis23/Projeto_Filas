public class Fila {
  private int prim;
  private int ult;
  private int tamanho;
  private int[] dados;

  public Fila (int capacidade) {
    // por clareza, começar do 0
    prim = 0;
    ult = 0;
    tamanho = 0;
    dados = new int[capacidade]; // dá ao usuário a possibilidade de escolher
  }

  public Fila () { // se o usuário não escolher nada...
    this(10);
  }
  int prox (int pos) {
    return (pos + 1) % dados.length;
  }

  public void enfileira (int i) {
    dados[ult] = i; //insere o elemento
    ult = prox(ult); //atualiza a posição do ultimo, a lista aumenta de tamanho
    tamanho++;
  }

  public boolean estaCheia () {
    return tamanho == dados.length;
  }

  public boolean estaVazia () {
    return tamanho == 0;
  }

  public int desenfileira () {
    int temp = dados[prim]; //var. temporário
    prim = prox(prim); //quando chega no final, volta para a "prim. posição"
    tamanho--;
    return temp;
  }

  @Override
  public String toString () {
    String s = "fila: ";
    if (estaVazia()) {
      s+= "vazia";
    } 
    else {
      int i = prim;
      do {
        s+= dados[i] + " ";
        i = prox(i);
      } while (i != ult);
    }
    return s;
  }

  public String oVetor () { //método de demonstração da estrutura do vetor
    String s = "o vetor: ";
    if (estaVazia()) {
      for (int i=0; i<dados.length; i++)
        s+= "_ ";
    }
    else if (estaCheia()) {
      for (int i=0; i<dados.length; i++)
        s+= dados[i] + " ";
    }
    else if (prim < ult) {
      for (int i=0; i<prim; i++)
        s+= "_ ";
      for (int i=prim; i<ult; i++)
        s+= dados[i] + " "; 
      for (int i=ult; i<dados.length; i++)
        s+= "_ ";
    }
    else {
      for (int i=0; i<ult; i++)
        s+= dados[i] + " ";
      for (int i=ult; i<prim; i++)
        s+= " ";
      for (int i=prim; i<dados.length; i++)
        s+= dados[i] + " ";
    }
    return s;
  }
}







