import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConvert extends JFrame implements ActionListener {
    private JButton b1;
    private JButton b2;
    private JTextField t;
    private Container box;
    public TempConvert(){
        this.setTitle("Temperature converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        box = this.getContentPane();
        box.setLayout(new FlowLayout());

        b1 = new JButton("Convert to celsius");
        b2 = new JButton("convert to farenheit");
        t = new JTextField(10);

        b1.addActionListener(this);
        b2.addActionListener(this);
        t.addActionListener(this);
        
        
        box.add(b1);
        box.add(b2);
        box.add(t);
    }
    
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        System.out.println(s);
    }


    public static double FtoC(double t){
        return t * 1.8 + 32;
    }
    
    public static double CtoF(double t){
        return (t - 32) * (5.0 / 9);
    }
    
    
    public static void main(String[] args){
        TempConvert t = new TempConvert();
        t.setVisible(true);
    }
}
