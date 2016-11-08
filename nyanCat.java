   import java.awt.*;
   import java.awt.image.*;
   import java.applet.*;
   import javax.swing.*;
   import java.awt.geom.*;
   import sun.audio.*;
   import java.io.*;
   import java.net.*;
   import java.awt.event.*;
   import java.util.*;
	
	

   public class nyanCat extends JPanel implements Runnable, KeyListener, ActionListener
   {
      Scanner AdviceGiver;
      BufferedImage backbuffer;
      Graphics2D backg;
      int cat = 1;
      int[][] Stars = new int[15][4]; //position 0 is x; position 1 is y; position 2 is the Star's Image; position 3 is the # of times it has trun through it's animation.
      int x = 125;
      int y = 125;
      int rainbow = -10;
      int step = 1;
      ArrayList<Point2D.Double> awesomeTrail = new ArrayList<Point2D.Double>();
   	
      public static void main(String[] args)
      {
         yourmom.main(args);
      }
      public void keyPressed(KeyEvent e)
      {
         if (e.getKeyCode() == 37)
         {
            x -= 10;
         }
         if (e.getKeyCode() == 38)
         {
            y -= 10;
         }
         if (e.getKeyCode() == 39)
         {
            x += 10;
         }
         if (e.getKeyCode() == 40)
         {
            y += 10;
         }
         rainbowConstructor();
      }
      public void keyReleased(KeyEvent e)
      {
      }
      public void keyTyped(KeyEvent e)
      {
      }
      public nyanCat()
      {
         setSize(550,550);
         setFocusable(true);
         backbuffer = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
         backg = backbuffer.createGraphics();
         backg.setBackground(Color.PINK);
         for (int w = 0; w < 15; w++)
         {
            Stars[w][0] = (int)(Math.random() * 499 + 1);
            Stars[w][1] = (int)(Math.random() * 499 + 1);
            Stars[w][2] = (int)(Math.random() * 6 + 1);
            Stars[w][3] = -1;
         }
      }
      public void start()
      {
         sound();
         Thread cat = new Thread(this);
         cat.start();
         addKeyListener(this);
         rainbowConstructor();
      
      }
      public void run()
      {
         Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
         while(true)
         {	
            cat++;
            if (cat == 7)
               cat = 1;
            for (int q = 0; q < 15; q++)
            {
               Stars[q][0] -= 5;
               Stars[q][2] += 1;
               if (Stars[q][2] == 7)
               {
                  Stars[q][2] = 1;
                  Stars[q][3] += 1;
               }
               if (Stars[q][3] > 0)
               {
                  Stars[q][0] = (int)(Math.random() * 499 + 1);
                  Stars[q][1] = (int)(Math.random() * 499 + 1);
                  Stars[q][3] = -1;
               }
            }
            for (int f = 0; f < awesomeTrail.size(); f++)
            {
               awesomeTrail.get(f).setLocation(awesomeTrail.get(f).getX() - 20, awesomeTrail.get(f).getY());
               if (awesomeTrail.get(f).getX() < -20)
               {
                  awesomeTrail.remove(f);
                  f--;
               }
            }
            rainbowConstructor();
            repaint();
            try
            {
               Thread.sleep(50);
            }
               catch(InterruptedException ie){}
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
         }
      }
      public void update(Graphics g)
      {
         backg.setColor(Color.BLUE);
         backg.fillRect(0, 0, 1000, 1000);
         drawer();
         g.drawImage(backbuffer, 0, 0, this);
      }
      public void paint(Graphics g)
      {
         update(g);
      }
      public void drawer()
      {
         for (int e = 0; e < 15; e++)
         {
            starGetter(Stars[e]);
         }
         rainbowGetter(rainbow);
         catGetter(cat);
         
      }
      public void rainbowConstructor()
      {
        /* awesomeTrail.clear();
         for (int r = x + 80; r > -20; r -= 10)
         {
            	awesomeTrail.add(new Point2D.Double(r, 0));//((y + 60) * r)/(x + 80) + 250 - (250/(250 / r))));
         }
         for (int l = 0; l < awesomeTrail.size(); l++)
      	{
      		awesomeTrail.set(l, new Point2D.Double(awesomeTrail.get(l).getX(), 175 - ((double)awesomeTrail.size() - l) * (double)((175 - y - 60) / (double)awesomeTrail.size()) ));// 250 - 250 * l * y  ));
      	}*/
         awesomeTrail.add(new Point2D.Double(x + 70, y + 60));
         awesomeTrail.add(new Point2D.Double(x + 80, y + 60));
      }
      public void rainbowGetter(int rainbowTrail)
      {
      	try
      	{
         for (int d = 0; d < awesomeTrail.size(); d++)
         {
            backg.drawImage(ImgMaker.getImage("Rainbow.png"),
               new AffineTransformOp(AffineTransform.getScaleInstance(.5, .5), null),
               (int)awesomeTrail.get(d).getX(),(int)awesomeTrail.get(d).getY());//285 + (y - 225 + rainbowTrail));
         }
         }catch(Exception e){}
      	
      	/*if(step == 1 || step == 2)
      	{
      		rainbow += 10;
      	}
      	else
      	{
      		rainbow -= 10;
      		if( step == 4 )
      			step = 0;
      	}
      	step++;*/
      }
      public void catGetter(int dog)
      {
         backg.drawImage(ImgMaker.getImage("Nyan Cat " + dog + ".png"), x, y, null);
      }
      public void starGetter(int[] sun)
      {
         backg.drawImage(ImgMaker.getImage("star " + sun[2] + ".png"),
            new AffineTransformOp(AffineTransform.getScaleInstance(5, 5),
            null),
            sun[0], sun[1]);
      }
   
      public void sound()
      {
         try { 
            URL u = getClass().getResource("NyaNyaNyan.wav");
         	//URL u = getClass().getResource("rastley.jar");
            InputStream in = u.openStream();
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);
         } 
            catch(FileNotFoundException fnfe) { ; }
            catch(IOException ioe) { ; }
      }
   	
      public void Button()
      {
         Object[] options = { "Need moar advice?", "Or not?" };
         if(JOptionPane.showOptionDialog(null, AdviceGetter(), "Warning",
         JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
         new ImageIcon("Nyan Cat 1.png"), options, options[0]) == 0)
         {
            Button();
         }
         else
         {
            requestFocus();
         }
      }
   	
      public void actionPerformed(ActionEvent o)
      {
         JButton Src = (JButton)o.getSource();
         if(Src.getText().equals( "Advice?"))
            Button();
      }
   	
      public String AdviceGetter()
      {
         try
         {
            AdviceGiver = new Scanner(new File("Advice"));
         }
            catch(FileNotFoundException q){
               return null;}
         int pie = (int)(Math.random() * 76 + 1);
         int cake = 0;
         while(AdviceGiver.hasNextLine())
         {
         	System.out.println(cake);
            cake++;
            if(cake == pie)
            {
               return AdviceGiver.nextLine();
            }
            AdviceGiver.nextLine();
         	
         }
      	
         return AdviceGiver.nextLine();
      }
   		
   }