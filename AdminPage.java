import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.security.PrivilegedExceptionAction;
import java.sql.*;
//import Fonts.*;


public class AdminPage extends JFrame implements ActionListener
{
    JLabel admin,datelbl,citylbl;
    DefaultTableModel model,model2;
    JComboBox cb;
    JScrollPane jsp,jsp2;
    JTable jt,jt2;
    JTextField date,city, transparent1,transparent2,transparent3,transparent4,transparent5,transparent6;
    JButton show,clear,search;
    static JTextField aname;
    String tocombo[] = {"Select City","Indore","Bhopal","Jaipur","Ahemdabad","Visakhapatnam","Lucknow","Kanpur","Nagpur","Banglore","Chennai"};

    public AdminPage()
    {
        setTitle("Admin Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(580,200,900,600);
        Container c = getContentPane();
        c.setBackground(Color.WHITE);

        admin = new JLabel("Admin : ");
        admin.setBounds(540,20,120,30);
        admin.setFont(new Font("Serif",Font.PLAIN,25));
        c.add(admin);

        aname = new JTextField("");
        aname.setBounds(660,20,200,30);
        aname.setFont(new Font("",Font.BOLD,17));
        aname.setEditable(false);
        c.add(aname);

        JButton b = new JButton("Select Date");
        b.setBounds(60,80,150,30);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JFrame f = new JFrame();
                date.setText(new DatePicker(f).setPickedDate());
            }
        });
        c.add(b);

        date = new JTextField("");
        date.setBounds(260,80,120,30);
        date.setFont(new Font("",Font.BOLD,17));
        c.add(date);


        cb = new JComboBox(tocombo);
        cb.setBounds(60,130,180,30);
        cb.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
                if(ie.getStateChange()==ie.SELECTED)
                {
                    String no = cb.getSelectedItem().toString();
                    city.setText(no);
                }
            }
        });
        c.add(cb);

        city = new JTextField("");
        city.setBounds(260, 130, 180, 30);
        city.setFont(new Font("",Font.BOLD,17));
        c.add(city);

        show = new JButton("Show");
        show.setBounds(470,80,80,30);
        show.addActionListener(this);
        c.add(show);

        clear = new JButton("Clear");
        clear.setBounds(470,130,80,30);
        clear.addActionListener(this);
        c.add(clear);

        transparent1 = new JTextField("");
        transparent1.setBounds(400,270,120,30);
        transparent1.setBorder(BorderFactory.createEmptyBorder());
        transparent1.setBackground(Color.LIGHT_GRAY);
        transparent1.setFont(new Font("",Font.BOLD,17));
        c.add(transparent1);

        search = new JButton("Search User Details");
        search.setBounds(530,270,190,30);
        search.addActionListener(this);
        c.add(search);

        model = new DefaultTableModel();

        jt = new JTable(model);

        model.addColumn("Username");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Phone");
        model.addColumn("Date Of Birth");
        model.addColumn("Gender");

        jsp = new JScrollPane(jt);
        jsp.setBounds(5,380,800,100);

        model2 = new DefaultTableModel();

        jt2 = new JTable(model2);

        model2.addColumn("Username");
        model2.addColumn("Date");
        model2.addColumn("City");

        jsp2 = new JScrollPane(jt2);
        jsp2.setBounds(5,270,350,100);

        c.add(jsp);
        c.add(jsp2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        JButton b = (JButton) ae.getSource();
        JButton b1 = (JButton) ae.getSource();
        if (b == clear) {
            date.setText("");
            city.setText("");
        }

        if(b1 == show)
        {
            Connection con = null;
            Statement st1 = null,st2 = null,st3 = null;
            ResultSet rs1 = null,rs2 = null,rs3 = null;

            try
            {
                System.out.println("Done");
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql:admin","postgres","chaitanya");

                st1 = con.createStatement();


                String dc = "Select * from cd where date = '" + date.getText() + "' and city = '" + city.getText() + "'";

                if(con==null)
                {
                    System.out.println("Connection Failed");
                }
                else
                {
                    System.out.println("Connection Successful");
                    rs1 = st1.executeQuery(dc);
                    while(rs1.next())
                    {
                        model2.addRow(new Object[]{rs1.getString(1), rs1.getString(2), rs1.getString(3)});
                    }
                }
                con.close();

            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
        }

        if(b==search)
        {
            Connection con2 = null;
            Statement st2 = null;
            ResultSet rs2 = null;

            try
            {
                System.out.println("GG");
                Class.forName("org.postgresql.Driver");
                con2 = DriverManager.getConnection("jdbc:postgresql:admin","postgres","chaitanya");

                st2 = con2.createStatement();


                String pc = "Select * from profile where username = '" + transparent1.getText() + "'" ;

                if(con2==null)
                {
                    System.out.println("Connection Failed");
                }
                else
                {
                    System.out.println("Connection Successful");
                    rs2 = st2.executeQuery(pc);
                    while(rs2.next())
                    {
                        model.addRow(new Object[]{rs2.getString(2), rs2.getString(1), rs2.getString(3),rs2.getLong(4),rs2.getString(5),rs2.getString(6)});
                    }
                }

                con2.close();
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
        }

        class DatePicker
        {
            int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
            int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            ;
            JLabel l = new JLabel("", JLabel.CENTER);
            String day = "";
            JDialog d;
            JButton[] button = new JButton[49];

            public void DatePicker(JFrame parent) {
                d = new JDialog();
                d.setModal(true);
                String[] header = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
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
        new AdminPage();
    }
}