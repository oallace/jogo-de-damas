package mc322.lab05;

public class Movimento {
	// Analisa se peça de uma dada posição é inimiga.
	public boolean ehInimigo(Peca peca, Peca pecaAtual) {
		if (peca.getJogador() != pecaAtual.getJogador()) {
			return true;
		}
		return false;
	}
	
	
	// Dado uma direção (no caso do peão e dama, direções diagonais : (1,1) - (1,-1) - (-1,1) - (-1,-1), analisa as possíveis posições
	// até chegar no limite de movimentos (no caso da Dama, apenas quando chegar na borda do tabuleiro) ou encontrar um aliado ou
	// inimigo.
	public boolean untilBlockedPath(Peca peca, int[] direcaoDiagonal, int iAlvo, int jAlvo, int numMovimentosMax) {
		int numPecasInimigas = 0;
		int numMovimentos = 0;
		int posicaoAtual[] =  new int[2];
		posicaoAtual[0] = peca.getPosicao()[0] + direcaoDiagonal[0];
		posicaoAtual[1] = peca.getPosicao()[1] + direcaoDiagonal[1];
		
		numMovimentos += 1;
		
		while (posicaoAtual[0] != iAlvo || posicaoAtual[1] != jAlvo) {
			Peca pecaAtual = peca.getTabuleiro().getPeca(posicaoAtual[0], posicaoAtual[1]);
			if (pecaAtual != null) {
				if (!ehInimigo(peca, pecaAtual)) {
					return false;
				}
				
				else {
					peca.getTabuleiro().setPecaCapturada(pecaAtual);
					numPecasInimigas += 1;
					if (numPecasInimigas > 1) {
						peca.getTabuleiro().setPecaCapturada(null);
						return false;
					}
					if (peca instanceof Peao) {
						numMovimentos -= 1;
					}
				}
			}
			
			posicaoAtual[0] += direcaoDiagonal[0];
			posicaoAtual[1] += direcaoDiagonal[1];
			numMovimentos += 1;
		}
		
		if (numMovimentos > numMovimentosMax) {
			return false;
		}
		
		return true;
	}
}
