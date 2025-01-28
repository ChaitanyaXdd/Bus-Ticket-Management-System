/*Write a program which shows the combo box which includes list of T.Y.B.Sc.(Comp. Sci)
subjects. Display the selected subject in a text field.*/

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
public class Bus extends JFrame implements ItemListener
{
    JComboBox cb1,cb2,cb3;
    JLabel l;
    JTextField t;
    JFrame frame;
    JButton b;

    private StringBuffer s1=new StringBuffer();
    String from[] = {"Pune"};
    String to[] = {"Java","Web Technologies","TCS","Python","Operating System","Computer Networks","Blockchain","Data Science"};
    Bus()
    {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        setBounds(100,100,1100,800);
        Container c = getContentPane();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100,100,900,400);

        l = new JLabel("From : ");
        l.setBounds(10, 40, 70, 30);
        panel.add(l);

        cb1 = new JComboBox(from);
        cb1.setBounds(90, 40, 150, 30);
        cb1.addItemListener(this);
        panel.add(cb1);

        cb2 = new JComboBox(to);
        cb2.setBounds(260, 40, 150, 30);
        cb2.addItemListener(this);
        panel.add(cb2);

        t = new JTextField(" ");
        t.setBounds(10, 100, 300, 30);
        panel.add(t);

        b = new JButton("Submit");
        b.setBounds(10,200,300,70);
        panel.add(b);

        c.add(panel);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent ie)
    {
        if(ie.getSource()== cb2)
        {
            if(cb2.getSelectedItem().equals("Java"))
            {
                new Login();
            }
        }
    }

    public static void main(String[] args)
    {
        new Bus();
    }
}
