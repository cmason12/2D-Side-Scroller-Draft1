/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author cmaso
 */
public class Floor {
    
    public  ImageView platfourm;
    private  int xLayout = 0;
    private  int yLayout = 0;
    public  static ImageView[] allFloor = new ImageView[10];//=new List<ImageView>();
    public  int numFloors = 0;
    public static int count = 0;
    private int index = 0;
    Timeline collide;   
    //model;
       
   
    Floor (int w, int x, int y, int z){
        platfourm = new ImageView("http://clipart-library.com/images/pTodLkekc.png");
      //  platfourm.xProperty().addListener((obs, oldVal, newVal) -> System.out.println("X: " + newVal));
      //  platfourm.yProperty().addListener((obs, oldVal, newVal) -> System.out.println("Y: " + newVal));
        platfourm.setFitHeight(w);
        platfourm.setFitWidth(x);
        platfourm.setLayoutX(y);
        platfourm.setLayoutY(z);
        allFloor[count] = (platfourm);
        index = count;
        count++;
        DropShadow borderGlow = new DropShadow();
borderGlow.setColor(Color.BLACK);
borderGlow.setOffsetX(1f);
borderGlow.setOffsetY(1f);
platfourm.setEffect(borderGlow);
    
     
    }
   
 public  ImageView retPlat() {
     return platfourm;
 }   
}
