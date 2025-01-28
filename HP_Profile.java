import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.sql.*;
//import Fonts.*;

public class HP_Profile extends JFrame implements ActionListener
{
    static JLabel Travelo,Pedia,home,profile,about,footabout,f,t,date,faq,contact,mail;
    JButton search,dte;
    JComboBox cb;
    JTextField from;
    static  JTextField to;
    static JTextField date1;
    JTextArea copyright,abtinfo,call,email;
    //String from[] = {"Pune"};
    String tocombo[] = {"Select City","Indore","Bhopal","Jaipur","Ahmedabad","Visakhapatnam","Lucknow","Kanpur","Nagpur","Banglore","Chennai"};
    public String name1,uname;

    public HP_Profile()
    {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(440,150,1100,800);
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
        home.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new HomePage();
                setVisible(false);

            }
        });
        panel.add(home);

        about = new JLabel("About");
        about.setBounds(290,15,70,30);
        about.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        about.setForeground(Color.ORANGE);
        about.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new About();
                setVisible(false);
            }

        });
        panel.add(about);

        profile = new JLabel("Profile");
        profile.setBounds(1000,15,70,30);
        profile.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        profile.setForeground(Color.GREEN);
        panel.add(profile);
        profile.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                new Profile();
                setVisible(false);

                Connection con = null;
                Statement stmt = null,stmt2 = null;
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
                        rs = stmt.executeQuery("Select * from signup");

                        stmt2 = con.createStatement();
                        rs2 = stmt2.executeQuery("Select * from profile");


                        while(rs.next())
                        {
                            if(rs.getString(2).equals(Login.uname.getText()))
                            {
                                Profile.username.setText(rs.getString(2));
                            }
                        }

                        while(rs2.next())
                        {
                            if(rs2.getString(2).equals(Login.uname.getText()))
                            {
                                Profile.name.setText(rs2.getString(1));
                                Profile.email.setText(rs2.getString(3));
                                Profile.phone.setText(String.valueOf(rs2.getLong(4)));
                                Profile.dateofbirth.setText(rs2.getString(5));
                                Profile.gentext.setText(rs2.getString(6));
                            }
                        }
                    }
                    con.close();
                }
                catch (Exception e)
                {
                    System.out.println("ERROR" + e);
                }

                //Profile.username.setText(Login.uname.getText());
            }
        });

        ImageIcon icon = new ImageIcon("C:\\Users\\Dell G5\\IdeaProjects\\Final Project\\Bus.jpg");
        JPanel panel4 = new JPanel();
        panel4.setBounds(0,125,700,720);
        panel4.add(new JLabel(icon));

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(Color.lightGray);
        panel3.setBounds(730,110,300,450);

        f = new JLabel("From : ");
        f.setFont(new Font("Segoe Print",Font.PLAIN,20));
        f.setBounds(20, 40, 80, 30);
        panel3.add(f);

        from = new JTextField("Pune");
        from.setBounds(40, 90, 180, 30);
        from.setFont(new Font("",Font.BOLD,17));
        from.setEditable(false);
        panel3.add(from);

        t = new JLabel("To : ");
        t.setFont(new Font("Segoe Print",Font.PLAIN,20));
        t.setBounds(20, 140, 80, 30);
        panel3.add(t);

        cb = new JComboBox(tocombo);
        cb.setBounds(40,190,180,30);
        cb.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
                if(ie.getStateChange()==ie.SELECTED)
                {
                    String no = cb.getSelectedItem().toString();
                    to.setText(no);
                }
            }
        });
        panel3.add(cb);

        to = new JTextField("");
        to.setBounds(40, 240, 180, 30);
        to.setFont(new Font("",Font.BOLD,17));
        panel3.add(to);

        JFrame f = new JFrame();

        JButton b = new JButton("Select Date");
        b.setBounds(40,290,150,30);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                date1.setText(new DatePicker(f).setPickedDate());

            }
        });
        panel3.add(b);

        date = new JLabel("Selected Date : ");
        date.setBounds(20,340,180,30);
        date.setFont(new Font("Segoe Print",Font.PLAIN,18));
        panel3.add(date);

        date1 = new JTextField("");
        date1.setBounds(170,340,105,30);
        date1.setFont(new Font("",Font.BOLD,15));
        date1.setEditable(false);
        panel3.add(date1);

        search = new JButton("Search");
        search.setBounds(90,400,120,30);
        search.setBackground(Color.pink);
        search.addActionListener(this);
        panel3.add(search);

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

        abtinfo = new JTextArea("TraveloPedia is the world's largest online bus ticket booking " +
                "\nservice trusted by over 25 million happy customers globally.\nTraveloPedia " +
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
        c.add(panel4);
        setVisible(true);
    }

    private void displayDate()
    {
    }

    public void actionPerformed(ActionEvent ae)
    {
        JButton jb = (JButton)ae.getSource();
        if(date1.getText().length()!=0 && to.getText().length()!=0)
        {
            if(jb==search)
            {
                Connection con1 = null,con2 = null;
                Statement stmt1 = null,stmt2 = null;
                ResultSet rs = null;
                PreparedStatement ps1 = null,ps2 = null;

                String source,username,date;

                try
                {
                    Class.forName("org.postgresql.Driver");
                    con1 = DriverManager.getConnection("jdbc:postgresql:loginpage","postgres","chaitanya");

                    ps1 = con1.prepareStatement("Insert into citydate values(?,?,?)");


                    if(con1==null)
                    {
                        System.out.println("Connection Failed");
                    }

                    else
                    {
                        System.out.println("Connection Succesful");
                        stmt1 = con1.createStatement();


                        source = to.getText();
                        date = date1.getText();
                        username = Login.uname.getText();
                        if(to.getText().length()!=0)
                        {
                            if(date1.getText().length()!=0)
                            {
                                ps1.setString(1, username);
                                ps1.setString(2, date);
                                ps1.setString(3, source);
                            }
                        }
                        ps1.executeUpdate();

                    }
                    try
                    {
                        Class.forName("org.postgresql.Driver");
                        con2 = DriverManager.getConnection("jdbc:postgresql:admin","postgres","chaitanya");

                        ps2 = con2.prepareStatement("Insert into cd values(?,?,?)");

                        if(con2==null)
                        {
                            System.out.println("Connection Failed");
                        }

                        else
                        {
                            System.out.println("Connection Successful");
                            stmt2 = con2.createStatement();

                            source = to.getText();
                            date = date1.getText();
                            username = Login.uname.getText();

                            if(to.getText().length()!=0)
                            {
                                if(date1.getText().length()!=0)
                                {
                                    ps2.setString(1,username);
                                    ps2.setString(2, date);
                                    ps2.setString(3, source);
                                }
                            }
                            ps2.executeUpdate();
                        }
                        con1.close();
                        con2.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println("ERROR" + e);
                    }

                }
                catch(Exception e)
                {
                    System.out.println("ERROR" + e);
                }



                if(to.getText().equals("Ahmedabad"))
                {
                    setVisible(false);
                    new pune_Ahmedabad();
                }
                else if(to.getText().equals("Banglore"))
                {
                    setVisible(false);
                    new pune_Banglore();
                }
                else if(to.getText().equals("Bhopal"))
                {
                    setVisible(false);
                    new pune_Bhopal();
                }
                else if(to.getText().equals("Chennai"))
                {
                    setVisible(false);
                    new pune_Chennai();
                }
                else if(to.getText().equals("Indore"))
                {
                    setVisible(false);
                    new pune_Indore();
                }
                else if(to.getText().equals("Jaipur"))
                {
                    setVisible(false);
                    new pune_Jaipur();
                }
                else if(to.getText().equals("Kanpur"))
                {
                    setVisible(false);
                    new pune_Kanpur();
                }
                else if(to.getText().equals("Lucknow"))
                {
                    setVisible(false);
                    new pune_Lucknow();
                }
                else if(to.getText().equals("Nagpur"))
                {
                    setVisible(false);
                    new pune_Nagpur();
                }
                else if(to.getText().equals("Visakhapatnam"))
                {
                    setVisible(false);
                    new pune_Visakhapatnam();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(f,"Please Fill The Required Fields!!!");
        }
        class DatePicker {
            int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
            int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
            JLabel l = new JLabel("", JLabel.CENTER);
            String day = "";
            JDialog d;
            JButton[] button = new JButton[49];

            public void DatePicker(JFrame parent) {
                d = new JDialog();
                d.setModal(true);
                String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
                JPanel p1 = new JPanel(new GridLayout(7, 7));
                p1.setPreferredSize(new Dimension(430, 120));

                for (int x = 0; x < button.length; x++) {
                    final int selection = x;
                    button[x] = new JButton();
                    button[x].setFocusPainted(false);
                    button[x].setBackground(Color.white);
                    if (x > 6) {
                        button[x].addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                day = button[selection].getActionCommand();
                                d.dispose();
                            }
                        });
                    }
                    if (x < 7) {
                        button[x].setText(header[x]);
                        button[x].setForeground(Color.red);
                    }
                    p1.add(button[x]);
                }
                JPanel p2 = new JPanel(new GridLayout(1, 3));

                // Previous month button
                JButton previous = new JButton("<< Previous");
                previous.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        month--;
                        displayDate();
                    }
                });
                p2.add(previous);

                // Current month label between the previous and next buttons
                p2.add(l);

                // Next month button
                JButton next = new JButton("Next >>");
                next.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        month++;
                        displayDate();
                    }
                });
                p2.add(next);

                d.add(p1, BorderLayout.CENTER);
                d.add(p2, BorderLayout.SOUTH);
                d.pack();
                d.setLocationRelativeTo(parent);
                displayDate();
                d.setVisible(true);
            }

            public void displayDate() {
                for (int x = 7; x < button.length; x++) {
                    button[x].setText("");
                }

                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(year, month, 1);
                int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
                int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

                for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
                    button[x].setText("" + day);
                }

                l.setText(sdf.format(cal.getTime()));
                d.setTitle("Choose Date");
            }

            public String setPickedDate() {
                if (day.equals("")) {
                    return day;
                }

                // Set the return date format
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");

                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(year, month, Integer.parseInt(day));
                return sdf.format(cal.getTime());
            }
        }
    }

    public static void main(String[] args)
    {
        new HP_Profile();
    }
}