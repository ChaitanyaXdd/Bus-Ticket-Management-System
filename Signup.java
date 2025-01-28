import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import Fonts.*;


import static javax.swing.JOptionPane.*;

public class Signup extends JFrame implements ActionListener
{
    JPanel panel;
    JFrame frame;
    JLabel name, uinfo,password,haveacc,title,dob,db,req1,req2,req3,confirmpwd;
    public static JTextField uname, udetails,dofb;
    static JPasswordField pwd,conpwd;
    public static JButton signup,back;
    public static String n,u;
    public Signup()
    {
        setTitle("Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(580,200,820,680);
        Container c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);

        title = new JLabel("Signup");
        title.setBounds(360,65,150,55);
        title.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
        title.setForeground(Color.red);
        c.add(title);

        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        panel.setBounds(110,120,600,410);

        name = new JLabel("Enter name : ");
        name.setBounds(40,30,150,30);
        name.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        name.setForeground(Color.BLACK);
        panel.add(name);

        uname = new JTextField("");
        uname.setBounds(210,30,230,35);
        uname.setFont(new Font("",Font.BOLD,17));
        panel.add(uname);

        req1 = new JLabel("");
        req1.setForeground(Color.red);
        req1.setBounds(450,30,90,30);
        panel.add(req1);

        uinfo = new JLabel("Username : ");
        uinfo.setBounds(40,90,150,30);
        uinfo.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        uinfo.setForeground(Color.BLACK);
        panel.add(uinfo);

        udetails = new JTextField("");
        udetails.setBounds(210,90,230,35);
        udetails.setFont(new Font("",Font.BOLD,17));
        panel.add(udetails);

        req2 = new JLabel("");
        req2.setForeground(Color.red);
        req2.setBounds(450,90,90,30);
        panel.add(req2);

        password = new JLabel("Enter Password :");
        password.setBounds(40,150,230,30);
        password.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        password.setForeground(Color.BLACK);
        panel.add(password);

        pwd = new JPasswordField("");
        pwd.setBounds(210,150,230,35);
        pwd.setFont(new Font("",Font.BOLD,17));
        panel.add(pwd);

        req3 = new JLabel("");
        req3.setForeground(Color.red);
        req3.setBounds(450,150,90,30);
        panel.add(req3);

        confirmpwd = new JLabel("Confirm Password : ");
        confirmpwd.setBounds(40,210,230,30);
        confirmpwd.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        confirmpwd.setForeground(Color.BLACK);
        panel.add(confirmpwd);

        conpwd = new JPasswordField("");
        conpwd.setBounds(210,210,230,35);
        conpwd.setFont(new Font("",Font.BOLD,17));
        panel.add(conpwd);

        signup = new JButton("Signup");
        signup.setBounds(100,290,120,30);
        signup.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        signup.addActionListener(this);
        panel.add(signup);

        back = new JButton("Back");
        back.setBounds(300,290,120,30);
        back.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        back.addActionListener(this);
        panel.add(back);

        haveacc = new JLabel("Already have an account?");
        haveacc.setBounds(160,340,210,30);
        haveacc.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        haveacc.setForeground(Color.BLACK);
        panel.add(haveacc);
        haveacc.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                if(me.getSource()==haveacc)
                {
                    new Login();
                    setVisible(false);
                }
            }
        });

        c.add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String userdetails = udetails.getText();

        JButton b = (JButton)ae.getSource();
        if(b==back)
        {
            new HomePage();
            setVisible(false);
        }

        if(b==signup)
        {
            Connection con = null;
            Statement stmt = null,stmt2 = null;
            ResultSet rs = null,rs2 = null;
            PreparedStatement ps1 = null;

            String name,username,password;

            try
            {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql:loginpage","postgres","chaitanya");

                ps1 = con.prepareStatement("Insert into signup values(?,?,?)");

                if(con==null)

                    System.out.println("Connection Failed");

                else
                {
                    System.out.println("Connection Successful");
                    stmt = con.createStatement();

                    name = uname.getText();
                    username = udetails.getText();
                    password = pwd.getText();
                    if(uname.getText().length()!=0)
                    {
                        if(udetails.getText().length()!=0)
                        {
                            if (pwd.getText().equals(conpwd.getText()))
                            {
                                ps1.setString(1, name);
                                ps1.setString(2, username);
                                ps1.setString(3, password);

                                new Confirm();
                                setVisible(false);
                            }
                        }
                    }
                    else
                    {
                       JFrame f = new JFrame();
                       JOptionPane.showMessageDialog(f,"Please Fill The Required Fields");

                       new Signup();
                       setVisible(false);
                    }
                    ps1.executeUpdate();
                }
                con.close();
            }
            catch(Exception e)
            {
                System.out.println("ERROR" + e);
            }
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Signup();
    }
}