class TimerThread extends Thread
{
int i;
public void run()
{
try
{
for(i=0;true;i++)
{
Game2.timer.setText("Time: "+i);
Thread.sleep(1000);

}
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}
