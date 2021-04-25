package mc322.lab05;

public class Tabuleiro {
	private Peca posicoes[][];      // Guarda as peças no tabuleiro
	private int numPecasBrancas;
	private int numPecasPretas;
	private char jogadorAtual;      // 'B' : Brancas ; 'P' : Pretas
	private Peca pecaCapturada;     // Peça que foi capturada em um dado turno;
	
	/* Descreve a forma inicial do tabuleiro:
    1: espaço pode ser ocupado por uma peça
    0: espaço inválido
    */
    private static int formaTabuleiro[][] = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
    };
    
    
    // Inicia um novo tabuleiro completo
    Tabuleiro(){
    	posicoes = new Peca[8][8];
    	numPecasBrancas = 12;
    	numPecasPretas = 12;
    	jogadorAtual = 'B'; // Corrigir: depende do primeiro comando
    	pecaCapturada = null;
    	
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			if (ehEspacoValido(i, j)) {
                    if (i < 3) {
                        posicoes[i][j] = new Peca('P', '1', i, j);
                    }
                    else if (i > 4){
                        posicoes[i][j] = new Peca('B', '1', i, j);
                    }
                    else {
                        posicoes[i][j] = null;
                    }
    			}
                else{
                    posicoes[i][j] = null;
                }
            }
    	}
    }
    
    
    // Checa se o espaço informado pode ser ocupado por uma peça
    private boolean ehEspacoValido(int i, int j){
        if (i >= 0 && i < 8 && j >= 0 && j < 8){
            if (formaTabuleiro[i][j] == 1)
            {
                return true;
            }
        }
        return false;
    }
    
    
    // Muda o turno após um movimento, caso este último não tenha comido nenhuma peça inimiga.
    public void mudarTurno() {
    	//
    	//
    }
    
    
    // Promover um peão para uma dama.
    public void promoverPeca() {
    	//
    }
    
    
    // Criar metodo para capturar peça : Opcional, da para fazer isso dentro do metodo mover.
    
    
    // Realiza o movimento indicado, quando possível. Caso contrário, não faz nada.
    public void mover(int iInicio, int jInicio, int iFim, int jFim) {
    	//
    	//
    }
    
    
 // Retorna uma string que representa a linha
    private String stringLinha(int i){
        String res = "";

        for(int j = 0; j < 8; j++){
        	if(posicoes[i][j] != null){
        		res += posicoes[i][j];
            }
            else{
            	res += '-';
            }
        }

        return res + "\n";
    }
    
    
 // Apresenta o estado atual do tabuleiro;
    public void apresenta(){
        String linhaAtual;

        for(int i = 0; i < 8; i++){
            System.out.print(i + 1);
            linhaAtual = stringLinha(i);
            for (int k = 0; k < linhaAtual.length(); k++){
                System.out.print(" " + linhaAtual.charAt(k));
            }
        }
        System.out.println("  a b c d e f g h");
    }
    
    public String toString(){
        String res = "";

        for(int i = 0; i < 8; i++){
            res += stringLinha(i);
        }

        return res;
    }
}
