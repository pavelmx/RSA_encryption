

import java.math.BigInteger;
import java.util.LinkedList;

public class Main {

	private final static int p = 13;
	private final static int q = 101;
	private static LinkedList<String> result = new LinkedList<>();
	
		public static void main (String[] args)
		{
			String s = "ћј–„” ";
			long a = 4;
			MyRSA rsa = new MyRSA();
			Calc calc = new Calc();
			rsa.setP(p);
			rsa.setQ(q);		
			if(calc.checkSimpleNum(rsa.getP()) && calc.checkSimpleNum(rsa.getQ())) 
			{
				rsa.setN(calc.calcN(rsa.getP(), rsa.getQ()));
				rsa.setM(calc.calcM(rsa.getP(), rsa.getQ()));
				rsa.setD(calc.calcD(rsa.getM()));
				
				System.out.println("d = " + calc.calcD(rsa.getM()));
				calc.check2SimpleNum(rsa.getD(), rsa.getM());
				
				rsa.setE(calc.calcE(rsa.getD(), rsa.getM(), rsa.getN()));
				if(calc.check2SimpleNum(rsa.getE(), rsa.getM()) == true)
				{
					BigInteger b = calc.encode(rsa.getN(), rsa.getE(), a);
					calc.decode(rsa.getN(), rsa.getD(), b);
					System.out.println("encode string: (" + s + ")");
					result = calc.encodeString(s, rsa.getE(), rsa.getN());
					System.out.println("decode string:");
					calc.decodeString(result, rsa.getD(), rsa.getN());
				}
				else
					System.out.println("„исла e и m взаимно не простые!!");
			}			
		}
	}


