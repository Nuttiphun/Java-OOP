import java.awt.Graphics;
public class Square extends Point{
    private int width, height, line;
    Square(int x1, int y1, int x2, int y2){
        super(x1,y1,x2,y2);
    }

    public void draw(Graphics g){
        setWidth(getX2() - getX1() );
        setHeight(getY2() - getY1() );
        setLine();

        //Line1 (Start from Upper Left to Upper Right)
        g.drawLine(getX1(),getY1(), getX1()+getLine(), getY1() );
        g.drawString(GraphicsPanel.positionFormat( getX1(),getY1() ), getX1(),getY1()-10 );

        //Line2
        g.drawLine(getX1()+getLine(),getY1(), getX1()+getLine(), getY1()+getLine());
        g.drawString(GraphicsPanel.positionFormat( getX1()+getLine(),getY1() ), getX1()+getLine()+10,getY1() );


        //Line3
        g.drawLine(getX1()+getLine(),getY1()+getLine(), getX1(),getY1()+getLine());
        g.drawString(GraphicsPanel.positionFormat(
                getX1()+getLine(),getY1()+getLine() ), getX1()+getLine()+10,getY1()+getLine()+13 );

        //Line4
        g.drawLine(getX1(),getY1()+getLine(), getX1(),getY1());
        g.drawString(GraphicsPanel.positionFormat(
                getX1(),getY1()+getLine() ), getX1(),getY1()+getLine()+13 );

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLine() {
        return line;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height ;
    }

    public void setLine() {
        this.line = Math.max(getWidth(), getHeight());
    }
}
