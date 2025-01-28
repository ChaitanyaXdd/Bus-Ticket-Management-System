//import org.postgresql.Driver;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.regex.*;
//import Fonts.*;
public class Profile extends JFrame implements ActionListener,ItemListener
{
    JLabel Travelo,Pedia,home,logout,nm,eid,pinfo,unm,pno,gen,addr,dob,dd_mm_yyyy,faq;
    public static JTextField name;
    public static JTextField username;
    public static JTextField phone,email,dateofbirth,gentext;
    public static JRadioButton male,female;
    JButton edit,save,clear,back,delete,update;

    public Profile()
    {
        setTitle("Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(440,150,1150,820);
        Container c = getContentPane();
        c.setBackground(Color.WHITE);


        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0,0,1150,65);

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

        logout = new JLabel("Logout");
        logout.setBounds(1050,15,70,30);
        logout.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        logout.setForeground(Color.GREEN);
        logout.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JFrame f = new JFrame();
                int result = JOptionPane.showConfirmDialog(f,"Confirm Logout","Logout Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(result==JOptionPane.YES_OPTION)
                {
                    new HomePage();
                    setVisible(false);
                }
                else if(result==JOptionPane.NO_OPTION)
                {
                    new Profile();
                    setVisible(false);
                }
            }
        });
        panel.add(logout);

        ImageIcon icon = new ImageIcon("C:\\Users\\Dell G5\\IdeaProjects\\Final Project\\Profile1.jpg");
        JPanel panel2 = new JPanel();
        panel2.setBounds(30,80,210,200);
        panel2.add(new JLabel(icon));

        unm = new JLabel("Username : ");
        unm.setBounds(20,300,140,30);
        unm.setFont(new Font("Segoe Print",Font.PLAIN,20));
        unm.setForeground(Color.BLACK);
        c.add(unm);

        username = new JTextField("");
        username.setBounds(27,340,220,40);
        username.setFont(new Font("Serif",Font.BOLD,17));
        username.setEditable(false);
        c.add(username);

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(338,80,750,330);
        panel3.setBackground(Color.WHITE);
        panel3.setBorder(BorderFactory.createTitledBorder("PERSONAL INFORMATION"));

        nm = new JLabel("Name : ");
        nm.setBounds(20,50,150,30);
        nm.setFont(new Font("Segoe Print",Font.PLAIN,27));
        nm.setForeground(Color.BLACK);
        panel3.add(nm);

        name = new JTextField("");
        name.setBounds(150,50,350,30);
        name.setFont(new Font("",Font.BOLD,18));
        name.setEditable(false);
        panel3.add(name);

        dob = new JLabel("Date Of Birth : ");
        dob.setBounds(20,140,230,30);
        dob.setFont(new Font("Segoe Print",Font.PLAIN,27));
        dob.setForeground(Color.BLACK);
        panel3.add(dob);

        dateofbirth = new JTextField("");
        dateofbirth.setBounds(250,140,180,30);
        dateofbirth.setFont(new Font("",Font.BOLD,18));
        dateofbirth.setEditable(false);
        panel3.add(dateofbirth);

        dd_mm_yyyy = new JLabel("DD-MM-YYYY");
        dd_mm_yyyy.setBounds(470,140,220,30);
        dd_mm_yyyy.setFont(new Font("Serif",Font.PLAIN,29));
        panel3.add(dd_mm_yyyy);

        gen = new JLabel("Gender : ");
        gen.setBounds(20,235,130,30);
        gen.setFont(new Font("Segoe Print",Font.PLAIN,27));
        gen.setForeground(Color.BLACK);
        panel3.add(gen);

        ButtonGroup G = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(150,235,100,30);
        male.setFont(new Font("Serif",Font.PLAIN,20));
        male.setBackground(Color.LIGHT_GRAY);
        male.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent ie)
            {
                if(ie.getSource().equals(male))
                {
                    gentext.setText("Male");
                }
            }
        });
        G.add(male);
        panel3.add(male);

        female = new JRadioButton("Female");
        female.setBounds(260,235,130,30);
        female.setFont(new Font("Serif",Font.PLAIN,20));
        female.setBackground(Color.LIGHT_GRAY);
        female.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent ie)
            {
                if(ie.getSource().equals(female))
                {
                    gentext.setText("Female");
                }
            }
        });
        G.add(female);
        panel3.add(female);

        gentext = new JTextField("");
        gentext.setBounds(420,235,100,30);
        gentext.setForeground(Color.BLACK);
        gentext.setEditable(false);
        gentext.setBorder(BorderFactory.createEmptyBorder());
        gentext.setFont(new Font("",Font.BOLD,17));
        panel3.add(gentext);

        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBounds(338,460,750,210);
        panel4.setBackground(Color.WHITE);
        panel4.setBorder(BorderFactory.createTitledBorder("CONTACT DETAILS"));

        eid = new JLabel("Email Address : ");
        eid.setBounds(20,50,230,30);
        eid.setFont(new Font("Segoe Print",Font.PLAIN,27));
        eid.setForeground(Color.BLACK);
        panel4.add(eid);

        email = new JTextField("");
        email.setBounds(250,50,320,30);
        email.setFont(new Font("",Font.BOLD,17));
        email.setEditable(false);
        panel4.add(email);

        pno = new JLabel("Phone Number : ");
        pno.setBounds(20,130,250,30);
        pno.setFont(new Font("Segoe Print",Font.PLAIN,27));
        pno.setForeground(Color.BLACK);
        panel4.add(pno);

        phone = new JTextField("");
        phone.setBounds(250,130,150,30);
        phone.setFont(new Font("",Font.BOLD,18));
        phone.setEditable(false);
        panel4.add(phone);

        edit = new JButton("Edit Profile");
        edit.setBounds(210,740,170,30);
        edit.setFont(new Font("Segoe Print",Font.PLAIN,20));
        edit.addActionListener(this);
        c.add(edit);

        clear = new JButton("Clear");
        clear.setBounds(425,740,120,30);
        clear.setFont(new Font("Segoe Print",Font.PLAIN,20));
        clear.addActionListener(this);
        c.add(clear);

        save = new JButton("Save Changes");
        save.setBounds(755,740,170,30);
        save.setFont(new Font("Segoe Print",Font.PLAIN,20));
        save.addActionListener(this);
        c.add(save);

        back = new JButton("Back");
        back.setBounds(590,740,120,30);
        back.setFont(new Font("Segoe Print",Font.PLAIN,20));
        back.addActionListener(this);
        c.add(back);

        c.add(panel);
        c.add(panel2);
        c.add(panel3);
        c.add(panel4);
        setVisible(true);
        c.add(createVerticalSeparator());
    }

    static JComponent createVerticalSeparator()
    {
        JSeparator x = new JSeparator(SwingConstants.VERTICAL);
        x.setPreferredSize(new Dimension(2,50));
        x.setBounds(280,80,2,630);
        x.setForeground(Color.BLACK);
        return x;
    }

    public void itemStateChanged(ItemEvent ie)
    {
    }
    public void actionPerformed(ActionEvent ae)
    {
        JButton b = (JButton)ae.getSource();

        if(b==edit)
        {
            name.setEditable(true);
            email.setEditable(true);
            username.setEditable(false);
            dateofbirth.setEditable(true);
            phone.setEditable(true);
        }

        if(b==clear)
        {
            name.setText("");
            email.setText("");
            phone.setText("");
        }

        if(b==back)
        {
            new HP_Profile();
            setVisible(false);
        }

        if(b==save)
        {
            Connection con = null,con1 = null;
            Statement stmt = null,stmt1 = null;
            ResultSet rs = null,rs1 = null;
            PreparedStatement ps1 = null,ps2 = null;

            try
            {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql:loginpage","postgres","chaitanya");

                ps1 = con.prepareStatement("Insert into profile values(?,?,?,?,?,?)");

                if(con==null)

                    System.out.println("Connection Failed");

                else
                {
                    System.out.println("Connection Successful");
                    stmt = con.createStatement();

                    String n = name.getText();
                    String un = username.getText();
                    String e = email.getText();
                    long p = Long.parseLong(phone.getText());
                    String dbirth = dateofbirth.getText();
                    String g = gentext.getText();
                    String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
                    boolean result = e.matches(regex);


                    if(name.getText().length()!=0)
                    {
                        if(username.getText().length()!=0)
                        {
                            if (email.getText().length()!=0)
                            {
                                if(phone.getText().length()==10)
                                {
                                    if(dateofbirth.getText().length()!=0)
                                    {
                                        if(result)
                                        {


                                                ps1.setString(1, n);
                                                ps1.setString(2, un);
                                                ps1.setString(3, e);
                                                ps1.setLong(4, p);
                                                ps1.setString(5, dbirth);
                                                ps1.setString(6, g);


                                        }
                                        else
                                        {
                                            JFrame f = new JFrame();
                                            JOptionPane.showMessageDialog(f,"Invalid email");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ps1.executeUpdate();
                }


                try
                {
                    Class.forName("org.postgresql.Driver");
                    con1 = DriverManager.getConnection("jdbc:postgresql:admin","postgres","chaitanya");

                    ps2 = con1.prepareStatement("Insert into profile values(?,?,?,?,?,?)");

                    if(con1==null)

                        System.out.println("Connection Failed");

                    else
                    {
                        System.out.println("Connection Successful");
                        stmt1 = con.createStatement();

                        String n = name.getText();
                        String un = username.getText();
                        String e = email.getText();
                        long p = Long.parseLong(phone.getText());
                        String dbirth = dateofbirth.getText();
                        String g = gentext.getText();
                        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
                        boolean result = e.matches(regex);


                        if(name.getText().length()!=0)
                        {
                            if(username.getText().length()!=0)
                            {
                                if (email.getText().length()!=0)
                                {
                                    if(phone.getText().length()==10)
                                    {
                                        if(dateofbirth.getText().length()!=0)
                                        {
                                            if(result)
                                            {
                                                    ps2.setString(1, n);
                                                    ps2.setString(2, un);
                                                    ps2.setString(3, e);
                                                    ps2.setLong(4, p);
                                                    ps2.setString(5, dbirth);
                                                    ps2.setString(6, g);
                                            }
                                            else
                                            {
                                                JFrame f = new JFrame();
                                                JOptionPane.showMessageDialog(f,"Invalid email");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        ps2.executeUpdate();
                    }
                    con.close();
                    con1.close();
                }
                catch(Exception e)
                {
                    System.out.println("ERROR" + e);
                }
                con.close();
            }
            catch(Exception e)
            {
                System.out.println("ERROR" + e);
            }
        }
    }

    public static void main(String[] args)
    {
        new Profile();
    }
}