/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import java.net.URL;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import static testclass.Floor.allFloor;
import static testclass.TestClass.play;

/**
 *
 * @author cmaso
 */
public class Player {
   // private URL link1 = getClass().getResource("/Default.png");
    private Image default1 = new Image("/Resources/Default.png");
    private Image default2 = new Image("/Resources/Default2.png");
    private Image default3 = new Image("/Resources/Default3.png");
    private Image left1 = new Image("/Resources/Left.png");
    private Image left2 = new Image("/Resources/Left2.png");
    private Image right1 = new Image("/Resources/Right.png");
    private Image right2 = new Image("/Resources/Right2.png");
    private  static int xcoord = -100;
    private int tick = 0;
    private static int yTrans = 0;
    public boolean ground = false;
    private static int  groundIndex = 0;
    private boolean center = true;
    public static  ImageView model = new ImageView();
    private static boolean doubleJump = false;
    private static int leftOff = 0;
    //if (model.getX() == 400) System.out.println("Center");
    public static  void reset(){
        yTrans= 0;
                xcoord = -100;
                model.setLayoutY(yTrans);
                model.setLayoutX(xcoord);
                TestClass.plat.retPlat().setLayoutX(-100);
              TestClass.plat.retPlat().setLayoutY(400);
              TestClass.plat2.retPlat().setLayoutX(400);
              TestClass.plat2.retPlat().setLayoutY(350);
              TestClass.plat3.retPlat().setLayoutX(530);
              TestClass.plat3.retPlat().setLayoutY(410);
              TestClass.plat4.retPlat().setLayoutX(730);
              TestClass.plat4.retPlat().setLayoutY(350);
              TestClass.plat5.retPlat().setLayoutX(930);
              TestClass.plat5.retPlat().setLayoutY(290);
              TestClass.plat6.retPlat().setLayoutX(1130);
              TestClass.plat6.retPlat().setLayoutY(310);
              ImageButton.isClicked = false;
              ImageButton.playButton.setOpacity(1);
              Enemy.reset();
              Portal.reset();
              sum = 0;
              leftOff = 0;
              groundIndex = -1;
    }
    private boolean cross(ImageView obj, int index){
        double x, y, ytrans, xtrans; 
        double modelX = model.getLayoutX();
        double modelY = model.getLayoutY()+1;
        boolean crosses = false;
        
        if(index != groundIndex)crosses = model.getBoundsInParent().intersects(obj.getBoundsInParent());
                      //  ){;
        
       // System.out.println(index + " " + groundIndex + "" + crosses);
        
        return crosses;
    }
        
