package mc322.lab05;

public class Dama extends Peca
{
	Dama(char jogador, int i, int j, Tabuleiro tab)
	{
		super(jogador, i, j, tab);
	}
	
	public boolean ehMovimentoValido(int i, int j)
	{
		// Deve setar a peça que será comida caso o movimento seja válido; (essa conexão é mesmo boa?)
		return true;
	}
	
	public String toString()
	{
		return (jogador == 'B') ? "B" : "P";
	}
}
