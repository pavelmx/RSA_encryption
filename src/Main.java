
import java.math.BigInteger;
import java.util.LinkedList;

/**главный класс, который выполняет всю последовательность действий
 по шифрованию/дешифрованию
 *
 */
public class Main { 

	private final static int p = 3571; // задаем простое число p
	private final static int q = 2179; // задаем простое число q
	private static LinkedList<String> result = new LinkedList<>();

	public static void main(String[] args) {

		String s = "МАРЧУК"; // задаем сообщение для шифрования(строка)
		long a = 4; // задаем сообщение для шифрования(число)
		MyRSA rsa = new MyRSA();
		Calc calc = new Calc();
		rsa.setP(p); // устанавливаем p
		rsa.setQ(q); // устанавливаем q
		if (p == q) { // проверяем на равенство, если равны то ошибка
			System.out.println("Числа p и q не должны быть равны!");
		} else { // если p и q не равны
			if (calc.checkSimpleNum(rsa.getP()) && calc.checkSimpleNum(rsa.getQ())) { // проверяем на простые числа
				rsa.setN(calc.calcN(rsa.getP(), rsa.getQ())); // рассчитываем и устанавливаем n
				rsa.setM(calc.calcM(rsa.getP(), rsa.getQ()));// рассчитываем и устанавливаем m
				rsa.setD(calc.calcD(rsa.getM()));// рассчитываем и устанавливаем d
				calc.check2SimpleNum(rsa.getD(), rsa.getM()); // проверяем на взаимно простые числа d и m
				rsa.setE(calc.calcE(rsa.getD(), rsa.getM(), rsa.getN()));// рассчитываем и устанавливаем e
				if (calc.check2SimpleNum(rsa.getE(), rsa.getM()) == true) { // проверяем на взаимно простые числа e и m
					System.out.println("\nШифрование/дешифрование числа");
					BigInteger b = calc.encode(rsa.getN(), rsa.getE(), a); // шифрование числа
					calc.decode(rsa.getN(), rsa.getD(), b);// дешифрование числа
					System.out.println("\nШифрование/дешифрование строки");
					System.out.println("encode string: (" + s + ")");
					result = calc.encodeString(s.toUpperCase(), rsa.getE(), rsa.getN());// шифрование строки
					System.out.println("\ndecode string:");
					calc.decodeString(result, rsa.getD(), rsa.getN());// дешифрование строки
				} else // если числа e и m не взаимно простые
					System.out.println("Числа e и m взаимно не простые!!");
			}
		}

	}
}
