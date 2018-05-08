package botw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PauseMenuInput implements MouseListener{

	//Game game = new Game();

	public void mouseClicked(MouseEvent e){

	}

	public void mouseEntered(MouseEvent e){

	}
	public void mouseExited(MouseEvent e){

	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();


		//Check game state first
		if(Game.State == Game.STATE.PAUSE){

			//Play button
			if(mx >= Game.WIDTH/5+120 && mx <= Game.WIDTH/5+320){
				if(my >= 150 && my <= 200){
					//Pressed Play Button
					Game.State = Game.STATE.GAME;
				}
			}
			//Save Button
			if(mx >= Game.WIDTH/5+120 && mx <= Game.WIDTH/5+320){
				if(my >= 210 && my <= 260){
					//Pressed Save Button
					Game.Save();
					System.out.println("Saving");
				}
			}

			//Load Button
			if(mx >= Game.WIDTH/5+120 && mx <= Game.WIDTH/5+320){
				if(my >= 270 && my <= 320){
					//Pressed Load Button
					Game.Load();
					System.out.println("Loading");
				}
			}

			//Quit button
			if(mx >= Game.WIDTH/5+120 && mx <= Game.WIDTH/5+320){
				if(my >= 330 && my <= 380){
					//Pressed Quit Button
					System.exit(1);
				}
			}
		}
	}







	public void mouseReleased(MouseEvent e){

	}
}