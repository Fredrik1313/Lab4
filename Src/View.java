import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it is controller in it is state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it is components.
 **/

public class View extends JFrame implements RedrawObserver {
    private static final int X = 1000;
    private static final int Y = 900;

    private ArrayList<ControllerObserver> ControllerObservers;

    // The model member
    Model model;

    //DrawPanel drawPanel = new DrawPanel(X, Y-240, model);
    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasAndBrakeSpinner = new JSpinner();
    int gasAndBrakeAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JPanel brakePanel = new JPanel();
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");


    // Constructor
    public View(String frameName, Model model){
        this.model = model;
        ControllerObservers = new ArrayList<ControllerObserver>();
        drawPanel = new DrawPanel(X, Y-240, model);
        initComponents(frameName);
        model.addRedrawObserver(this);
    }
    public void addControllerObserver(ControllerObserver observer){
        ControllerObservers.add(observer);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);



        // Gas
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasAndBrakeSpinner = new JSpinner(spinnerModel);
        gasAndBrakeSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAndBrakeAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasAndBrakeSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        // Brake

        brakePanel.setLayout(new BorderLayout());


        this.add(brakePanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        addCarButton.setBackground(Color.green);
        addCarButton.setForeground(Color.black);
        addCarButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(addCarButton);

        removeCarButton.setBackground(Color.orange);
        removeCarButton.setForeground(Color.black);
        removeCarButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(removeCarButton);

        // This actionListener is for the gas button only
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.gasAll(gasAndBrakeAmount / 100.0);
                }
            }
        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.brakeAll(gasAndBrakeAmount / 100.0);
                }
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.stopAll();
                }
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.startAll();
                }
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.turboOffAll();
                }
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.turboOnAll();
                }
            }
        });
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.liftBedAll();
                }
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.lowerBedAll();
                }
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.addCar();
                }
            }
        });

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerObserver observer : ControllerObservers) {
                    observer.removeCar();
                }
            }
        });

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void redraw(){
        drawPanel.repaint();
    }
}