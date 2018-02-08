/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
public class Enemy {
    public  ImageView opponent ;
    private  int xLayout = 0;
    private  int yLayout = 0;
    public  static ImageView[] allEn = new ImageView[10];
    private  static ImageView hitEn;//=new List<ImageView>();
    public  static int[] shiftEn = new int[10];//=new List<ImageView>();
    public  int numFloors = 0;
    public static int count = 0;
    private int index = 0;
    Timeline collide;   
    //model;
    private int left = 0;
    private int right = 0;
    
    Timeline moveCheckCol = new Timeline(new KeyFrame(Duration.seconds(.03), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            boolean crosses = false;
            crosses =  model.getBoundsInParent().intersects(opponent.getBoundsInParent());
            if (!crosses){if (left != 70){
                opponent.setTranslateX(opponent.getTranslateX() -1);
               // hitEn.setTranslateX(hitEn.getTranslateX() -1);
                left += 1;
            } else {
                opponent.setTranslateX(opponent.getTranslateX() +1);
                //hitEn.setTranslateX(hitEn.getTranslateX() -1);
                right += 1;
                if(right == 70) {
                    left = 0 ;
                    right = 0;
                }
            }
            crosses =  model.getBoundsInParent().intersects(opponent.getBoundsInParent());
            if(crosses) Player.reset();
            } else Player.reset();
        }
        }));   
   
    Enemy (int w, int x, int y, int z){
        opponent = new ImageView(new Image("/Resources/shroom.gif"));
      //  platfourm.xProperty().addListener((obs, oldVal, newVal) -> System.out.println("X: " + newVal));
      //  platfourm.yProperty().addListener((obs, oldVal, newVal) -> System.out.println("Y: " + newVal));
        opponent.setFitHeight(w);
        opponent.setFitWidth(x);
        opponent.setLayoutX(y);
        opponent.setLayoutY(z);
     
        allEn[count] = (opponent);
        index = count;
        count++;
        DropShadow borderGlow = new DropShadow();
borderGlow.setColor(Color.RED);
borderGlow.setOffsetX(1f);
borderGlow.setOffsetY(1f);
opponent.setEffect(borderGlow);

for (int i = 0; i < 10; i++){
    shiftEn[i] = 0;
}
moveCheckCol.setCycleCount(Timeline.INDEFINITE);
         moveCheckCol.play();
    
     
    }
   
 public  ImageView retOP() {
     return opponent;
 }  

public static void shiftAll(int x){
    boolean crosses = false;
    for (int i = 0; i < count && !crosses; i++){
        crosses =  model.getBoundsInParent().intersects(allEn[i].getBoundsInParent());
        if(crosses) Player.reset();
         else  {
            allEn[i].setLayoutX(allEn[i].getLayoutX() + x);
            shiftEn[i] += x;
        }
    }
} 
public static void reset(){
    for (int i = 0; i < count; i++){
        allEn[i].setLayoutX(allEn[i].getLayoutX() - shiftEn[i]);
        shiftEn[i] = 0;
    }
}
}
