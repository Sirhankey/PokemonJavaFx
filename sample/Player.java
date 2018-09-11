package sample;

public class Player {
    private String nomePlayer;
    static int pontosPlayer;
    static int roundPlayer = 0;
    static boolean gameOver;

    public Player() {
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getNomePlayer() {
        return nomePlayer;
    }

    public int getPontosPlayer() {
        return pontosPlayer;
    }

    public int getRoundPlayer() {
        return roundPlayer;
    }

    public void setPontosPlayer(int i) {
        switch (i){
            case 25: {pontosPlayer+=11;
                break;
            }
            case 50: {pontosPlayer+=12;
                break;
            }
            case 100:{pontosPlayer+=13;
                break;
            }
            case 151:{pontosPlayer+=14;
                break;
            }
            default:pontosPlayer+=10;
        }

    }

    public void setRoundPlayer() {
        roundPlayer+=1;
    }

    public Player(String nomePlayer) {
        this.nomePlayer = nomePlayer;
        this.pontosPlayer = 0;
        roundPlayer++;
        this.gameOver = false;
    }

}
