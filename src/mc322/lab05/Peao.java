package mc322.lab05;

public class Peao extends Peca
{
	Peao(char jogador, int i, int j, Tabuleiro tab)
	{
		super(jogador, i, j, tab);
	}
	
	public boolean ehMovimentoValido(int iAlvo, int jAlvo)
	{
		int direcaoDiagonal[] = super.obterDirecaoDiagonal(iAlvo, jAlvo);
		
		if (direcaoDiagonal == null) {
			return false;
		}
		
		if (this.jogador == 'P' && direcaoDiagonal[0] == -1) {
			if (ehPossivelComerDirecao(-2, +2)) {
				return true;
			}
			else if (ehPossivelComerDirecao(-2, -2)) {
				return true;
			}
			
			return false;
		}
		else if (this.jogador == 'B' && direcaoDiagonal[0] == 1) {
			if (ehPossivelComerDirecao(2, 2)) {
				return true;
			}
			else if (ehPossivelComerDirecao(2, -2)) {
				return true;
			}
			
			return false;
		}
		
		
		return this.movimento.untilBlockedPath(this, direcaoDiagonal, iAlvo, jAlvo, 1);
	}
	
	public boolean ehPossivelComerDirecao(int di, int dj) {
		if (this.getTabuleiro().ehEspacoValido(this.posicao[0]+di, this.posicao[1]+dj) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]+di, this.posicao[1]+dj)) {
			int direcaoDiagonal[] = new int[2];
			direcaoDiagonal[0] = di/Math.abs(di);
			direcaoDiagonal[1] = dj/Math.abs(dj);
			
			if (this.movimento.untilBlockedPath(this, direcaoDiagonal, this.posicao[0]+di, this.posicao[1]+dj, 1)) {
				return true;
			}
		}
		return false;
	}
	
	
	public String toString()
	{
		return (jogador == 'B') ? "b" : "p";
	}
}
