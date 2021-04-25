package mc322.lab05;

public class Tabuleiro {
	Peca posicoes[][];
	int numPecasBrancas;
	int numPecasPretas;
	char jogadorAtual;      // 'B' : Brancas ; 'P' : Pretas
	Peca pecaCapturada;     // Peça que foi capturada em um dado turno;
	
	/* Descreve a forma inicial do tabuleiro:
    1: espaço com peça
    0: espaço vazio
    */
    private static int formaTabuleiro[][] = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
    };
    
    
    // Inicia um novo tabuleiro completo
    Tabuleiro(){
    	posicoes = new Peca[8][8];
    	numPecasBrancas = 12;
    	numPecasPretas = 12;
    	jogadorAtual = 'B';
    	pecaCapturada = null;
    	
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			if (formaTabuleiro[i][j] == 0) {
    				posicoes[i][j] = null;
    			}
    			else if (formaTabuleiro[i][j] == 1 && i < 3) {
    				posicoes[i][j] = new Peao('P', '1', i, j);
    			}
    			else {
    				posicoes[i][j] = new Peao('B', '1', i, j);
    			}
    		}
    	}
    }
    
    
    // Checa se o espaço informado está dentro do tabuleiro
    private boolean ehEspacoValido(int i, int j){
        if (i < 0 || i > 7 || j < 0 || j > 7){
            return false;
        }
        else{
            return true;
        }
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
        		res += posicoes[i][j].apresenta();
            }
            else{
            	res += '-';
            }
        }

        return res + "\n";
    }
    
    
 // Apresenta o estado atual do tabuleiro;
    public void apresenta(){
        for(int i = 0; i < 8; i++){
            System.out.printf("%d ", i + 1);
            System.out.print(stringLinha(i));
        }
        System.out.println("  abcdefg");
        System.out.println();
    }
    
    
    public String toString(){
        String res = "";

        for(int i = 0; i < 8; i++){
            res += stringLinha(i);
        }

        return res;
    }
}
