package Exercise9;

import java.io.FileInputStream;
import java.io.IOException;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Map extends Canvas {
	private final static int SQUARE_SIDE = 201;
	private final static int SQUARE_SIZE = SQUARE_SIDE * SQUARE_SIDE;

	private int[] map;
	private String filename;
	private Frame frm;

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
		frm.setSize(SQUARE_SIDE + 50, SQUARE_SIDE + 75);
		frm.setVisible(true);
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	} // Map

	public void paint(Graphics g) {
		for (int j = 0; j < SQUARE_SIDE; j++) {
			for (int i = 0; i < SQUARE_SIDE; i++) {
				int index = i * SQUARE_SIDE + j;
				if (map[index] < 60)
					g.setColor(new Color(0 + map[index] * 3,
							0 + map[index] * 3, 128));
				else if (map[index] < 150)
					g.setColor(new Color(0 + map[index] - 60, 128,
							0 + map[index] - 60));
				else
					g.setColor(new Color(128 - map[index] / 3,
							203 - map[index] / 2, 150 - map[index] / 2));
				g.drawLine(20 + i, 20 + j, 20 + i, 20 + j);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		Map map = new Map("mountains.map");
	}
} // class Map