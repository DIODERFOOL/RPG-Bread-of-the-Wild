package botw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

public class FightInput implements MouseListener{

	Enemy enemy = new Enemy("Ugly Bagel", 100, 5, 2, 3);
	Player pJ = new Player ("Frosty McMuffin", 200, 10, 10, 1, 30 );
	Fight fight;

	public void mouseClicked(MouseEvent e){

	}

	public void mouseEntered(MouseEvent e){

	}
	public void mouseExited(MouseEvent e){

	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();

			fight.setText("hola");

		if(Game.State == Game.STATE.FIGHT){
			//Back button
			if(mx >= 720 && mx <=820){
				if(my >= 590 && my <= 630){
					Game.State = Game.STATE.BATTLE;
				}
			}

			//Attack
			if(mx >= 50 && mx <=290){
				if(my >= 450 && my <= 490){

					enemy.setLife(pJ.getDamage());
					if (enemy.getLife()> 0){
						pJ.setLife(enemy.getDamage());
					}
					System.out.println("Enemy hp: "+enemy.getLife());
					System.out.println("McMuffin hp: "+pJ.getLife());
				}

			}

			//Special Attack
			if(mx >= 50 && mx <= 290){
				if(my >= 500 && my <= 540){

					if(pJ.getMana()>0){
						enemy.setLife(pJ.specialAttack());
						if (enemy.getLife()> 0){
							pJ.setLife(enemy.getDamage());
						}
						System.out.println("Enemy hp: "+enemy.getLife());
						System.out.println("McMuffin hp: "+pJ.getLife());
						System.out.println("McMuffin mana: "+pJ.getMana());
					}else if(pJ.getMana()==0){
						System.out.println("Insufficient mana");
					}

				}
			}

			//Defend
			if(mx >= 50 && mx <= 290){
				if(my >= 550 && my <= 590){

					int newDamage=  enemy.getDamage()-pJ.getDefense();
					if (enemy.getLife()> 0){
						pJ.setLife(newDamage);
					}
					System.out.println("Enemy hp: "+enemy.getLife());
					System.out.println("McMuffin hp: "+pJ.getLife());
				}


			}
		}

	}


public void mouseReleased(MouseEvent e){

}


}
