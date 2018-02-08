/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import static testclass.Player.model;

/**
 *
 * @author cmaso
 */
public class Portal {
    public  static ImageView port;
    private static int shift = 0;
    //model;
    private int left = 0;
    private int right = 0;
    Timeline moveCheckCol = new Timeline(new KeyFrame(Duration.seconds(.03), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            boolean crosses = false;
            crosses =  model.getBoundsInParent().intersects(port.getBoundsInParent());
            if(crosses) Platform.exit();
        }
        }));   
   
    Portal (int w, int x, int y, int z){
        port = new ImageView(new Image("/Resources/port.gif"));
      //  platfourm.xProperty().addListener((obs, oldVal, newVal) -> System.out.println("X: " + newVal));
      //  platfourm.yProperty().addListener((obs, oldVal, newVal) -> System.out.println("Y: " + newVal));
        port.setFitHeight(w);
        port.setFitWidth(x);
        port.setLayoutX(y);
        port.setLayoutY(z);
       
        DropShadow borderGlow = new DropShadow();
borderGlow.setColor(Color.LIMEGREEN);
borderGlow.setOffsetX(3f);
borderGlow.setOffsetY(3f);
port.setEffect(borderGlow);
port.setOpacity(.7);

moveCheckCol.setCycleCount(Timeline.INDEFINITE);
         moveCheckCol.play();
    
     
    }
   
 public  ImageView retPort() {
     return port;
 }  

public static void shiftAll(int x){
    boolean crosses = false;
   
        crosses =  model.getBoundsInParent().intersects(port.getBoundsInParent());
        if(crosses) Platform.exit();
         else  {
            port.setLayoutX(port.getLayoutX() + x);
            shift += x;
        
    }
} 
public static void reset(){
  
        port.setLayoutX(port.getLayoutX() - shift);
        shift = 0;
}
}
