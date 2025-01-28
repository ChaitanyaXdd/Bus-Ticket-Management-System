import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import Fonts.*;

public class Login extends JFrame implements ActionListener
{
    JLabel user,pass,fpass,noacc,signup,title;
    static JTextField uname;
    public static JButton login,back;
    static JPasswordField pwd;
    public static String q,su;
    public Login()
    {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(600,200,700,600);
        Container c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);

        title = new JLabel("User Login");
        title.setBounds(240,65,200,55);
        title.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
        title.setForeground(Color.red);
        c.add(title);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        panel.setBounds(120,120,430,300);

        user = new JLabel("Username : ");
        user.setBounds(40,30,150,30);
        user.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        user.setForeground(Color.BLACK);
        panel.add(user);

        uname = new JTextField("");
        uname.setBounds(170,30,180,35);
        uname.setFont(new Font("",Font.BOLD,17));
        panel.add(uname);
        q = uname.getText();

        pass = new JLabel("Password  : ");
        pass.setBounds(40,90,150,30);
        pass.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        pass.setForeground(Color.BLACK);
        panel.add(pass);

        pwd = new JPasswordField("");
        pwd.setBounds(170,90,180,35);
        pwd.setFont(new Font("", Font.BOLD,18));
        panel.add(pwd);

        login = new JButton("Login");
        login.setBounds(40,170,150,30);
        login.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        login.addActionListener(this);
        panel.add(login);

        back = new JButton("Back");
        back.setBounds(250,170,120,30);
        back.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        back.addActionListener(this);
        panel.add(back);

        fpass = new JLabel("Forget Password?");
        fpass.setBounds(250,230,150,30);
        fpass.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        fpass.setForeground(Color.BLACK);
        fpass.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new ForgetPassword();
                setVisible(false);
            }
        });
        panel.add(fpass);

        noacc = new JLabel("Don't have an account?");
        noacc.setBounds(20,230,180,30);
        noacc.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        noacc.setForeground(Color.BLACK);
        panel.add(noacc);

        signup = new JLabel("SignUp");
        signup.setBounds(80,250,180,30);
        signup.setFont(new Font("Segoe Print", Font.PLAIN, 12));
        signup.setForeground(Color.BLACK);
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

        c.add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        JButton b = (JButton)ae.getSource();

        if(b==back)
        {
            new HomePage();
            setVisible(false);
        }

        if(login==b)
        {
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try
            {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql:loginpage","postgres","chaitanya");

                if (con == null)
                {
                    System.out.println("Connection Unsuccessful");
                }
                else
                {
                    System.out.println("Connection Successful");

                    stmt = con.createStatement();
                    rs = stmt.executeQuery("Select * from signup");

                    while(rs.next())
                    {
                        if(rs.getString(2).equals(uname.getText()))
                        {
                            if(rs.getString(3).equals(pwd.getText()))
                            {
                                new HP_Profile();
                                setVisible(false);
                            }
                        }
                        else
                        {
                        }
                    }
                }
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("ERROR" + e);
            }
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}