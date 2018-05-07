package botw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PauseMenuInput implements MouseListener{

	public void mouseClicked(MouseEvent e){

	}

	public void mouseEntered(MouseEvent e){

	}
	public void mouseExited(MouseEvent e){

	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();

		//public Rectangle contButton = new Rectangle(Game.WIDTH/5+120, 150, 200, 50);
		//public Rectangle saveButton = new Rectangle(Game.WIDTH/5+120, 210, 200, 50);
		//public Rectangle loadButton = new Rectangle(Game.WIDTH/5+120, 270, 200, 50);
		//public Rectangle quitButton = new Rectangle(Game.WIDTH/5+120, 330, 200, 50);

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