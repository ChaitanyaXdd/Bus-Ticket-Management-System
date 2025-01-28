import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
//import Fonts.*;

public class Payment extends JFrame
{
    public static JLabel name,fpass,nmlbl,captcha,generate,ecapt,amount,amt;
    JTextField capt,ccapt;
    JButton pay;
    Payment()
    {
        setTitle("Payment Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(500,200,700,490);
        Container c = getContentPane();

        fpass = new JLabel("Payment");
        fpass.setBounds(260,30,180,55);
        fpass.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
        fpass.setForeground(Color.red);
        c.add(fpass);

        JPanel panel = new JPanel();
        panel.setBounds(90,80,520,290);
        panel.setBackground(Color.CYAN);

        name = new JLabel("Name : ");
        name.setBounds(10,10,90,30);
        name.setFont(new Font("Segoe Print",Font.PLAIN,20));
        name.setForeground(Color.BLACK);
        panel.add(name);

        nmlbl = new JLabel("");
        nmlbl.setBounds(100,10,320,30);
        nmlbl.setFont(new Font("Serif",Font.PLAIN,20));
        nmlbl.setForeground(Color.BLACK);
        panel.add(nmlbl);

        captcha = new JLabel("Captcha : ");
        captcha.setBounds(10,75,110,30);
        captcha.setFont(new Font("Serif",Font.PLAIN,20));
        captcha.setForeground(Color.BLACK);
        panel.add(captcha);

        capt = new JTextField("");
        capt.setBounds(120,75,120,30);
        capt.setEditable(false);
        capt.setFont(new Font("Segoe Print",Font.BOLD,19));
        panel.add(capt);

        generate = new JLabel("Generate New Captcha");
        generate.setBounds(260,75,230,30);
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
                capt.setText(sb.toString());
            }

            private void getAlphaNumericString(int n)
            {
            }

        });
        panel.add(generate);

        ecapt = new JLabel("Enter Captcha : ");
        ecapt.setBounds(10,135,190,30);
        ecapt.setFont(new Font("Serif",Font.PLAIN,20));
        ecapt.setForeground(Color.BLACK);
        panel.add(ecapt);

        ccapt = new JTextField("");
        ccapt.setBounds(180,135,120,30);
        panel.add(ccapt);

        amount = new JLabel("Amount : ");
        amount.setBounds(10,210,130,30);
        amount.setFont(new Font("Serif",Font.PLAIN,25));
        amount.setForeground(Color.BLACK);
        panel.add(amount);

        amt = new JLabel("");
        amt.setBounds(140,210,110,30);
        amt.setFont(new Font("Serif",Font.PLAIN,25));
        amt.setForeground(Color.BLACK);
        panel.add(amt);

        pay = new JButton("Pay Now");
        pay.setBounds(340,210,140,30);
        pay.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        pay.setForeground(Color.BLACK);
        panel.add(pay);
        pay.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me) {
                if (me.getSource() == pay) {
                    if (ccapt.getText().length() != 0) {
                        if (capt.getText().equals(ccapt.getText())) {
                            new Reciept();
                            setVisible(false);

                            Reciept.nm.setText(Profile.name.getText());
                            Reciept.t.setText(HP_Profile.to.getText());
                            Reciept.pno.setText(Profile.phone.getText());
                            Reciept.d.setText(HP_Profile.date1.getText());
                            Reciept.seats.setText(BusSeats.seatprint.getText() + "");

                            Reciept.finalcost.setText(amt.getText() + "");
                        } else {
                            JFrame f1 = new JFrame();
                            JOptionPane.showMessageDialog(f1, "Incorrect Captcha");
                            capt.setText("");
                            ccapt.setText("");
                        }
                    } else {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Captcha Failed");
                        capt.setText("");
                        ccapt.setText("");
                    }

                }
                String NumericString = "0123456789";
                getNumericString(999999);
                StringBuilder sb = new StringBuilder(999999);

                for (int i = 0; i < 6; i++)
                {
                    int index = (int)(NumericString.length() * Math.random());
                    sb.append(NumericString.charAt(index));
                }
                Reciept.i.setText(sb.toString());
            }

            private void getNumericString(int i)
            {

            }


        });

        panel.setLayout(null);
        c.add(panel);
        setVisible(true);
    }


    public static void main(String[] args)
    {
        new Payment();
    }
}