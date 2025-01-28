import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ConcurrentModificationException;
//import Fonts.*;

public class Faq extends JFrame
{
    JTextArea faq;
    JButton back;
    Faq()
    {
        setTitle("FAQ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        setBounds(400,150,1100,800);
        Container c = getContentPane();
        c.setBackground(Color.WHITE);

        back = new JButton("<-Go Back");
        back.setBounds(20,10,130,30);
        back.setFont(new Font("Segoe Print",Font.PLAIN,15));
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new About();
                setVisible(false);
            }
        });
        c.add(back);

        faq = new JTextArea("->What do we offer?\n" +
                "Ans – Online Bus Ticket Reservation.\n" +
                "\n" +
                "->Which cities we are operating in?\n" +
                "Ans – Pune.\n\n" +
                "->What happens if the vehicle breaks down?\n" +
                "Ans - Since we work with the best operators, the vehicles are usually \n" +
                "reliable. In case of a breakdown, it is the operator's responsibility to\n" +
                "replace the vehicle during the journey.\n\n" +
                "->Whom do I contact if I have additional questions?\n" +
                "Ans - You can write to us at support@travelopedia.in. Alternately, you \n" +
                "can request a call back by clicking on the 'Request a Callback' button\n" +
                "on any of the quotes you've received. One of our customer service\n" +
                "executives will reach out to you.\n\n" +
                "->What if I need to cancel my trip?\n" +
                "Ans  - You can cancel your ticket by visiting our nearest branch.\n\n" +
                "\t------For our branch addresses visit about page------");
        faq.setBounds(20,80,1060,660);
        faq.setFont(new Font("Serif",Font.BOLD,23));
        faq.setEditable(false);
        c.add(faq);

        setVisible(true);

    }

    public static void main(String[] args)
    {
        new Faq();
    }
}
