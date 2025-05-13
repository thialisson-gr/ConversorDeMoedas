public class ConversorDeMoeda {

    public String conversor(double quantoDeDinheiro, double taxaOrigem, double taxaDestino){
        return "O valor é:  ###  " + ((quantoDeDinheiro / taxaOrigem) * taxaDestino) + "  ###";
    }
}
