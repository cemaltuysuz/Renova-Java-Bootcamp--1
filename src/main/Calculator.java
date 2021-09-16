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
	
	public static void main(String [] args) {
		
		// Initialize
		input = new Scanner(System.in); 
		
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
	
}
