package shapes;

import java.awt.*;

public class Circle extends Shape implements Drawable{
    private int rad;	// Fields


    public Circle(Point initPos, Color col, int radius){ // The constructor
        super(initPos,col);
        rad=radius;	// Initialize the fields of the object
    }

    public void draw(Graphics g) {	// A method that draws the object in g
        g.setColor(col);
        g.fillOval(pos.x,pos.y,rad, rad);
    }
}

