package mc322.lab05;

public class Dama extends Peca
{
	Dama(char jogador, int i, int j, Tabuleiro tab)
	{
		super(jogador, i, j, tab);
	}
	
	public boolean ehMovimentoValido(int iAlvo, int jAlvo)
	{	
		int direcaoDiagonal[] = super.obterDirecaoDiagonal(iAlvo, jAlvo);
		if (direcaoDiagonal == null) {
			return false;
		}
		
		return this.movimento.untilBlockedPath(this, direcaoDiagonal, iAlvo, jAlvo, 7);
	}
	
	
	public boolean ehPossivelComerDirecao(int di, int dj) {
		int numPecasInimigas = 0;
		int posicaoAtual[] = new int[2];
		int direcaoDiagonal[] = new int[2];
		direcaoDiagonal[0] = di;
		direcaoDiagonal[1] = dj;
		posicaoAtual[0] = this.getPosicao()[0] + di;
		posicaoAtual[1] = this.getPosicao()[1] + dj;
		
		while (this.getTabuleiro().ehEspacoValido(posicaoAtual[0], posicaoAtual[1])) {
			if (this.getTabuleiro().ehEspacoVazio(posicaoAtual[0], posicaoAtual[1])) {
				if (this.movimento.untilBlockedPath(this, direcaoDiagonal, posicaoAtual[0], posicaoAtual[1], 7) && this.getTabuleiro().getPecaCapturada() != null) {
					return true;
				}
			}
			else {
				Peca pecaAtual = this.getTabuleiro().getPeca(posicaoAtual[0], posicaoAtual[1]);
				if (!this.movimento.ehInimigo(this, pecaAtual)) {
					break;
				}
				else {
					numPecasInimigas += 1;
					if (numPecasInimigas > 1) {
						break;
					}
				}
			}
			posicaoAtual[0] += di;
			posicaoAtual[1] += dj;
		}
		
		return false;
	}
	
	
	public String toString()
	{
		return (jogador == 'B') ? "B" : "P";
	}
}
