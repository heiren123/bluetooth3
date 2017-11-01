package sixchess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 棋盘面板类
 * @author BeeHive
 *
 */
public class MainPanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int length = 19;//棋盘路数
	private int arr[][] = new int[19][19];//棋盘二维数组
	private boolean isOver = true;//棋局输赢状态变量
	private boolean isBlack = true;//当前下子颜色
	private int nowChessColor;
	private int chessNumber = 1;//将下一方棋子的数目
	/**
	 * 构造函数
	 */
	public MainPanel() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.cyan);
	}
	/**
	 * 用背景色重画面板方法
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(int i = 0;i<length;i++){
			g.drawLine(30, 30*i+30, 570,30*i+30);
			g.drawLine(30*i+30, 30,  30*i+30,570);
			g.drawString(""+(char)('A'+i), 27+i*30,20);
			g.drawString(""+(char)('A'+i), 10,35+i*30);
		}
		/**
		 * 遍历数组，绘制棋盘
		 */
      for(int i = 0;i<length;i++){
    	  for(int j = 0;j<length;j++){
    		  if(arr[i][j] == 1){
    			  g.setColor(Color.black);
    			  g.fillOval(20+30*i, 20+30*j, 20, 20);
    			  
    		  }else if(arr[i][j] == 2){
    			  g.setColor(Color.black);
    			  g.drawOval(20+30*i, 20+30*j, 20, 20);
    			  g.setColor(Color.white);
    			  g.fillOval(20+30*i, 20+30*j, 20, 20);
    		  }
    	  }
      }
	this.addMouseListener(this);//添加鼠标事件
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		//鼠标点击的事件
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		//鼠标按下的事件
		if(!isOver){
		  int tempx = (e.getX()+15)/30;
		  int tempy = (e.getY()+15)/30;
			if(tempx>0&&tempx<=19&&tempy>0&&tempy<=19){
				if(arr[tempx-1][tempy-1] == 0){
					if(isBlack){
					arr[tempx-1][tempy-1] = 1;
					chessNumber--;
					nowChessColor = 1;
					if(chessNumber==0){
						isBlack = false;
						chessNumber = 2;
					}
				}else {
					arr[tempx-1][tempy-1] = 2;
					chessNumber--;
					nowChessColor = 2;
					if(chessNumber == 0){
						isBlack = true;
						chessNumber = 2;
					}
					
					
				 }
					isWin(tempx,tempy);//调用判断输赢的函数
				}
				else {}
				
			}
		}
		
		
		
		repaint();
		
	}
	public void mouseReleased(java.awt.event.MouseEvent e) {
	}
	public void mouseEntered(java.awt.event.MouseEvent e) {
	}
	public void mouseExited(java.awt.event.MouseEvent e) {
	}
	int count;
	/**
	 * 判断输赢的函数
	 * @param x 当前下子的x
	 * @param y 当前下子的y
	 */
	public void isWin(int x,int y){
		count = 1;
		/**
		 * 横向
		 */
		for(int n = x+1;n<=19;n++){
			if(arr[n-1][y-1] == nowChessColor){
				count++;
			}else break;//防止隔子
		}
		for(int n = x-1;n>0;n--){
			if(arr[n-1][y-1] == nowChessColor){
				count++;
			}else break;//防止隔子
		}
		if(count>=6){
			if(nowChessColor ==1){
				JOptionPane.showMessageDialog(this, "黑棋赢了！！！");
			}else JOptionPane.showMessageDialog(this, "白棋赢了！！！");
			isOver = true;
		}
		
		/**
		 * 纵向
		 */
		count = 1;
		for(int m = y+1;m<=19;m++){
			if(arr[x-1][m-1] == nowChessColor){
				count++;
			}else break;//防止隔子
		}
		for(int m = y-1;m>0;m--){
			if(arr[x-1][m-1] == nowChessColor){
				count++;
			}else break;//防止隔子
		}
		if(count>=6){
			if(nowChessColor ==1){
				JOptionPane.showMessageDialog(this, "黑棋赢了！！！");
			}else JOptionPane.showMessageDialog(this, "白棋赢了！！！");
			isOver = true;
		}

		/**
		 * 斜向
		 */	
		count = 1;
		for(int n = x+1,m = y+1;n<=19&&m<=19;n++,m++){
			if(arr[n-1][m-1] == nowChessColor){
				count++;
			}else break;//防止隔子
		}
		for(int n = x-1,m = y-1;n>0&&m>0;n--,m--){
			if(arr[n-1][m-1] == nowChessColor){
				count++;
			}else break;//防止隔子
		}
		if(count>=6){
			if(nowChessColor ==1){
				JOptionPane.showMessageDialog(this, "黑棋赢了！！！");
			}else JOptionPane.showMessageDialog(this, "白棋赢了！！！");
			isOver = true;
		}
		/**
		 * 反斜向
		 */	
		count = 1;
		for(int n = x+1,m = y-1;n<=19&&m>0;n++,m--){
			if(arr[n-1][m-1] == nowChessColor){
				count++;
			}else break;//防止隔子
		}
		for(int n = x-1,m = y+1;n>0&&m<=19;n--,m++)
		{
			if(arr[n-1][m-1] == nowChessColor){
				count++;
			}else break;//防止隔子
		}
		if(count>=6){
			if(nowChessColor ==1){
				JOptionPane.showMessageDialog(this, "黑棋赢了！！！");
			}else JOptionPane.showMessageDialog(this, "白棋赢了！！！");
			isOver = true;
		}
		
	}
	/**
	 * 获取棋盘的 二维数组
	 * @return 返回棋盘二维数组的首地址
	 */
	public int[][] getArr() {
		return arr;
	}
	/**
	 *   设置棋局输赢状态变量的值
	 * @param isOver 将此值赋值给棋盘输赢状态变量
	 */
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	/**
	 * 设置将要下子的棋子数目
	 * @param chessNumber 将该变量赋值给棋子数目的变量
	 */
	public void setChessNumber(int chessNumber) {
		this.chessNumber = chessNumber;
	}
	
}
