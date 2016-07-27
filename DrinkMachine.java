//this applet replicates a soda machine
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DrinkMachine extends JApplet{

  private final int INVENTORY = 20;
  private double PRICE = 0.75;
  private int colaInv = INVENTORY;
  private int llInv = INVENTORY;
  private int grapeInv = INVENTORY;
  private int rbInv = INVENTORY;
  private int waterInv = INVENTORY;

  private JPanel buttonPanel; //panel for coke buttons
  private JPanel moneyPanel; //panel for text field money amount

  private JButton colaButton;
  private JButton llButton;
  private JButton grapeButton;
  private JButton rbButton;
  private JButton waterButton;

  private JTextField moneyIn;
  private JLabel message;
  private JLabel banner;
  private JLabel banner1;
  private JLabel banner2;
  private Container contentPane; //to reference the content panel

  //init method
  public void init(){
    //set background
    getContentPane().setBackground(new Color(96, 96, 96));
    setPreferredSize(new Dimension(1000, 1000));
    //build buttonPanel
    buildButtonPanel();
    //build moneyPanel
    buildMoneyPanel();
    //create label w/ banner
    banner = new JLabel("ICE COLD COLAS $0.75 each.");
    // banner = new JLabel("ICE COLD");
    // banner1 = new JLabel("COLAS");
    // banner2 = new JLabel("$0.75 each");
    banner.setFont(new Font("Ariel", Font.ITALIC, 30));
    // banner1.setFont(new Font("Ariel", Font.ITALIC, 30));
    // banner2.setFont(new Font("Ariel", Font.ITALIC, 30));
    //add buttons and banner to content panel
    add(buttonPanel, BorderLayout.EAST);
    add(moneyPanel, BorderLayout.NORTH);
    add(banner, BorderLayout.CENTER);
    // add(banner1, BorderLayout.CENTER);
    // add(banner2, BorderLayout.CENTER);

  }

  private void buildButtonPanel(){
    //create new panel
    buttonPanel = new JPanel();
    //create the buttons
    colaButton = new JButton("Cola");
    //For MACs this is needed to change backgroufn color of a button
    colaButton.setOpaque(true);
    colaButton.setBorderPainted(false);
    colaButton.setBackground(Color.red);
    colaButton.setForeground(Color.gray);
    llButton = new JButton("Lemon-Lime");
    llButton.setOpaque(true);
    llButton.setBorderPainted(false);
    llButton.setBackground(new Color(153, 255, 51));
    llButton.setForeground(Color.gray);
    grapeButton = new JButton("Grape");
    grapeButton.setOpaque(true);
    grapeButton.setBorderPainted(false);
    grapeButton.setBackground(new Color(204, 0, 204));
    grapeButton.setForeground(new Color(224, 224, 224));
    rbButton = new JButton("Rootbeer");
    rbButton.setOpaque(true);
    rbButton.setBorderPainted(false);
    rbButton.setBackground(new Color(102, 51, 0));
    rbButton.setForeground(new Color(224, 224, 224));
    waterButton = new JButton("Water");
    waterButton.setOpaque(true);
    waterButton.setBorderPainted(false);
    waterButton.setBackground(new Color(153, 204, 255));
    waterButton.setForeground(Color.gray);
    //add action listeners
    colaButton.addActionListener(new ButtonListener());
    llButton.addActionListener(new ButtonListener());
    grapeButton.addActionListener(new ButtonListener());
    rbButton.addActionListener(new ButtonListener());
    waterButton.addActionListener(new ButtonListener());
    //set layout for buttons
    buttonPanel.setLayout(new GridLayout(5,1));

    buttonPanel.add(colaButton);
    buttonPanel.add(llButton);
    buttonPanel.add(grapeButton);
    buttonPanel.add(rbButton);
    buttonPanel.add(waterButton);
  }
  private void buildMoneyPanel(){
    //create new panel
    moneyPanel = new JPanel();
    //create a lbale to display message
    message = new JLabel("Enter Your Money");
    //create a text field for money submitted
    moneyIn = new JTextField(3);
    moneyIn.setText("0.00");
    //create a layout manager for the panel
    moneyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    //add label
    moneyPanel.add(message);
    moneyPanel.add(moneyIn);

  }

  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){

      double amount = getAmountIn();
      if(amount < PRICE){
        JOptionPane.showMessageDialog(null, "Please enter more money to make purchase.");
      }
      else{
        if(e.getSource() == colaButton)
        giveCola(amount);
        else if(e.getSource() == llButton)
        giveLL(amount);
        else if(e.getSource() == grapeButton)
        giveGrape(amount);
        else if(e.getSource() == rbButton)
        giveRB(amount);
        else
        giveWater(amount);

        moneyIn.setText("0.00");
      }
    }

    private double getAmountIn(){
      double amount;
      try{
        amount = Double.parseDouble(moneyIn.getText());
      }
      catch(Exception e){
        amount = 0;
        moneyIn.setText("0.00");
      }
      return amount;
    }

    private void giveCola(double amount){
      double change;

      if (colaInv > 0){
        change = amount - PRICE;
        colaInv--;
        JOptionPane.showMessageDialog(null, String.format("Here is your can of Cola and $%,.2f in change.", change));
      }
      else{
      JOptionPane.showMessageDialog(null, "We are out of that flavor, please select a different flavor.");
      }
    }
    private void giveLL(double amount){
      double change;

      if (llInv > 0){
        change = amount - PRICE;
        llInv--;
        JOptionPane.showMessageDialog(null, String.format("Here is your can of Lemon-Lime and $%,.2f in change.", change));
      }
      else{
      JOptionPane.showMessageDialog(null, "We are out of that flavor, please select a different flavor.");
      }
    }
    private void giveGrape(double amount){
      double change;

      if (grapeInv > 0){
        change = amount - PRICE;
        grapeInv--;
        JOptionPane.showMessageDialog(null, String.format("Here is your can of Grape and $%,.2f in change.", change));
      }
      else{
      JOptionPane.showMessageDialog(null, "We are out of that flavor, please select a different flavor.");
      }
    }
    private void giveRB(double amount){
      double change;

      if (rbInv > 0){
        change = amount - PRICE;
        rbInv--;
        JOptionPane.showMessageDialog(null, String.format("Here is your can of Rootbeer and $%,.2f in change.", change));
      }
      else{
      JOptionPane.showMessageDialog(null, "We are out of that flavor, please select a different flavor.");
      }
    }
    private void giveWater(double amount){
      double change;

      if (waterInv > 0){
        change = amount - PRICE;
        waterInv--;
        JOptionPane.showMessageDialog(null, String.format("Here is your bottle of water and $%,.2f in change.", change));
      }
      else{
      JOptionPane.showMessageDialog(null, "We are out of that flavor, please select a different flavor.");
      }
    }

  }

 public static void main(String[] args){

 }
}
