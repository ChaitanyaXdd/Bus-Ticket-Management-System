import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
//import Fonts.*;

class BusSeats extends JFrame implements ItemListener,ActionListener
{
    public static int cnt = 1 ,total = 0;
    public static String t;
    public static JLabel Travelo,Pedia,home,profile,to,from,faq;
    public static JCheckBox seats[] = new JCheckBox[38];
    JLabel select;
    public static JTextField blank,seatprint,transcost;
    BusSeats()
    {
        setTitle("Bus Seats");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(350,150,1100,800);
        Container c = getContentPane();

        JPanel panel = new JPanel();
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

        faq = new JLabel("FAQ");
        faq.setBounds(290,15,70,30);
        faq.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        faq.setForeground(Color.ORANGE);
        panel.add(faq);

        profile = new JLabel("Profile");
        profile.setBounds(1000,15,70,30);
        profile.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        profile.setForeground(Color.GREEN);
        panel.add(profile);
        profile.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                if(me.getSource()==profile)
                {
                    new Profile();
                    setVisible(false);

                    Profile.username.setText(Login.uname.getText());

                    Connection con = null;
                    Statement stmt = null;
                    ResultSet rs = null,rs2 = null;
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
                            rs = stmt.executeQuery("Select * from profile");

                            while(rs.next())
                            {
                                Profile.name.setText(rs.getString(1));
                                Profile.dateofbirth.setText(rs.getString(5));
                                Profile.email.setText(rs.getString(3));
                                String p = String.valueOf(rs.getLong(4));
                                Profile.phone.setText(p);
                                Profile.gentext.setText(rs.getString(6));
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
        });

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel2.setBounds(30,80,1045,65);

        transcost = new JTextField("");
        transcost.setBounds(10,10,80,30);
        transcost.setForeground(Color.LIGHT_GRAY);
        transcost.setEditable(false);
        transcost.setBackground(Color.LIGHT_GRAY);
        transcost.setBorder(BorderFactory.createEmptyBorder());
        panel2.add(transcost);

        to = new JLabel("Pune  To");
        to.setBounds(300,20,160,30);
        to.setFont(new Font("Segoe Print",Font.BOLD,30));
        to.setForeground(Color.BLACK);
        panel2.add(to);

        from = new JLabel("");
        from.setBounds(470,20,250,30);
        from.setFont(new Font("Segoe Print",Font.BOLD,30));
        from.setForeground(Color.BLACK);
        panel2.add(from);

        ImageIcon icon = new ImageIcon("C:\\Users\\Dell G5\\IdeaProjects\\Final Project\\Seats1.jpg");
        JPanel panel4 = new JPanel();
        panel4.setBounds(45,180,650,700);
        panel4.add(new JLabel(icon));

        select = new JLabel("Select Seats : ");
        select.setForeground(Color.red);
        select.setFont(new Font("Segoe Print",Font.PLAIN,30));
        select.setBounds(760,180,220,30);
        c.add(select);

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel3.setBounds(750,220,270,430);

        seatprint = new JTextField("");
        seatprint.setBounds(750,660,270,30);
        c.add(seatprint);

        JButton book = new JButton("Book Seats");
        book.setBounds(810,700,150,30);
        book.setBackground(Color.LIGHT_GRAY);
        book.setFont(new Font("Segoe Print",Font.PLAIN,18));
        book.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton b = (JButton) e.getSource();
                if(b==book)
                {
                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    PreparedStatement ps = null;

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
                            System.out.println("Connection Successful");


                            st = con.createStatement();
                            rs = st.executeQuery("Select * from seats");
                            ps = con.prepareStatement("Insert into seats values(?,?,?,?)");

                            String u = Profile.username.getText();
                            String c = HP_Profile.to.getText();
                            String d = HP_Profile.date1.getText();
                            String s = seatprint.getText();

                            ps.setString(1,u);
                            ps.setString(2,c);
                            ps.setString(3,d);
                            ps.setString(4,s);

                            while(rs.next())
                            {
                                if(HP_Profile.to.getText().equals(rs.getString(2)))
                                {
                                    if(HP_Profile.date1.getText().equals(rs.getString(3)))
                                    {
                                        if(seatprint.getText().equals(rs.getString(4)))
                                        {
                                            JFrame f = new JFrame();
                                            JOptionPane.showMessageDialog(f,"Seats are booked");

                                            new BusSeats();
                                            setVisible(false);
                                            break;
                                        }
                                    }
                                }
                                else
                                {
                                    new Payment();
                                    setVisible(false);
                                    Payment.nmlbl.setText(Profile.name.getText());
                                    int cnt1 = BusSeats.cnt;
                                    int cost = Integer.parseInt(transcost.getText());
                                    total = cost * cnt1;
                                    t = String.valueOf(total);
                                    Payment.amt.setText(t + "/-");
                                }
                            }

                            ps.executeUpdate();


                        }
                        con.close();
                    }
                    catch (Exception oe)
                    {

                    }
                }
            }
        });
        c.add(book);

        blank = new JTextField("");
        blank.setBounds(150,20,100,60);
        blank.setBackground(Color.GRAY);
        blank.setEditable(false);
        panel3.add(blank);

        seats[1] = new JCheckBox("A1");
        seats[1].setBounds(20,20,50,30);

        seats[2] = new JCheckBox("A2");
        seats[2].setBounds(70,20,50,30);

        /*seats[3] = new JCheckBox("A4");
        seats[3].setBounds(200,20,50,30);*/

        seats[3] = new JCheckBox("B1");
        seats[3].setBounds(20,60,50,30);

        seats[4] = new JCheckBox("B2");
        seats[4].setBounds(70,60,50,30);

        /*seats[7] = new JCheckBox("B4");
        seats[7].setBounds(200,60,50,30);*/

        seats[5] = new JCheckBox("C1");
        seats[5].setBounds(20,100,50,30);

        seats[6] = new JCheckBox("C2");
        seats[6].setBounds(70,100,50,30);

        seats[7] = new JCheckBox("C3");
        seats[7].setBounds(150,100,50,30);

        seats[8] = new JCheckBox("C4");
        seats[8].setBounds(200,100,50,30);

        seats[9] = new JCheckBox("D1");
        seats[9].setBounds(20,140,50,30);

        seats[10] = new JCheckBox("D2");
        seats[10].setBounds(70,140,50,30);

        seats[11] = new JCheckBox("D3");
        seats[11].setBounds(150,140,50,30);

        seats[12] = new JCheckBox("D4");
        seats[12].setBounds(200,140,50,30);

        seats[13] = new JCheckBox("E1");
        seats[13].setBounds(20,180,50,30);

        seats[14] = new JCheckBox("E2");
        seats[14].setBounds(70,180,50,30);

        seats[15] = new JCheckBox("E3");
        seats[15].setBounds(150,180,50,30);

        seats[16] = new JCheckBox("E4");
        seats[16].setBounds(200,180,50,30);

        seats[17] = new JCheckBox("F1");
        seats[17].setBounds(20,220,50,30);

        seats[18] = new JCheckBox("F2");
        seats[18].setBounds(70,220,50,30);

        seats[19] = new JCheckBox("F3");
        seats[19].setBounds(150,220,50,30);

        seats[20] = new JCheckBox("F4");
        seats[20].setBounds(200,220,50,30);

        seats[21] = new JCheckBox("G1");
        seats[21].setBounds(20,260,50,30);

        seats[22] = new JCheckBox("G2");
        seats[22].setBounds(70,260,50,30);

        seats[23] = new JCheckBox("G3");
        seats[23].setBounds(150,260,50,30);

        seats[24] = new JCheckBox("G4");
        seats[24].setBounds(200,260,50,30);

        seats[25] = new JCheckBox("H1");
        seats[25].setBounds(20,300,50,30);

        seats[26] = new JCheckBox("H2");
        seats[26].setBounds(70,300,50,30);

        seats[27] = new JCheckBox("H3");
        seats[27].setBounds(150,300,50,30);

        seats[28] = new JCheckBox("H4");
        seats[28].setBounds(200,300,50,30);

        seats[29] = new JCheckBox("I1");
        seats[29].setBounds(20,340,50,30);

        seats[30] = new JCheckBox("I2");
        seats[30].setBounds(70,340,50,30);

        seats[31] = new JCheckBox("I3");
        seats[31].setBounds(150,340,50,30);

        seats[32] = new JCheckBox("I4");
        seats[32].setBounds(200,340,50,30);

        seats[33] = new JCheckBox("J1");
        seats[33].setBounds(20,380,50,30);

        seats[34] = new JCheckBox("J2");
        seats[34].setBounds(65,380,50,30);

        seats[35] = new JCheckBox("J3");
        seats[35].setBounds(115,380,50,30);

        seats[36] = new JCheckBox("J4");
        seats[36].setBounds(155,380,50,30);

        seats[37] = new JCheckBox("J5");
        seats[37].setBounds(200,380,50,30);

        for(int i = 1;i<38;i++)
        {
            panel3.add(seats[i]);
            seats[i].addItemListener(this);

        }
        System.out.println(cnt);

        c.add(panel);
        c.add(panel2);
        c.add(panel3);
        c.add(panel4);
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent e)
    {
        int i;
        String s="";
        for(i=1;i<38;i++)
        {
            if(seats[i].isSelected())
            {
                s=s+""+seats[i].getText();
            }
        }
        cnt = BusSeats.seatprint.getText().length();
        cnt = cnt / 2 + 1;
        seatprint.setText(s);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Connection con = null;
        PreparedStatement ps = null;
        Statement st = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql:loginpage","postgres","chaitanya");
            st = con.createStatement();
            if(con==null)
            {
                System.out.println("No");
            }
            else
            {
                ps = con.prepareStatement("insert into citydate values(?)");
                String s = seatprint.getText();
                ps.setString(4,s);
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        new BusSeats();
    }
}