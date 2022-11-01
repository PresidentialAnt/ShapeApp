import shapes.Circle;
import shapes.Rect;
import shapes.Square;
import shapes.Shape;
import java.util.concurrent.ThreadLocalRandom;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Drawing extends Canvas {
    Point p=new Point(200,200);
    Color c=new Color(0x992266);//test
    Circle circ= new Circle(p, c, 50);
    Point p2= new Point(250,250);
    Color c2= new Color(0x536733);
    Rect rect = new Rect(p2, c2, 25,40);
    Point p3= new Point(210,210);
    Color c3= new Color(0x5767e3);
    Square squ = new Square(p3,c3,35);

    ArrayList<Shape> shapeArrayList = new ArrayList<>();


    private Frame f;

    public Drawing(){
        setupFrame();
        setupCanvas();
        for(int i=0; i<20;i++){
            int randomRad = ThreadLocalRandom.current().nextInt(30, 80 + 1);
            int randomX = ThreadLocalRandom.current().nextInt(0, 300 + 1);
            int randomY = ThreadLocalRandom.current().nextInt(0, 300 + 1);
            int randomColor=randomInt(0x000000, 0xFFFFFF);
            Color tmp_co= new Color(randomColor);
            Point tmp_p=new Point(randomX,randomY);
            Circle tmp_c=new Circle(tmp_p,tmp_co, randomRad);
            Shape tmp_s = tmp_c;
            shapeArrayList.add(tmp_s);
        }
        for(int i=0; i<20;i++){
            int randomWidth = ThreadLocalRandom.current().nextInt(30, 80 + 1);
            int randomHeight = ThreadLocalRandom.current().nextInt(30, 80 + 1);
            int randomX = ThreadLocalRandom.current().nextInt(0, 300 + 1);
            int randomY = ThreadLocalRandom.current().nextInt(0, 300 + 1);
            int randomColor=randomInt(0x000000, 0xFFFFFF);
            Color tmp_co= new Color(randomColor);
            Point tmp_p=new Point(randomX,randomY);
            Rect tmp_c=new Rect(tmp_p,tmp_co, randomWidth, randomHeight);
            Shape tmp_s = tmp_c;
            shapeArrayList.add(tmp_s);
        }
    }

    private void setupFrame() {
        f = new Frame("My window"); 	// Instantiates the Frame
        f.add(this);			// Adds the Canvas (ie this object) to the Frame
        f.setLayout(null);		// Stops the frame from trying to layout contents
        f.setSize(400, 400);		// Sets the dimensions of the frame
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {	// Closes the program if close window clicked
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }

    private void setupCanvas() {
        setBackground(Color.WHITE); 	// Sets the Canvas background
        setSize(400, 400);		// Sets the Canvas size to be the same as the frame
    }

    private int randomInt(int min, int max){
        int rand = min + (int)(Math.random() * (max - min)+1);
        return rand;
    }
    public void paint(Graphics g){
        circ.draw(g);
        rect.draw(g);
        squ.draw(g);
        for (Shape e:shapeArrayList){
            e.draw(g);
        }
    }
}
