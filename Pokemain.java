import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.MouseListener;


public class Pokemain {

// Begin cited code https://www.youtube.com/watch?v=5AEIgLzueHk&t=232s&ab_channel=RyiSnow
    JLabel counterLabel, perSecLabel;
    JButton button1, button2, button3, button4;
    int PokeCounter, timerSpeed, premierNumber, premierPrice;
    double perSecond;
    boolean timerOn;
    Font font1, font2;
    PokeHandler pHandler = new PokeHandler();
    Timer timer; 
    JTextArea messageText;
    MouseHandler mHandler = new MouseHandler();
    public int greatPrice, ultraPrice, masterPrice;
    public boolean greatUnlocked, ultraUnlocked, masterUnlocked;
    public int greatNumber, ultraNumber, masterNumber;
    public static void main (String[] args) {

        new Pokemain();

    }
    // End of cited code
    public Pokemain(){

        timerOn =false;
        perSecond = 0;
        PokeCounter = 0;
        premierNumber = 0;
        premierPrice = 10;
        greatNumber = 0;
        greatPrice = 50;
        greatUnlocked = false;
        ultraNumber = 0;
        ultraPrice = 1250;
        ultraUnlocked = false;
        masterNumber = 0;
        masterPrice = 1000;
        masterUnlocked = false;

        createFont();
        createUI();

    }
    public void createFont(){

        font1 = new Font("IMPACT", Font.PLAIN, 30);
        font2 = new Font("Comic Sans MS", Font.PLAIN, 15);


    }
    public void createUI(){
    // Cited code https://www.youtube.com/watch?v=5AEIgLzueHk&t=232s&ab_channel=RyiSnow
        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        JPanel pokePanel = new JPanel();
        pokePanel.setBounds(100, 220, 200, 200);
        pokePanel.setBackground(Color.black);
        window.add(pokePanel);

        ImageIcon poke = new ImageIcon(getClass().getClassLoader().getResource("pokeball.png"));

        JButton pokeButton = new JButton();
        pokeButton.setBackground(Color.black);
        pokeButton.setFocusPainted(false);
        pokeButton.setBorder(null);
        pokeButton.setIcon(poke);
        pokeButton.addActionListener(pHandler);
        pokeButton.setActionCommand("poke");
        pokePanel.add(pokeButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100, 100, 200, 100);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2, 1));
        window.add(counterPanel);

        counterLabel = new JLabel(PokeCounter + " Pokeballs");
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);

        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);

        JPanel itemPanel = new JPanel();
        itemPanel.setBounds(500, 170, 250, 250);
        itemPanel.setBackground(Color.black);
        itemPanel.setLayout(new GridLayout(4,1));
        window.add(itemPanel);

        button1 = new JButton("Premier Ball");
        button1.setFont(font1);
        button1.setFocusPainted(false);
        button1.addActionListener(pHandler);
        button1.setActionCommand("Premier Ball");
        button1.addMouseListener(mHandler);
        itemPanel.add(button1);
        button2 = new JButton("Great Ball");
        button2.setFont(font1);
        button2.setFocusPainted(false);
        button2.addActionListener(pHandler);
        button2.setActionCommand("Great Ball");
        button2.addMouseListener(mHandler);
        itemPanel.add(button2);
        button3 = new JButton("Ultra Ball");
        button3.setFont(font1);
        button3.setFocusPainted(false);
        button3.addActionListener(pHandler);
        button3.setActionCommand("Ultra Ball");
        button3.addMouseListener(mHandler);
        itemPanel.add(button3);
        button4 = new JButton("Master Ball");
        button4.setFont(font1);
        button4.setFocusPainted(false);
        button4.addActionListener(pHandler);
        button4.setActionCommand("Master Ball");
        button4.addMouseListener(mHandler);
        itemPanel.add(button4);

        JPanel messagePanel = new JPanel();
        messagePanel.setBounds(500, 70, 250, 150);
        messagePanel.setBackground(Color.black);
        window.add(messagePanel);

        messageText = new JTextArea();
        messageText.setBounds(500, 70, 250, 150);
        messageText.setForeground(Color.white);
        messageText.setBackground(Color.BLACK);
        messageText.setFont(font2);
        messageText.setWrapStyleWord(true);
        messageText.setEditable(false);
        messagePanel.add(messageText);
        


        window.setVisible(true);
}
// end of Cited 
// Cited https://www.geeksforgeeks.org/java-util-timer-class-java/
public void setTimer(){

    timer = new Timer(timerSpeed, new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e){
            
            PokeCounter++;
            counterLabel.setText(PokeCounter + " pokeballs");

            if(greatUnlocked==false){
                if(PokeCounter>=100){
                    greatUnlocked=true;
                    button2.setText("Great Ball " + "(" + greatNumber +")");
                }

            }
            if(ultraUnlocked==false){
                if(PokeCounter>=1250){
                    ultraUnlocked=true;
                    button3.setText("Great Ball " + "(" + ultraNumber +")");
                }

            }
            if(masterUnlocked==false){
                if(PokeCounter>=10000){
                    masterUnlocked=true;
                    button4.setText("Master Ball " + "(" + masterNumber +")");
                }

            }
        }
    });
}
public void timerUpdate(){

    if(timerOn==false){
        timerOn=true;
    }
    else if(timerOn==true){
        timer.stop();

    }

    double speed = 1/perSecond*1000;
    timerSpeed = (int)Math.round(speed);

    String s = String.format("%.1f", perSecond);
    perSecLabel.setText("per second: " + s);

    setTimer();
    timer.start();
}

