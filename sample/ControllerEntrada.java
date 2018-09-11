package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerEntrada implements Initializable{

    static String playerName = "";
    static int numeroRodadas = 0;


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumeroRodadas() {
        return numeroRodadas;
    }

    public void setNumeroRodadas(int numeroRodadas) {
        this.numeroRodadas = numeroRodadas;
    }

    @FXML
    private TextField nickname;

    @FXML
    private CheckBox numeroRounds1;

    @FXML
    private CheckBox numeroRounds2;

    @FXML
    private CheckBox numeroRounds3;

    @FXML
    private CheckBox numeroRounds4;
    @FXML
    private void setNumeroRounds1(){
        numeroRodadas = 25;
        numeroRounds2.setSelected(false);
        numeroRounds3.setSelected(false);
        numeroRounds4.setSelected(false);
    }
    @FXML
    private void setNumeroRounds2(){
        numeroRodadas = 50;
        numeroRounds1.setSelected(false);
        numeroRounds3.setSelected(false);
        numeroRounds4.setSelected(false);
    }
    @FXML
    private void setNumeroRounds3(){
        numeroRodadas = 100;
        numeroRounds1.setSelected(false);
        numeroRounds2.setSelected(false);
        numeroRounds4.setSelected(false);
    }
    @FXML
    private void setNumeroRounds4(){
        numeroRodadas = 151;
        numeroRounds1.setSelected(false);
        numeroRounds2.setSelected(false);
        numeroRounds3.setSelected(false);
    }



    @FXML
    private void handleButtonAction(ActionEvent event){
        try {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            if(nickname.getText().equals("")){
                alert.setTitle("Nickname parceiro");
                alert.setHeaderText("Escolha o seu nome de treinador");
                alert.showAndWait();
            }else if(numeroRodadas == 0){
                alert.setTitle("Total de rodadas");
                alert.setHeaderText("Escolha quantos pokemons você quer encontrar");
                alert.showAndWait();
            }else{
            setPlayerName(nickname.getText());

            Parent homePageParent  = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene homePageScene = new Scene((homePageParent));
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homePageScene);
            app_stage.show();




//                String nomeAluno = tF_NomeAluno.getText();
//                Integer matAluno = Integer.valueOf(tF_MatriculaAluno.getText());
//                String nascAluno = tF_NascimentoAluno.getText();
//                String turmaAluno = tF_TurmaAluno.getText();
//
//
//                Alunos alunoNovo = new Alunos(nomeAluno, nascAluno, turmaAluno, matAluno);
//                Alunos.alunos_Cadastrados.add(alunoNovo);
//
//                if (cb_portugues.isSelected()) {
//                    alunoNovo.setMaterias_Alunos("Português");
////                alunoNovo.setTotal_Materias_Aluno();
//                }
//
//                if (cb_matematica.isSelected()) {
//                    alunoNovo.setMaterias_Alunos("Matemática");
////                alunoNovo.setTotal_Materias_Aluno();
//                }
//
//                if (cb_historia.isSelected()) {
//                    alunoNovo.setMaterias_Alunos("História");
////                alunoNovo.setTotal_Materias_Aluno();
//                }
//
//                if (cb_geografia.isSelected()) {
//                    alunoNovo.setMaterias_Alunos("Geografia");
////                alunoNovo.setTotal_Materias_Aluno();
//                }
//
//                if (cb_ingles.isSelected()) {
//                    alunoNovo.setMaterias_Alunos("Inglês");
////                alunoNovo.setTotal_Materias_Aluno();
//                }
//
//                if (cb_ciencias.isSelected()) {
//                    alunoNovo.setMaterias_Alunos("Ciências");
////                alunoNovo.setTotal_Materias_Aluno();
//                }
//
//
//                System.out.println("Aluno Cadastrado com sucesso!");


            }
        //Fim
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
