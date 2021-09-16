package main;
import java.util.Scanner;

/**
 * 
 * @author Cemal Tüysüz
 * @date 16.09.2021
 * 
 * */


/**
 * 
 * -> Menüyü göstermek için seçilen işlemi geri döndüren bir method. | showMenu() ,
 * -> Seçilen işlemi işlemesi ve kullanıcıdan girdi alması için bir method. | request() 
 * 
 * Çıkış yapılmak istenilene kadar kullanıcıya menü gösterdikten sonra seçilen maddeye göre işlem yapılması bir 
 * döngü halindedir. 
 *  
 * Kullanıcı işlem seçtikten sonra request methodu içerisinde farklı bir döngü daha vardır. Bu döngü ile seçilen işleme
 * göre sürekli sayı alınır ve işlem devam ettirilir ta ki kullanıcı girdi kısmından ayrılmak isteyene kadar.
 * */


public class Calculator {
	

static Scanner input; // Declare Scanner
static double result; // Kayıt
	
public static void main(String [] args) {
		
	input = new Scanner(System.in); // Initialize Scanner
	result = 0L; 
	
	/**
	 * Kullanıcı her işlem yaptığı zaman kayıt ederek devam etmek isterse geçici ve her yeni işlemde o işlemin
	 * Sonucunu tutan bir değişken oluşturdum.
	 * */
	double temporaryResult = 0L; 
	
	boolean loopStatus = true; // döngü kontrolü
		
		while(loopStatus) {
			int select = showMenu();
			
			switch(select) {
			case 0:
				loopStatus = false;
				break;
				
			case 7: 
				System.out.println("Sonuc :" + String.valueOf(result));
				result = 0L;
				break;
				// işlem hafızaya alındı.
			case 6:
				result = temporaryResult;
				break;
				
				// Kullanıcı çıkış yapmak istemediyse (0) yada hafızayı temizlemek istemediyse bir işlem seçmiştir.
				// Bu durumda seçimi request methoduna gönderiyoruz.
				default :
					double newResult = request(select);
					temporaryResult = newResult;
					break;
			}
				
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
		
		// Kullanıcıdan sayı girişi aldığım kısım.
		System.out.println("Sayı giriniz : [Sayı girişinden ayrılmak için 0]");
		double num = input.nextDouble();
		
		// Kullanıcı girdiği sayıda, sayı girişinden çıkmak veya bu işlemdeki sonucu hafızaya yazdırmak isteyebilir.
		
		if(num == 0) {
			loopStatus = false; // Sayı girişinden çıkmak isterse döngü kapanır.
			break;
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

/**
 * 
 * Kullanıcı toplama işlemi haricinde başka bir işlem seçip sayı girerse girdiği ilk sayı herhangi bir işleme
 * girmeden direkt olarak döndürülür ve localResult'a eşit olmuş olur. Bunun sebebi ise toplama haricinde yapılmak 
 * istenen işlemlerde girilen ilk sayı işleme 0 ile beraber giriyor olması.
 * 
 * */

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
