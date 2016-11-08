import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import javax.imageio.*;
import java.io.*;

public class ImgMaker { 
	public static BufferedImage getImage(String filename) { 
		BufferedImage img = null;
		try { 
			img = ImageIO.read(new File(filename));
		} catch(IOException ioe) { 
			ioe.printStackTrace();
		} finally { 
			if(img == null) { 
				System.err.println(filename+" could not be located.");
				return null;
			}
		}
		return img;
	}
}