    private static int sum = 0; 
    Timeline RightWalking= new Timeline(new KeyFrame(Duration.seconds(.07), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            boolean intersects = false;
           
            
              /*  if(!intersects){
                    for (int i = 0; i < Floor.count;i++ ){
                        allFloor[i].setLayoutX(allFloor[i].getLayoutX()-10);
                          for (int j = 0; j < Floor.count && !intersects; j++)
                intersects = cross(allFloor[j]);
                    }*/
                       
                  //  }
                  int j = 0;
                  if (sum > -200) {
                      model.setLayoutX(model.getLayoutX() + 10);
                      if (leftOff <= 0) sum-=10;
                      else leftOff -=10;
                      for (j = 0; j < Floor.count && !intersects ; j++){
                      intersects = cross(allFloor[j], j);
                      }
                      if(intersects){
                          if (leftOff <= 0) sum+=10;
                          else leftOff +=10;
                          model.setLayoutX(model.getLayoutX() - 10);
                      } 
                  }
                  
                      else if (sum + 1630 > 300)  {
                      for (j = 0; j < Floor.count && !intersects ; j++){
                    allFloor[j].setLayoutX(allFloor[j].getLayoutX()-10);
                      intersects = cross(allFloor[j], j);
                      }
                     if(intersects){ for (int k = 0; k < j; k++){
                    allFloor[k].setLayoutX(allFloor[k].getLayoutX()+10);
                      //System.out.println("Crosses" + j + ": " + cross(allFloor[j], j));
                      }
                     }else {
                         if (leftOff <= 0) {
                             sum-=10;
                             Enemy.shiftAll(-10);
                             Portal.shiftAll(-10);
                         }
                      else leftOff -=10;
                         
                     }
                    intersects= false;
                  } else {
                      if (model.getLayoutX() != 620){
                          
                          model.setLayoutX(model.getLayoutX() + 10);
                                  for (j = 0; j < Floor.count && !intersects ; j++){
                      intersects = cross(allFloor[j], j);
                      }
                      if(intersects){
                          if (leftOff <= 0) sum+=10;
                      else leftOff +=10;
                          model.setLayoutX(model.getLayoutX() - 10);
                      }
                      }
                  }
                  
                    //intersects = cross(allFloor[j],j);}
               /* if(intersects) {
                    for (j = 0; j < Floor.count && !intersects; j++)
                    allFloor[j].setLayoutX(allFloor[j].getLayoutX()+10);
                }   */ 
                
               if (tick == 1){
                  
                   tick = 2;
                   try{
                   model.setImage(right1);
                   } catch(Exception e){}
               } else {
                   model.setTranslateX(+5);
                    try{
                   model.setImage(right2);
                   } catch(Exception e){}
                   tick = 1;
               }
        }
        }));
        
        
   Timeline fall = new Timeline(new KeyFrame(Duration.seconds(.004), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
         int count = 0;
         boolean intersects = false;
        int i = 0;
            for (i = 0; i < Floor.count && !intersects; i++)
                intersects = model.getBoundsInParent().intersects(allFloor[i].getBoundsInParent());
                      //  ){
          if (!intersects) {
            yTrans += 1;
          if (yTrans >= 450) {
                reset();
        }
        model.setLayoutY(yTrans);
        }else {
              ground = true;
              doubleJump = false;
              groundIndex = i-1;
             // System.out.println(groundIndex);
          }
       
        }
        }));     
   
   Timeline LeftWalking= new Timeline(new KeyFrame(Duration.seconds(.07), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            //if (xcoord != -100)
               // xcoord -= 10;
               boolean intersects = false;
          //  model.setLayoutX(model.getLayoutX()-10);
           int j = 0;
           
                     if(model.getLayoutX() > -100){ model.setLayoutX(model.getLayoutX() - 10);
                      leftOff +=10;
                      for (j = 0; j < Floor.count && !intersects ; j++){
                      intersects = cross(allFloor[j], j);
                      }
                      if(intersects){
                          leftOff -= 10;
                          model.setLayoutX(model.getLayoutX() + 10);
                      }
                     }
                      System.out.println("Here");
                      
                  
                  
               if (tick == 1){
                   tick = 2;
                   
                    try{
                   model.setImage(left1);//loadFile(playerModel, 30, "L2.txt");
                   } catch(Exception e){}
               } else {
                    try{
                   model.setImage(left2);
                   } catch(Exception e){}
                   tick = 1;
               }
                
            }
        
        }));
   
    Timeline eyeAnimation= new Timeline(new KeyFrame(Duration.seconds(.25), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
               if (tick == 1){
                  // System.out.println("here");
                   tick = 2;
                 model.setImage(default2);
               } else if (tick == 2){
                   tick = 3;
                  model.setImage(default3);
               } else {
                   model.setImage(default1);
                   tick = 1;
               }
                
            }
        }));
   
    Player(){
        model.setFitWidth(60);
        model.setFitHeight(60);
        model.setImage(default1);
        //isCenter.setCycleCount(Timeline.INDEFINITE);
        //isCenter.play();
    }
    
    public ImageView add(){
         yTrans= 0;
         xcoord = -100;
         model.setLayoutY(yTrans);
         model.setLayoutX(xcoord);
         eyeAnimation.setCycleCount(Timeline.INDEFINITE);
         eyeAnimation.play();
         fall.setCycleCount(Timeline.INDEFINITE);
         fall.play();
        return model;
    }
    
    public void move(String keyCase){
        boolean justFalse = false;
        keyCase = keyCase.toLowerCase();
        if(keyCase.equals("up")){
        //    if(!ground) System.out.println(doubleJump);
            // if (!doubleJump){
               //  if (!ground && !doubleJump) doubleJump = true;
                       if (ground) {
                           ground = false;
                           yTrans -= 180;
                           justFalse = true;
                       }
                   
                       if(!ground && !doubleJump && !justFalse) {
                           doubleJump = true;
                           yTrans -= 120;
                       }
                    model.setLayoutY(yTrans);
                    if (model.getBoundsInParent().intersects(play.retPlay().getBoundsInParent())){
                
                play.playButton.setOpacity(.1);
                model.setLayoutY(play.playButton.getY()-10);
                model.setLayoutY(yTrans);}
       // }
        } else if (keyCase.equals("left")){
            eyeAnimation.stop();
                   
                    if (tick == 0)
                   model.setImage(left1);
                    LeftWalking.setCycleCount(Timeline.INDEFINITE);
                    
                    LeftWalking.play();
        }else if (keyCase.equals("right")){
           // System.out.println("Right2");
         eyeAnimation.stop();
                 
                    if (tick == 0)
                   model.setImage(right1);
                    RightWalking.setCycleCount(Timeline.INDEFINITE);
                    RightWalking.play();   
        } else;
    }
    
    
    public void stop() {
        tick = 0;
                    RightWalking.stop();
                    LeftWalking.stop();
                    eyeAnimation.setCycleCount(Timeline.INDEFINITE);
                    eyeAnimation.play();
                   model.setImage(default1);
    }
    
    public boolean isGround(){
        return ground;
    }
}
