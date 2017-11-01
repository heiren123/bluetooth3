package sixchess;

import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
/**
 * 棋盘窗口类
 * @author BeeHive
 *
 */
public class ChessFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int line = 19;//棋盘路数
	private int width = line*30+40;//棋盘宽度
	private int height = line*30+80;//棋盘高度
	private int w = Toolkit.getDefaultToolkit().getScreenSize().width;//屏幕宽度
	private int h = Toolkit.getDefaultToolkit().getScreenSize().height;//屏幕高度
	private MainPanel p;//定义画板对象变量
	/**
	 * ChessFrame类的构造函数
	 */
	public ChessFrame() {
		// TODO Auto-generated constructor stub
		this.setSize(width, height);
		this.setLocation((w-width)/2, (h-height)/2);
		this.setResizable(false);
		
		JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);
		
		
		JMenu m1 = new JMenu("游戏");
		JMenu m2 = new JMenu("视图");
		JMenu m3 = new JMenu("帮助");
		
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		
		JMenuItem m1_1 = new JMenuItem("开局");
		JMenuItem m1_2 = new JMenuItem("悔棋");
		JMenuItem m1_3 = new JMenuItem("退出");
		JMenuItem m3_1 = new JMenuItem("关于");
		
		
		JMenu s1_1 = new JMenu("模式");
		JRadioButtonMenuItem item1_5 = new JRadioButtonMenuItem("人机对弈");
		JRadioButtonMenuItem item1_6 = new JRadioButtonMenuItem("人人对弈");
		item1_6.setSelected(true);
	    ButtonGroup g1 = new ButtonGroup();
	    g1.add(item1_5);
	    g1.add(item1_6);
	    s1_1.add(item1_5);
	    s1_1.add(item1_6);
	   
		JMenu s1_2 = new JMenu("先手顺序");
		JRadioButtonMenuItem item1_7 = new JRadioButtonMenuItem("玩家先手");
		JRadioButtonMenuItem item1_8 = new JRadioButtonMenuItem("计算机先手");
		item1_6.setSelected(true);
	    ButtonGroup g2 = new ButtonGroup();
	    g2.add(item1_7);
	    g2.add(item1_8);
	    s1_2.add(item1_7);
	    s1_2.add(item1_8);
		
	    m1.add(m1_1);
	    m1.add(m1_2);
	    m1.add(s1_2);
	    m1.add(s1_1);
	    m1.addSeparator();
	    m1.add(m1_3);
	    m3.add(m3_1);

	    /**
	     * 添加面板		
	     */
		Container con = this.getContentPane();
	    p = new MainPanel();
		con.add(p);
		
		m1_1.addActionListener(new StartListener());
	    m1_3.addActionListener(new ExitListener());
	    m3_1.addActionListener(new AboutListener());
	    

	}
	/**
	 * 退出按钮
	 * @author BeeHive
	 *
	 */
	private class ExitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}

	/**
	 * 关于按钮
	 * @author BeeHive
	 *
	 */
	private class AboutListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	JDialog dialog = new JDialog(ChessFrame.this,"关于窗体");
	    	dialog.setSize(200,150);
	    	dialog.setLocation(500, 450);
	    	dialog.setVisible(true);
	    	dialog.getContentPane().add(new AboutPanel());
	    }
	}
	/**
	 * 开局按钮
	 * @author BeeHive
	 *
	 */
	private class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			p.setOver(false);
			p.setChessNumber(1);
			int[][] a = p.getArr();
			for(int i = 0;i<line;i++){
				for(int j = 0;j<line;j++){
					a[i][j] = 0;
					p.repaint();//重新绘制
				}
			}
		}
	}

}
