import java.util.Iterator;
import java.util.NoSuchElementException;


public class CrazyMarket implements MyQueue<Customer>{
	Node front;
	Node rear;
	int numberOfCustomer;
	//boyut
	int size;
    public class Node{
        Node next;
        Customer data;
        public Node(Customer data) {
            this.data = data;
            this.next = null;
        }
	}
	
	/**        default tekerleme       **/
	
	
	String tekerleme = "O piti piti karamela sepeti "
			+ "\nTerazi lastik jimnastik "
			+ "\nBiz size geldik bitlendik Hamama gittik temizlendik.";
	/**
	 *  numberOfCustumer ile verilen sayida  
	 * musteri hizmet gorene kadar calismaya devam eder*/
	public CrazyMarket(int numberOfCustomer) {
		size=0;
		double gelis=0;
		double bekleme=0;
		
		//ilk müsteri geliyor
		enqueue(new Customer());
			gelis+=rear.data.arrivalTime;
			rear.data.wait=0;
			bekleme+=rear.data.removalTime;
	
			/*System.out.print("müşteri bekleme süresi: "+ rear.data.wait);
			System.out.print(" müşteri geliş süresi: "+rear.data.arrivalTime);
			System.out.print(" müşteri hizmet süresi: "+rear.data.removalTime);
			System.out.print(" müşterinin geldiği zaman "+gelis+". saniye\n");*/

		while(true){
				//eger ondeki müsterinin bekleme süresi arkasındaki müsterilerin gelis süresinden fazlaysa yeni müsteri gelir
			if(front!=null&&front.data.removalTime>gelis){
			
					enqueue(new Customer());
				
					bekleme+=rear.data.removalTime;
					gelis+=rear.data.arrivalTime;
					rear.data.wait=bekleme-gelis;
					
					/*System.out.print("müşteri bekleme süresi: "+ rear.data.wait);
					System.out.print(" müşteri geliş süresi: "+rear.data.arrivalTime);
					System.out.print(" müşteri hizmet süresi: "+rear.data.removalTime);
					System.out.print(" müşterinin geldiği zaman "+ gelis+". saniye\n");*/
						if(front!=null&&front.data.numara==1){
						System.out.println("1. Müşterinin işlemi yapıldı");
						front=front.next;
						gelis=rear.data.arrivalTime;
						}
			}
			else{
				chooseCustomer();	
					//verilen müsterinin islemi yapıldıgında donguden cıkılır		
					if(front!=null&&front.data.numara==numberOfCustomer+1){
						break;
					}
					if(front==null){
							//eger kuyrukta eleman kalmadıysa yeni müsteri 
							enqueue(new Customer());	
							gelis=0;
							bekleme=0;
							gelis+=rear.data.arrivalTime;
							rear.data.wait=0;
							bekleme+=rear.data.removalTime;
					}
					else{						
						 gelis=rear.data.arrivalTime;
					}	
			}
		}
		System.out.println(" DAHA FAZLA MÜŞTERİ ALAMIYORUZ İYİ AKŞAMLAR.... \n\n");

		System.out.println(" kuyruktakilerin bekleme bekleme süreleri :\n");


	
		Iterator<Customer> itr=this.iterator();
		while(itr.hasNext()){
			Customer element=itr.next();
			System.out.println(element.numara+". müsteri "+element.wait);
		}
		Customer element =itr.next();
		System.out.println(element.numara+". müsteri "+element.wait);
		
	}

	
	/**
	 *  numberOfCustumer ile verilen sayida  
	 * musteri hizmet gorene kadar calismaya devam eder, 
	 * calisirken verilen tekerlemeyi kullanir*/
	public CrazyMarket(int numberOfCustomer, String tekerleme) {
		size=0;
		double gelis=0;
		double bekleme=0;
		this.tekerleme=tekerleme;
		//ilk müsteri geliyor
		enqueue(new Customer());
			gelis+=rear.data.arrivalTime;
			rear.data.wait=0;
			bekleme+=rear.data.removalTime;
	
			/*System.out.print("müşteri bekleme süresi: "+ rear.data.wait);
			System.out.print(" müşteri geliş süresi: "+rear.data.arrivalTime);
			System.out.print(" müşteri hizmet süresi: "+rear.data.removalTime);
			System.out.print(" müşterinin geldiği zaman "+gelis+". saniye\n");*/

		while(true){
				//eger ondeki müsterinin bekleme süresi arkasındaki müsterinin gelis süresinden fazlaysa yeni müsteri gelir
			if(front!=null&&front.data.removalTime>gelis){
			
					enqueue(new Customer());
				
					bekleme+=rear.data.removalTime;
					gelis+=rear.data.arrivalTime;
					rear.data.wait=bekleme-gelis;
					
					/*System.out.print("müşteri bekleme süresi: "+ rear.data.wait);
					System.out.print(" müşteri geliş süresi: "+rear.data.arrivalTime);
					System.out.print(" müşteri hizmet süresi: "+rear.data.removalTime);
					System.out.print(" müşterinin geldiği zaman "+ gelis+". saniye\n");*/
						if(front!=null&&front.data.numara==1){
						System.out.println("1. Müşterinin işlemi yapıldı");
						front=front.next;
						gelis=rear.data.arrivalTime;
						}
			}
			else{
				chooseCustomer();			
					if(front!=null&&front.data.numara==numberOfCustomer+1){
						break;
					}
					if(front==null){
							//eger kuyrukta eleman kalmadıysa yeni müsteri 
							enqueue(new Customer());	
							gelis=0;
							bekleme=0;
							gelis+=rear.data.arrivalTime;
							rear.data.wait=0;
							bekleme+=rear.data.removalTime;
					}
					else{						
						 gelis=rear.data.arrivalTime;
					}	
			}
		}
		System.out.println(" DAHA FAZLA MÜŞTERİ ALAMIYORUZ İYİ AKŞAMLAR.... \n\n");

		System.out.println(" kuyruktakilerin bekleme bekleme süreleri :\n");


		Iterator<Customer> itr=this.iterator();
		while(itr.hasNext()){
			Customer element=itr.next();
			System.out.println(element.numara+". müsteri "+element.wait);
		}
		Customer element =itr.next();
		System.out.println(element.numara+". müsteri "+element.wait);
	}



