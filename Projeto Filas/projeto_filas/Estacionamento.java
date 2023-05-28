import java.util.Scanner;

public class Estacionamento {
    private static Fila estacionamento;

    private static void chegada(String entrada) {
        String placa = entrada.substring(2);

        if (estacionamento.estaCheia()) {
            System.out.println("Não há vagas disponíveis para o carro com placa " + placa + ". O carro aguardará.");
        } else {
            estacionamento.enfileira(placa);
            System.out.println("Carro com placa " + placa + " estacionou.");
        }
    }

    private static void partida(String entrada) {
      String placa = entrada.substring(2);
      int deslocamentos = 0;

      while (!estacionamento.estaVazia()) {
          String carroAtual = estacionamento.desenfileira();
          deslocamentos++;

          if (carroAtual.equals(placa)) {
              System.out.println("Carro com placa " + placa + " saiu do estacionamento após " + deslocamentos + " deslocamento(s).");
              return;
          }
      }

      System.out.println("O carro com placa " + placa + " não está estacionado no extremo norte.");
  }

    // Simulação do Estacionamento
    public static void main(String[] args) {
      estacionamento = new Fila(12); // Cria uma instância da fila de tamanho máximo 12
      Scanner sc = new Scanner(System.in);
      String entrada;

      System.out.println("Digite 'C {placa}' para chegada ou 'P {placa}' para partida.\nDigite 'F' para finalizar:");

      do {
          entrada = sc.nextLine();

          if (entrada.startsWith("C")) {
              chegada(entrada);
          } else if (entrada.startsWith("P")) {
              partida(entrada);
          }
      } while (!entrada.equals("F"));
  }
}
