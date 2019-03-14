import java.util.concurrent.Semaphore;
import java.util.Scanner;
class rw
{
static Semaphore readlock=new Semaphore(1);
static Semaphore writelock=new Semaphore(1);
static int readcount=0;
static class Read implements Runnable
{
 @Override
 public void run()
 {
  try
  {
   readlock.acquire();
   synchronized(rw.class)
   {
       readcount++;
   }
   if(readcount==1)
   {
        writelock.acquire();
   }
 readlock.release();
  
 System.out.println(Thread.currentThread().getName()+" is reading");
 Thread.sleep(1500);
 System.out.println(Thread.currentThread().getName()+" have finished reading");
 readlock.acquire();
 synchronized(rw.class)
 {
    readcount--;
 }
 if(readcount==0)
 {
  writelock.release();
 }
 readlock.release();
 }
 catch(Exception e)
 {
 System.out.println(e.getMessage());
 }
 }
 }
static class Write implements Runnable
{
 @Override
 public void run()
 {
  try
  { 
   writelock.acquire();
   System.out.println(Thread.currentThread().getName()+" is  writing");
   Thread.sleep(2500);
   System.out.println(Thread.currentThread().getName()+" have finished writing");
   writelock.release();
  }catch(Exception e)
  {
  System.out.println(e.getMessage());
 }
 }
 }
public static void main(String[] args)throws Exception
{
 int th,n,i,b,j;
Read read=new Read();
Write write=new Write();
 Scanner obj=new Scanner(System.in);
 System.out.print("Enter the number of readers:");
 n=obj.nextInt();
 System.out.print("Enter the number of writers:");
 b=obj.nextInt();
 th=n+b;
 Thread[] threads=new Thread[th];
 for(i=0;i<th;i++)
 {
  if(i<n)
  {
  threads[i]=new Thread(read);
  }
else
{
 threads[i]=new Thread(write);
}
 threads[i].setName("Person"+(i+1));
 threads[i].start();

 
}
}
} 
