package mc322.lab05;

public class AppDama {
    public static void main(String[] args) {
        String resultado[] = executaJogo("../testes/teste01.csv");
    }
    
    public static String[] executaJogo(String entrada)
    {
        CSVHandling csv;
        String comandos[];
        String resultado[];
        Tabuleiro tab;
        int iInicio, jInicio, iFim, jFim;
        
        csv = new CSVHandling();
        csv.setDataSource(entrada); // setar por argumentos de entrada
        comandos = csv.requestCommands();
        resultado = new String[comandos.length];
        tab = new Tabuleiro(); // setar jogador inicial;
        System.out.println("Início:");
        tab.imprimirTabuleiro();
        for (int i = 0; i < comandos.length; i++)
        {
            // converte o comando em string em seus valores inteiros:
            System.out.printf("Source: %s\n", comandos[i].substring(0,2));
            jInicio = Character.getNumericValue(comandos[i].charAt(0)) - Character.getNumericValue('a');
            iInicio = Character.getNumericValue(comandos[i].charAt(1)) - Character.getNumericValue('1');
            System.out.printf("Target: %s\n", comandos[i].substring(3,5));
            jFim = Character.getNumericValue(comandos[i].charAt(3)) - Character.getNumericValue('a');
            iFim = Character.getNumericValue(comandos[i].charAt(4)) - Character.getNumericValue('1');
            // executa o movimento:
            System.out.println(iInicio);
            System.out.println(jInicio);
            System.out.println(iFim);
            System.out.println(jFim);
            tab.solicitaMovimento(iInicio, jInicio, iFim, jFim);
            tab.imprimirTabuleiro();
            resultado[i] = tab.toString();
        }
        
        return resultado;
    }
}
