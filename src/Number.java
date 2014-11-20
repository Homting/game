import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * project name game
 * Created by LiJin
 * Email:594268218@qq.com  homtingli@gmail.com
 * By IntelliJ IDEA 13.1
 * Date 2014/7/22 Time 20:42
 */
public class Number extends JLabel {
    public boolean isAdd = false;
    public void setText(String s) {
        super.setText(s);
        this.setFont(new Font("Simsum",Font.BOLD,40));
        if(s.equals(String.valueOf("")))
            this.setBackground(Color.white);
        else if(s.equals(String.valueOf(2)))
            this.setBackground(Color.gray);
        else if(s.equals(String.valueOf(4)))
            this.setBackground(Color.green);
        else if(s.equals(String.valueOf(8)))
            this.setBackground(Color.yellow);
        else if(s.equals(String.valueOf(16)))
            this.setBackground(Color.blue);
        else if(s.equals(String.valueOf(32)))
            this.setBackground(Color.cyan);
        else if(s.equals(String.valueOf(64)))
            this.setBackground(Color.red);
        else if(s.equals(String.valueOf(128)))
            this.setBackground(Color.magenta);
        else if(s.equals(String.valueOf(256)))
            this.setBackground(Color.orange);
        else if(s.equals(String.valueOf(512)))
            this.setBackground(Color.darkGray);
        else if(s.equals(String.valueOf(1024)))
            this.setBackground(Color.lightGray);
        else if(s.equals(String.valueOf(2048)))
            this.setBackground(Color.pink);

    }
}
