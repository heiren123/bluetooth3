package sixchess;

import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * 关于类
 * @author BeeHive
 *
 */
public class AboutPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawString("计算机博弈--六子棋程序", 25, 30);
		g.drawString("-----version 1.0", 65, 60);
		g.drawString("---@尉安瑞", 70, 90);
	}

}
