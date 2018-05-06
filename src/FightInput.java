package botw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FightInput implements MouseListener{



	public void mouseClicked(MouseEvent e){

	}

	public void mouseEntered(MouseEvent e){

	}
	public void mouseExited(MouseEvent e){

	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();

if(Game.State == Game.STATE.FIGHT){
	//Back button
	if(mx >= 720 && mx <=820){
		if(my >= 590 && my <= 630){
			Game.State = Game.STATE.BATTLE;
		}
	}

	//Attack
	if(mx >= 50 && mx <=170){
		if(my >= 450 && my <= 490){

		}
	}

	//Special Attack
	if(mx >= 50 && mx <= 170){
		if(my >= 500 && my <= 540){

		}
	}

	//Defend
	if(mx >= 50 && mx <= 170){
		if(my >= 550 && my <= 590){

		}
	}

}


	}

	public void mouseReleased(MouseEvent e){

	}


}
