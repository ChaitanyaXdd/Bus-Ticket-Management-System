import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import Fonts.*;

public class About extends JFrame
{
    JTextArea about,adr;
    JButton faq,back;
    About()
    {
        setTitle("About");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        setBounds(400,150,1100,800);
        Container c = getContentPane();
        c.setBackground(Color.WHITE);

        about = new JTextArea("We have our branches in:\n\n\n");
        about.setBounds(20,20,800,40);
        about.setFont(new Font("Serif",Font.BOLD,25));
        about.setEditable(false);
        c.add(about);

        back = new JButton("<-Go Back");
        back.setBounds(840,20,130,30);
        back.setFont(new Font("Segoe Print",Font.PLAIN,15));
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new HP_Profile();
                setVisible(false);
            }
        });
        c.add(back);

        faq = new JButton("FAQ");
        faq.setBounds(990,20,80,30);
        faq.setFont(new Font("Segoe Print",Font.BOLD,17));
        faq.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Faq();
                setVisible(false);
            }
        });
        c.add(faq);

        adr = new JTextArea("Katraj :  Elixir Infotech Pune, Office No 15, Panache Mall, Tiranga Chowk,\n" +
                "              Pune  - 411043\n\n\n" +
                            "Hadapsar : Postmaster, Hadapsar S.O, Pune, Maharashtra, India (IN),\n                  Pune - 411028\n\n\n" +
                            "Swargate : Araneshwar, Near Jagtap and Chavan Mall, Swargate,\n                 Pune - 414045\n\n\n" +
                            "Aundh : Near Aloma County, Near Lifeline Hospital, Aundh, \n" +
                            "             Pune - 411007\n\n\n" +
                            "Vishrantwadi : Shanti Nagar , Near Joshi Snacks Center, Vishrantwadi \n" +
                            "                       Pune - 411015\n\n\n" +
                            "Kothrud : Ideal Colony, Eklavya Hospital, Kothrud, \n" +
                            "                Pune – 411038\n\n\n"
                );
        adr.setBounds(20,90,1000,700);
        adr.setFont(new Font("Serif",Font.BOLD,22));
        adr.setEditable(false);
        c.add(adr);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        new About();
    }
}
