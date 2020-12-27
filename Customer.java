import java.util.Random;

public class Customer {
	//datafield tiplerini degistirebilirsiniz
	double arrivalTime; //musteri gelis zamani-
	//bekleme zamanini hesaplamada kullanabilirsiniz
	double removalTime;
	//müşteri kuyruk bekeleme zamanı
	double wait;
	
	//Her yeni müsteride yeni numara
	static int x =0;
	//Müsteri numarası
	int numara;
	
	Customer(){
		x+=1;
		numara=x;
		Random a = new Random();
		 arrivalTime=(a.nextDouble()+(a.nextDouble()));
		 removalTime=1+(a.nextDouble()+(a.nextDouble()));
		 System.out.println(numara+".  müşteri geldi");
		 wait=0;
		
		 
	}
}
