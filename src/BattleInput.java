package botw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattleInput implements MouseListener{

	public void mouseClicked(MouseEvent e){

	}

	public void mouseEntered(MouseEvent e){

	}
	public void mouseExited(MouseEvent e){

	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();

if(Game.State == Game.STATE.BATTLE){
	//Fight button
	if(mx >= 51 && mx <=170){
		if(my >= 450 && my <= 490){
			Game.State = Game.STATE.FIGHT;
		}
	}

	//Item
	if(mx >= 50 && mx <= 170){
		if(my >= 500 && my <= 540){
			Game.State = Game.STATE.ITEM;
		}
	}

	//Run
	if(mx >= 50 && mx <= 170){
		if(my >= 550 && my <= 590){
			Game.State = Game.STATE.GAME;
		}
	}

}


	}

	public void mouseReleased(MouseEvent e){

	}


}
