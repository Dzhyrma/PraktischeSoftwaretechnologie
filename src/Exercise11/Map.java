package Exercise11;

import java.io.FileInputStream;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

import javax.swing.event.MouseInputAdapter;

@SuppressWarnings("serial")
public class Map extends Canvas {
	private final static int SQUARE_SIDE = 201;
	private final static int SQUARE_SIZE = SQUARE_SIDE * SQUARE_SIDE;

	static private double angle = 0;
	private int[] map;
	private String filename;
	private Frame frm;
	private Image bufImage;

	public int[] RotateCoordX(int[] coords) {
		int[] result = new int[3];
		result[0] = coords[0];
		result[1] = (int) Math.round(coords[1] * Math.cos(angle) - coords[2]
				* Math.sin(angle));
		//result[2] = (int) Math.round(coords[1] * Math.sin(angle) + coords[2]* Math.cos(angle));
		return result;
	}

	public void readMapFromFile() throws IOException {
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(filename);
			int i = 0;
			while (i < SQUARE_SIZE && (map[i] = fstream.read()) != -1)
				i++;
		} finally {
			if (fstream != null)
				fstream.close();
		}
	}

	public Map(String filename) throws IOException {
		this.filename = filename;
		map = new int[SQUARE_SIZE];
		readMapFromFile();
		frm = new Frame(filename);
		frm.add(this);
		frm.setSize(SQUARE_SIDE + 50, SQUARE_SIDE + 150);
		frm.setVisible(true);
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		MyListener ml = new MyListener();
		this.addMouseListener(ml);
		this.addMouseMotionListener(ml);
	} // Map

	public void paint(Graphics gBuf) {
		if (bufImage==null){
            bufImage = createImage(getWidth(), getHeight());
            
        }else
		gBuf.drawImage(bufImage, 0,0,this);
		bufImage = createImage(getWidth(), getHeight());
		Graphics g = bufImage.getGraphics();
        //Get width and height of current clip
        
		int[] coords = new int[3];
		int[] oldX = new int[SQUARE_SIDE];
		int[] oldY = new int[SQUARE_SIDE];
		int lastX = 0, lastY = 0;
		for (int j = 0; j < SQUARE_SIDE; j++) {
			for (int i = 0; i < SQUARE_SIDE; i++) {
				int jNew = ((angle < Math.PI) ? j : (SQUARE_SIDE - 1 - j));
				int index = i * SQUARE_SIDE + jNew;
				if (map[index] < 60)
					g.setColor(new Color(0 + map[index] * 3,
							0 + map[index] * 3, 128));
				else if (map[index] < 150)
					g.setColor(new Color(0 + map[index] - 60, 128,
							0 + map[index] - 60));
				else
					g.setColor(new Color(128 - map[index] / 3,
							203 - map[index] / 2, 150 - map[index] / 2));
				coords = RotateCoordX(new int[] { i, jNew - 100, map[index] / 2});
				if (j > 0 && i > 0) {
					g.fillPolygon(new int[] { 20 + oldX[i - 1], 20 + oldX[i],
							20 + coords[0], 20 + lastX }, new int[] {
							156 + oldY[i - 1], 156 + oldY[i], 156 + coords[1],
							156 + lastY }, 4);
					/*g.fillPolygon(new int[] { 20 + oldX[i - 1]*2, 20 + oldX[i]*2,
							20 + coords[0]*2, 20 + lastX*2 }, new int[] {
							255 + oldY[i - 1]*2, 255 + oldY[i]*2, 255 + coords[1]*2,
							255 + lastY*2 }, 4);*/
				}
				oldX[i == 0 ? SQUARE_SIDE - 1 : i - 1] = lastX;
				oldY[i == 0 ? SQUARE_SIDE - 1 : i - 1] = lastY;
				lastX = coords[0];
				lastY = coords[1];
			}
		}
		gBuf.drawImage(bufImage, 0,0,this);
		}

	public static void main(String[] args) throws IOException {
		if (args.length > 0)
			try {
				angle = Math.toRadians(Integer.parseInt(args[0]));
				if (angle < 0 || angle > 90)
				{
					angle = 0;
					System.out.printf("Angle muste between 0 and 90");
				}
			} catch (NumberFormatException nfe) {
				System.out.printf("Try to use numbers as argument");
			}
		@SuppressWarnings("unused")
		Map map = new Map("mountains.map");
	}

	private class MyListener extends MouseInputAdapter {
		private int oldY = 0;

		public void mouseDragged(MouseEvent e) {
			if (Math.abs(oldY - e.getY()) < 100) {
				angle = (angle + (e.getY() - oldY) / 180. + 2 * Math.PI)
						% (2 * Math.PI);
				Map.this.repaint();
			}
			oldY = e.getY();

		}
	}
} // class Map