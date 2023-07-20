import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class GraphicsPanel extends JPanel implements MouseListener, MouseMotionListener{
    protected int xMove, yMove;
    private int shapeChoice;
    private int colorChoice;

    Box box;
    Circle circle;
    Square square;
    Triangle triangle;

    GraphicsPanel(){
        super(true);
        super.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        super.setPreferredSize(new Dimension(1000,610));
        super.setBorder(new LineBorder(Color.BLACK, 1));
        super.setBackground(Color.WHITE);

        super.addMouseListener(this);
        super.addMouseMotionListener(this);

        // Set Shape Default Location
        box = new Box(-100,0,-100,-100);
        circle = new Circle(-100,-100,-100,-100);
        square = new Square(-100,-100,-100,-100);
        triangle = new Triangle(-100,-100,-100,-100);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(positionFormat(xMove,yMove), 5,15);

        //set Color
        switch (colorChoice){
            case 4:
                g.setColor(Color.RED); break;
            case 5:
                g.setColor(Color.GREEN); break;
            case 6:
                g.setColor(Color.BLUE); break;
            case 7:
                g.setColor(Color.MAGENTA); break;
        }

        //Draw Shape
        switch(shapeChoice) {
            case 0:
                triangle.draw(g);
                break;
            case 1:
                square.draw(g);
                break;
            case 2:
                box.draw(g);
                break;
            case 3:
                circle.draw(g);
                break;
        }
        super.repaint();
    }


    public void mouseClicked(MouseEvent e) {
        // For debugging
        System.out.println("mouseClicked " + "(" + getxMove() + ", " + getyMove() + ")");
    }

    public void mousePressed(MouseEvent e) {
        switch(shapeChoice){
            case 0 :
                triangle.setX1(e.getX());
                triangle.setY1(e.getY());
                triangle.setX2(e.getX());
                triangle.setY2(e.getY());
                break;
            case 1 :
                square.setX1(e.getX());
                square.setY1(e.getY());
                square.setX2(e.getX());
                square.setY2(e.getY());
                break;
            case 2:
                box.setX1(e.getX());
                box.setY1(e.getY());
                box.setX2(e.getX());
                box.setY2(e.getY());
                break;
            case 3:
                circle.setX1(e.getX());
                circle.setY1(e.getY());
                circle.setX2(e.getX());
                circle.setY2(e.getY());
                circle.setDiameter(0,0,0,0);
                circle.setCenterX(); circle.setCenterY();
                break;
        }
        repaint();

    }


    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        //For debugging
        //System.out.println("mouseDragged " + "(" + e.getX() + ", " + e.getY() + ")");
        switch(shapeChoice){
            case 0 :
                triangle.setX2(e.getX());
                triangle.setY2(e.getY());
                break;
            case 1 :
                square.setX2(e.getX());
                square.setY2(e.getY());
                break;
            case 2:
                box.setX2(e.getX());
                box.setY2(e.getY());
                break;
            case 3:
                circle.setX2(e.getX());
                circle.setY2(e.getY());
                circle.setDiameter(circle.getX1(),circle.getY1(),circle.getX2(),circle.getY2());
                circle.setCenterX(); circle.setCenterY();
                break;
        }

        repaint();

    }
    public static String positionFormat(int x, int y){
        return "["+ x + "," + y + "]";
    }

    public void mouseMoved(MouseEvent e) {
        this.xMove = e.getX();
        this.yMove = e.getY();
        //System.out.println("mouseMoved " + "(" + getxMove() + ", " + getyMove() + ")");
    }

    public int getxMove() {
        return xMove;
    }

    public int getyMove() {
        return yMove;
    }

    public int getShapeChoice() {
        return shapeChoice;
    }

    public int getColorChoice() {
        return colorChoice;
    }

    public void setShapeChoice(int shapeChoice) {
        this.shapeChoice = shapeChoice;
    }

    public void setColorChoice(int colorChoice) {
        this.colorChoice = colorChoice;
    }



}
