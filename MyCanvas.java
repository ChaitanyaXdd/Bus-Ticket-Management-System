import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyCanvas extends JFrame
{
    MyCanvas()
    {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        setBounds(100,100,1100,800);
        Container c = getContentPane();

        ImageIcon icon = new ImageIcon("C:\\Users\\Dell G5\\IdeaProjects\\Final Project\\Logo.jpg");
        JPanel panel3 = new JPanel();
        panel3.setBounds(40,70,700,360);
        panel3.add(new JLabel(icon));

        c.add(panel3);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new MyCanvas();
    }
}