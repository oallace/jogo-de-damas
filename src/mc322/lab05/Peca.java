package mc322.lab05;

public class Peca {
	private char jogador;    // 'B' : Jogador das brancas ; 'P' : Jogador das Pretas
	private char tipoPeca;  // '1' : Peao ; '2' : Dama
	private int posicao[] = new int[2];
	private Tabuleiro tab; // Tabuleiro ao qual a peça pertence.
	private Movimento movimento;
	
	Peca(char jogador, char tipoPeca, int i, int j, Tabuleiro tab){
		this.jogador = jogador;
		this.tipoPeca = tipoPeca;
		this.tab = tab;
		this.movimento = new Movimento();
		setPosicao(i, j);
	}

	public int[] getPosicao()
	{
		return posicao;
	}

	public void setPosicao(int i, int j)
	{
		this.posicao[0] = i;
		this.posicao[1] = j;
	}

	public boolean ehMovimentoValido(int iAlvo, int jAlvo)
	{
		return true;
	}

	public String toString(){
		if (jogador == 'B'){
			if (tipoPeca == '1'){
				return "b";
			}
			else
			{
				return "B";
			}
		}
		else{
			if (tipoPeca == '1'){
				return "p";
			}
			else{
				return "P";
			}
		}

	}
}
