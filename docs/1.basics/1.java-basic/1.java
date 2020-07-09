package java.lang;

import java.lang.annotation.Native;

public final class Integer extends Number implements Comparable<Integer> {  //继承了Number,那么就一定重写了Number的四个方法

	//定义了最小值和最大值的

	//使用native关键字说明这个方法是原生函数，也就是这个方法是用C/C++语言实现的，
	// 并且被编译成了DLL或者SO（Linux下），由java去调用。
	@Native public static final int   MIN_VALUE = 0x80000000;//-（2^31）


	@Native public static final int   MAX_VALUE = 0x7fffffff;//（2^31-1）


	//字节码文件
	@SuppressWarnings("unchecked")
	public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");


	//所有可能的将数字表示为字符串的字符集合。
	final static char[] digits = {
		'0' , '1' , '2' , '3' , '4' , '5' ,
		'6' , '7' , '8' , '9' , 'a' , 'b' ,
		'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
		'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
		'o' , 'p' , 'q' , 'r' , 's' , 't' ,
		'u' , 'v' , 'w' , 'x' , 'y' , 'z'
	};

//扩展
//    字符串转数字的合法字符串分为2部分，1）-或+符号位； 2）0到9，a到z;
//    符号位不参与转换
//    基数必须大于1，因为如果基数等于1，那么就会无意义，陷入无限循环。
//    Character. MIN_RADIX = 2， Character.MAX_RADIX = 36
//    所以，0到9一共10位，a到z一共26位，所以一共36位。

	//这些是'\u0030'至'\u0039'和'\u0061'至'\u007A'。如果进制数是N，则按显示顺序，这些字符的前N个用作N进制的数字。因此，十六进制（进制数16）的数字是0123456789abcdef。如果需要大写字母，可以对结果调用String.toUpperCase()方法：

	public static String toString(int i, int radix) {//数字，进制

		//如果进制数小于Character.MIN_RADIX或大于Character.MAX_RADIX，则使用10进制 。
		//为什么要一定保持十进制呢?
		//这个的主要原因在于我之后取模取余很好判断
		//例子：25/10---->2,5，然后放到了数组，在从数组到字符串就可以了
		if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
			radix = 10;
		/* Use the faster version */
		if (radix == 10) {
			return toString(i);
		}

        //主要是来放元素
		char buf[] = new char[33];
		boolean negative = (i < 0);//判断一下引进来的数字是哪个范围的
		int charPos = 32;


		正负数呢，我就通过boolean来判断就好了------>negative
		如果说是个位数，那么就可以直接放入到数组中---->buf[charPos] = digits[-i];
		如果说是十位数，那么先进行拆分，然后在进行组合

		if (!negative) {//negative为假
			i = -i;
		}

		while (i <= -radix) {
			buf[charPos--] = digits[-(i % radix)];
			i = i / radix;
		}
		buf[charPos] = digits[-i];

		if (negative) {
			buf[--charPos] = '-';
		}

		return new String(buf, charPos, (33 - charPos));//可以实现数组到字符串的转换
		//将value[]数组按照传入的下标和指定的截取数组数据的数量进行截取，并且创建一个内容为此的string对象
		//offset表示第一个被截取的字符在数组value[]中的下标，count表示从此字符开始向后截取的字符的数量
		//返回第一个参数的字符串表示形式，由第二个参数指定进制数。
	}

	//
	public static String toUnsignedString(int i, int radix) { return Long.toUnsignedString(toUnsignedLong(i), radix); }
	//根据int类型转换为无符字符串，根据无符字符串进行设置
	//为什么是移位这么多，就是与进制有关系
	public static String toHexString(int i) { return toUnsignedString0(i, 4); }
	public static String toOctalString(int i) { return toUnsignedString0(i, 3); }
	public static String toBinaryString(int i) { return toUnsignedString0(i, 1); }

