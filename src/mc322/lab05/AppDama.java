package mc322.lab05;

public class AppDama {
    public static String[] executaJogo(String entrada, String saida) {
        CSVHandling csv;
        String comandos[];
        String resultado[];
        Tabuleiro tab;

        csv = new CSVHandling();
        csv.setDataSource(entrada);
        comandos = csv.requestCommands();
        if (comandos == null)
        {
            System.out.println("Digite um arquivo de entrada válido!");
            return null;
        }
        resultado = new String[comandos.length];
        tab = new Tabuleiro();
        System.out.println("Início:");
        tab.imprimirTabuleiro();
        for (int i = 0; i < comandos.length; i++) {
            tab.solicitaMovimento(comandos[i]);
            tab.imprimirTabuleiro();
            resultado[i] = tab.toString();
        }
        tab.exportarArquivo(saida);

        return resultado;
    }

    public static void main(String[] args) {
        if (args.length == 2)
            executaJogo(args[0], args[1]);
        else
            System.out.println("Você deve fornecer os caminhos do arquivo de entrada e de saída!");
    }

}