//End cited


public class PokeHandler implements ActionListener{

    public void actionPerformed(ActionEvent event){

        String action = event.getActionCommand();

        switch(action){
        case "poke":
        PokeCounter++;
        counterLabel.setText(PokeCounter + " pokeballs");
            break;
        case "Premier Ball":
            if(PokeCounter>=premierPrice){
                PokeCounter = PokeCounter - premierPrice;
                premierPrice = premierPrice + 5;
                counterLabel.setText(PokeCounter + " pokeballs");
                
                premierNumber++;
                button1.setText("PremierBall " + "(" + premierNumber + ")");
                messageText.setText("Premier Ball\n[price: " + premierPrice + "]\nCreates a Pokeball every 10 seconds.");
                perSecond = perSecond + 0.1;
                timerUpdate();
            }
            else{
                messageText.setText("You need more pokeballs!");
            }
            break;
        case "Great Ball":
            if(PokeCounter>=greatPrice){
                PokeCounter = PokeCounter - greatPrice;
                greatPrice = greatPrice + 50;
                counterLabel.setText(PokeCounter + " pokeballs");
            
                greatNumber++;
                button2.setText("Great Ball " + "(" + greatNumber + ")");
                messageText.setText("Great Ball\n[price: " + greatPrice + "]\nEach greatball produces 1 pokeball per second.");

                perSecond = perSecond + 1;
                timerUpdate();
            }
            else{
                messageText.setText("You need more pokeballs!");
            }
            break;
            case "Ultra Ball":
            if(PokeCounter>=ultraPrice){
                PokeCounter = PokeCounter - ultraPrice;
                ultraPrice = ultraPrice + 125;
                counterLabel.setText(PokeCounter + " pokeballs");
            
                ultraNumber++;
                button3.setText("Ultra Ball " + "(" + ultraNumber + ")");
                messageText.setText("Ultra Ball\n[price: " + ultraPrice + "]\nEach ultra produces 10 pokeball per second.");

                perSecond = perSecond + 10;
                timerUpdate();
            }
            else{
                messageText.setText("You need more pokeballs!");
            }
            break;
            case "Master Ball":
            if(PokeCounter>=masterPrice){
                PokeCounter = PokeCounter - masterPrice;
                masterPrice = masterPrice + 500;
                counterLabel.setText(PokeCounter + " pokeballs");
            
                masterNumber++;
                button4.setText("Master Ball " + "(" + masterNumber + ")");
                messageText.setText("GreatBall\n[price: " + masterPrice + "]\nEach greatball produces 1 pokeball per second.");

                perSecond = perSecond + 100;
                timerUpdate();
            }
            else{
                messageText.setText("You need more pokeballs!");
            }

           
        }
        
    }
}

public class MouseHandler implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
       
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        

        JButton button = (JButton)e.getSource();
        
        if(button == button1){
            
            messageText.setText("Premier Ball\n[price: " + premierPrice + "]\nEach Premier Ball produces\n 1 pokeball every 10 second.");

        }
        else if(button == button2){
         
            messageText.setText("GreatBall\n[price: " + greatPrice + "]\nEach Great Ball produces\n 1 pokeball per second.");
            


        }
        else if(button == button3){
                if(ultraUnlocked=true){
                messageText.setText("Ultra Ball\n[price: " + greatPrice + "]\nEach Ultra Ball produces\n 10 pokeball per second.");
                }
            
        
        
        }
        
        else if(button == button4){
            if(masterUnlocked=false){
                messageText.setText("This item is currently locked!\nYou need 10000 pokeballs");
             }
        else{
            if(masterUnlocked=true){
                messageText.setText("Master ball\n[price: " + greatPrice + "]\nEach Master Ball produces\n 100 pokeball per second.");
            }
          }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        JButton button = (JButton)e.getSource();

        if(button == button1){
            messageText.setText(null);
        }
        else if(button == button2){
            messageText.setText(null);
        }
        else if(button == button3){
            messageText.setText(null);
        }
        else if(button == button4){
            messageText.setText(null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
        
    }


}



    










}