	/** kuyrugun basindaki musteriyi yada tekerleme 
	 * ile buldugu musteriyi return eder*/
	public Customer chooseCustomer() {
		
		if(front!=null&&front.data.wait>10){
			dequeuNext();
		}
		else{
			dequeuWithCounting(tekerleme);
		}
		return null;
	}


	public int size(){
		return this.size;
	}	
	public boolean isEmpty(){
		return size()==0;
	}

	public boolean enqueue(Customer item){
		
		Node temp = new Node(item);
		size++;
		//kuyrukta eleman yoksa
		if (this.rear == null) { 
			this.front = this.rear = temp; 
			
            return false; 
		} 
		
		this.rear.next = temp; 
		this.rear = temp; 
		
		return true;
		
	}

	public Customer dequeuNext() 
    { 	
		
		System.out.println(front.data.numara+". Müşteri çok beklediği için seçildi ve işlemi yapıldı");
         // If queue is empty, return NULL. 
		 if (front == null){
		   return null; 
		 }

		 size--;
		 //Sadece 1 elemean var ise  
		 if(front.next==null){
			front=null;
			rear=null;
			return null;
		}
		 else{
			 front = front.next; 
		 return front.data;
		 }
	} 
	public Customer dequeuWithCounting(String tekerleme){
		// If queue is empty, return NULL.
		if (front == null){
			return null; 
		  }
		  
		char sesliHarf;
		int sesliHarfsayisi = 0;
		
			for(int i=0; i<tekerleme.length(); i++) {
			sesliHarf = tekerleme.charAt(i);

			if (sesliHarf=='a'|| sesliHarf=='e'|| sesliHarf=='ı'|| sesliHarf=='i'|| sesliHarf=='o'|| sesliHarf=='ö'|| sesliHarf=='u'|| sesliHarf=='ü' ){

			 sesliHarfsayisi++;
			}
		}

				Node temp1=front;
				Node temp2=front;
				for(int c=0;c<sesliHarfsayisi;c++)
				{	//Son elemana gelindiyse basa dön
					if(temp1.next==null){
						temp1=front;
						
					}else{
					temp1=temp1.next;
					}
				}
				
				//secilen eleman en baştaysa 
				if(temp1==front){
					System.out.println(front.data.numara+". Müşteri tekerlemeye göre seçildi ve işlemi yapıldı");
					//sırada sadece en baştaki eleman varsa
					if(front.next==null){
						front=null;
						rear=null;
						size--;
						return null;
					}
					else{
					front=front.next;
					}
				}
				//secilen eleman en basta degilse
				else{
					System.out.println(temp1.data.numara+". Müşteri tekerlemeye göre seçildi ve işlemi yapıldı");
					//secilen eleman en sondaysa
					if(temp1.next==null){
						rear=null;
						size--;
						return null;
					}
					//son dan veya bastan farklı bir yerde ise
					else{
					temp1=temp1.next;
					}
				}

		 size--;
		return temp1.data;
		 
	}

	@Override
	public Iterator<Customer> iterator(){
		return new MyQueueIterator();
	}
	private class MyQueueIterator implements Iterator<Customer>{
		 Node itr =front;
		@Override
		public boolean hasNext(){
			if(itr ==null && front !=null){
				return true;
			}
			else if( itr !=null){
				return itr.next!=null;

			}
			return true;
		}
		@Override
		public Customer next() {
			if(itr ==null && front!=null){
				itr =front;
				return front.data;
			}
			else if(itr !=null){
				Customer id= itr.data;
				itr=itr.next;
				return id;
			}
			throw new NoSuchElementException();
		}
	}

		public static void main(String[] args) {
		
		CrazyMarket x= new CrazyMarket(100);
	
	}
}
