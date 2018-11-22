
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;


public class Calc {

	char[] alphabet = new char[] 
			{'�','�','�','�','�','�','�','�','�','�','�','�',
			'�','�','�','�','�','�','�','�','�','�','�','�','�','�',
			'�','�','�','�','�','�','0','1','2','3','4','5','6','7','8','9',};
	
	
		public long calcN(long p, long q)
		{			
				long result = p * q;
				System.out.println("n = " + result);			
				return result;		
		}
		
		public long calcM(long p, long q)
		{			
				long result = (p - 1) * (q - 1);
				System.out.println("m = " + result);
				return result;		
		}
				
		public boolean checkSimpleNum(long num)
		{
			for(long i = 2; i < num; i++)
				if(num % i == 0)
				{
					System.out.println("������! ����� " + num + " �� �������");
					return false;
				}		
			System.out.println("����� " + num + " �������");
			return true;
		}
		
		public long calcD(long m)
		{			
			long d = m - 1;
			 
		    for (long i = 2; i <= m; i++)
		        if ((m % i == 0) && (d % i == 0)) //���� ����� ����� ��������
		        {
		            d--;
		            i = 1;
		        }		 
		    return d;
		}
		
		public long gcd(long num1, long num2) 
		{
			long c;
			while(num2 != 0)
			{
				c = num1;
				num1 = num2;
				num2 = c % num2;
			}
			return num1;
		}

		public boolean check2SimpleNum(long num1, long num2)

		{
			if(gcd(num1, num2) == 1) {
				System.out.println("����� " + num1 + " � "+ num2 + " ������� �������");
				return true;
			}	
			System.out.println("������! ����� " + num1 + " � "+ num2 + " �������  �� �������");		
			return false;
		}

		public long calcE(long d, long m, long n)
		{
			for(long e = 2; e < n; e++)
			{
				if((e * d) % m == 1 )
				{
					System.out.println("e = " + e);
					return e;
				}
			}
			return 0;
		}

		public BigInteger encode(long n, long e, long a)
		{
			BigInteger aa =  BigInteger.valueOf(a);	
			BigInteger nn =  BigInteger.valueOf(n);	
			BigInteger ee =  BigInteger.valueOf(e);	
			BigInteger result = aa.modPow(ee, nn);
			System.out.println("encode " + a + " = " + result);
			return result;
		}

		public BigInteger decode(long n, long d, BigInteger b)
		{			
			BigInteger nn =  BigInteger.valueOf(n);	
			BigInteger dd =  BigInteger.valueOf(d);	
			BigInteger result = b.modPow(dd, nn);
			System.out.println("decode " + b + " = " + result);
			return result;
		}

		public LinkedList<String> encodeString(String s, long e, long n)
		{
			LinkedList<String> result = new LinkedList<String>();
			BigInteger bi;
			
			for (int i = 0; i < s.length(); i++)
		    {
		        int index = Arrays.binarySearch(alphabet,s.charAt(i));
		        System.out.println(index);
		        bi = BigInteger.valueOf(index);
		        bi = bi.pow((int)e);
		 
		        BigInteger n_ = BigInteger.valueOf((int)n);
		 
		        bi = bi.mod(n_);
		        System.out.println(bi.toString());
		        result.add(bi.toString());
		    }
			return result;
		}
		
		public String decodeString(LinkedList<String> list, long d, long n)
		{
		 String result = "";
		 
		    BigInteger bi;
		 
		    for(String item: list)
		    {
		        bi = BigInteger.valueOf(Integer.valueOf(item));
		        bi = bi.pow( (int)d);
		 
		        BigInteger n_ = BigInteger.valueOf((int)n);
		 
		        bi = bi.mod(n_);
		 
		        int index = Integer.valueOf(bi.toString());
		 
		        result += String.valueOf(alphabet[index]);
		    }
		    System.out.println(result);
		    return result;
		}
	}

	

