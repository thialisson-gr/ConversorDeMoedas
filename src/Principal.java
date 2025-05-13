import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        BuscaCambio buscaCambio = new BuscaCambio();
        Cambio cambio = buscaCambio.buscaCambio();

        ConversorDeMoeda moedaConversor = new ConversorDeMoeda();

        Moedas moedas = new Moedas();

        Scanner leitor = new Scanner(System.in);

        //Taxa atual das moedas.
        double valorEmReal = cambio.conversion_rates().BRL();
        double valorEmDolar = cambio.conversion_rates().USD();
        double valorEmEuro = cambio.conversion_rates().EUR();
        double valorEmIene = cambio.conversion_rates().JPY();
        double valorEmPesoArgentino = cambio.conversion_rates().ARS();
        double valorEmCny = cambio.conversion_rates().CNY();

        //Descrições das moedas.
        String dolar = moedas.getDolar();
        String euro = moedas.getEuro();
        String real = moedas.getReal();
        String iene = moedas.getiene();
        String pesoArgentino = moedas.getPesoArgentino();
        String yaun = moedas.getYuan();

        //Menu
        System.out.println("Seja bem vindo ao moedaConversor de moedas");
        System.out.println("1. " + dolar);
        System.out.println("2. " + euro);
        System.out.println("3. " + iene);
        System.out.println("4. " + real);
        System.out.println("5. " + pesoArgentino);
        System.out.println("6. " + yaun);
        System.out.println("7. Sair");

        //Execução do programa.
        while (true) {
            double quantoEmMoeda;
            System.out.println("\nEscolha a moeda de origem ou 7 para sair: ");
            int moedaOrigem = leitor.nextInt();

            if (moedaOrigem == 7) {
                System.out.println("Programa encerrado!");
                System.exit(0);
            }

            // resto do código continua...
            System.out.println("Escolha a moeda de destino:");
            int moedaDestino = leitor.nextInt();

            System.out.println("Digite o valor a ser convertido:");
            quantoEmMoeda = leitor.nextDouble();

            double taxaOrigem = switch (moedaOrigem) {
                case 1 -> valorEmDolar;
                case 2 -> valorEmEuro;
                case 3 -> valorEmIene;
                case 4 -> valorEmReal;
                case 5 -> valorEmPesoArgentino;
                case 6 -> valorEmCny;
                default -> 1.0;
            };

            double taxaDestino = switch (moedaDestino) {
                case 1 -> valorEmDolar;
                case 2 -> valorEmEuro;
                case 3 -> valorEmIene;
                case 4 -> valorEmReal;
                case 5 -> valorEmPesoArgentino;
                case 6 -> valorEmCny;
                default -> 1.0;
            };

            String moedaOrigemNome = switch (moedaOrigem) {
                case 1 -> dolar;
                case 2 -> euro;
                case 3 -> iene;
                case 4 -> real;
                case 5 -> pesoArgentino;
                case 6 -> yaun;
                default -> "";
            };

            String moedaDestinoNome = switch (moedaDestino) {
                case 1 -> dolar;
                case 2 -> euro;
                case 3 -> iene;
                case 4 -> real;
                case 5 -> pesoArgentino;
                case 6 -> yaun;
                default -> "";
            };

            System.out.println("\nConvertendo do " + moedaOrigemNome + " para o " + moedaDestinoNome);
            System.out.println(moedaConversor.conversor(quantoEmMoeda, taxaOrigem, taxaDestino));

            System.out.println("\nPara continuar convertendo digite 0.");
            int continua = leitor.nextInt();
            if (continua != 0) {
                System.out.println("\nPrograma encerrado!");
                System.exit(0);
            }
        }
    }
}