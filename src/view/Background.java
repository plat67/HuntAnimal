package view;
import java.awt.*;

import javax.swing.*;
public class Background extends JPanel{
	private Image bg;
	
	public Background(Image image) {
		this.bg=image;
	}

	
	public void paintComponent(Graphics g) {
        // Display image at at full size
        g.drawImage(bg, 0, 0, null);
        setOpaque(false);
        super.paintComponent(g);
    }

}
