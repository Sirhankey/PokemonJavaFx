package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable{
    @FXML
    private ImageView imageView;
    @FXML
    private Label labelInfo;
    @FXML
    private Label labelPontos;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Label labelRounds;
    @FXML
    private Label labelPlayerName;

    @FXML
    private void setButton1() throws Exception {
        buttonPressed = 0;
        trocaImagensTexto();

        verificarResposta();

    }
    @FXML
    private void setButton2() throws Exception {
        buttonPressed = 1;
        trocaImagensTexto();

        verificarResposta();

    }
    @FXML
    private void setButton3() throws Exception {
        buttonPressed = 2;
        trocaImagensTexto();

        verificarResposta();

    }
    @FXML
    private void setButton4() throws Exception {
        buttonPressed = 3;
        trocaImagensTexto();

        verificarResposta();

    }

    Pokemon pkmn ;
    Player newPlayer ;
    Alert alert ;
    private boolean gameOver = false;
    static int respostaCerta = 2;
    static int buttonPressed = 0;
    static boolean pokemonSombra =false;
    ControllerEntrada gamePassed =new ControllerEntrada();
    Random random ;

    public void delay(int milisegundos){
        try
        {
            Thread.sleep(milisegundos);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }



    public void startGame() throws Exception {
        pkmn = new Pokemon();


        newPlayer = new Player(gamePassed.getPlayerName()); // set new player
        setRoundLabel();
        setPointsLabel();
        setLabelPlayerName();
        setLabelInfoPergunta();
        pkmn.setPokemons();
        setRespostas(newPlayer , pkmn);
    }

    public void setRespostas(Player newPlayer, Pokemon pkmn) throws Exception {
        random = new Random();
        pegarImagem(newPlayer.getRoundPlayer()-1 , pkmn);
        System.out.println("Imagem numero : "+newPlayer.getPontosPlayer());
        respostaCerta = random.nextInt(3);

        switch (respostaCerta){
            case 0:{
                button1.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()-1));//resposta certa
                button2.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()));
                button3.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+1));
                button4.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+3));
                break;
            }
            case 1:{
                button1.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()));
                button2.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()-1));//resposta certa
                button3.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+1));
                button4.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+3));

                break;
            }
            case 2:{
                button1.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+1));
                button2.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()));
                button3.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()-1));//resposta certa
                button4.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+3));

                break;
            }
            case 3:{
                button1.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+3));
                button2.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()));
                button3.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+1));
                button4.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()-1));//resposta certa
                break;
            }
            default:{

                button3.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()-1));//resposta certa
                button2.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()));
                button1.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+1));
                button4.setText(pkmn.getPokemonName(newPlayer.getRoundPlayer()+3));

            }
        }
    }

    public void trocaImagensTexto() throws Exception {

        setLabelInfoResposta(pkmn.getPokemonName(newPlayer.getRoundPlayer()-1));
        pokemonSombra=true;
        pegarImagem(newPlayer.getRoundPlayer()-1,pkmn);
        pokemonSombra = false;

    }

    public void verificarResposta() throws Exception {
        if(respostaCerta==buttonPressed){//resposta certa
        newPlayer.setRoundPlayer();                                 //seta o round
        newPlayer.setPontosPlayer(gamePassed.getNumeroRodadas());   //seta os pontos
        setRoundLabel();
        setPointsLabel();
        setLabelPlayerName();
//        setRespostas(newPlayer,pkmn);
        }else { // resposta errada
            setRoundLabel();
            setPointsLabel();
            setLabelPlayerName();
        }
    }
    public void setLabelInfoPergunta(){
        labelInfo.setText("Quem é esse Pokemon?");
        labelInfo.setFont(Font.font ("Verdana", 14));
        labelInfo.setTextFill(Color.RED);
    }

    public void setLabelInfoResposta(String nomePkmn){
        labelInfo.setText("É o "+nomePkmn+"!");
        labelInfo.setFont(Font.font ("Verdana", 14));
        labelInfo.setTextFill(Color.RED);
    }

    public void setLabelPlayerName(){
        labelPlayerName.setText(newPlayer.getNomePlayer());
    }



    public void setRoundLabel(){
        labelRounds.setText("Round: "+newPlayer.getRoundPlayer()+" / "+gamePassed.getNumeroRodadas());
    }

    public void setPointsLabel(){
        labelPontos.setText("Pontos: "+newPlayer.getPontosPlayer());
    }

    public void pegarImagem(int i , Pokemon pkmn ) throws Exception{
        if (!pokemonSombra) {
            FileInputStream input = new FileInputStream("C:/Users/Daniel/IdeaProjects/Pokemon/src/Imagens" + "/" + pkmn.imagemVez(i));
            Image image = new Image(input);
            imageView.setImage(image);
        }else {
            FileInputStream input = new FileInputStream("C:/Users/Daniel/IdeaProjects/Pokemon/src/Imagens" + "/" + pkmn.respostaImagemVez(i));
            Image image = new Image(input);
            imageView.setImage(image);
        }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Image image = new Image(new FileInputStream())
//        Pokemon pokemon = new Pokemon();
//        pokemon.setPokemons();


        try {
            startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
