import java.awt.*;
import javax.swing.*;

//Panel Class Extension
public class Drawer extends JPanel{
	//Serial Version UID
	private static final long serialVersionUID = 1L;
	//Map and Shape tables
	private int[][] boxmap = new int[25][10];
	private int[][] shape = new int[4][4];
	//Coordinates indicating shape position along with a string for output
	public int sx = 0, sy = 0;
	private String navis ;
	//
	//_______________________________________________________________________________________________________________
	//
	//_______________________________________________________________________________________________________________
	//
	//_______________________________________________________________________________________________________________
	
	
	//"Painting MainLoop"
	//....the "Frame" renderer
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		navis = String.format("	Position : X: %d , Y: %d " ,sx ,sy);
		//Basic steps for proceeding to the next frame, append to each individual function for further explanation
		shapeChange();
		printShape();
		paintMap(g);
		allClear();
		update();
	}
	
	//
	public void paintMap(Graphics g) {
		g.setColor(Color.RED);
		for(int j=0;j<10;j++) {
			for(int i=0;i<25;i++) {
				if(boxmap[i][j]!=0)
				g.fillRect(10 + j*20, 20 + i*20, 20, 20);
				g.drawRect(10 + j*20, 20 + i*20, 20, 20);
				g.drawString(navis,220,220);
			}
		}
	}
	
	// Function for customizing the shape ( through its table )
	public void shapeChange(){
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++) {
				shape[i][j] = 1;
			}
	}
	
	// The shape gets printed on the map according to the current coordinates
	public void printShape(){
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++){
				boxmap[i + sx][j + sy] = shape[i][j];
			}
	}
	// Attempt (try) to drop the shape by 1 block
	public void update(){
		try{
			Thread.sleep(150);
			sx = (sx + 1) % 22;
		}
		catch(Exception e){}
		repaint();
	}
	
	public void allClear() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j<25; j++) {
				boxmap[j][i] = 0;
			}
		}
	}
	//Clear the ceiling-line that was just drawn by the printShape()
	/*public void clear(){
		 	// If its dropping -> clear ceiling line
			if(sx > 0)
				for(int i = 0; i < 4; i++)
					boxmap[sx - 1][sy + i] = 0;
			//Clear the whole bottom area when shape respawns at top
			if(sx == 0){
				for(int i = 0; i < 4; i++)
					for(int j = 0; j < 4; j++){
						boxmap[i + 21][j] = 0;
					}
			}
			// Override with the bug created while shape has sx = 1
			if(sx == 1){
				for(int i = 0; i < 4; i++) boxmap[sx - 1][sy + i] = 0;
			}
	}
	*/
	public void dynamicClearRight(){
		for( int i = 0; i < 4; i++){
			boxmap[sx + i][sy + 5] = 0;
		}
	}
	
	public void dynamicClearLeft(){
		for( int i = 0; i < 4; i++){
			boxmap[sx + i][sy - 1] = 0;
		}
	}
	


}