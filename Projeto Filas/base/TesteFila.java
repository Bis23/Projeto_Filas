import java.util.Random;

public class TesteFila {
  public static void main(String[] args) {
    Random r = new Random();
    Fila f = new Fila();
    // while (!f.estaCheia()) {
    //   f.enfileira(r.nextInt(10));
    //   System.out.println(f);
    // }
    do{
      if (r.nextInt(2) == 0) { //se par: enfileira
        if (!f.estaCheia()) {
          f.enfileira(r.nextInt(10)); // de 0 a 9
        }
      }
      else { //se impar: desenfileira
        if (!f.estaVazia()) {
          System.out.println(f.desenfileira() + " foi atendido");
        }
      }
      System.out.print(f + " // ");
      System.out.println(f.oVetor());
    }while (!f.estaVazia());
  }
}
