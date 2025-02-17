import java.util.Random;
class TargetThread extends Thread
{
int i,x=100,y=250;
public void run()
{
Random rand=new Random();
try
{
while(true)
{
for(i=0;i<=280;i++)
{
Game2.b1.setBounds(x,i,40,100);
Thread.sleep(50);
if(Game2.z==1)
break;
}
x=rand.nextInt(350);
y=rand.nextInt(350);
Game2.b1.setBounds(x,0,40,100);
Game2.z=0;
}

}
catch(Exception e)
{
}
}
}
