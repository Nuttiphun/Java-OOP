import java.awt.Graphics;
public class Box extends Point{
    private int width, height, line;

    Box(int x1, int y1, int x2, int y2){
        super(x1, y1, x2, y2);

    }

    public void draw(Graphics g){
        setLine();

//***********************************************SQUARE1**********************************************************//
        // Square1 Line1 is the main point, so every line of this Box have relation with x1, y1
        //Line1 (Start from Upper Left to Upper Right)
        g.drawLine(getX1(),getY1(), getX1()+getLine(), getY1() );
        g.drawString(GraphicsPanel.positionFormat( getX1(),getY1() ), getX1(),getY1()-8 );

        //Line2
        g.drawLine(getX1()+getLine(),getY1(), getX1()+getLine(), getY1()+getLine());
        g.drawString(GraphicsPanel.positionFormat( getX1()+getLine(),getY1() ), getX1()+getLine(),getY1()-8 );


        //Line3
        g.drawLine(getX1()+getLine(),getY1()+getLine(), getX1(),getY1()+getLine());
        g.drawString(GraphicsPanel.positionFormat(
                getX1()+getLine(),getY1()+getLine() ), getX1()+getLine(),getY1()+getLine()+15 );

        //Line4
        g.drawLine(getX1(),getY1()+getLine(), getX1(),getY1());
        g.drawString(GraphicsPanel.positionFormat(
                getX1(),getY1()+getLine() ), getX1(),getY1()+getLine()+15 );
//***********************************************SQUARE1**********************************************************//

//***********************************************SQUARE2**********************************************************//
        int s2x1,s2y1; // square2 x1 and square2 y1
        s2x1 = getX1()+getLine()/2;
        s2y1 = getY1()-getLine()/2;

        //Line1 (Start from Upper Left to Upper Right)
        g.drawLine(s2x1,s2y1, s2x1+getLine(), s2y1 );
        g.drawString(GraphicsPanel.positionFormat( s2x1,s2y1 ), s2x1,s2y1-8 );

        //Line2
        g.drawLine(s2x1+getLine(), s2y1, s2x1+getLine(), s2y1+getLine() );
        g.drawString(GraphicsPanel.positionFormat( s2x1+getLine(), s2y1 ), s2x1+getLine(), s2y1-8 );

        //Line3
        g.drawLine(s2x1+getLine(), s2y1+getLine(), s2x1, s2y1+getLine());
        g.drawString(GraphicsPanel.positionFormat(
                s2x1+getLine(), s2y1+getLine() ), s2x1+getLine(), s2y1+getLine() +13 );

        //Line4
        g.drawLine(s2x1, s2y1+getLine(), s2x1,s2y1 );
        g.drawString(GraphicsPanel.positionFormat( s2x1, s2y1+getLine() ), s2x1, s2y1+getLine()+13 );

//***********************************************SQUARE2**********************************************************//


//***********************************************SQUARE3**********************************************************//
        //Line1 start from upper left to upper right
        g.drawLine(getX1(),getY1(),s2x1,s2y1);

        //Line2
        g.drawLine(getX1()+getLine(),getY1(), s2x1+getLine(), s2y1);

        //Line3 start from bottom right to bottom left
        g.drawLine(getX1()+getLine(), getY1()+getLine(), s2x1+getLine(),s2y1+getLine());

        //Line4
        g.drawLine(getX1(), getY1()+getLine(), s2x1,s2y1+getLine());
//***********************************************SQUARE3**********************************************************//


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
        setWidth( getX2() -getX1() );
        setHeight(getY2() - getY1());
        this.line = Math.max(getWidth(), getHeight());
    }
}
