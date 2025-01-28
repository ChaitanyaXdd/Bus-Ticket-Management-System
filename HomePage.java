import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
//import Fonts.*;

class HomePage extends JFrame implements ActionListener
{
    public static JLabel Travelo,Pedia,home,login,signup,about,footabout,faq,contact,mail;
    JTextArea copyright,abtinfo,call,email;

    HomePage()
    {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        setBounds(350,150,1100,800);
        Container c = getContentPane();

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0,0,1100,65);

        Travelo = new JLabel("Travelo");
        Travelo.setBounds(8,15,120,30);
        Travelo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 35));
        Travelo.setForeground(Color.CYAN);
        panel.add(Travelo);

        Pedia = new JLabel("Pedia");
        Pedia.setBounds(102,15,120,30);
        Pedia.setFont(new Font("Monotype Corsiva", Font.PLAIN, 35));
        Pedia.setForeground(Color.ORANGE);
        panel.add(Pedia);

        home = new JLabel("Home");
        home.setBounds(210,15,70,30);
        home.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        home.setForeground(Color.ORANGE);
        panel.add(home);

        signup = new JLabel("SignUp");
        signup.setBounds(900,15,90,30);
        signup.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        signup.setForeground(Color.GREEN);
        panel.add(signup);
        signup.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                if(me.getSource()==signup)
                {
                    new Signup();
                    setVisible(false);
                }
            }
        });

        login = new JLabel("Login");
        login.setBounds(1000,15,70,30);
        login.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        login.setForeground(Color.GREEN);
        panel.add(login);
        login.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                if(me.getSource()==login)
                {
                    new adminuser();
                    setVisible(false);
                }
            }
        });

        ImageIcon icon = new ImageIcon("C:\\Users\\Dell G5\\IdeaProjects\\Final Project\\B.jpg");
        JPanel panel3 = new JPanel();
        panel3.setBounds(0,50,1100,580);
        panel3.add(new JLabel(icon));

        JPanel panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.DARK_GRAY);
        panel2.setBounds(0,610,1100,160);

        copyright = new JTextArea("© 2023 TraveloPedia Pvt. Ltd.\n");
        copyright.setBounds(15,125,230,20);
        copyright.setEditable(false);
        copyright.setFont(new Font("Serif", Font.PLAIN, 15));
        copyright.setBackground(Color.darkGray);
        copyright.setForeground(Color.WHITE);
        panel2.add(copyright);

        mail = new JLabel("Email ID : ");
        mail.setBounds(20,20,130,30);
        mail.setForeground(Color.GREEN);
        mail.setFont(new Font("Segoe Print",Font.PLAIN,20));
        panel2.add(mail);

        email = new JTextArea("support@travelopedia.com");
        email.setBounds(20,65,270,30);
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setEditable(false);
        email.setBackground(Color.darkGray);
        email.setForeground(Color.WHITE);
        panel2.add(email);

        contact = new JLabel("Contact : ");
        contact.setBounds(380,18,130,30);
        contact.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        contact.setForeground(Color.GREEN);
        panel2.add(contact);

        call = new JTextArea("+91 9816673945,\n\n+91 8324349083");
        call.setBounds(380,65,160,50);
        call.setFont(new Font("Arial", Font.PLAIN, 15));
        call.setEditable(false);
        call.setBackground(Color.darkGray);
        call.setForeground(Color.WHITE);
        panel2.add(call);

        footabout = new JLabel("About");
        footabout.setBounds(620,20,702,20);
        footabout.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        footabout.setForeground(Color.GREEN);
        panel2.add(footabout);

        abtinfo = new JTextArea("TraveloPedia is the Pune's largest online bus ticket booking " +
                 "\nservice trusted by over 25 thousand happy customers city wide.\nTraveloPedia " +
                "offers bus ticket booking through its website,iOS \nand Android mobile apps for all major routes.");
        abtinfo.setBounds(620,50,460,70);
        abtinfo.setEditable(false);
        abtinfo.setFont(new Font("Seoge Print",Font.PLAIN,15));
        abtinfo.setBackground(Color.darkGray);
        abtinfo.setForeground(Color.WHITE);
        panel2.add(abtinfo);

        c.add(panel);
        c.add(panel2);
        c.add(panel3);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {

    }

    public static void main(String[] args)
    {
        new HomePage();
    }
}