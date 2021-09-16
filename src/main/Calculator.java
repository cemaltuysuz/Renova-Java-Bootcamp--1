package main;
import java.util.Scanner;

/**
 * 
 * @author Cemal Tüysüz
 * @date 16.09.2021
 * 
 * */


public class Calculator {
	
	// Declare
	static Scanner input; 
	static double result;
	
	public static void main(String [] args) {
		
		// Initialize
		input = new Scanner(System.in); 
		result = 0L;
		boolean loopStatus = true;
		
		while(loopStatus) {
			int select = showMenu();
			request(select);
		}
	}
	
	/**
	 * Bu methodum ile kullanıcıya işlemlerin olduğu bir menü gösteriyor 
	 * ve bu işlemlerden bir seçim yapmasını istiyorum. Kullanıcı seçimini yaptığı 
	 * zaman bu değeri geri döndürüyorum.
	 * */
	
private static int showMenu() {
		
		String [] actions = {"Toplama","Çıkarma","Çarpma","Bölme","Mod","Hafızaya Al","Hafızadakini yazdır ve temizle","Çıkış"};
		
		for(int i=0;i<actions.length;i++) {
			System.out.println("["+(i+1)+"]"+" "+actions[i]);
		}
		int selected = input.nextInt();
		
		return selected;
	}

/**
 * Bu method kullanıcıdan sayı girişi alır,hesaplar ve sonucu döndürür. Aldığı parametre sayesinde yapılması gereken işleme ait 
 * methodu çağırır.
 * 
 * Method kendi içerisinde bir döngü halindedir. Kullanıcı artık istemeyene kadar sayı girişi yapar.
 * Bu methoda verilen parametre ile işlem methodları hesaplama yapar ve sonucları buraya geri döndürür.
 * Dönen sonuç artık localResult değişkenine eşit olur. Kullanıcı isterse bu değişkeni global kısımda tanımlanan
 * result değerine eşitler ardından başka bir işlem ile devam edebilir.
 * */

private static double request(int action) {	
	
	double localResult = result; // Tek bir işlem için alınan her sayıda elde edilen sonucu sakladığım değişken.
	boolean loopStatus = true; // Döngünün devamını kontrol ettiğin değişken.
	
	while(loopStatus) {
		
		// Kullanıcıdan sayı istiyorum
		
		System.out.println("Sayı giriniz : [Sayı girişinden ayrılmak için 0]");
		double num = input.nextDouble();
		
		if(num == 0) { 
			// Kullanıcı sayı girisini bitiridi ise yapmak istediği işlemi seçtirmek için tekrardan menüyü gösteriyorum
			// Böylelikle yapmış olduğu işlemlere ait sonucu global tarafa yazdırabilir ve yeni bir işlemden devam edebilir.
			// veya sonucunu yazdırır
			loopStatus = false;
			int reSelect = showMenu();
			if(reSelect == 6) {
				result = localResult;
			}else if(reSelect == 7) {
				System.out.println("Sonuc :" + String.valueOf(localResult));
			}
			
			
		}
		
		switch(action) {
		case 1: 
			localResult = sum(localResult,num);  // toplama
			break;
		case 2:
			localResult = sub(localResult,num);  // çıkarma
			break;
		case 3:
			localResult = multiplication(localResult,num); // çarpma
			break;
		case 4:
			localResult = divide(localResult,num); // bölme
			break;
		case 5:
			localResult = mod(localResult,num); // mod
			break;
		}
		
	}	
	return localResult;
}

	//Toplama işlemi

	public static double sum (double localResult,double num) {
		double result = localResult + num;
		System.out.println(" -> " + result);
		return result;
	}
	// Çıkarma işlemi
	
	public static double sub (double localResult,double num) {
		double result;
		if(localResult == 0) {
			result = num;
		}else {
			result = localResult - num;
		}
		System.out.println(" -> " + result);
		return result;
	}
	// Bölme işlemi
	
	public static double divide (double localResult,double num) {
		double result;
		if(localResult == 0) {
			result = num;
		}else {
			result = localResult / num;
		}
		System.out.println(" -> " + result);
		return result;
	}
	// Çarpma işlemi
	
	public static double multiplication (double localResult,double num) {
		double result;
		if(localResult == 0) {
			result = num;
		}else {
			result = localResult * num;
		}
		System.out.println(" -> " + result);
		return result;
	}
	// Mod Alma işlemi
	
	public static double mod (double localResult,double num) {
		double result;
		if(localResult == 0) {
			result = num;
		}else {
			result = localResult % num;
		}
		System.out.println(" -> " + result);
		return result;
	}




	
}
