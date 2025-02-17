import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

class Game2
{
Frame f;
static Label timer,score;
static Button tank,bullet,b1,b2;
int i,b=188,s;
static int z,z2;
Label highestscore;


Game2()
{
f=new Frame();
timer=new Label("0");
score=new Label("0");
Font ft=new Font("Arial",1,20);
tank=new Button();
bullet=new Button();
Random rd=new Random();
Label highestscore=new Label("0");
f.setVisible(true);
f.setSize(600,440);
f.setLayout(null);
//f.setBackground(Color.yellow);

highestscore.setBounds(400,50,200,30);
highestscore.setBackground(Color.blue);
f.add(highestscore);
highestscore.setFont(ft);
highestscore.setForeground(Color.white);

try
{
File highscore=new File("e:\\Game2Highscore.txt");
FileReader fr=new FileReader(highscore);
BufferedReader br=new BufferedReader(fr);
highestscore.setText("Highest Score: " +br.readLine());
}
catch(Exception e)
{
}

score.setBackground(Color.blue);
timer.setBackground(Color.blue);

score.setFont(ft);
timer.setFont(ft);

score.setForeground(Color.white);
timer.setForeground(Color.white);

tank.setBounds(185,385,40,40);
bullet.setBounds(188,360,2,2);
score.setBounds(10,390,100,40);
timer.setBounds(350,390,100,40);

bullet.setBackground(Color.black);

b1=new Button();
b2=new Button();

b1.setBounds(100,0,40,100);
b2.setBounds(250,0,40,100);
b1.setBackground(Color.yellow);
b2.setBackground(Color.yellow);

b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ex)
{
s=s+1;
score.setText("Score: "+s);
}
});
// cheatcode

f.addMouseMotionListener(new MouseMotionAdapter()
{
public void mouseDragged(MouseEvent e3)
{
tank.setBounds(e3.getX(),385,40,40);
bullet.setBounds(e3.getX(),360,2,2);
b=e3.getX();
}
});

f.add(tank);
f.add(bullet);
f.add(score);
f.add(timer);
f.add(b1);
f.add(b2);
f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
tank.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
try
{
for(i=360;i>=0;i--)
{
bullet.setBounds(b,i,20,20);
Thread.sleep(1);

int t1y,t2y,by,t1x,t2x,bx;
t1x=b1.getX();
t2x=b2.getX();
t1y=b1.getY();
t2y=b2.getY();
bx=bullet.getX();
by=bullet.getY();

if(by==t1y+100&&bx>=t1x-20&&bx<=t1x+40)
{
b1.setBackground(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
z=1;
s=s+1;
score.setText("Score: "+s);
}
if(by==t2y+100&&bx>=t2x-20&&bx<=t2x+40)
{
b2.setBackground(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
z2=1;
s=s+1;
score.setText("Score: "+s);
}
}
bullet.setBounds(188,360,2,2);

if(Integer.parseInt(score.getText())>Integer.parseInt(highestscore.getText()))
{
highestscore.setText(score.getText());
}

File highscore=new File("e:\\Game2Highscore.txt");
FileWriter fw=new FileWriter(highscore);
PrintWriter pw=new PrintWriter(fw);
String high=highestscore.getText();
pw.println(high);
fw.close();
pw.close();
}
catch(Exception eee)
{
}
}
});

TimerThread tt=new TimerThread();
tt.start();
TargetThread tgt=new TargetThread();
tgt.start();
TargetThread2 tgt2=new TargetThread2();
tgt2.start();








}
public static void main(String ar[])
{
Game2 g2=new Game2();
}
}








