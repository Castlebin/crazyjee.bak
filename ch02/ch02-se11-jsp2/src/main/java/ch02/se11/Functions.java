package ch02.se11;

// EL表达式自定义函数的类
public class Functions {
	
	// EL表达式自定义函数都得定义为public static的，这样才能在EL表达式中被调用
	public static String reverse(String text) {
	
		return new StringBuffer(text).reverse().toString();
	}
	
	public static int countChar(String text) {
		return text.length();
	}
}
