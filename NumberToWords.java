import java.util.Scanner;
public class NumberToWords
{

	static String[] units = { "", "One", "Two", "Three", "Four","Five", "Six",
	"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve","Thirteen", "Fourteen",
	"Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen" };

	static String[] tens = { "","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
	"Eighty","Ninety"};

	public static String convert(final int n)
	{
		if (n < 0)
			return "Minus " + convert(-n);

		if (n < 20)
			return units[n];

		if (n < 100)
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];

		if (n < 1000)
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);

		if (n < 1000000)
			return convert(n / 1000) + " Thousand" + ((n % 1000 != 0) ? " " : "") + convert(n % 1000);

		return convert(n / 1000000) + " Million" + ((n % 1000000 != 0) ? " " : "") + convert(n % 1000000);
	}

	public static void main(String[] args)throws Exception
	{
		int n;
		Scanner s=new Scanner(System.in);
	  System.out.println("Enter a number to convert into word format");
		n =s.nextInt();
		if (n==0)
			System.out.println("Zero");
		else
			System.out.println(convert(n));
	}
}
