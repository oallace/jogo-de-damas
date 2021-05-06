package mc322.lab05;

public class Tabuleiro {
    private Peca pecas[][]; // Guarda as peças no tabuleiro
    private int numPecasBrancas;
    private int numPecasPretas;
    private Peca pecaCapturada; // Peça que foi capturada em um dado turno
    private boolean movimentoExecutado; // Indica se o último movimento solicitado ao tabuleiro foi executado
    private CSVHandling csv;
    /*
     * Descreve a forma inicial do tabuleiro: 1: espaço pode ser ocupado por uma
     * peça 0: espaço inválido
     */
    private static int formaTabuleiro[][] = { { 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0 } };
        // char linhas[] = { '8', '7', '6', '5', '4', '3', '2', '1' };
    private String linhas = "87654321";
        // char colunas[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
    private String colunas = "abcdefgh";

    // Inicia um novo tabuleiro completo
    Tabuleiro() {
        pecas = new Peca[8][8];
        numPecasBrancas = 12;
        numPecasPretas = 12;
        pecaCapturada = null;
        csv = new CSVHandling();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ehEspacoValido(i, j)) {
                    if (i < 3) {
                        pecas[i][j] = new Peao('P', i, j, this);
                    } else if (i > 4) {
                        pecas[i][j] = new Peao('B', i, j, this);
                    } else {
                        pecas[i][j] = null;
                    }
                } else {
                    pecas[i][j] = null;
                }
            }
        }
    }

    public Peca getPeca(int i, int j) {
        if (ehEspacoValido(i, j) && !ehEspacoVazio(i, j)) {
            return this.pecas[i][j];
        }
        return null;
    }

    public Peca getPecaCapturada() {
        return this.pecaCapturada;
    }

    public void setPecaCapturada(Peca p) {
        this.pecaCapturada = p;
    }

    // Checa se o espaço informado pode ser ocupado por uma peça
    public boolean ehEspacoValido(int i, int j) {
        if (i >= 0 && i < 8 && j >= 0 && j < 8) {
            if (formaTabuleiro[i][j] == 1) {
                return true;
            }
        }
        return false;
    }

    // retorna se o espaço informado está vazio
    public boolean ehEspacoVazio(int i, int j) {
        if (ehEspacoValido(i, j)) {
            if (pecas[i][j] == null) {
                return true;
            }
        }
        return false;
    }

    // Promover um peão para uma dama caso necessário.
    private void promoverPeca(Peca peca) {
        if (peca instanceof Peao) {
            int posicaoPeca[] = peca.getPosicao();
            char jogador = peca.getJogador();

            if ((posicaoPeca[0] == 0 && jogador == 'B') || (posicaoPeca[0] == 7 && jogador == 'P')) {
                this.pecas[posicaoPeca[0]][posicaoPeca[1]] = new Dama(jogador, posicaoPeca[0], posicaoPeca[1], this);
            }
        }
    }

    private void capturarPeca() {
        if (pecaCapturada != null) {
            if (pecaCapturada.getJogador() == 'B') {
                this.numPecasBrancas--;
            } else {
                this.numPecasPretas--;
            }
            int posicaoPeca[] = pecaCapturada.getPosicao();
            pecas[posicaoPeca[0]][posicaoPeca[1]] = null;
            setPecaCapturada(null);
        }
    }

    // Realiza o movimento indicado, quando possível. Caso contrário, não faz nada.
    public void solicitaMovimento(String comando) {
        // converte o comando em string em seus valores inteiros compatíveis com a matriz:
        int iInicio, jInicio, iFim, jFim;
        System.out.printf("Source: %s\n", comando.substring(0, 2));
        jInicio = colunas.indexOf(comando.substring(0, 1));
        iInicio = linhas.indexOf(comando.substring(1, 2));
        System.out.printf("Target: %s\n", comando.substring(3, 5));
        jFim = colunas.indexOf(comando.substring(3, 4));
        iFim = linhas.indexOf(comando.substring(4, 5));
        // checa o movimento
        if (ehEspacoValido(iInicio, jInicio) && !ehEspacoVazio(iInicio, jInicio) && ehEspacoValido(iFim, jFim)
                && ehEspacoVazio(iFim, jFim)) {
            Peca pecaSelecionada = pecas[iInicio][jInicio];
            if (pecaSelecionada.ehMovimentoValido(iFim, jFim)) {
                this.movimentoExecutado = true;
                // Capturar peça
                capturarPeca();

                // atualiza as coordenadas de inicio e fim:
                pecaSelecionada.setPosicao(iFim, jFim);
                pecas[iFim][jFim] = pecaSelecionada;
                pecas[iInicio][jInicio] = null;

                // Promove a peça caso seja necessário
                promoverPeca(pecaSelecionada);
                return;
            }
        }
        this.movimentoExecutado = false;
        System.out.println("Movimento Inválido");

    }

    // Retorna uma string que representa a linha
    private String stringLinha(int i) {
        String res = "";

        for (int j = 0; j < 8; j++) {
            if (pecas[i][j] != null) {
                res += pecas[i][j];
            } else {
                res += '-';
            }
        }

        return res + "\n";
    }

    public void imprimirTabuleiro() {
        String linhaAtual;

        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i);
            linhaAtual = stringLinha(i);
            for (int k = 0; k < linhaAtual.length(); k++) {
                System.out.print(" " + linhaAtual.charAt(k));
            }
        }
        System.out.println("  a b c d e f g h\n");
    }

    public String toString() {
        String res = "";

        for (int i = 0; i < 8; i++) {
            res += stringLinha(i);
        }

        return res;
    }

    public void exportarArquivo(String caminho) {
        csv.setDataExport(caminho);
        String estado[];
        if (movimentoExecutado) {
            estado = new String[64];
            int count = 0;
            for (int j = 0; j < 8; j++)
                for (int i = 7; i >= 0; i--) {
                    String aux = "";
                    Peca peca = getPeca(i, j);
                    aux += colunas.charAt(j);
                    aux += linhas.charAt(i);
                    if (peca != null) {
                        aux += peca;
                    } else {
                        aux += '_';
                    }
                    estado[count++] = aux;
                }
        } else {
            estado = new String[1];
            estado[0] = "erro";
        }
        csv.exportState(estado);
    }
}
