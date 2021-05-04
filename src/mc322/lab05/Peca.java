package mc322.lab05;

import java.lang.Math;

public class Peca {
	protected char jogador;    // 'B' : Jogador das brancas ; 'P' : Jogador das Pretas
	protected int posicao[] = new int[2];
	protected Tabuleiro tab;  // Tabuleiro ao qual a peça pertence.
	protected Movimento movimento = new Movimento();
	
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
		return false;
	}
	
	// (1,1) superior direita ; (1,-1) superior esquerda ; (-1,-1) inferior esquerda ; (-1,1) inferior direita
	public int[] obterDirecaoDiagonal(int iAlvo, int jAlvo) {
		int direcaoDiagonal[] = new int[2];
				
		// A linha que liga a peça atual e o alvo não é uma diagonal.
		if (Math.abs(this.posicao[0] - iAlvo) != Math.abs(this.posicao[1] - jAlvo)) {
			return null;
		}
		else if ((this.posicao[0] - iAlvo) == (this.posicao[1] - jAlvo) && (this.posicao[0] - iAlvo) > 0) {
			direcaoDiagonal[0] = 1;
			direcaoDiagonal[1] = 1;
		}
		else if ((this.posicao[0] - iAlvo) == (this.posicao[1] - jAlvo) && (this.posicao[0] - iAlvo) < 0) {
			direcaoDiagonal[0] = -1;
			direcaoDiagonal[1] = -1;
		}
		else if ((this.posicao[0] - iAlvo) != (this.posicao[1] - jAlvo) && (this.posicao[0] - iAlvo) > 0) {
			direcaoDiagonal[0] = 1;
			direcaoDiagonal[1] = -1;
		}
		else if ((this.posicao[0] - iAlvo) == (this.posicao[1] - jAlvo) && (this.posicao[0] - iAlvo) < 0) {
			direcaoDiagonal[0] = -1;
			direcaoDiagonal[1] = 1;
		}
		
		return direcaoDiagonal;
	}
	
	public boolean ehPossivelComer() {
		return true;
	}

	public String toString(){	
		return "X"; // Peça genérica;
	}
}
