import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import Fonts.*;

public class adminuser extends JFrame implements ActionListener
{
    JLabel title;
    JButton user,admin,back;
    adminuser()
    {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        setBounds(650,200,500,500);
        Container c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        panel.setBounds(100,100,300,250);

        title = new JLabel("Select Login");
        title.setBounds(180,70,180,30);
        title.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
        title.setForeground(Color.red);
        c.add(title);

        admin = new JButton("Admin");
        admin.setBounds(70,50,150,40);
        admin.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        admin.addActionListener(this);
        panel.add(admin);

        user = new JButton("User");
        user.setBounds(70,110,150,40);
        user.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        user.addActionListener(this);
        panel.add(user);

        back = new JButton("Back");
        back.setBounds(70,180,150,40);
        back.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        back.addActionListener(this);
        panel.add(back);

        c.add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        JButton b = (JButton)ae.getSource();
        if(b==admin)
        {
            new AdminLogin();
            setVisible(false);
        }

        if(b==user)
        {
            new Login();
            setVisible(false);
        }

        if(b==back)
        {
            new HomePage();
            setVisible(false);
        }
    }

    /*public static void main(String[] args)
    {
        new adminuser();
    }*/
}
