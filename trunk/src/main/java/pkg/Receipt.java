package pkg;
//import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.lang.Math;

public class Receipt {
	
	private ArrayList<Product> myProductList;
	
	// Format the doubles to two decimals #.##
	DecimalFormat newFormat = new DecimalFormat("#.##");
	
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
		
		Object [] arr = this.getAllElements();
		
		for (int i=0; i<arr.length; i++) {
			totalTax += ((Product) arr[i]).computeSalesTax();
			totalPrice += ((Product) arr[i]).computeTotalPrice();
		}
		
		
		output[0] = Double.valueOf(newFormat.format(totalTax) );
		output[1] = Double.valueOf(newFormat.format(totalPrice) );
		
		return output;
	};
	
	public static void main(String[] args) {
		BasicTaxExemptProduct chocolateBox = new BasicTaxExemptProduct(11.25, true, "chocolateBox");
		BasicTaxApplicableProduct perfumeBottle = new BasicTaxApplicableProduct(18.99, false, "localBottle");
		BasicTaxApplicableProduct ImportedPerfumeBottle = new BasicTaxApplicableProduct(27.99, true, "ImportedPerfumeBottle");
		BasicTaxExemptProduct headPills = new BasicTaxExemptProduct(9.75, false, "Tylenol");
		
		Product [] myArr = {chocolateBox, perfumeBottle, ImportedPerfumeBottle, headPills};
		
		Receipt r = new Receipt(myArr);
		
		assertTrue(r.getAllProducts() != null);
		double [] output = new double[2];
		output = r.generateTotal();
		
		System.out.println(output[0]);
		System.out.println(output[1]);
	}	
}
