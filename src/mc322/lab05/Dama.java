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
	
	public boolean ehPossivelComer() {
		int posicaoAtual[] =  new int[2];
		
		posicaoAtual[0] = this.getPosicao()[0] + 1;
		posicaoAtual[1] = this.getPosicao()[1] + 1;
		while (this.getTabuleiro().ehEspacoValido(posicaoAtual[0], posicaoAtual[1]) && this.getTabuleiro().ehEspacoVazio(posicaoAtual[0], posicaoAtual[1])) {
			if (ehMovimentoValido(posicaoAtual[0], posicaoAtual[1]) && this.getTabuleiro().getPecaCapturada() != null) {
				this.getTabuleiro().setPecaCapturada(null);
				return true;
			}
			posicaoAtual[0] += 1;
			posicaoAtual[1] += 1;
		}
		
		
		posicaoAtual[0] = this.getPosicao()[0] + 1;
		posicaoAtual[1] = this.getPosicao()[1] - 1;
		while (this.getTabuleiro().ehEspacoValido(posicaoAtual[0], posicaoAtual[1]) && this.getTabuleiro().ehEspacoVazio(posicaoAtual[0], posicaoAtual[1])) {
			if (ehMovimentoValido(posicaoAtual[0], posicaoAtual[1]) && this.getTabuleiro().getPecaCapturada() != null) {
				this.getTabuleiro().setPecaCapturada(null);
				return true;
			}
			posicaoAtual[0] += 1;
			posicaoAtual[1] -= 1;
		}
		
		
		posicaoAtual[0] = this.getPosicao()[0] - 1;
		posicaoAtual[1] = this.getPosicao()[1] + 1;
		while (this.getTabuleiro().ehEspacoValido(posicaoAtual[0], posicaoAtual[1]) && this.getTabuleiro().ehEspacoVazio(posicaoAtual[0], posicaoAtual[1])) {
			if (ehMovimentoValido(posicaoAtual[0], posicaoAtual[1]) && this.getTabuleiro().getPecaCapturada() != null) {
				this.getTabuleiro().setPecaCapturada(null);
				return true;
			}
			posicaoAtual[0] -= 1;
			posicaoAtual[1] += 1;
		}
		
		
		posicaoAtual[0] = this.getPosicao()[0] - 1;
		posicaoAtual[1] = this.getPosicao()[1] - 1;
		while (this.getTabuleiro().ehEspacoValido(posicaoAtual[0], posicaoAtual[1]) && this.getTabuleiro().ehEspacoVazio(posicaoAtual[0], posicaoAtual[1])) {
			if (ehMovimentoValido(posicaoAtual[0], posicaoAtual[1]) && this.getTabuleiro().getPecaCapturada() != null) {
				this.getTabuleiro().setPecaCapturada(null);
				return true;
			}
			posicaoAtual[0] -= 1;
			posicaoAtual[1] -= 1;
		}
		
		return false;
	}
	
	public String toString()
	{
		return (jogador == 'B') ? "B" : "P";
	}
}
