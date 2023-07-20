import java.awt.Graphics;
public class Triangle extends Point{
    private int base;
    private int height;
    Triangle(int x1, int y1, int x2, int y2){
        super(x1, y1, x2, y2);
    }

    public void draw(Graphics g){
        setBase(); setHeight();

        //Line1 (Top to bottom right)
        g.drawLine(getX1(),getY1(),getX1()+base,getY1()+height);
        g.drawString(GraphicsPanel.positionFormat(getX1(),getY1()), getX1(),getY1()-8 );

        //Line2 ( bottom right to bottom left )
        g.drawLine(getX1()+base,getY1()+height,getX1()-base,getY1()+height);
        g.drawString(GraphicsPanel.positionFormat(getX1()+base,getY1()+height), getX1()+base,getY1()+height +13);

        //Line3
        g.drawLine(getX1()-base,getY1()+height, getX1(),getY1() );
        g.drawString(GraphicsPanel.positionFormat(getX1()-base,getY1()+height), getX1()-base,getY1()+height +13);
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    public void setBase() {
        this.base = getX2()-getX1();
    }

    public void setHeight() {
        this.height = getY2()-getY1();
    }
}
