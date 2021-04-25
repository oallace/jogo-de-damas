package mc322.lab05;

public class Peca {
	char player;    // 'B' : Jogador das brancas ; 'P' : Jogador das Pretas
	char tipoPeca;  // '1' : Peao ; '2' : Dama
	int posicao[] = new int[2];
	Movimento movimento = new Movimento();
	
	Peca(char player, char tipoPeca, int posX, int posY){
		this.player = player;
		this.tipoPeca = tipoPeca;
		this.posicao[0] = posX;
		this.posicao[1] = posY;
	}
}
