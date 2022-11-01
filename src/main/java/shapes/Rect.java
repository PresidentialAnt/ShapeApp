package shapes;

import java.awt.*;

public class Rect extends Shape implements Drawable{
    private int height;	// Fields
    private int width;


    public Rect(Point initPos, Color col, int height, int width){
        super(initPos, col); // The constructor
        this.width=width;	// Initialize the fields of the object
        this.height=height;
    }

    public void draw(Graphics g) {	// A method that draws the object in g
        g.setColor(col);
        g.fillRect(pos.x,pos.y,width,height);

    }
}

