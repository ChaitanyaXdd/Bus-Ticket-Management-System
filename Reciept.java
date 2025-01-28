import javax.swing.*;
import java.awt.*;

public class Reciept extends JFrame
{
    public static JLabel Travelo,Pedia,name,pno,phone,nm,from,to,f,t,date,d,nos,id,i,booked,amount,hj,finalcost;
    public static JTextArea call,seats;
    JTextField line;
    Reciept()
    {
        setTitle("Reciept");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Container c = getContentPane();
        c.setBackground(Color.WHITE);
        setBounds(520,50,800,900);

        ImageIcon icon = new ImageIcon("/C:\\Users\\Dell G5\\IdeaProjects\\Final Project\\Logo.jpg");
        JPanel panel = new JPanel();
        panel.setBounds(30,30,200,190);
        panel.add(new JLabel(icon));

        Travelo = new JLabel("Travelo");
        Travelo.setBounds(270,60,235,70);
        Travelo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 85));
        Travelo.setForeground(Color.RED);
        c.add(Travelo);

        Pedia = new JLabel("Pedia");
        Pedia.setBounds(495,60,230,70);
        Pedia.setFont(new Font("Monotype Corsiva", Font.PLAIN, 85));
        Pedia.setForeground(Color.BLACK);
        c.add(Pedia);

        call = new JTextArea("+91 9527040283,+91 9311670359");
        call.setBounds(470,170,280,30);
        call.setFont(new Font("Arial", Font.PLAIN, 15));
        call.setEditable(false);
        call.setBackground(Color.white);
        call.setForeground(Color.black);
        c.add(call);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(40,240,720,185);
        panel2.setBorder(BorderFactory.createTitledBorder(""));
        panel2.setBackground(Color.WHITE);
        c.add(panel2);

        name = new JLabel("Name : ");
        name.setBounds(20,20,100,30);
        name.setFont(new Font("Segoe Print",Font.PLAIN,22));
        name.setForeground(Color.BLACK);
        panel2.add(name);

        nm = new JLabel("");
        nm.setBounds(120,20,365,30);
        nm.setFont(new Font("Segoe Print",Font.PLAIN,22));
        panel2.add(nm);

        id = new JLabel("Reciept ID : ");
        id.setBounds(560,20,150,30);
        id.setFont(new Font("Segoe Print",Font.PLAIN,22));
        id.setForeground(Color.BLACK);
        panel2.add(id);

        i = new JLabel("");
        i.setBounds(560,60,365,30);
        i.setFont(new Font("Segoe Print",Font.PLAIN,22));
        panel2.add(i);

        phone = new JLabel("Phone No : ");
        phone.setBounds(20,60,150,30);
        phone.setFont(new Font("Segoe Print",Font.PLAIN,22));
        phone.setForeground(Color.BLACK);
        panel2.add(phone);

        pno = new JLabel("");
        pno.setBounds(160,60,250,30);
        pno.setFont(new Font("Segoe Print",Font.PLAIN,22));
        panel2.add(pno);

        from = new JLabel("From : ");
        from.setBounds(20,100,100,30);
        from.setFont(new Font("Segoe Print",Font.PLAIN,22));
        from.setForeground(Color.BLACK);
        panel2.add(from);

        f = new JLabel("Pune");
        f.setBounds(110,100,100,30);
        f.setFont(new Font("Segoe Print",Font.PLAIN,22));
        panel2.add(f);

        to = new JLabel("To : ");
        to.setBounds(240,100,100,30);
        to.setFont(new Font("Segoe Print",Font.PLAIN,22));
        to.setForeground(Color.BLACK);
        panel2.add(to);

        t = new JLabel("");
        t.setBounds(295,100,400,30);
        t.setFont(new Font("Segoe Print",Font.PLAIN,22));
        panel2.add(t);

        date = new JLabel("Date : ");
        date.setBounds(20,140,150,30);
        date.setFont(new Font("Segoe Print",Font.PLAIN,22));
        date.setForeground(Color.BLACK);
        panel2.add(date);

        d = new JLabel("");
        d.setBounds(100,140,190,30);
        d.setFont(new Font("Segoe Print",Font.PLAIN,22));
        panel2.add(d);

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(40,425,720,300);
        panel3.setBorder(BorderFactory.createTitledBorder(""));
        panel3.setBackground(Color.WHITE);
        c.add(panel3);

        booked = new JLabel("Booked Seats");
        booked.setBounds(70,10,180,30);
        booked.setFont(new Font("Segoe Print",Font.PLAIN,22));
        booked.setForeground(Color.BLACK);
        panel3.add(booked);

        seats = new JTextArea("");
        seats.setBounds(30,60,250,120);
        seats.setFont(new Font("Segoe Print",Font.PLAIN,22));
        seats.setBorder(BorderFactory.createEmptyBorder());
        seats.setEditable(false);
        panel3.add(seats);

        line = new JTextField("");
        line.setBounds(10,230,700,2);
        line.setEditable(false);
        panel3.add(line);

        amount = new JLabel("Amount ");
        amount.setBounds(390,250,120,30);
        amount.setFont(new Font("Segoe Print",Font.PLAIN,22));
        amount.setForeground(Color.BLACK);
        panel3.add(amount);

        finalcost = new JLabel("");
        finalcost.setBounds(550,250,170,30);
        finalcost.setFont(new Font("Segoe Print",Font.BOLD,27));
        panel3.add(finalcost);

        hj = new JLabel("HAPPY JOURNEY!!");
        hj.setBounds(150,770,600,50);
        hj.setFont(new Font("Segoe Print",Font.PLAIN,50));
        hj.setForeground(Color.BLACK);
        c.add(hj);

        c.add(panel);
        c.add(createHorizontalSeparator());
        panel3.add(createVerticalSeparator());
        setVisible(true);


    }
    static JComponent createHorizontalSeparator()
    {
        JSeparator x = new JSeparator(SwingConstants.HORIZONTAL);
        x.setPreferredSize(new Dimension(50,2));
        x.setBounds(20,200,750,5);
        x.setForeground(Color.BLACK);
        return x;
    }

    static JComponent createVerticalSeparator()
    {
        JSeparator y = new JSeparator(SwingConstants.VERTICAL);
        y.setPreferredSize(new Dimension(50,2));
        y.setBounds(520,10,50,280);
        y.setForeground(Color.BLACK);
        return y;
    }

    public static void main(String[] args)
    {
        new Reciept();
    }
}

