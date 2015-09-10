package pkg;
import java.util.ArrayList;

public class Receipt {
	
	private ArrayList<Product> myProductList;
	
	public Receipt() {
		myProductList = new ArrayList<Product>();
	};
	
	public Receipt(Product[] prod) {
		myProductList = new ArrayList<Product>();
		
		for (int i=0; i<prod.length; i++) {
			myProductList.add(prod[i]);
		}
	};
	
	public ArrayList<Product> getAllProducts() {
		return this.myProductList;
	};
	
	// returns an array of Objects
	public Object[] getAllElements() {
		return this.myProductList.toArray();
	};
	
	public double [] generateTotal() {
		double totalTax = 0;
		double totalPrice = 0;
		double [] output = new double [2];
		
		Product [] arr = (Product[]) this.getAllElements();
		
		for (int i=0; i<arr.length; i++) {
			totalTax += arr[i].computeSalesTax();
			totalPrice += arr[i].computeTotalPrice();
		}
		
		output[0] = totalTax;
		output[1] = totalPrice;
		
		return output;
	};
}
