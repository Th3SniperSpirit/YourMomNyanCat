import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JApplet;
import java.util.concurrent.TimeUnit;
import java.util.Random.*;
import java.beans.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
import java.util.Scanner;
 import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;

public class Brush1 extends JApplet 
   implements MouseMotionListener, MouseListener {
   
   int width, height;
   Image backbuffer;
   Graphics backg;
   String shape;
   int brushnum;
   int dragRx;
   int dragRy;
   Rectangle dragR;
   JFrame title;   
   ArrayList<Rectangle> clickDrag;
   Point p;
   Color color;
   int i;
   int lineX;
   int lineY;
   String input;
   BufferedImage upload;
  
        
      
      //paint colors:
   Color blue = Color.blue;
   Color red = Color.red;
   Color pink = Color.pink;
   Color orange = Color.orange;
   Color gray = Color.gray;

      //cheap way of making eraser:
   Color eraser = Color.black;
   
   public static void wait (int n){
      long t0,t1;
      t0=System.currentTimeMillis();
      do{
         t1=System.currentTimeMillis();
      }
        while (t1-t0<1000);
   }
     
  
 
      
   
   public void init() {
   

   requestFocus();
      System.out.println("Welcome to PAINT.mes!");
       
      shape = "circle";
      width = getSize().width*2;
      height = getSize().height*2;
      clickDrag = new ArrayList<Rectangle>();   
         
   
      
     
      
      backbuffer = createImage( width, height );
      backg = backbuffer.getGraphics();
      setSize(width,height);
      backg.setColor( Color.black );
      backg.fillRect( 0, 0, width, height );
      backg.setColor( Color.white );
      
      
      
      //box that if dragged onto will make the color random
         
      
      //creates the second rectangle
        
         
       //vertical line
      backg.drawLine(50,0,50,height); //from (0,50) to (50,height)
      backg.drawLine(0,50,50,50);
      backg.drawLine(0,100,50,100);
      backg.drawLine(0,150,50,150);
      backg.drawLine(0,200,50,200);
      backg.drawLine(0,250,50,250);
      backg.drawLine(0,300,50,300);
      backg.drawLine(0,350,50,350);
      backg.drawLine(0,400,50,400);
       
      backg.setColor(red);
      backg.fillRect(0,0,50,50);
       
      backg.setColor(blue);
      backg.fillRect(0,50,50,50);
       
      backg.setColor(pink);
      backg.fillRect(0,100,50,50);
       
      backg.setColor(orange);
      backg.fillRect(0,150,50,50);
       
      backg.setColor(Color.gray);
      backg.fillRect(0,200,50,50);
      
      backg.setColor(Color.white);
      backg.fillRect(0,400,50,50);
      
      backg.setColor(Color.orange);
      backg.fillRect(0,450,50,50);
      backg.setColor(Color.black);
      backg.drawString("Drag",10,475);
      
      backg.setColor(Color.white);
      backg.fillRect(0,500,50,50);
      backg.setColor(Color.black);
      backg.drawString("Line",10,525);
      
       backg.setColor(Color.blue);
      backg.fillRect(0,550,50,50);
      backg.setColor(Color.yellow);
      backg.drawString("Image",10,575);
       
      backg.setColor(Color.white);
      backg.fillRect(0,250,50,50);
      backg.setColor(Color.black);
      backg.drawString("Eraser",10,290);
       
      backg.setColor(Color.green);
      backg.fillRect(0,300,50,50);
       
      
      backg.setColor(Color.black);
      backg.drawString("Box",10,340);
      backg.setColor(Color.yellow);
      backg.drawString("Circle",10,390);
      backg.setColor(Color.black);
      backg.drawString("Rect",10,420);
      backg.drawString("angle",10,430);
      
      
      
    backg.setColor(Color.white); //defaultColor
    shape = "circle"; //default shape
    
    // ***TO DO LIST***
    //1. brush size changer pop up text box w/ scanner input
    //2. try to fix rectangle mover (possibly need massive code rework
    //3. Save file 
    //4. text tool
    //5. image uploader \-\(done)
    //6. sound uploader /--will need save file thing for these too
    //7. resize tool
    //8. line tool (done)
    
       
       
       
      
      
      
      addMouseMotionListener( this );
      addMouseListener(this);
   }
   
   
   
   public void mouseMoved( MouseEvent e ) {
      int x = e.getX();
      int y = e.getY();
      showStatus(x + " , " + y + "     BRUSH SIZE: " + brushnum + "     Shape selected: " + shape);
          
        
          
          
    
   }
   public void mouseDragged( MouseEvent e ) {
      int x = e.getX();
      int y = e.getY();
        p = new Point(x,y);
      
    
        
      //add slider here for brush size
      
      if(x>60){
      
         if(shape.equals("circle")){
            backg.fillOval(x-5,y-5,10+brushnum,10+brushnum);
            repaint();
          
         }
         
         if(shape.equals("square"))
         {
            backg.fillRect(x-5,y-5,10+brushnum,10+brushnum);
            repaint();
           
         }
      
      
      }
      
         
          /*  backg.setColor(Color.black);
            backg.drawRect((int)clickDrag.get(i).getX(),(int)clickDrag.get(i).getY(),(int)clickDrag.get(i).getWidth(),(int)clickDrag.get(i).getHeight());
          
           }
            clickDrag.get(i).setLocation(p);
         backg.setColor(color);
        backg.drawRect(e.getX(),e.getY(),(int)clickDrag.get(i).getWidth(),(int)clickDrag.get(i).getHeight());
      
                  
      }
      }*/
      
    
      
      
   }
   

        
      
      
      
   public void mouseEntered( MouseEvent e ) { }
  
   public void mouseExited( MouseEvent e ) { }
  
   public void mouseClicked( MouseEvent e ) { 
      int x = e.getX();
      int y = e.getY();
      if(y >= 0 && x>=0 & x<=50 & y<=50)
      {
         color = red;
         backg.setColor(color);
      }
      if(y >= 50 && x>=0 & x<=50 & y<=100)
      {
         color = blue;
         backg.setColor(color);
      }
      if(y >= 100 && x>=0 & x<=50 & y<=150)
      {
         color = pink;
         backg.setColor(color);
      }
      if(y >= 150 && x>=0 & x<=50 & y<=200)
      {
         color = orange;
         backg.setColor(color);
      }
      if(y >= 200 && x>=0 & x<=50 & y<=250)
      {
         init();
      }
      if(y >= 250 && x>=0 & x<=50 & y<=300)
      { 
         shape = "circle";
         backg.setColor(eraser);
      }
      if(y>=300 && x>=0 & x<=50 & y<=350)
      {
         shape = "square";
      }
      if(y>=350 && x>=0 & x<= 50 & y<=400){
         shape = "circle";
      }
      if(y>=400 && x>=0 & x<= 50 & y <=450){
         shape = "rectangle";
      }
      if(y>450 && x>=0 && x<= 50 && y <=500){
         shape = "drag";
      }
      if(y>500 && x >=0 && x<=50 && y <=550){
         shape = "line";
      }
      
      if(y >550 && x >=0 && x<=50 && y <= 600){
      System.out.println("Enter image file :D");
      Scanner scan = new Scanner(System.in);
      input = scan.next();
      
       backg.drawImage(ImgMaker.getImage(input), 50, 50, null);
       
     
         }
      
      repaint();
   
   }
   
   
   public void mouseReleased( MouseEvent e ) {
      int endx = e.getX();
      int endy = e.getY();
      int x = e.getX();
      int y = e.getY();
      int m = i;
    
     Point t = new Point(x,y);
     
     /*(if(shape.equals("drag") && x>50){
      backg.setColor(color);
       backg.drawRect(x,y,(int)clickDrag.get(m).getWidth(),(int)clickDrag.get(m).getHeight());

     }*/
     
     //^ drag tool removed temporary
      
           
      if(shape.equals("rectangle") && dragRx < endx && dragRy < endy && x >50){ //down right
         dragR = new Rectangle(dragRx,dragRy,endx-dragRx,endy-dragRy);
         backg.drawRect((int)dragR.getX(),(int)dragR.getY(),(int)dragR.getWidth(),(int)dragR.getHeight());
         clickDrag.add(dragR);
         System.out.println(clickDrag.size());
      }
      if(shape.equals("rectangle") && dragRx > endx && dragRy < endy && x > 50){ //down left
         dragR = new Rectangle(endx,dragRy,dragRx-endx,endy-dragRy);
         backg.drawRect((int)dragR.getX(),(int)dragR.getY(),(int)dragR.getWidth(),(int)dragR.getHeight());
         clickDrag.add(dragR);
      }
      if(shape.equals("rectangle") && dragRx < endx && dragRy > endy && x >50){ //up right
         dragR = new Rectangle(dragRx,endy,endx-dragRx,dragRy-endy);
         backg.drawRect((int)dragR.getX(),(int)dragR.getY(),(int)dragR.getWidth(),(int)dragR.getHeight());
         clickDrag.add(dragR);
      }
      if(shape.equals("rectangle") && dragRx > endx && dragRy > endy && x > 50){ //up left
         dragR = new Rectangle(endx,endy,dragRx-endx,dragRy-endy);
         backg.drawRect((int)dragR.getX(),(int)dragR.getY(),(int)dragR.getWidth(),(int)dragR.getHeight());
         clickDrag.add(dragR);
      }
      
      if(shape.equals("line") && x > 50){
         backg.drawLine(lineX,lineY,endx,endy);
         }
      
     
      repaint();
   
   
   
   }
   
   public void mousePressed( MouseEvent e ) {
      int y = e.getY();
      int x = e.getX();
      p = new Point(x,y);
      
      if(shape.equals("rectangle") && x > 50){
         dragRx = e.getX();
         dragRy = e.getY();
      }
      
      if(shape.equals("line") && x > 50){
         lineX = e.getX();
         lineY = e.getY();
         }
      
      /*
      if(shape.equals("drag") && x > 50){
      for(i = 0; i < clickDrag.size()-1; i++){
         if(clickDrag.get(i).contains(p)){
         clickDrag.remove(i);
           backg.setColor(Color.black);
           backg.drawRect((int)clickDrag.get(i).getX(),(int)clickDrag.get(i).getY(),(int)clickDrag.get(i).getWidth(),(int)clickDrag.get(i).getHeight());
           System.out.println("HI");
           i--;
           }
         }
         }*/
         
      
   
      repaint();
      
   }
      
      
      
   
   public void update( Graphics g ) {
      g.drawImage( backbuffer, 0, 0, this ); 
      
   }
   
   public void paint( Graphics g ) {
      
      update( g );
      	
          
      
   }
   
    
}