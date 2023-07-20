import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class AnimationPanel extends JPanel implements MouseMotionListener, ActionListener {
    final public int[] ufoMenu = {0, 5, 10, 15, 20, 25, 30};
    private int xMove, yMove;

    Picture[] ufo = new Picture[30];
    static Timer timer;

    AnimationPanel(){
        super(true);
        super.setLayout(new FlowLayout());
        super.setPreferredSize(new Dimension(1000, 660));
        super.setBorder(new LineBorder(Color.BLUE,2));
        addMouseMotionListener(this);

        timer = new Timer(30,this);


        // Create UFO
        for(int i = 0; i < ufo.length; i++){
            // Picture ( PanelWidth, PanelHeight)
            ufo[i] = new Picture(super.getPreferredSize().width, super.getPreferredSize().height);
        }

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // Draw Mouse position in AnimationPanel.
        g.drawString(positionFormat(getxMove(),getyMove()),5,15);

        // Paint ufo
        for(int i =0; i < ufoMenu[Project02.ufoChoice]; i++){
            ufo[i].getImageIcon().paintIcon(this, g, ufo[i].getX(), ufo[i].getY());
        }

        super.repaint();
    }

    protected void paintIcon(Component c, Graphics g, int x,int y){ }

    // Ufo Animation Update
    public void actionPerformed(ActionEvent e) {
        for(int i =0; i < ufoMenu[Project02.ufoChoice]; i++){

            // For make UFO don't fly out from Animation Panel.

            /////////////////////////// Set speed x,y to positive or negative Speed  /////////////////////////////
            // For make UFO don't move more than width, height limit.
            if (ufo[i].getX() + ufo[i].getxSpeed() > super.getPreferredSize().width-ufo[i].getIconWidth()) {
                ufo[i].setxSpeed(ufo[i].getxSpeed() * -1);
            }if (ufo[i].getY() + ufo[i].getySpeed() > super.getPreferredSize().height-ufo[i].getIconHeight() ) {
                ufo[i].setySpeed(ufo[i].getySpeed() * -1);
            }
            // For make UFO don't move less than width, height limit.
            // 5 is mean gap.
            if (ufo[i].getX() + ufo[i].getxSpeed() < 5) {
                ufo[i].setxSpeed(ufo[i].getxSpeed() * -1);
            }
            if (ufo[i].getY() + ufo[i].getySpeed() < 5) {
                ufo[i].setySpeed(ufo[i].getySpeed() * -1);
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////

            // Move UFO position (position + speed)l
            ufo[i].setX( ufo[i].getX() + ufo[i].getxSpeed());
            ufo[i].setY( ufo[i].getY() + ufo[i].getySpeed());

        }
    }

    public static String positionFormat(int x, int y){
        return "["+ x + "," + y + "]";
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        setxMove(e.getX());
        setyMove(e.getY());
    }

    public int getxMove() {
        return xMove;
    }

    public int getyMove() {
        return yMove;
    }

    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }

}