	/**
	 * Convert the integer to an unsigned number.int类型转换为无符号字符串
	 */
	private static String toUnsignedString0(int val, int shift) {//移位符
		//Integer.numberOfLeadingZeros(val);
		//作用为返回无符号整型i的最高非零位前面的0的个数，包括符号位在内。
		// 所以mag为val的二进制有效位数
		int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
		//chars表示的是var转换为1<<shift进制后的长度
		//要达到这种效果只需要mag/shift并向上取整便可达成，（因为可能存在小数位）
		//为了达到向上取整的格式，所以采用((mag + (shift - 1))/shift虽然我写不出来这种算式，但确实可以达到这种效果==
		int chars = Math.max(((mag + (shift - 1)) / shift), 1);
		//java9之后，为了节省字符串的空间，默认开启字符串压缩，也就是用byte（8位）保存字母。
		// COMPACT_STRINGS默认开启。coder由两个值：LATIN1，UTF16。UTF16是肯定没有开启压缩的。
		//COMPACT_STRINGS默认为true即使用的LATIN1
		if (COMPACT_STRINGS) {
			byte[] buf = new byte[chars];
			//该方法就是将val的(1<<shift)进制存到byte[]里
			formatUnsignedInt(val, shift, buf, 0, chars);
			return new String(buf, LATIN1);
		} else {
			byte[] buf = new byte[chars * 2];
			formatUnsignedIntUTF16(val, shift, buf, 0, chars);
			return new String(buf, UTF16);
		}
	}

	//把一个长类型转换为char数组
	static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
		int charPos = len;
		int radix = 1 << shift;//进制
		int mask = radix - 1;
		//先循环后判断
		do {//因位一开始是长度
			buf[offset + --charPos] = Integer.digits[val & mask];
			val >>>= shift;
		} while (val != 0 && charPos > 0);

