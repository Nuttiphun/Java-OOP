import javax.swing.*;
import java.util.Random;
import java.awt.*;
public class Picture {
    private int x,y;
    private int xSpeed, ySpeed;

    private final ImageIcon imageIcon;

    //width and height is from JPanel height
    Picture(int width, int height){
        imageIcon = new ImageIcon("images//ufo.png");

        // Set UFO Random position
        // random( gap, width - iconSize, gap);
        setX(random(5, width-imageIcon.getIconWidth() - 5 ));
        setY(random(5, height-imageIcon.getIconHeight() - 5 ));

        // Set random speed. For make our UFO look COOL! :D
        setxSpeed(random(1,7));setySpeed(random(1,7));
    }

    public int random(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    
    

    public int getIconHeight(){
        return imageIcon.getIconHeight();
    }public int getIconWidth(){
        return imageIcon.getIconWidth();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}
