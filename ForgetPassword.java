import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.module.ResolutionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import Fonts.*;
public class ForgetPassword extends JFrame
{
    JLabel user,title,cap,entcap,generate;
    JTextField unm,seecap,entercap;
    JButton get,back;
    ForgetPassword()
    {
        setTitle("Forgot Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(650,200,680,540);
        Container c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);

        title = new JLabel("Forgot Password");
        title.setBounds(215,45,250,55);
        title.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
        title.setForeground(Color.red);
        c.add(title);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        panel.setBounds(120,100,430,300);

        user = new JLabel("Your Username : ");
        user.setBounds(40,30,250,30);
        user.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        user.setForeground(Color.BLACK);
        panel.add(user);

        unm = new JTextField("");
        unm.setBounds(180,30,200,35);
        unm.setFont(new Font("",Font.BOLD,17));
        panel.add(unm);

        cap = new JLabel("CAPTCHA : ");
        cap.setBounds(40,90,150,30);
        cap.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        cap.setForeground(Color.BLACK);
        panel.add(cap);

        seecap = new JTextField("");
        seecap.setBounds(140,90,180,35);
        seecap.setFont(new Font("Segoe Print",Font.BOLD,17));
        seecap.setEditable(false);
        panel.add(seecap);

        generate = new JLabel("Generate New Captcha");
        generate.setBounds(140,135,230,30);
        generate.setFont(new Font("Serif",Font.PLAIN,16));
        generate.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
                getAlphaNumericString(999999);
                StringBuilder sb = new StringBuilder(999999);

                for (int i = 0; i < 6; i++)
                {
                    int index = (int)(AlphaNumericString.length() * Math.random());
                    sb.append(AlphaNumericString.charAt(index));
                }
                seecap.setText(sb.toString());
            }

            private void getAlphaNumericString(int n)
            {
            }

        });
        panel.add(generate);

        entcap = new JLabel("Enter Captcha : ");
        entcap.setBounds(40,180,150,30);
        entcap.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        entcap.setForeground(Color.BLACK);
        panel.add(entcap);

        entercap = new JTextField("");
        entercap.setBounds(170,180,120,30);
        panel.add(entercap);

        get = new JButton("Get Password");
        get.setBounds(50,240,200,35);
        get.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        get.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JButton b = (JButton)ae.getSource();

                if(b==get)
                {
                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;

                    try
                    {
                        Class.forName("org.postgresql.Driver");
                        con = DriverManager.getConnection("jdbc:postgresql:loginpage","postgres","chaitanya");

                        if(con==null)
                        {
                            System.out.println("Connection Failed");
                        }
                        else
                        {
                            st = con.createStatement();
                            rs = st.executeQuery("Select * from signup");

                            while(rs.next())
                            {
                                if(seecap.getText().equals(entercap.getText()))
                                {
                                    if(entercap.getText().length()!=0)
                                    {
                                        if (rs.getString(2).equals(unm.getText()))
                                        {
                                            String s = rs.getString(3);
                                            JFrame f = new JFrame();
                                            JOptionPane.showMessageDialog(f, "Password : " + s);
                                        }
                                    }
                                    else
                                    {
                                        JFrame f1 = new JFrame();
                                        JOptionPane.showMessageDialog(f1,"Please Enter Captcha");
                                    }
                                }
                                else
                                {
                                    JFrame f1 = new JFrame();
                                    JOptionPane.showMessageDialog(f1,"Incorrect Captcha");
                                }
                            }
                        }
                    }
                    catch(Exception ge)
                    {
                        ge.printStackTrace();
                    }
                }

            }
        });
        panel.add(get);

        back = new JButton("Back");
        back.setBounds(290,240,80,35);
        back.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                JButton b = (JButton)e.getSource();
                if(b==back)
                {
                    new Login();
                    setVisible(false);
                }

            }
        });
        panel.add(back);


        panel.setLayout(null);
        c.add(panel);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new ForgetPassword();

    }


}
