/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import static testclass.ImageButton.playButton;

/**
 *
 * @author cmaso
 */
public class ImageButton {
    public static ImageView playButton = new ImageView("http://mythicreign.com/home/images/playbutton.png");
    public static boolean isClicked = false;
    public  static ImageView retPlay(){
        
        playButton.setTranslateY(155);
        playButton.setTranslateX(100);
        playButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
    @Override public void handle(MouseEvent e) {
        DropShadow borderGlow = new DropShadow();
borderGlow.setColor(Color.RED);
borderGlow.setOffsetX(0f);
borderGlow.setOffsetY(0f);
if(!isClicked)playButton.setEffect(borderGlow);
    }
        });
        
        playButton.setOnMousePressed(new EventHandler<MouseEvent>() {
    @Override public void handle(MouseEvent e) {
        
playButton.setEffect(null);
    }
        });
        playButton.setOnMouseExited(new EventHandler<MouseEvent>() {
    @Override public void handle(MouseEvent e) {
        
playButton.setEffect(null);
    }
        });
        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override public void handle(MouseEvent e) {
        playButton.setOpacity(.1);
        isClicked = true;
    }
});
        return playButton;
               };

}
