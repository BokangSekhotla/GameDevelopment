package com.example.bokangsekhotlagame;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    Pane root = new Pane();

    Scene scene = new Scene(root, 550, 550);

    ImageView cloudView= new ImageView(new Image("See.png"));

    ImageView cloudVie= new ImageView(new Image("cloud.png"));

    ImageView cloudVi= new ImageView(new Image("Seek.png"));

    ImageView gold1= new ImageView(new Image("gold1.png"));

    ImageView gold2= new ImageView(new Image("gold2.png"));

    ImageView gold3= new ImageView(new Image("gold3.png"));

    ImageView image = new ImageView(new Image("plane.png"));

    int Scorenum=0;

    TranslateTransition tx = new TranslateTransition(Duration.millis(6000), cloudView);

    TranslateTransition tp = new TranslateTransition(Duration.millis(7000), cloudVie);

    TranslateTransition tr = new TranslateTransition(Duration.millis(8000), cloudVi);

    TranslateTransition g1 = new TranslateTransition(Duration.millis(6000), gold1);

    TranslateTransition g2 = new TranslateTransition(Duration.millis(7000), gold2);

    TranslateTransition g3 = new TranslateTransition(Duration.millis(8000), gold3);







    Label Gameover=new Label();

    Label Score=new Label();

    Label Scoren=new Label();


    AnimationTimer Mycollision=new AnimationTimer() {
        @Override
        public void handle(long l) {
            Collision(scene);
        }
    };




    @Override
    public void start(Stage stage) {

       Image back=new Image("pressure.png");
        ImageView backview=new ImageView(back);
        backview.setFitHeight(550);
        backview.setFitWidth(550);
        ImageView enemy = createEnemy(scene);
        ImageView enemy1 = Enemy1(scene);
        ImageView enemy2 = Enemy2(scene);
        ImageView ship = createShip(scene);

        ImageView golder = Money1(scene);
        ImageView gold = Money2(scene);
        ImageView goll = Money3(scene);

        Mycollision.start();
        Score.setText("Score:");
        Score.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,20));
        Score.setTextFill(Color.WHITE);
        root.getChildren().addAll(backview,Score,ship,Scoren, enemy,enemy1,enemy2,golder,gold,goll,Gameover);


        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = ship.getX();
            double y = ship.getY();

            switch (event.getCode()){

                case UP -> ship.setY(y - 10);
                case DOWN -> ship.setY(y + 10);
            }


        });

        stage.setTitle("Hello!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private ImageView Enemy1(Scene scene) {


        cloudView.setLayoutX(850);
        cloudView.setLayoutY(250);
        cloudView.setFitWidth(80);
        cloudView.setFitHeight(30);


        tx.setByX(-800);
        tx.setCycleCount(Integer.MAX_VALUE);

        tx.play();

        return cloudView;
    }

    private ImageView Enemy2(Scene scene) {


        cloudVie.setLayoutX(512);
        cloudVie.setLayoutY(400);
        cloudVie.setFitWidth(80);
        cloudVie.setFitHeight(30);


        tp.setByX(-800);
        tp.setCycleCount(Integer.MAX_VALUE);

        tp.play();

        return cloudVie;
    }
    private ImageView createEnemy(Scene scene) {


        cloudVi.setLayoutX(512);
        cloudVi.setLayoutY(100);
        cloudVi.setFitWidth(80);
        cloudVi.setFitHeight(30);


        tr.setByX(-800);
        tr.setCycleCount(Integer.MAX_VALUE);

        tr.play();

        return cloudVi;
    }

    private ImageView createShip(Scene scene) {


        image.setLayoutX(20);
        image.setLayoutY(-80);


        image.setFitWidth(150);
        image.setFitHeight(90);
        image.setY(scene.getHeight() - image.getFitHeight());
        return image;
    }
    private void Collision(Scene scene){
        if(image.getBoundsInParent().intersects(cloudVi.getBoundsInParent())||
                image.getBoundsInParent().intersects(cloudVie.getBoundsInParent())||
        image.getBoundsInParent().intersects(cloudView.getBoundsInParent())){

            Gameover.setText("Game Over");
            Gameover.setLayoutX(512/2);
            Gameover.setLayoutY(512/2);

            Gameover.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,30));
            Gameover.setTextFill(Color.WHITE);

            tp.stop();
            tr.stop();
            tx.stop();

            g1.stop();
            g2.stop();
            g3.stop();








        } else if (image.getBoundsInParent().intersects(gold1.getBoundsInParent())) {
            gold1.setVisible(false);
            Scorenum++;
            Scoren.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,20));
            Scoren.setTextFill(Color.WHITE);
            Scoren.setLayoutX(70);

            Scoren.setText(String.valueOf(Scorenum));
        }else if(image.getBoundsInParent().intersects(gold2.getBoundsInParent())){
            gold2.setVisible(false);
            Scorenum++;
            Scoren.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,20));
            Scoren.setTextFill(Color.WHITE);
            Scoren.setLayoutX(70);
            Scoren.setText(String.valueOf(Scorenum));

        } else if (image.getBoundsInParent().intersects(gold3.getBoundsInParent())) {
            gold3.setVisible(false);
            Scorenum++;
            Scoren.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,20));
            Scoren.setTextFill(Color.WHITE);
            Scoren.setLayoutX(70);
            Scoren.setText(String.valueOf(Scorenum));

        }

    }
    private ImageView Money1(Scene scene) {


        gold1.setLayoutX(600);
        gold1.setLayoutY(250);
        gold1.setFitWidth(80);
        gold1.setFitHeight(30);


        g1.setByX(-800);
        g1.setCycleCount(Integer.MAX_VALUE);

        g1.play();

        return gold1;
    }
    private ImageView Money2(Scene scene) {


        gold2.setLayoutX(850);
        gold2.setLayoutY(290);
        gold2.setFitWidth(80);
        gold2.setFitHeight(30);


        g2.setByX(-800);
        g2.setCycleCount(Integer.MAX_VALUE);

        g2.play();

        return gold2;
    }
    private ImageView Money3(Scene scene) {


        gold3.setLayoutX(850);
        gold3.setLayoutY(125);
        gold3.setFitWidth(80);
        gold3.setFitHeight(30);


        g3.setByX(-800);
        g3.setCycleCount(Integer.MAX_VALUE);

        g3.play();

        return gold3;
    }


    public static void main(String[] args) {
        launch();
    }
}
