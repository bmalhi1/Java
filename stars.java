import java.util.Scanner;
public class stars
{
public static void main(String[] args)throws Exception
{

  System.out.println("Enter the number of lines to be printed");
  Scanner s=new Scanner(System.in);
  int n=s.nextInt();

  for(int i=0; i<n;i++)
  {
    for(int k=n-1;k>i;k--)
      System.out.print(" ");
    for(int j=0;j<=i*2;j++)
    {
      System.out.print("*");
    }
    System.out.println();
  }
}
}
