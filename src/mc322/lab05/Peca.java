package mc322.lab05;

public class Peca {
	protected char jogador;    // 'B' : Jogador das brancas ; 'P' : Jogador das Pretas
	protected int posicao[] = new int[2];
	protected Tabuleiro tab;  // Tabuleiro ao qual a peça pertence.
	
	Peca(char jogador, int i, int j, Tabuleiro tab){
		this.jogador = jogador;
		this.tab = tab;
		setPosicao(i, j);
	}

	public int[] getPosicao(){
		return posicao;
	}

	public void setPosicao(int i, int j){
		this.posicao[0] = i;
		this.posicao[1] = j;
	}
	
	public char getJogador() {
		return this.jogador;
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tab;
	}

	// Retorna se o movimento pode ser realizado e seleciona a peça que foi capturada
	// durante o processo
	public boolean ehMovimentoValido(int iAlvo, int jAlvo){
		return true;
	}

	public String toString(){	
		return "X"; // Peça genérica;
	}
}
