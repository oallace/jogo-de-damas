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
                        posicoes[i][j] = new Peao('P', i, j, this);
                    }
                    else if (i > 4){
                        posicoes[i][j] = new Peao('B', i, j, this);
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

    public void setPecaCapturada(Peca p)
    {
        this.pecaCapturada = p;
    }
    
    // Checa se o espaço informado pode ser ocupado por uma peça
    public boolean ehEspacoValido(int i, int j){
        if (i >= 0 && i < 8 && j >= 0 && j < 8){
            if (formaTabuleiro[i][j] == 1)
            {
                return true;
            }
        }
        return false;
    }

    // retorna se o espaço informado está vazio
    public boolean ehEspacoVazio(int i, int j)
    {
        if (ehEspacoValido(i, j))
        {
            if (posicoes[i][j] == null)
            {
                return true;
            }
        }
        return false;
    }
    
    
    // Altera o  jogador do movimento atual
    public void mudarTurno()
    {
    	this.jogadorAtual = (this.jogadorAtual == 'B') ? 'P' : 'B'; 
    }
    
    
    // Promover um peão para uma dama.
    public void promoverPeca() {
    	//
    }
    
    
    private void capturarPeca()
    {
        if (pecaCapturada != null)
        {
            int posicaoPeca[] = pecaCapturada.getPosicao();
            posicoes[posicaoPeca[0]][posicaoPeca[1]] = null;
            setPecaCapturada(null);
        }
    }
    
    
    // Realiza o movimento indicado, quando possível. Caso contrário, não faz nada.
    // Por enquanto leva em conta só peões
    public void mover(int iInicio, int jInicio, int iFim, int jFim)
    {
    	if (ehEspacoValido(iInicio, jInicio) && !ehEspacoVazio(iInicio, jInicio))
        {
            Peca pecaSelecionada = posicoes[iInicio][jInicio];

            if (pecaSelecionada.ehMovimentoValido(iFim, jFim))
            {
                // capturar Peca:
                capturarPeca();
                // atualiza as coordenadas de inicio e fim:
                pecaSelecionada.setPosicao(iFim, jFim);
                posicoes[iFim][jFim] = pecaSelecionada;
                posicoes[iInicio][jInicio] = null;
            }
        }
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
        System.out.println("  a b c d e f g h\n");
    }
    
    public String toString(){
        String res = "";

        for(int i = 0; i < 8; i++){
            res += stringLinha(i);
        }

        return res;
    }
}
