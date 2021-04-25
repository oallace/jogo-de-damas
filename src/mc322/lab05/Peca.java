package mc322.lab05;

public class Peca {
	private char jogador;    // 'B' : Jogador das brancas ; 'P' : Jogador das Pretas
	private char tipoPeca;  // '1' : Peao ; '2' : Dama
	private int posicao[] = new int[2];
	// private Movimento movimento = new Movimento();
	
	Peca(char jogador, char tipoPeca, int posX, int posY){
		this.jogador = jogador;
		this.tipoPeca = tipoPeca;
		this.posicao[0] = posX;
		this.posicao[1] = posY;
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
