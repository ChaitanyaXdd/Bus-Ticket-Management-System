import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Confirm extends JFrame
{
    JButton ok,no;
    JLabel l;
    Confirm()
    {
        setTitle("Confirm Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(850,450,300,150);
        Container c = getContentPane();

        l = new JLabel("Fill The Profile First!!!");
        l.setBounds(40,5,250,30);
        l.setFont(new Font("",Font.BOLD,18));
        c.add(l);

        ok = new JButton("Ok");
        ok.setBounds(110,50,70,30);
        ok.setFont(new Font("",Font.BOLD,15));
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                JButton b = (JButton) e.getSource();
                if(b==ok)
                {
                    new Profile();
                    Profile.username.setText(Signup.udetails.getText());
                    Profile.name.setText(Signup.uname.getText());
                    setVisible(false);

                }
                else
                {

                }

            }
        });
        c.add(ok);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Confirm();
    }

}
