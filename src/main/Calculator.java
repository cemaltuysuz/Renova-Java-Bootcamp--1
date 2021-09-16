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
		
		int select = showMenu();
		System.out.println("Seçilen :" + select);
		
	}
	
	/**
	 * Bu methodum ile kullanıcıya işlemlerin olduğu bir menü gösteriyor 
	 * ve bu işlemlerden bir seçim yapmasını istiyorum. Kullanıcı seçimini yaptığı 
	 * zaman bu değeri geri döndürüyorum.
	 * */
	
private static int showMenu() {
		
		String [] actions = {"Toplama","Çıkarma","Çarpma","Bölme","Mod","Hafızaya Al","Hafızadakini yazdır ve temizle","Çıkış"};
		
		for(int i=0;i<actions.length;i++) {
			System.out.println("["+i+"]"+" "+actions[i]);
		}
		String selected = input.nextLine();
		int selectedInt = Integer.valueOf(selected);
		
		return selectedInt;
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
	double localResult = 0L;
	
	System.out.println("Sayı giriniz :");
	int num = input.nextInt();
	
	
	switch(action) {
	case 0:
		// Çıkış
		break;
	case 1:
		// toplama
		break;
	case 2:
		// çıkarma
		break;
	case 3:
		// çarpma
		break;
	case 4:
		// bölme
		break;
	case 5:
		// mod
		break;
	case 6:
		// Hafızaya al
		break;
	case 7:
		// Hafızadakini yazdır
		break;
	}
	
	return localResult;
}


	
}
