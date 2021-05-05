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
			if (this.getTabuleiro().ehEspacoValido(this.posicao[0]-2, this.posicao[1]+2) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]-2, this.posicao[1]+2)) {
				if (ehMovimentoValido(this.posicao[0]-2, this.posicao[1]+2)) {
					return true;
				}
			}
			
			else if (this.getTabuleiro().ehEspacoValido(this.posicao[0]-2, this.posicao[1]-2) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]-2, this.posicao[1]-2)) {
				if (ehMovimentoValido(this.posicao[0]-2, this.posicao[1]-2)) {
					return true;
				}
			}
			
			return false;
		}
		else if (this.jogador == 'B' && direcaoDiagonal[0] == 1) {
			if (this.getTabuleiro().ehEspacoValido(this.posicao[0]+2, this.posicao[1]+2) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]+2, this.posicao[1]+2)) {
				if (ehMovimentoValido(this.posicao[0]+2, this.posicao[1]+2)) {
					return true;
				}
			}
			
			else if (this.getTabuleiro().ehEspacoValido(this.posicao[0]+2, this.posicao[1]-2) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]+2, this.posicao[1]-2)) {
				if (ehMovimentoValido(this.posicao[0]+2, this.posicao[1]-2)) {
					return true;
				}
			}
			
			return false;
		}
		
		
		return this.movimento.untilBlockedPath(this, direcaoDiagonal, iAlvo, jAlvo, 1);
	}
	
	public boolean ehPossivelComer() {
		if (this.getTabuleiro().ehEspacoValido(this.posicao[0]+2, this.posicao[1]+2) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]+2, this.posicao[1]+2)) {
			if (ehMovimentoValido(this.posicao[0]+2, this.posicao[1]+2)) {
				this.getTabuleiro().setPecaCapturada(null);
				return true;
			}
		}
		
		else if (this.getTabuleiro().ehEspacoValido(this.posicao[0]+2, this.posicao[1]-2) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]+2, this.posicao[1]-2)) {
			if (ehMovimentoValido(this.posicao[0]+2, this.posicao[1]-2)) {
				this.getTabuleiro().setPecaCapturada(null);
				return true;
			}
		}
		
		else if (this.getTabuleiro().ehEspacoValido(this.posicao[0]-2, this.posicao[1]+2) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]-2, this.posicao[1]+2)) {
			if (ehMovimentoValido(this.posicao[0]-2, this.posicao[1]+2)) {
				this.getTabuleiro().setPecaCapturada(null);
				return true;
			}
		}
		
		else if (this.getTabuleiro().ehEspacoValido(this.posicao[0]-2, this.posicao[1]-2) && this.getTabuleiro().ehEspacoVazio(this.posicao[0]-2, this.posicao[1]-2)) {
			if (ehMovimentoValido(this.posicao[0]-2, this.posicao[1]-2)) {
				this.getTabuleiro().setPecaCapturada(null);
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
