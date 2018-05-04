package botw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuInput implements MouseListener{



	public void mouseClicked(MouseEvent e){

	}

	public void mouseEntered(MouseEvent e){

	}
	public void mouseExited(MouseEvent e){

	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();

		//Play button
		if(Game.State == Game.STATE.MENU){
			if(mx >= Game.WIDTH/5+120 && mx <= Game.WIDTH/5+320){
				if(my >= 150 && my <= 200){
					//Pressed Play Button
					Game.State = Game.STATE.GAME;
				}
			}

			//Quit button
			if(mx >= Game.WIDTH/5+120 && mx <= Game.WIDTH/5+320){
				if(my >= 310 && my <= 360){
					//Pressed Quit Button
					System.exit(1);
				}
			}
		}
		}


	public void mouseReleased(MouseEvent e){

	}


}
