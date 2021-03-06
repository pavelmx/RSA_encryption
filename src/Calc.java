
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;


public class Calc { 

	/** массив символов для шифрования строковых значений
	 * 
	 */
	char[] alphabet = new char[] { 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
			'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', };

	/** ф-ия расчета n
	 * 
	 * @param p - простое число
	 * @param q - простое число
	 * @return - возвращает n
	 */
	public long calcN(long p, long q) {
		long result = p * q;
		System.out.println("n = " + result);
		return result;
	}

	/** ф-ия расчета m
	 * 
	 * @param p - простое число
	 * @param q - простое число
	 * @return - возвращает m
	 */
	public long calcM(long p, long q) {
		long result = (p - 1) * (q - 1);
		System.out.println("m = " + result);
		return result;
	}

	/** ф-ия проверки числа на простое
	 * 
	 * @param num - число
	 * @return - возвращает результат проверки числа на простое
	 */
	public boolean checkSimpleNum(long num) {
		for (long i = 2; i < num; i++)
			if (num % i == 0) {
				System.out.println("Ошибка! Число " + num + " не простое");
				return false;
			}
		if (num < 2) {
			System.out.println("Ошибка! Число " + num + " не простое");
			return false;
		}

		System.out.println("Число " + num + " простое");
		return true;
	}

	/** ф-ия генерации чсила d
	 * 
	 * @param m - число m
	 * @return - возвращает d
	 */
	public long calcD(long m) {
		long d = 0;
		for (long i = 2; i <= m; i++) {
			if (gcd(i, m) == 1) {
				d = i;
				break;
			}
		}
		System.out.println("d = " + d);
		return d;
	}

	/** ф-ия генерации числа e
	 * 
	 * @param d - число d
	 * @param m - число m
	 * @param n - число n
	 * @return - возвращает число e
	 */
	public long calcE(long d, long m, long n) {
		long e = 0;
		for (long i = 2; i < n; i++) {
			if ((i * d) % m == 1) {
				e = i;
			}
		}
		System.out.println("e = " + e);
		return e;
	}

	/** ф-ия нахождения максимального общего делителя
	 * 
	 * @param num1 - число 1
	 * @param num2 - число 2
	 * @return - возвращает наибольший общий делитель 2 чисел
	 */
	public long gcd(long num1, long num2) {
		long c;
		while (num2 != 0) {
			c = num1;
			num1 = num2;
			num2 = c % num2;
		}
		return num1;
	}

	/** ф-ия проверки двух чисел на взаимно простые
	 * 
	 * @param num1 - число 1
	 * @param num2 - число 2
	 * @return - возвращает результат проверки 2 чисел на взаимно простые
	 */
	public boolean check2SimpleNum(long num1, long num2) {
		if (gcd(num1, num2) == 1) {
			System.out.println("Числа " + num1 + " и " + num2 + " взаимно простые");
			return true;
		}
		System.out.println("Ошибка! Числа " + num1 + " и " + num2 + " взаимно  не простые");
		return false;
	}

	/** ф-ия шифрования числовых значений
	 * 
	 * @param n - число n
	 * @param e - число e
	 * @param a - число, которое необходимо зашифровать
 	 * @return - возвращает результат шифрования
	 */
	public BigInteger encode(long n, long e, long a) {
		BigInteger aa = BigInteger.valueOf(a);
		BigInteger nn = BigInteger.valueOf(n);
		BigInteger ee = BigInteger.valueOf(e);
		BigInteger result = aa.modPow(ee, nn);
		System.out.println("encode " + a + " = " + result);
		return result;
	}

	/** ф-ия дешифрования числовых значений
	 * 
	 * @param n - число 
	 * @param d - число
	 * @param b - результат шифрования числа а
	 * @return - возвращает резутат дешифрования b
	 */
	public BigInteger decode(long n, long d, BigInteger b) {
		BigInteger nn = BigInteger.valueOf(n);
		BigInteger dd = BigInteger.valueOf(d);
		BigInteger result = b.modPow(dd, nn);
		System.out.println("decode " + b + " = " + result);
		return result;
	}

	/** ф-ия шифрования строковых значений
	 * 
	 * @param s - строка для шифрования
	 * @param e - число e
	 * @param n - число n
	 * @return - возвращает зашифрованный массив
	 */
	public LinkedList<String> encodeString(String s, long e, long n) {
		LinkedList<String> result = new LinkedList<String>();
		BigInteger bi;

		for (int i = 0; i < s.length(); i++) {
			int index = Arrays.binarySearch(alphabet, s.charAt(i));
			bi = BigInteger.valueOf(index);
			bi = bi.pow((int) e);

			BigInteger n_ = BigInteger.valueOf((int) n);

			bi = bi.mod(n_);
			System.out.print(bi.toString());
			result.add(bi.toString());
		}
		return result;
	}

	/** ф-ия дешифрования строковых значений
	 * 
	 * @param list - зашифрованный массив строк
	 * @param d - число d
	 * @param n - число n
	 * @return - возвращает расшифрованную строку
	 */
	public String decodeString(LinkedList<String> list, long d, long n) {
		String result = "";

		BigInteger bi;

		for (String item : list) {
			bi = BigInteger.valueOf(Integer.valueOf(item));
			bi = bi.pow((int) d);

			BigInteger n_ = BigInteger.valueOf((int) n);

			bi = bi.mod(n_);

			int index = Integer.valueOf(bi.toString());

			result += String.valueOf(alphabet[index]);
		}
		System.out.println(result);
		return result;
	}
}
