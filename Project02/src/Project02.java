import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Project02 extends JFrame implements KeyListener {
    public int width, height;
    final String menuText = "P - Play  S - Stop  1 - 5  2 - 10  3 - 15  4 - 20  5 - 25  6 - 30";
    public static int ufoChoice = 0;

    // Get user screen resolution
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Container container;
    JPanel menuPanel;
    AnimationPanel animationPanel;
    JLabel menuLabel;
    Font font = new Font("Tahoma",Font.BOLD,20);


    Project02(){
        super("Project02 : Animation : 060243104 Object-oriented Programming");
        //set default app size
        width = 1024; height = 768;

        super.setUndecorated(true);
        super.getRootPane().setWindowDecorationStyle(2);
        super.getRootPane().setFont(font);
        JFrame.setDefaultLookAndFeelDecorated(true);
        addKeyListener(this);

        container = super.getContentPane();
        container.setLayout(new FlowLayout());

        //Create animationPanel
        animationPanel = new AnimationPanel();

        //Create Menu Panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPanel.setPreferredSize(new Dimension(1000,60));
        menuPanel.setBorder(new LineBorder(Color.BLUE,2));

        menuLabel = new JLabel();
        menuLabel.setText(menuText);
        menuLabel.setFont(font);
        menuPanel.add(menuLabel);

        container.add(animationPanel);
        container.add(menuPanel);

        super.setSize(width,height);
        setLocation(
                //set window position to center
                //screenSize/2 - windowWidth/2
                (int)screenSize.getWidth()/2-(super.getWidth()/2),
                (int)screenSize.getHeight()/2-(super.getHeight()/2) );
        super.setVisible(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void keyTyped(KeyEvent e) {

    }

    // Press Key Event
    public void keyPressed(KeyEvent e) {
        System.out.println("\n-------------------------------------");
        System.out.println("keyPressed Code: " + e.getKeyCode() );
        System.out.println("keyPressed Char: " + e.getKeyChar() );
        System.out.println("-------------------------------------");

        // Set how many UFO in screen.
        if(     // 49-54 are number on keyboard, 97-105 are number on numpad
                // This is key number 1-6
                ( e.getKeyCode() >= 49 ) && ( e.getKeyChar() <= 54) ||
                ( e.getKeyCode() >= 97 ) && ( e.getKeyChar() <= 105))
        setUfoChoice( Integer.parseInt(String.valueOf(e.getKeyChar())) );// end of if

        // Set UFO start and stop.
        if (Character.toString(e.getKeyChar()).toUpperCase().equals("P")){
            AnimationPanel.timer.start();
        }else if (Character.toString(e.getKeyChar()).toUpperCase().equals("S")){
            AnimationPanel.timer.stop();
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public int getUfoChoice() {
        return ufoChoice;
    }

    public void setUfoChoice(int ufoChoice) {
        Project02.ufoChoice = ufoChoice;
    }

    public static void main(String[] args) {
        new Project02();
    }
}
