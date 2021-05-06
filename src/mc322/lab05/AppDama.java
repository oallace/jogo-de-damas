package mc322.lab05;

public class AppDama {
    public static String[] executaJogo(String entrada, String saida)
    {
        CSVHandling csv;
        String comandos[];
        String resultado[];
        Tabuleiro tab;
        int iInicio, jInicio, iFim, jFim;
        
        csv = new CSVHandling();
        csv.setDataSource(entrada);
        comandos = csv.requestCommands();
        resultado = new String[comandos.length];
        tab = new Tabuleiro();
        System.out.println("Início:");
        tab.imprimirTabuleiro();
        for (int i = 0; i < comandos.length; i++)
        {
            // converte o comando em string em seus valores inteiros compatíveis com a matriz:
            System.out.printf("Source: %s\n", comandos[i].substring(0,2));
            jInicio = Character.getNumericValue(comandos[i].charAt(0)) - Character.getNumericValue('a');
            iInicio = Character.getNumericValue(comandos[i].charAt(1)) - Character.getNumericValue('1');
            iInicio = Math.abs(iInicio - 7); //corrige para que a orientação da linha seja adequada com a matriz
            System.out.printf("Target: %s\n", comandos[i].substring(3,5));
            jFim = Character.getNumericValue(comandos[i].charAt(3)) - Character.getNumericValue('a');
            iFim = Character.getNumericValue(comandos[i].charAt(4)) - Character.getNumericValue('1');
            iFim = Math.abs(iFim - 7); //corrige para que a orientação da linha seja adequada com a matriz
            // executa o movimento:
            tab.solicitaMovimento(iInicio, jInicio, iFim, jFim);
            tab.imprimirTabuleiro();
            resultado[i] = tab.toString();
        }
        tab.exportarArquivo(saida);
        
        return resultado;
    }
    public static void main(String[] args) {
        String resultado[] = executaJogo("testes/teste01.csv", "testes/arq001.out");
    }
    
}
