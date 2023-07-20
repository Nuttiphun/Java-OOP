import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Project01 extends JFrame implements ActionListener{
    final private String[] buttonName = {"Triangle","Square","Box","Circle","Red","Green","Blue","Magenta"};

    // This is for get user screen resolution x,y
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Container container;
    JPanel menuPanel, statusPanel;
    GraphicsPanel graphicsPanel;
    JLabel blankLabel = new JLabel();
    JLabel shapeLabel, colorLabel;
    JButton[] button = new JButton[8];
    Font font = new Font("Tahoma",Font.BOLD,20);


    Project01(){
        super("Project 01 : 060243104 Object-oriented Programming");
        ////////////////////////////////////////////////////
        //This is for decoration program title. (By use old style JFrame);
        super.setUndecorated(true);
        super.getRootPane().setWindowDecorationStyle( 2);
        ////////////////////////////////////////////////////
        super.getRootPane().setFont(font);

        JFrame.setDefaultLookAndFeelDecorated(true);
        container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));


/////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////// Create Panel ///////////////////////////////////
        //*********** Create Selection Menu Panel ***********//
        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        menuPanel.setPreferredSize(new Dimension(1000,50));
        menuPanel.setBorder(new LineBorder(Color.BLACK, 1));

        //create and add Button
        for (int i = 0; i < button.length; i++){
            button[i] = new JButton(buttonName[i]);
            button[i].addActionListener(this);
            button[i].setFont(font);

            menuPanel.add(button[i]);
        }


        //*********** Create Painting Area Panel ***********//
        graphicsPanel = new GraphicsPanel();

        //set Default Shape Choice ( 0 - 3 )
        graphicsPanel.setShapeChoice(0);
        //set Default Color Choice( 4 - 7 )
        graphicsPanel.setColorChoice(4);


        //*********** Create Status Panel ***********//
        statusPanel = new JPanel();
        statusPanel.setPreferredSize(new Dimension(1000,50));
        statusPanel.setBorder(new LineBorder(Color.BLACK, 1));
        statusPanel.setLayout(new GridLayout(1,3));

        shapeLabel = new JLabel("Shape : " + buttonName[graphicsPanel.getShapeChoice()] , SwingConstants.LEFT);
        shapeLabel.setFont(font);
        statusPanel.add(shapeLabel);

        statusPanel.add(blankLabel);

        colorLabel = new JLabel("Color : " + buttonName[graphicsPanel.getColorChoice()],SwingConstants.LEFT);
        colorLabel.setFont(font);

        statusPanel.add(colorLabel);

        // Add Panel to Container
        container.add(menuPanel);
        container.add(graphicsPanel);
        container.add(statusPanel);

//////////////////////////////////// Finished Panel ////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
        setSize(1024,768);
        setLocation(
                //set window position to center
                //screenSize/2 - windowWidth/2
                (int)screenSize.getWidth()/2-(super.getWidth()/2),
                (int)screenSize.getHeight()/2-(super.getHeight()/2) );
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event){
        for (int i =0; i < button.length; i++){
            if(event.getSource() == button[i]){
                if (i < 4){
                    graphicsPanel.setShapeChoice(i);
                }else graphicsPanel.setColorChoice(i);
                shapeLabel.setText("Shape : " + buttonName[graphicsPanel.getShapeChoice()]);
                colorLabel.setText("Shape : " + buttonName[graphicsPanel.getColorChoice()]);
            } // end of if(event.getSource() == button[i])
        } // end for statement.

    }

    public static void main(String[] args) {
        new Project01();
    }



}
