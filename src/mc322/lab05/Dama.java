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
	
	
	public String toString()
	{
		return (jogador == 'B') ? "B" : "P";
	}
}
