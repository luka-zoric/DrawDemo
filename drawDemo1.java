import java.awt.*;
import java.util.*;
import javax.swing.*;

/*
 * -----AUTHOR INFO----- name: Luka Zoric sID: s5027193 email:
 * luka.zoric@griffithuni.edu.au
 * 
 * 
 * -------APP INFO------ name: DrawGUI resolution: 800x600 description: simple
 * drawing game, enter coordinates of the shape and draw it onto the screen
 * 
 */

public class drawDemo extends JFrame {

    // title of the window
    String title = "DrawDemo";

    // declaring variables
    private final JSplitPane splitPane; // split pane
    private final JPanel inputPanel; // panel for all inputs
    private final JPanel boardPanel; // panel for drawings

    // buttons for drawing
    private final JButton addRect, addCircle, addTriangle, addLine;

    // buttons for colours
    private final JButton redButton, orangeButton, yellowButton, greenButton, blueButton, indigoButton, violetButton;

    // COLOURS
    private final Color red = new Color(219, 37, 37);
    private final Color orange = new Color(255, 172, 30);
    private final Color yellow = new Color(255, 255, 25);
    private final Color green = new Color(42, 193, 19);
    private final Color blue = new Color(19, 103, 193);
    private final Color indigo = new Color(76, 19, 193);
    private final Color violet = new Color(247, 12, 227);

    // buttons for save and load
    private final JButton save, load, resetButton;

    // adding labels
    Font font = new Font("Bahnschrift Light", Font.BOLD, 20);

    // intro message
    private final JLabel introText = new JLabel("Welcome to DrawDemo!");

    // origin size for shapes
    private final JLabel Origin = new JLabel("Origin    x                y");
    private final JLabel Size = new JLabel("Size       h                w");

    // p1, p2 and angle for line
    private final JLabel p1 = new JLabel("Point1    x                y");
    private final JLabel p2 = new JLabel("Point2    x                y");
    private final JLabel ang = new JLabel("Angle");

    public drawDemo() {
        // set title
        setTitle(title);
        // close when 'X' is pressed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // creating pannel
        splitPane = new JSplitPane();

        // creating panels
        inputPanel = new JPanel();
        boardPanel = new JPanel();

        // creating buttons for input pannel DRAWING BUTTONS
        addRect = new JButton("RECTANGLE");
        addCircle = new JButton("CIRCLE");
        addTriangle = new JButton("TRIANGLE");
        addLine = new JButton("LINE");

        // creating buttons for board panel COLOURS + SAVE and LOAD
        redButton = new JButton();
        orangeButton = new JButton();
        yellowButton = new JButton();
        greenButton = new JButton();
        blueButton = new JButton();
        indigoButton = new JButton();
        violetButton = new JButton();

        save = new JButton("SAVE");
        load = new JButton("LOAD");
        resetButton = new JButton("RESET");

        // set the size of the screen and add split pane into it
        setPreferredSize(new Dimension(800, 600));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane); // add split pane

        // setting up split pane
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT); // split horizontally
        splitPane.setDividerLocation(250); // split at x = 250px
        splitPane.setLeftComponent(inputPanel); // add input panel
        splitPane.setRightComponent(boardPanel); // add boar panel

        // declare sizes for both panels so split pane is unmovable
        inputPanel.setMinimumSize(new Dimension(250, 600));
        inputPanel.setBackground(new Color(47, 48, 48));
        boardPanel.setMinimumSize(new Dimension(550, 600));
        boardPanel.setBackground(new Color(255, 255, 255));

        // add image logo
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon("logoDrawDemo.png"));// your image here
        inputPanel.add(image); // 465x105
        image.setBounds(0, 60, 465, 105);
        //
        //
        //
        ////////////////////////////// ADD OBJECTS TO INPUT PANEL //////////

        ///////////////////////////////////////////////////////// INTRO TEXT
        inputPanel.add(introText);
        introText.setBounds(10, 20, 300, 20);
        introText.setFont(font);
        introText.setForeground(new Color(255, 255, 255));

        ///////////////////////////////////////////////////////// RECTANGLE TEXT
        // OBJECT ORIGIN
        inputPanel.add(Origin); // add
        Origin.setBounds(10, 190, 200, 20); // set bounds
        Origin.setFont(new Font("Bahnschrift Light", Font.BOLD, 14)); // set font
        Origin.setForeground(new Color(166, 168, 168)); // set colour
        // OBJECT SIZE
        inputPanel.add(Size); // add
        Size.setBounds(10, 240, 200, 20); // set bounds
        Size.setFont(new Font("Bahnschrift Light", Font.BOLD, 14)); // set font
        Size.setForeground(new Color(166, 168, 168)); // set colour
        //
        //
        //
        // BUTTONS for DRAW
        inputPanel.setLayout(null); // set layout to null for a parent

        inputPanel.add(resetButton); // add RESET BUTTON
        resetButton.setBounds(0, 510, 250, 60);
        resetButton.setFont(new Font("Bahnschrift Light", Font.BOLD, 18));
        inputPanel.add(addRect); // add RECTANGLE
        addRect.setBounds(-10, 290, 90, 30);
        addRect.setFont(new Font("Bahnschrift Light", Font.BOLD, 9));
        inputPanel.add(addCircle); // add CIRCLE
        addCircle.setBounds(80, 290, 90, 30);
        addCircle.setFont(new Font("Bahnschrift Light", Font.BOLD, 9));
        inputPanel.add(addTriangle); // add TRIANGLE
        addTriangle.setBounds(170, 290, 90, 30);
        addTriangle.setFont(new Font("Bahnschrift Light", Font.BOLD, 9));
        inputPanel.add(addLine); // add LINE
        addLine.setBounds(80, 450, 90, 30);
        addLine.setFont(new Font("Bahnschrift Light", Font.BOLD, 9));

        // add objects to board panel

        // BUTTONS for COLOURS
        boardPanel.setLayout(null); // set layout to null for a parent

        boardPanel.add(redButton);
        redButton.setBackground(red);

        int colourButtonLength = 50;
        int colourButtonHeight = 30;

        redButton.setBounds(0, 0, colourButtonLength, colourButtonHeight);

        boardPanel.add(orangeButton);
        orangeButton.setBackground(orange);
        orangeButton.setBounds(colourButtonLength, 0, colourButtonLength, colourButtonHeight);

        boardPanel.add(yellowButton);
        yellowButton.setBackground(yellow);
        yellowButton.setBounds(colourButtonLength * 2, 0, colourButtonLength, colourButtonHeight);

        boardPanel.add(greenButton);
        greenButton.setBackground(green);
        greenButton.setBounds(colourButtonLength * 3, 0, colourButtonLength, colourButtonHeight);

        boardPanel.add(blueButton);
        blueButton.setBackground(blue);
        blueButton.setBounds(colourButtonLength * 4, 0, colourButtonLength, colourButtonHeight);

        boardPanel.add(indigoButton);
        indigoButton.setBackground(indigo);
        indigoButton.setBounds(colourButtonLength * 5, 0, colourButtonLength, colourButtonHeight);

        boardPanel.add(violetButton);
        violetButton.setBackground(violet);
        violetButton.setBounds(colourButtonLength * 6, 0, colourButtonLength, colourButtonHeight);

        boardPanel.add(save);
        save.setBounds(350, 0, 90, 30);

        boardPanel.add(load);
        load.setBounds(440, 0, 90, 30);

        // clean things out, 'pack' the screen
        pack();
    }

    public static void main(String args[]) {
        // invoke the constructor class
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new drawDemo().setVisible(true);
            }
        });
    }
}
