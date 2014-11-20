import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * project name game
 * Created by LiJin
 * Email:594268218@qq.com  homtingli@gmail.com
 * By IntelliJ IDEA 13.1
 * Date 2014/7/22 Time 20:40
 */
public class Game extends JFrame{
    Number [] numlabel;
    JPanel jPanel;
    int index,num;
    GridLayout gridLayout;
    public Game() {
        jPanel = new JPanel();
        numlabel = new Number[16];
        gridLayout = new GridLayout(4,4,10,10);
        jPanel.setLayout(gridLayout);
        this.add(jPanel);
        for(int i=0;i<numlabel.length;i++){
            numlabel[i] = new Number();
            numlabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            numlabel[i].setOpaque(true);
            jPanel.add(numlabel[i]);
        }
        index = (int)(Math.random() *16);
        //System.out.println(index);
        numlabel[index].setText("2");
        index = (int)(Math.random() *16);
        while(!numlabel[index].getText().equals("")) {
            index = (int)(Math.random() *15);
            System.out.println(index);
        }
        numlabel[index].setText("2");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((width-600)/2,(height-600)/2,600,600);
        this.setTitle("1024");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.addKeyListener(new Event());
    }

    private void ranNum() {
        //boolean endBool = false;
        if(Math.random() >=0.5)
            num = 4;
        else
            num = 2;
        index = (int)(Math.random() *16);
        System.out.printf("%d ",index);
        while(!numlabel[index].getText().equals("")) {
            index = (int)(Math.random()*16);
            System.out.printf("%d ", index);
        }
        numlabel[index].setText(String.valueOf(num));
        System.out.println(index);
        //return endBool;
    }

