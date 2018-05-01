
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

 //botón back no funcina bien u.u

public class GameBattle extends JFrame{

    JFrame Bwindow;
    Container container;
    JPanel upperPanel1, upperPanel2, optionPanel, itemPanel, heroPanel, enemyPanel, combatPanel;
    JLabel upperLabel1, upperLabel2, manaH, hHp, eHP;
    ImageIcon image1, image2;
    JButton option1, option2, option3, back, attack, sAttack, defend;
    Font titlefont = new Font("Arial", Font.PLAIN, 70);
    Font normalfont = new Font("Arial", Font.PLAIN, 50);
    Font labelfont = new Font("Arial", Font.PLAIN, 40);

    GameBattleHandler gbHandler = new GameBattleHandler();
    BackHandler bHandler = new BackHandler();

  public static void main (String [] args){
     new GameBattle();
  }



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

    back = new JButton("Back");
    back.setBackground(Color.black);
    back.setForeground(Color.white);
    back.setFont(normalfont);
    back.setBorderPainted(false);
    back.setBounds(680,650,150,50);
    back.addActionListener(bHandler);
    back.setVisible(false);
    container.add(back);


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

    public void FightScreen(){

      optionPanel.setVisible(false);
      back.setVisible(true);

      heroPanel = new JPanel();
      combatPanel = new JPanel();
      heroPanel.setBounds(50,2,350,50);
      heroPanel.setBackground(Color.black);
      combatPanel.setBounds(100, 450, 350,350);
      combatPanel.setBackground(Color.black);

      attack = new JButton(">Attack            ");
      attack.setBackground(Color.black);
      attack.setForeground(Color.white);
      attack.setFont(normalfont);
      attack.setBorderPainted(false);

      sAttack = new JButton(">Special Attack");
      sAttack.setBackground(Color.black);
      sAttack.setForeground(Color.white);
      sAttack.setFont(normalfont);
      sAttack.setBorderPainted(false);

      defend = new JButton(">Defend            ");
      defend.setBackground(Color.black);
      defend.setForeground(Color.white);
      defend.setFont(normalfont);
      defend.setBorderPainted(false);

      hHp = new JLabel("HP:         ");
      manaH= new JLabel("Mana:");
      hHp.setFont(labelfont);
      hHp.setForeground(Color.white);
      manaH.setFont(labelfont);
      manaH.setForeground(Color.white);


      heroPanel.add(hHp);
      heroPanel.add(manaH);
      combatPanel.add(attack);
      combatPanel.add(sAttack);
      combatPanel.add(defend);


      enemyPanel =new JPanel();
      enemyPanel.setBounds(600,2,300,50);
      enemyPanel.setBackground(Color.black);
      eHP = new JLabel("HP:");
      eHP.setFont(labelfont);
      eHP.setForeground(Color.white);
      enemyPanel.add(eHP);


      container.add(heroPanel);
      container.add(enemyPanel);
      container.add(combatPanel);


    }

    public void ItemScreen(){
      //Necesita clase inventario para desplegar lista de cosas. (Max. 4 artículos yo digo)
      optionPanel.setVisible(false);
      back.setVisible(true);

      itemPanel =new JPanel();
      itemPanel.setBounds(100,450,300,300);
      itemPanel.setBackground(Color.pink);
      container.add(itemPanel);
    }


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

  public class BackHandler implements ActionListener{
    public void actionPerformed(ActionEvent a){
      if (a.getSource()==back){
        try{
          optionPanel.setVisible(true);
          itemPanel.setVisible(false);
          heroPanel.setVisible(false);
          enemyPanel.setVisible(false);
          back.setVisible(false);

        }catch(Exception e){

          System.out.println(":)");
        }

      }
    }
  }


}
