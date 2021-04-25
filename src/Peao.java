package mc322.lab05;

public class Peao extends Peca{
	Peao(char player, char tipoPeca, int posX, int posY){
		super(player, tipoPeca, posX, posY);
	}
	
	public boolean ehMovimentoValidoPeao() {
		//
	}
	
	// Falta a função de pegar a direçao : Se for peao branco, as direções são (-1,1) - (1,1) , se for preto (-1,-1) - (1,-1).
}
