package botw ;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameBattle extends JFrame {

    JFrame Bwindow;
    Container container;
    JPanel upperPanel1, upperPanel2, optionPanel, itemPanel, heroPanel, enemyPanel, combatPanel;
    JLabel upperLabel1, upperLabel2, manaH, hHp, eHP;
    ImageIcon image1, image2;
    JButton option1, option2, option3, backF,backI, attack, sAttack, defend;
    Font titlefont = new Font("Arial", Font.PLAIN, 70);
    Font normalfont = new Font("Arial", Font.PLAIN, 50);
    Font labelfont = new Font("Arial", Font.PLAIN, 40);

    GameBattleHandler gbHandler = new GameBattleHandler();
    BackIHandler bHandler = new BackIHandler();
    BackFHandler bHandler1 = new BackFHandler();
    FightHandler fHandler = new FightHandler();

    Finish finish = new Finish();

    Enemy enemy = new Enemy("Ugly Bagel", 100, 5, 2, 3);
    Player pJ = new Player ("Frosty McMuffin", 200, 10, 10, 1, 30 );

    int pJLife= pJ.getLife();

  public GameBattle(){

    Bwindow =new JFrame();
    Bwindow.setSize(1000,800);
    Bwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Bwindow.getContentPane().setBackground(Color.black);
    Bwindow.setLayout(null);
    Bwindow.setTitle("Combat");
    container = Bwindow.getContentPane();

    upperPanel1 =new JPanel();
    upperPanel1.setBounds(100, 100, 252, 252);
    upperPanel1.setBackground(Color.black);
    container.add(upperPanel1);

    upperPanel2 = new JPanel();
    upperPanel2.setBounds(640,100, 252, 252);
    upperPanel2.setBackground(Color.black);
    container.add(upperPanel2);

    OptionScreen();

    backF = new JButton("Back");
    backF.setBackground(Color.black);
    backF.setForeground(Color.white);
    backF.setFont(normalfont);
    backF.setBorderPainted(false);
    backF.setBounds(680,650,150,50);
    backF.addActionListener(bHandler1);
    backF.setVisible(false);
    container.add(backF);

    backI = new JButton("Back");
    backI.setBackground(Color.black);
    backI.setForeground(Color.white);
    backI.setFont(normalfont);
    backI.setBorderPainted(false);
    backI.setBounds(680,650,150,50);
    backI.addActionListener(bHandler);
    backI.setVisible(false);
    container.add(backI);


    image1 =new ImageIcon(getClass().getResource("testMcMuffin.png"));
    Image newImage = image1.getImage();
    Image scaledImage = newImage.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
    image1 = new ImageIcon(scaledImage);
    upperLabel1 = new JLabel(image1);

    image2 = new ImageIcon(getClass().getResource("testEnemy.png"));
    Image newImage2 =image2.getImage();
    Image scaledImage2 =newImage2.getScaledInstance(250,250, java.awt.Image.SCALE_SMOOTH);
    image2 =new ImageIcon(scaledImage2);
    upperLabel2 = new JLabel(image2);

    upperPanel1.add(upperLabel1);
    upperPanel2.add(upperLabel2);
    optionPanel.add(option1);
    optionPanel.add(option2);
    optionPanel.add(option3);

    Bwindow.setVisible(true);

  }


//pantalla de batalla
    public void OptionScreen(){

      optionPanel = new JPanel();
      optionPanel.setBounds(100, 450, 200, 300);
      optionPanel.setBackground(Color.black);
      container.add(optionPanel);

      option1 = new JButton(">Fight");
      option1.setBackground(Color.black);
      option1.setForeground(Color.white);
      option1.setFont(normalfont);
      option1.setBorderPainted(false);
      option1.addActionListener(gbHandler);

      option2 = new JButton(">Run ");
      option2.setBackground(Color.black);
      option2.setForeground(Color.white);
      option2.setFont(normalfont);
      option2.setBorderPainted(false);
      option2.addActionListener(gbHandler);

      option3 = new JButton(">Item");
      option3.setBackground(Color.black);
      option3.setForeground(Color.white);
      option3.setFont(normalfont);
      option3.setBorderPainted(false);
      option3.addActionListener(gbHandler);

    }

    //pantalla de fight
    public void FightScreen(){

      optionPanel.setVisible(false);
      backF.setVisible(true);

      heroPanel = new JPanel();
      combatPanel = new JPanel();
      heroPanel.setBounds(50,2,350,100);
      heroPanel.setBackground(Color.black);
      combatPanel.setBounds(100, 450, 350,350);
      combatPanel.setBackground(Color.black);

      attack = new JButton(">Attack            ");
      attack.setBackground(Color.black);
      attack.setForeground(Color.white);
      attack.setFont(normalfont);
      attack.setBorderPainted(false);
      attack.addActionListener(fHandler);

      sAttack = new JButton(">Special Attack");
      sAttack.setBackground(Color.black);
      sAttack.setForeground(Color.white);
      sAttack.setFont(normalfont);
      sAttack.setBorderPainted(false);
      sAttack.addActionListener(fHandler);

      defend = new JButton(">Defend            ");
      defend.setBackground(Color.black);
      defend.setForeground(Color.white);
      defend.setFont(normalfont);
      defend.setBorderPainted(false);
      defend.addActionListener(fHandler);

//EDITAAAAAAAAAAAAAAAAAAAR
      hHp = new JLabel("HP:   " + pJ.getLife());
      manaH= new JLabel("Mana:" + pJ.getMana());
      hHp.setFont(labelfont);
      hHp.setForeground(Color.white);
      manaH.setFont(labelfont);
      manaH.setForeground(Color.white);

      heroPanel.add(hHp);
      heroPanel.add(manaH);
      combatPanel.add(attack);
      combatPanel.add(sAttack);
      combatPanel.add(defend);

//EDITAAAAAAAAAAAAAAAAAAAAAAAAR
      enemyPanel =new JPanel();
      enemyPanel.setBounds(600,2,300,50);
      enemyPanel.setBackground(Color.black);
      eHP = new JLabel("HP:"+ enemy.getLife());
      eHP.setFont(labelfont);
      eHP.setForeground(Color.white);
      enemyPanel.add(eHP);


      container.add(heroPanel);
      container.add(enemyPanel);
      container.add(combatPanel);


    }

public class FightHandler implements ActionListener{

      public void actionPerformed(ActionEvent e){


  //********************ATTACK**************************//


          if (e.getSource()==attack){

            enemy.setLife(pJ.getDamage());
  					if (enemy.getLife()> 0){
  						pJ.setLife(enemy.getDamage());
  					}
  					//System.out.println("Enemy hp: "+enemy.getLife());
            String enemyLife =Integer.toString(enemy.getLife());
              eHP.setText("HP: "+enemyLife);
  				//	System.out.println("McMuffin hp: "+pJ.getLife());
            String pJLife= Integer.toString(pJ.getLife());
              hHp.setText("HP: "+pJLife);

//***********************SPECIAL ATTACK*******************//

          }else if(e.getSource()==sAttack){

            if(pJ.getMana()>0){
              enemy.setLife(pJ.specialAttack());
              if (enemy.getLife()> 0){
               pJ.setLife(enemy.getDamage());
              }

              String enemyLife =Integer.toString(enemy.getLife());
                eHP.setText("HP: "+enemyLife);
              String pJLife =Integer.toString(pJ.getLife());
                hHp.setText("HP: "+pJLife);
              String pJMana =Integer.toString(pJ.getMana());
                manaH.setText("Mana: "+pJMana);
            }else if(pJ.getMana()==0){
              manaH.setText("Insufficient mana");
            }


//***********************DEFEND**************************//

          }else if(e.getSource()==defend){

            int newDamage=  enemy.getDamage()-pJ.getDefense();
            if (enemy.getLife()> 0){
              pJ.setLife(newDamage);
            }

            //System.out.println("Enemy hp: "+enemy.getLife());
            String enemyLife =Integer.toString(enemy.getLife());
              eHP.setText("HP: "+enemyLife);
            //System.out.println("McMuffin hp: "+pJ.getLife());
            String pJLife =Integer.toString(pJ.getLife());
              hHp.setText("HP: "+pJLife);

          }

          if (enemy.getLife()<=0){
          hHp.setText("You have WON!");
          pJ.setLvl(pJ.getLvl());
          backF.addActionListener(finish);
          combatPanel.setVisible(false);
          manaH.setText("lvl UP!!!!: "+ pJ.getLvl());
        }else if(pJ.getLife()<=0){
            hHp.setText("You have LOST");
            backF.addActionListener(finish);
          }



      }
    }


//pantalla de items
    public void ItemScreen(){
      //Necesita clase inventario para desplegar lista de cosas. (Max. 4 artículos yo digo)
      optionPanel.setVisible(false);
      backI.setVisible(true);

      itemPanel =new JPanel();
      itemPanel.setBounds(100,450,300,300);
      itemPanel.setBackground(Color.pink);
      container.add(itemPanel);
    }


//Para escuchar los botones del menu de battle
  public class GameBattleHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (e.getSource()==option1){
        FightScreen();
      }else if(e.getSource()==option2){
        System.exit(0); //no creo que sea lo mejor a la hora de implementarlo en el juego pero funciona por ahora
      }else if(e.getSource()==option3){
        ItemScreen();
      }
    }

  }

//back for fight
  public class BackFHandler implements ActionListener{
    public void actionPerformed(ActionEvent a){
      if (a.getSource()==backF){
        try{
          optionPanel.setVisible(true);
          heroPanel.setVisible(false);
          enemyPanel.setVisible(false);
          combatPanel.setVisible(false);
          backF.setVisible(false);

        }catch(Exception e){

          System.out.println(":)");
        }

      }
    }
  }


  //back for items
  public class BackIHandler implements ActionListener{
    public void actionPerformed(ActionEvent a){
      if (a.getSource()==backI){
        try{

          optionPanel.setVisible(true);
          itemPanel.setVisible(false);
          backI.setVisible(false);

        }catch(Exception e){

          System.out.println(":)");
        }

      }
    }
  }

  //Finish

  public class Finish implements ActionListener{
    public void actionPerformed(ActionEvent a){
      if (a.getSource()==backF){
        System.exit(0);

        }

      }
    }
  }
