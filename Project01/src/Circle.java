import java.awt.Graphics;

public class Circle extends Point{
    private int radius;
    private int centerX, centerY;

    Circle(int x1, int y1, int x2, int y2){
        super(x1, y1, x2, y2);
        setDiameter(x1, y1, x2, y2);
    }

    public void draw(Graphics g){

        //(x1,y1, x2,y2)
        g.drawOval(getCenterX() - getRadius(),
                getCenterY() - getRadius(),
                getRadius()*2,
                getRadius()*2);

        g.drawOval(getCenterX()-2,
                getCenterY() -2,
                2,
                2);

        g.drawString(GraphicsPanel.positionFormat(getX1(),getY1()),getCenterX()-25,getCenterY()-10);




    }

    public int getRadius() {
        return radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setDiameter(int x1, int y1, int x2, int y2) {
        // this is difference of x1 x2 and y1 y2
        int x = Math.abs(x2-x1);
        int y = Math.abs(y2-y1);


        this.radius = Math.max(x,y);
    }

    public void setCenterX() {
        this.centerX = getX1();
    }

    public void setCenterY() {
        this.centerY = getY1();
    }
}
