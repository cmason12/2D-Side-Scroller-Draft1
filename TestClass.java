/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import java.io.File;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.imageio.ImageIO;

/**
 *
 * @author cmaso
 */
public class TestClass extends Application {
     private static  final int BOARD_SIZE = 60;
    private static  final int SQUARE_SIZE = 10;
    private static ImageView character = new ImageView();
    private static char[][] playerModel = new char[30][30];
    private static int xcoord = -100;
    private StackPane root = new StackPane();
    private static boolean added = false;
    private static int yTrans = 0;
    private static boolean ground = false;
    public static ImageButton play;
    public  static Player mono = new Player();
    
    private static int tick = 0; 
    private static int fallTick = 0;
    public static Floor plat = new Floor(50, 400, -100, 400);
    public static Floor plat2 = new Floor(50, 50, 400, 350);
    public static Floor plat3 = new Floor(50, 200, 530, 410);
    public static Floor plat4 = new Floor(100, 200, 730, 350);
    public static Floor plat5 = new Floor(200, 200, 930, 290);
    public static Floor plat6 = new Floor(200, 800, 1130, 310);
    
    @Override
    public void start(Stage primaryStage) {
     
        
    
        
        GridPane stage = new GridPane();
        //MakePlayer.configureGridLayout(stage);
        ScrollPane stageScene = new ScrollPane(stage);
        stageScene.setMaxWidth(800);
        stageScene.setMinWidth(800);
        stageScene.setLayoutX(-100);
        stageScene.setMinHeight(450);
        stageScene.setFitToHeight(true);
        stageScene.setFitToWidth(true);
        
        for (int i =0; i < 30; i++){
             RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setMinHeight(2);
            rowConstraints.setPrefHeight(2);
            rowConstraints.setMaxHeight(2);
            rowConstraints.setValignment(VPos.CENTER);
     
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setMinWidth(2);
            colConstraints.setMaxWidth(2);
            colConstraints.setPrefWidth(2);
            colConstraints.setHalignment(HPos.CENTER);
        }
        
        Pane game = new Pane();
        game.setMaxWidth(600);
        game.setMaxHeight(450);

        
    ImageView background = new ImageView(new Image("/Resources/testBack.gif"));
    Enemy shroom= new Enemy(50, 50, 120, 350);
    Portal port = new Portal(250, 200, 1600, 70);
    //Rectangle background = new Rectangle();
    background.setFitHeight(450);
    background.setFitWidth(800);
   // background.setFill(tst);
    background.setLayoutY(300);
    background.autosize();
    background.setLayoutX(-100);
    background.setLayoutY(0);
    
    //background.setStyle("-fx-background-size: stretch;");
    game.getChildren().addAll( stageScene, background, shroom.retOP(), port.retPort(), mono.add(), 
            ImageButton.retPlay());
    game.getChildren().addAll(plat.retPlat(), plat2.retPlat(), 
            plat3.retPlat(), plat4.retPlat(), plat5.retPlat(),
            plat6.retPlat());
       

       // stage.setStyle("-fx-background-color: DDD1E7; -fx-grid-lines-visible: false");
       // stage.setStyle("-fx-background-image: /resources/testBack.gif;" + "-fx-background-size: stretch;");
        root.getChildren().add(game);
        
        Scene scene = new Scene(root, 800, 450);
        
        stageScene.setMouseTransparent(true);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //scene.set;
        primaryStage.show();
        
       
         scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                if (ImageButton.isClicked){
               
                   if (key.getCode().equals(KeyCode.RIGHT) ||key.getCode().equals(KeyCode.D)) {
                    //System.out.println("right");
                    mono.move("right");
                    
                } else if (key.getCode().equals(KeyCode.LEFT) || key.getCode().equals(KeyCode.A)){
                    mono.move("left");
                }else if (key.getCode().equals(KeyCode.UP)|| key.getCode().equals(KeyCode.W)){
                   mono.move("up");
               
            }else if (key.getCode().equals(KeyCode.DELETE)){
                Player.reset();
            }else;
                } else if (key.getCode().equals(KeyCode.ENTER)){
                    ImageButton.playButton.setOpacity(.1);
                    ImageButton.isClicked = true;
                } else;
                }
            });
               
               
            
         
         scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
               mono.stop();
                    
    
            }
   });

         
    }
    public static void main(String[] args) {
      // System.out.println("Fds");
       launch(args);
    }
    
}
