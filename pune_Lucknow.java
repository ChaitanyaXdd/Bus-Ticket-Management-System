import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pune_Lucknow extends JFrame implements ActionListener
{
    public static int p1,p2,p3,p4;
    JLabel Travelo,Pedia,home,help,bname1,bname2,bname3,bname4,btype1,btype2,btype3,btype4, departure1, departure2, departure3, departure4;
    JLabel depttime1,depttime2,depttime3,depttime4,cost1,cost2,cost3,cost4,pkg;
    JRadioButton single1,single2,single3,single4,return1,return2,return3,return4;
    ButtonGroup BG;
    JButton viewseats1,viewseats2,viewseats3,viewseats4;
    pune_Lucknow()
    {
        setTitle("Pune to Lucknow");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        setBounds(450,150,1100,800);
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
            public void mouseClicked(MouseEvent me)
            {
                if(me.getSource()==home)
                {
                    setVisible(false);
                    new HP_Profile();
                }
            }
        });
        panel.add(home);

        help = new JLabel("Help");
        help.setBounds(910,15,70,30);
        help.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        help.setForeground(Color.ORANGE);
        panel.add(help);

        JLabel back = new JLabel("Back");
        back.setBounds(1000,15,70,30);
        back.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        back.setForeground(Color.ORANGE);
        back.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                new HP_Profile();
            }
        });
        panel.add(back);

        BG = new ButtonGroup();

        pkg = new JLabel("Select Package");
        pkg.setBounds(420,80,240,35);;
        pkg.setFont(new Font("Serif",Font.PLAIN,30));
        pkg.setForeground(Color.red);
        c.add(pkg);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(100,130,900,140);
        panel2.setBackground(Color.LIGHT_GRAY);

        bname1 = new JLabel("realBus");
        bname1.setBounds(10,10,130,30);;
        bname1.setFont(new Font("Serif",Font.PLAIN,23));
        bname1.setForeground(Color.red);
        panel2.add(bname1);

        btype1 = new JLabel("Volvo A/C Seater (2+1)");
        btype1.setBounds(10,50,170,30);;
        btype1.setFont(new Font("Serif",Font.PLAIN,13));
        btype1.setForeground(Color.BLACK);
        panel2.add(btype1);

        departure1 = new JLabel("Departure Time");
        departure1.setBounds(210,10,140,30);;
        departure1.setFont(new Font("Dialog",Font.PLAIN,17));
        departure1.setForeground(Color.BLACK);
        panel2.add(departure1);

        depttime1 = new JLabel("19.30");
        depttime1.setBounds(240,60,80,30);
        depttime1.setFont(new Font("Monotype Corsiva",Font.PLAIN,30));
        depttime1.setForeground(Color.BLACK);
        panel2.add(depttime1);

        cost1 = new JLabel("Cost");
        cost1.setBounds(460,10,60,30);
        cost1.setFont(new Font("Dialog",Font.PLAIN,17));
        cost1.setForeground(Color.BLACK);
        panel2.add(cost1);

        single1 = new JRadioButton("Single  :  INR 4200");
        single1.setBounds(410,50,220,30);
        single1.setFont(new Font("Serif",Font.PLAIN,18));
        single1.setForeground(Color.BLACK);
        single1.setBackground(Color.LIGHT_GRAY);
        BG.add(single1);
        panel2.add(single1);

        viewseats1 = new JButton("View Seats");
        viewseats1.setBounds(700,50,140,40);
        viewseats1.addActionListener(this);
        viewseats1.setBackground(Color.WHITE);
        viewseats1.setFont(new Font("Segoe Print",Font.PLAIN,18));
        panel2.add(viewseats1);
        viewseats1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JButton b1 = (JButton)ae.getSource();

                if(b1==viewseats1)
                {
                    new BusSeats();
                    setVisible(false);

                    BusSeats.from.setText(HP_Profile.to.getText());

                    p1 = 4200;
                    BusSeats.transcost.setText(String.valueOf(p1));
                }
            }
        });

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(100,280,900,140);
        panel3.setBackground(Color.LIGHT_GRAY);

        bname2 = new JLabel("realBus");
        bname2.setBounds(10,10,130,30);;
        bname2.setFont(new Font("Serif",Font.PLAIN,23));
        bname2.setForeground(Color.red);
        panel3.add(bname2);

        btype2 = new JLabel("Volvo A/C Seater (2+1)");
        btype2.setBounds(10,50,170,30);;
        btype2.setFont(new Font("Serif",Font.PLAIN,13));
        btype2.setForeground(Color.BLACK);
        panel3.add(btype2);

        departure2 = new JLabel("Departure Time");
        departure2.setBounds(210,10,140,30);;
        departure2.setFont(new Font("Dialog",Font.PLAIN,17));
        departure2.setForeground(Color.BLACK);
        panel3.add(departure2);

        depttime2 = new JLabel("22.00");
        depttime2.setBounds(240,60,80,30);
        depttime2.setFont(new Font("Monotype Corsiva",Font.PLAIN,30));
        depttime2.setForeground(Color.BLACK);
        panel3.add(depttime2);

        cost2 = new JLabel("Cost");
        cost2.setBounds(460,10,60,30);
        cost2.setFont(new Font("Dialog",Font.PLAIN,17));
        cost2.setForeground(Color.BLACK);
        panel3.add(cost2);

        single2 = new JRadioButton("Single  :  INR 4570");
        single2.setBounds(410,50,220,30);
        single2.setFont(new Font("Serif",Font.PLAIN,18));
        single2.setForeground(Color.BLACK);
        single2.setBackground(Color.LIGHT_GRAY);
        BG.add(single2);
        panel3.add(single2);

        viewseats2 = new JButton("View Seats");
        viewseats2.setBounds(700,50,140,40);
        viewseats2.addActionListener(this);
        viewseats2.setBackground(Color.WHITE);
        viewseats2.setFont(new Font("Segoe Print",Font.PLAIN,18));
        panel3.add(viewseats2);
        viewseats2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JButton b1 = (JButton)ae.getSource();

                if(b1==viewseats2)
                {
                    new BusSeats();
                    setVisible(false);

                    BusSeats.from.setText(HP_Profile.to.getText());

                    p2 = 4570;
                    BusSeats.transcost.setText(String.valueOf(p2));
                }
            }
        });

        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBounds(100,430,900,140);
        panel4.setBackground(Color.LIGHT_GRAY);

        bname3 = new JLabel("realBus");
        bname3.setBounds(10,10,130,30);;
        bname3.setFont(new Font("Serif",Font.PLAIN,23));
        bname3.setForeground(Color.red);
        panel4.add(bname3);

        btype3 = new JLabel("Volvo A/C Seater (2+1)");
        btype3.setBounds(10,50,170,30);;
        btype3.setFont(new Font("Serif",Font.PLAIN,13));
        btype3.setForeground(Color.BLACK);
        panel4.add(btype3);

        departure3 = new JLabel("Departure Time");
        departure3.setBounds(210,10,140,30);;
        departure3.setFont(new Font("Dialog",Font.PLAIN,17));
        departure3.setForeground(Color.BLACK);
        panel4.add(departure3);

        depttime3 = new JLabel("23.30");
        depttime3.setBounds(240,60,80,30);
        depttime3.setFont(new Font("Monotype Corsiva",Font.PLAIN,30));
        depttime3.setForeground(Color.BLACK);
        panel4.add(depttime3);

        cost3 = new JLabel("Cost");
        cost3.setBounds(460,10,60,30);
        cost3.setFont(new Font("Dialog",Font.PLAIN,17));
        cost3.setForeground(Color.BLACK);
        panel4.add(cost3);

        single3 = new JRadioButton("Single  :  INR 4300");
        single3.setBounds(410,50,220,30);
        single3.setFont(new Font("Serif",Font.PLAIN,18));
        single3.setForeground(Color.BLACK);
        single3.setBackground(Color.LIGHT_GRAY);
        BG.add(single3);
        panel4.add(single3);

        viewseats3 = new JButton("View Seats");
        viewseats3.setBounds(700,50,140,40);
        viewseats3.addActionListener(this);
        viewseats3.setBackground(Color.WHITE);
        viewseats3.setFont(new Font("Segoe Print",Font.PLAIN,18));
        panel4.add(viewseats3);
        viewseats3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JButton b1 = (JButton)ae.getSource();

                if(b1==viewseats3)
                {
                    new BusSeats();
                    setVisible(false);

                    BusSeats.from.setText(HP_Profile.to.getText());

                    p3 = 4300;
                    BusSeats.transcost.setText(String.valueOf(p3));
                }
            }
        });

        JPanel panel5 = new JPanel();
        panel5.setLayout(null);
        panel5.setBounds(100,580,900,140);
        panel5.setBackground(Color.LIGHT_GRAY);

        bname4 = new JLabel("easyBus");
        bname4.setBounds(10,10,130,30);;
        bname4.setFont(new Font("Serif",Font.PLAIN,23));
        bname4.setForeground(Color.red);
        panel5.add(bname4);

        btype4 = new JLabel("Volvo A/C Seater (2+1)");
        btype4.setBounds(10,50,170,30);;
        btype4.setFont(new Font("Serif",Font.PLAIN,13));
        btype4.setForeground(Color.BLACK);
        panel5.add(btype4);

        departure4 = new JLabel("Departure Time");
        departure4.setBounds(210,10,140,30);;
        departure4.setFont(new Font("Dialog",Font.PLAIN,17));
        departure4.setForeground(Color.BLACK);
        panel5.add(departure4);

        depttime4 = new JLabel("1.00");
        depttime4.setBounds(240,60,80,30);
        depttime4.setFont(new Font("Monotype Corsiva",Font.PLAIN,30));
        depttime4.setForeground(Color.BLACK);
        panel5.add(depttime4);

        cost4 = new JLabel("Cost");
        cost4.setBounds(460,10,60,30);
        cost4.setFont(new Font("Dialog",Font.PLAIN,17));
        cost4.setForeground(Color.BLACK);
        panel5.add(cost4);

        single4= new JRadioButton("Single  :  INR 4000");
        single4.setBounds(410,50,220,30);
        single4.setFont(new Font("Serif",Font.PLAIN,18));
        single4.setForeground(Color.BLACK);
        single4.setBackground(Color.LIGHT_GRAY);
        BG.add(single4);
        panel5.add(single4);

        viewseats4 = new JButton("View Seats");
        viewseats4.setBounds(700,50,140,40);
        viewseats4.addActionListener(this);
        viewseats4.setBackground(Color.WHITE);
        viewseats4.setFont(new Font("Segoe Print",Font.PLAIN,18));
        panel5.add(viewseats4);
        viewseats4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JButton b1 = (JButton)ae.getSource();

                if(b1==viewseats4)
                {
                    new BusSeats();
                    setVisible(false);

                    BusSeats.from.setText(HP_Profile.to.getText());

                    p4 = 4000;
                    BusSeats.transcost.setText(String.valueOf(p4));
                }
            }
        });

        c.add(panel);
        c.add(panel2);
        c.add(panel3);
        c.add(panel4);
        c.add(panel5);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {

    }

    public static void main(String[] args)
    {
        new pune_Lucknow();
    }
}