    class Event implements KeyListener {
        boolean aBoolean;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_UP) { //上键盘
                for(int i=4;i<8;i++) {
                    if(numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")) { //第一行为空
                        numlabel[i-4].setText(numlabel[i].getText()); //第二行改动，直接上移
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i-4].isAdd==false&&numlabel[i-4].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i-4].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));//第一行有数字，数字相等，没有运算过，相加。
                        numlabel[i].setText("");
                        numlabel[i-4].isAdd = true;
                        aBoolean = true;
                    }
                }

                for(int i=8;i<12;i++){
                    if(numlabel[i-8].getText().equals("")&&numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-8].setText(numlabel[i].getText());//第三行上移第一行
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i-8].isAdd==false&&numlabel[i-8].getText().equals(numlabel[i].getText())&&numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-8].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));//第一行与第三行相等，第二行为空。相加至第一行
                        numlabel[i].setText("");
                        numlabel[i-8].isAdd = true;//相加为置为true
                        aBoolean = true;
                    }
                    else if(numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-4].setText(numlabel[i].getText());//第二行为空，直接上移一行
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i-4].isAdd==false&&numlabel[i-4].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i-4].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));//二三行相等，相加
                        numlabel[i].setText("");
                        numlabel[i-4].isAdd=true;
                        aBoolean = true;
                    }
                }
                for(int i=12;i<16;i++){
                    if(numlabel[i-12].getText().equals("")&&numlabel[i-8].getText().equals("")&&numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-12].setText(numlabel[i].getText());//第一二三行为空，第四行直接上移
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-12].isAdd==false&&numlabel[i-12].getText().equals(numlabel[i].getText())&&numlabel[i-8].getText().equals("")&&numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-12].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));//第四行相加到第一行
                        numlabel[i].setText("");
                        numlabel[i-12].isAdd=true;
                        aBoolean = true;
                    }else if(numlabel[i-8].getText().equals("")&&numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-8].setText(numlabel[i].getText());                   //第四行上移第二行
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-8].isAdd==false&&numlabel[i-8].getText().equals(numlabel[i].getText())&&numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-8].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));//第四行加到第二行
                        numlabel[i].setText("");
                        numlabel[i-8].isAdd=true;
                        aBoolean = true;
                    }else if(numlabel[i-4].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-4].setText(numlabel[i].getText());                   //四行上移到第三行
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-4].isAdd==false&&numlabel[i-4].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i-4].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));//四行相加到第三行
                        numlabel[i].setText("");
                        numlabel[i-4].isAdd=true;
                        aBoolean = true;
                    }
                }
                for(int i=0;i<numlabel.length;i++){
                    numlabel[i].isAdd=false;
                }
            }

            if(e.getKeyCode()==KeyEvent.VK_DOWN) {
                for(int i=8;i<12;i++){
                    if(numlabel[i+4].getText().equals("")&& !numlabel[i].getText().equals("")){
                        numlabel[i+4].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i+4].isAdd==false&&numlabel[i+4].getText().equals(numlabel[i].getText()) && !numlabel[i].getText().equals("")){
                        numlabel[i+4].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));//第一行有数字，数字相等，没有运算过，相加。
                        numlabel[i].setText("");
                        numlabel[i+4].isAdd = true;
                        aBoolean = true;
                    }
                }
                for(int i=4;i<8;i++){
                    if (numlabel[i+8].getText().equals("") && numlabel[i+4].getText().equals("")&& !numlabel[i].getText().equals("")) {
                        numlabel[i+8].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i+8].isAdd==false && numlabel[i+4].getText().equals("")&& numlabel[i+8].getText().equals(numlabel[i].getText())&& !numlabel[i].getText().equals("")) {
                        numlabel[i+8].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+8].isAdd = true;
                        aBoolean = true;
                    }
                    else if(numlabel[i+4].getText().equals("") && !numlabel[i].getText().equals("")) {
                        numlabel[i+4].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i+4].isAdd==false&& numlabel[i+4].getText().equals(numlabel[i].getText())&& !numlabel[i].getText().equals("")) {
                        numlabel[i+4].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+4].isAdd = true;
                        aBoolean = true;
                    }
                }

                for(int i=0;i<4;i++){
                    if (numlabel[i+12].getText().equals("")&&numlabel[i+8].getText().equals("")&&numlabel[i+4].getText().equals("")&& !numlabel[i].getText().equals("")) {
                        numlabel[i+12].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i+12].isAdd==false&&numlabel[i+12].getText().equals(numlabel[i].getText())&&numlabel[i+4].getText().equals("")&&numlabel[i+8].getText().equals("")&&!numlabel[i].getText().equals("")) {
                        numlabel[i+12].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+12].isAdd = true;
                        aBoolean = true;
                    }
                    else if(numlabel[i+8].getText().equals("")&&numlabel[i+4].getText().equals("")&& !numlabel[i].getText().equals("")) {
                        numlabel[i+8].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i+8].isAdd==false&& numlabel[i+8].getText().equals(numlabel[i].getText())&&numlabel[i+4].getText().equals("")&& !numlabel[i].getText().equals("")) {
                        numlabel[i+8].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+8].isAdd = true;
                        aBoolean = true;
                    }
                    else if(numlabel[i+4].getText().equals("")&& !numlabel[i].getText().equals("")) {
                        numlabel[i+4].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }
                    else if(numlabel[i+4].isAdd==false && numlabel[i+4].getText().equals(numlabel[i].getText())&& !numlabel[i].getText().equals("")) {
                        numlabel[i+4].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+4].isAdd = true;
                        aBoolean = true;
                    }
                }
                for(int i=0;i<numlabel.length;i++)
                    numlabel[i].isAdd = false;
            }

            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                for(int i=1;i<=13;i=i+4){
                    if(numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-1].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-1].isAdd==false&&numlabel[i-1].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i-1].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i-1].isAdd=true;
                        aBoolean = true;
                    }
                }
                for(int i=2;i<=14;i=i+4){
                    if(numlabel[i-2].getText().equals("")&&numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-2].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-2].isAdd==false&&numlabel[i-2].getText().equals(numlabel[i].getText())&&numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-2].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i-2].isAdd=true;
                        aBoolean = true;
                    }else if(numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-1].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-1].isAdd==false&&numlabel[i-1].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i-1].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i-1].isAdd=true;
                        aBoolean = true;
                    }
                }
                for(int i=3;i<=15;i=i+4){
                    if(numlabel[i-3].getText().equals("")&&numlabel[i-2].getText().equals("")&&numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-3].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-3].isAdd==false&&numlabel[i-3].getText().equals(numlabel[i].getText())&&numlabel[i-2].getText().equals("")&&numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-3].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i-3].isAdd=true;
                        aBoolean = true;
                    }else if(numlabel[i-2].getText().equals("")&&numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-2].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-2].isAdd==false&&numlabel[i-2].getText().equals(numlabel[i].getText())&&numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-2].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i-2].isAdd=true;
                        aBoolean = true;
                    }else if(numlabel[i-1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i-1].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i-1].isAdd==false&&numlabel[i-1].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i-1].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i-1].isAdd=true;
                        aBoolean = true;
                    }
                }
                for(int i=0;i<numlabel.length;i++){
                    numlabel[i].isAdd=false;
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                for(int i=2;i<=14;i=i+4){
                    if(numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+1].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i+1].isAdd==false&&numlabel[i+1].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i+1].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+1].isAdd=true;
                        aBoolean = true;
                    }
                }
                for(int i=1;i<=13;i=i+4){
                    if(numlabel[i+2].getText().equals("")&&numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+2].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i+2].isAdd==false&&numlabel[i+2].getText().equals(numlabel[i].getText())&&numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+2].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+2].isAdd=true;
                        aBoolean = true;
                    }else if(numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+1].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i+1].isAdd==false&&numlabel[i+1].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i+1].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+1].isAdd=true;
                        aBoolean = true;
                    }
                }
                for(int i=0;i<=12;i=i+4){
                    if(numlabel[i+3].getText().equals("")&&numlabel[i+2].getText().equals("")&&numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+3].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i+3].isAdd==false&&numlabel[i+3].getText().equals(numlabel[i].getText())&&numlabel[i+2].getText().equals("")&&numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+3].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+3].isAdd=true;
                        aBoolean = true;
                    }else if(numlabel[i+2].getText().equals("")&&numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+2].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i+2].isAdd==false&&numlabel[i+2].getText().equals(numlabel[i].getText())&&numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+2].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+2].isAdd=true;
                        aBoolean = true;
                    }else if(numlabel[i+1].getText().equals("")&&!numlabel[i].getText().equals("")){
                        numlabel[i+1].setText(numlabel[i].getText());
                        numlabel[i].setText("");
                        aBoolean = true;
                    }else if(numlabel[i+1].isAdd==false&&numlabel[i+1].getText().equals(numlabel[i].getText())&&!numlabel[i].getText().equals("")){
                        numlabel[i+1].setText(String.valueOf(Integer.parseInt(numlabel[i].getText())*2));
                        numlabel[i].setText("");
                        numlabel[i+1].isAdd=true;
                        aBoolean = true;
                    }
                }
                for(int i=0;i<numlabel.length;i++){
                    numlabel[i].isAdd=false;
                }
            }

            for(int i=0;i<16;i++)
                if(numlabel[i].getText().equals("1024")) {
                    Msg msg = new Msg("win"); //某一块到达1024 输出win
                }
            if(!numlabel[0].getText().equals("") && //所有块都有数字时
                    !numlabel[1].getText().equals("") && !numlabel[2].getText().equals("")&&
                    !numlabel[3].getText().equals("") && !numlabel[4].getText().equals("")&&
                    !numlabel[5].getText().equals("") && !numlabel[6].getText().equals("")&&
                    !numlabel[7].getText().equals("") && !numlabel[8].getText().equals("")&&
                    !numlabel[9].getText().equals("") && !numlabel[10].getText().equals("")&&
                    !numlabel[11].getText().equals("") && !numlabel[12].getText().equals("")&&
                    !numlabel[13].getText().equals("") && !numlabel[14].getText().equals("")&&
                    !numlabel[15].getText().equals("")){ //并且相邻的块上数字不相等
                if(!numlabel[3].getText().equals(numlabel[7].getText()) &&
                        !numlabel[7].getText().equals(numlabel[11].getText())&&
                        !numlabel[11].getText().equals(numlabel[15].getText())){
                    boolean temp = true;
                    for(int i=0;i<3;i++){
                        if(numlabel[i].getText().equals(numlabel[i+1].getText()) ||
                                numlabel[i].getText().equals(numlabel[i+4].getText()) ||
                                numlabel[i+4].getText().equals(numlabel[i+5].getText()) ||
                                numlabel[i+4].getText().equals(numlabel[i+8].getText()) ||
                                numlabel[i+8].getText().equals(numlabel[i+9].getText()) ||
                                numlabel[i+8].getText().equals(numlabel[i+12].getText())||
                                numlabel[i+12].getText().equals(numlabel[i+13].getText())){
                            temp = false;
                            break;
                        }

                    }
                    if(temp) {
                        Msg msg = new Msg("lose");//提示输了
                    }
                }
            }
            if(aBoolean){
                ranNum();//如果还有空间，就生成一个新块 2 或者 4
                aBoolean = false;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