		return charPos;
	}

	final static char [] DigitTens = {
		'0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
		'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
		'2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
		'3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
		'4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
		'5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
		'6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
		'7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
		'8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
		'9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
	} ;

	final static char [] DigitOnes = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	} ;

	public static String toString(int i) {
		if (i == Integer.MIN_VALUE)
			return "-2147483648";
		int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
		char[] buf = new char[size];
		getChars(i, size, buf);
		return new String(buf, true);
	}

	public static String toUnsignedString(int i) {
		return Long.toString(toUnsignedLong(i));
	}


	static void getChars(int i, int index, char[] buf) {
		int q, r;
		int charPos = index;
		char sign = 0;

		if (i < 0) {
			sign = '-';
			i = -i;
		}

		// Generate two digits per iteration
		while (i >= 65536) {
			q = i / 100;
			// really: r = i - (q * 100);
			r = i - ((q << 6) + (q << 5) + (q << 2));
			i = q;
			buf [--charPos] = DigitOnes[r];
			buf [--charPos] = DigitTens[r];
		}

		// Fall thru to fast mode for smaller numbers
		// assert(i <= 65536, i);
		for (;;) {
			q = (i * 52429) >>> (16+3);
			r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
			buf [--charPos] = digits [r];
			i = q;
			if (i == 0) break;
		}
		if (sign != 0) {
			buf [--charPos] = sign;
		}
	}

	final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
		99999999, 999999999, Integer.MAX_VALUE };

	// Requires positive x
	static int stringSize(int x) {
		for (int i=0; ; i++)
			if (x <= sizeTable[i])
				return i+1;
	}


	public static int parseInt(String s, int radix)
		throws NumberFormatException
	{
		/*
		 * WARNING: This method may be invoked early during VM initialization
		 * before IntegerCache is initialized. Care must be taken to not use
		 * the valueOf method.
		 */

		if (s == null) {
			throw new NumberFormatException("null");
		}

		if (radix < Character.MIN_RADIX) {
			throw new NumberFormatException("radix " + radix +
				" less than Character.MIN_RADIX");
		}

		if (radix > Character.MAX_RADIX) {
			throw new NumberFormatException("radix " + radix +
				" greater than Character.MAX_RADIX");
		}

		int result = 0;
		boolean negative = false;
		int i = 0, len = s.length();
		int limit = -Integer.MAX_VALUE;
		int multmin;
		int digit;

		if (len > 0) {
			char firstChar = s.charAt(0);
			if (firstChar < '0') { // Possible leading "+" or "-"
				if (firstChar == '-') {
					negative = true;
					limit = Integer.MIN_VALUE;
				} else if (firstChar != '+')
					throw NumberFormatException.forInputString(s);

				if (len == 1) // Cannot have lone "+" or "-"
					throw NumberFormatException.forInputString(s);
				i++;
			}
			multmin = limit / radix;
			while (i < len) {
				// Accumulating negatively avoids surprises near MAX_VALUE
				digit = Character.digit(s.charAt(i++),radix);
				if (digit < 0) {
					throw NumberFormatException.forInputString(s);
				}
				if (result < multmin) {
					throw NumberFormatException.forInputString(s);
				}
				result *= radix;
				if (result < limit + digit) {
					throw NumberFormatException.forInputString(s);
				}
				result -= digit;
			}
		} else {
			throw NumberFormatException.forInputString(s);
		}
		return negative ? result : -result;
	}


	public static int parseInt(String s) throws NumberFormatException {
		return parseInt(s,10);
	}


	public static int parseUnsignedInt(String s, int radix)
		throws NumberFormatException {
		if (s == null)  {
			throw new NumberFormatException("null");
		}

		int len = s.length();
		if (len > 0) {
			char firstChar = s.charAt(0);
			if (firstChar == '-') {
				throw new
					NumberFormatException(String.format("Illegal leading minus sign " +
					"on unsigned string %s.", s));
			} else {
				if (len <= 5 || // Integer.MAX_VALUE in Character.MAX_RADIX is 6 digits
					(radix == 10 && len <= 9) ) { // Integer.MAX_VALUE in base 10 is 10 digits
					return parseInt(s, radix);
				} else {
					long ell = Long.parseLong(s, radix);
					if ((ell & 0xffff_ffff_0000_0000L) == 0) {
						return (int) ell;
					} else {
						throw new
							NumberFormatException(String.format("String value %s exceeds " +
							"range of unsigned int.", s));
					}
				}
			}
		} else {
			throw NumberFormatException.forInputString(s);
		}
	}


	public static int parseUnsignedInt(String s) throws NumberFormatException {
		return parseUnsignedInt(s, 10);
	}


	public static Integer valueOf(String s, int radix) throws NumberFormatException {
		return Integer.valueOf(parseInt(s,radix));
	}


	public static Integer valueOf(String s) throws NumberFormatException {
		return Integer.valueOf(parseInt(s, 10));
	}



	private static class IntegerCache {
		static final int low = -128;
		static final int high;
		static final Integer cache[];

		static {
			// high value may be configured by property
			int h = 127;
			String integerCacheHighPropValue =
				sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
			if (integerCacheHighPropValue != null) {
				try {
					int i = parseInt(integerCacheHighPropValue);
					i = Math.max(i, 127);
					// Maximum array size is Integer.MAX_VALUE
					h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
				} catch( NumberFormatException nfe) {
					// If the property cannot be parsed into an int, ignore it.
				}
			}
			high = h;

			cache = new Integer[(high - low) + 1];
			int j = low;
			for(int k = 0; k < cache.length; k++)
				cache[k] = new Integer(j++);

			// range [-128, 127] must be interned (JLS7 5.1.7)
			assert IntegerCache.high >= 127;
		}

		private IntegerCache() {}
	}


	public static Integer valueOf(int i) {
		if (i >= IntegerCache.low && i <= IntegerCache.high)
			return IntegerCache.cache[i + (-IntegerCache.low)];
		return new Integer(i);
	}


	private final int value;


	public Integer(int value) {
		this.value = value;
	}


	public Integer(String s) throws NumberFormatException {
		this.value = parseInt(s, 10);
	}


	public byte byteValue() {
		return (byte)value;
	}
	public short shortValue() {
		return (short)value;
	}
	public int intValue() {
		return value;
	}
	public long longValue() {
		return (long)value;
	}
	public float floatValue() {
		return (float)value;
	}
	public double doubleValue() {
		return (double)value;
	}
	public String toString() {
		return toString(value);
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(value);
	}
	public static int hashCode(int value) {
		return value;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Integer) {
			return value == ((Integer)obj).intValue();
		}
		return false;
	}


	public static Integer getInteger(String nm) {
		return getInteger(nm, null);
	}
	public static Integer getInteger(String nm, int val) {
		Integer result = getInteger(nm, null);
		return (result == null) ? Integer.valueOf(val) : result;
	}

	public static Integer getInteger(String nm, Integer val) {
		String v = null;
		try {
			v = System.getProperty(nm);
		} catch (IllegalArgumentException | NullPointerException e) {
		}
		if (v != null) {
			try {
				return Integer.decode(v);
			} catch (NumberFormatException e) {
			}
		}
		return val;
	}


	public static Integer decode(String nm) throws NumberFormatException {
		int radix = 10;
		int index = 0;
		boolean negative = false;
		Integer result;

		if (nm.length() == 0)
			throw new NumberFormatException("Zero length string");
		char firstChar = nm.charAt(0);
		// Handle sign, if present
		if (firstChar == '-') {
			negative = true;
			index++;
		} else if (firstChar == '+')
			index++;

		// Handle radix specifier, if present
		if (nm.startsWith("0x", index) || nm.startsWith("0X", index)) {
			index += 2;
			radix = 16;
		}
		else if (nm.startsWith("#", index)) {
			index ++;
			radix = 16;
		}
		else if (nm.startsWith("0", index) && nm.length() > 1 + index) {
			index ++;
			radix = 8;
		}

		if (nm.startsWith("-", index) || nm.startsWith("+", index))
			throw new NumberFormatException("Sign character in wrong position");

		try {
			result = Integer.valueOf(nm.substring(index), radix);
			result = negative ? Integer.valueOf(-result.intValue()) : result;
		} catch (NumberFormatException e) {
			// If number is Integer.MIN_VALUE, we'll end up here. The next line
			// handles this case, and causes any genuine format error to be
			// rethrown.
			String constant = negative ? ("-" + nm.substring(index))
				: nm.substring(index);
			result = Integer.valueOf(constant, radix);
		}
		return result;
	}


	public int compareTo(Integer anotherInteger) {
		return compare(this.value, anotherInteger.value);
	}
	public static int compare(int x, int y) {
		return (x < y) ? -1 : ((x == y) ? 0 : 1);
	}

	public static int compareUnsigned(int x, int y) {
		return compare(x + MIN_VALUE, y + MIN_VALUE);
	}
	public static long toUnsignedLong(int x) {
		return ((long) x) & 0xffffffffL;
	}

	public static int divideUnsigned(int dividend, int divisor) {
		// In lieu of tricky code, for now just use long arithmetic.
		return (int)(toUnsignedLong(dividend) / toUnsignedLong(divisor));
	}
	public static int remainderUnsigned(int dividend, int divisor) {
		// In lieu of tricky code, for now just use long arithmetic.
		return (int)(toUnsignedLong(dividend) % toUnsignedLong(divisor));
	}


	//整型的长度为32位
	@Native public static final int SIZE = 32;
	public static final int BYTES = SIZE / Byte.SIZE;


	public static int highestOneBit(int i) {
		// HD, Figure 3-1
		i |= (i >>  1);
		i |= (i >>  2);
		i |= (i >>  4);
		i |= (i >>  8);
		i |= (i >> 16);
		return i - (i >>> 1);
	}

	public static int lowestOneBit(int i) {
		// HD, Section 2-1
		return i & -i;
	}


	//返回无符号整型i的最高非零位前面的0的个数，包括符号位在内
	//”>>>”表示无符号右移运算符。高位补0
	//采用的是二分法的思想，https://www.jianshu.com/p/2c1be41f6e59
	public static int numberOfLeadingZeros(int i) {
		// HD, Figure 5-6
		if (i == 0)
			return 32;

		int n = 1;//n作为符号位存在
		if (i >>> 16 == 0) { n += 16; i <<= 16; }  //i右移16位   左移赋值
		if (i >>> 24 == 0) { n +=  8; i <<=  8; }  //i右移24位
		if (i >>> 28 == 0) { n +=  4; i <<=  4; }  //i右移28位
		if (i >>> 30 == 0) { n +=  2; i <<=  2; }  //i右移30位
		n -= i >>> 31;//
		return n;
	}

	public static int numberOfTrailingZeros(int i) {
		// HD, Figure 5-14
		int y;
		if (i == 0) return 32;
		int n = 31;
		y = i <<16; if (y != 0) { n = n -16; i = y; }
		y = i << 8; if (y != 0) { n = n - 8; i = y; }
		y = i << 4; if (y != 0) { n = n - 4; i = y; }
		y = i << 2; if (y != 0) { n = n - 2; i = y; }
		return n - ((i << 1) >>> 31);
	}


	public static int bitCount(int i) {
		// HD, Figure 5-2
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		return i & 0x3f;
	}


	public static int rotateLeft(int i, int distance) {
		return (i << distance) | (i >>> -distance);
	}
	public static int rotateRight(int i, int distance) {
		return (i >>> distance) | (i << -distance);
	}


	public static int reverse(int i) {
		// HD, Figure 7-1
		i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
		i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
		i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
		i = (i << 24) | ((i & 0xff00) << 8) |
			((i >>> 8) & 0xff00) | (i >>> 24);
		return i;
	}


	public static int signum(int i) {
		// HD, Section 2-7
		return (i >> 31) | (-i >>> 31);
	}

	public static int reverseBytes(int i) {
		return ((i >>> 24)           ) |
			((i >>   8) &   0xFF00) |
			((i <<   8) & 0xFF0000) |
			((i << 24));
	}

	public static int sum(int a, int b) {
		return a + b;
	}
	public static int max(int a, int b) {
		return Math.max(a, b);
	}
	public static int min(int a, int b) {
		return Math.min(a, b);
	}
	@Native private static final long serialVersionUID = 1360826667806852920L;
}
