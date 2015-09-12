package pkg;

import static org.junit.Assert.*;

import org.junit.*;

public class ProductTest {
    
    // setUp environment before every test method
    @Before public void setUp () {
    }
    
    // tearDown environment after every test method    
    @After public void tearDown () {
 
    }

	@Test public void testGetPrice () {
    	BasicTaxApplicableProduct b = new BasicTaxApplicableProduct(1.24, false, "newprod");
        assertTrue(b.getPrice() == 1.24);
    }
	
	@Test public void testIsImported() {
		BasicTaxApplicableProduct b = new BasicTaxApplicableProduct(1.24, false, "newprod");
		assertFalse(b.isImported());
	}
	
	@Test public void testGetImportTax() {
		BasicTaxApplicableProduct b = new BasicTaxApplicableProduct(1.24, false, "newprod");
		assertTrue(b.getImportTax() == 0);
	}
	
	@Test public void testGetImportTaxTwo() {
		BasicTaxApplicableProduct b = new BasicTaxApplicableProduct(1.24, true, "newprod");
		assertFalse(b.getImportTax() == 0);
	}
	
	@Test public void testGetImportTaxThree() {
		BasicTaxApplicableProduct b = new BasicTaxApplicableProduct(1.00, true, "newprod");
		assertTrue(b.getImportTax() == 0.05);
	}
	
	/* BasicTaxNotApplicableProduct e.g. food, etc */
	@Test public void testBasicNotAppOne() {
		// books, food and medical products are exempt
		BasicTaxExemptProduct bestBook = new BasicTaxExemptProduct(1.00, false, "mybook");
		// tax should be zero 
		assertTrue(bestBook.computeSalesTax() == 0);
	}
	
	@Test public void testBasicNotAppTwo() {
		// books, food and medical products are exempt
		BasicTaxExemptProduct bestBook = new BasicTaxExemptProduct(1.00, false, "mybook");
		// price should be the same as before  
		assertTrue(bestBook.computeTotalPrice() == 1.00);
	}
	
	@Test public void testBasicNotAppThree() {
		// books, food and medical products are exempt
		BasicTaxExemptProduct bestBook = new BasicTaxExemptProduct(1.00, true, "mybook");
		// price should compensate for import tax  
		assertTrue(bestBook.computeTotalPrice() == 1.05);
	}
	
	/* test the receipt object*/
	@Test public void testReceiptConstructor() {
		Receipt r = new Receipt();
		assertTrue(r.getAllProducts() != null);
	}
	
	/* 
	 * 
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Output 1:
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83
	 * */
	@Test public void testGivenInputOne() {
		BasicTaxExemptProduct bestBook = new BasicTaxExemptProduct(12.49, false, "mybook");
		BasicTaxApplicableProduct musicCD = new BasicTaxApplicableProduct(14.99, false, "musicCD");
		BasicTaxExemptProduct chocolateBar = new BasicTaxExemptProduct(0.85, false, "chocoBar");
		
		Product [] myArr = {bestBook, musicCD, chocolateBar};
		
		Receipt r = new Receipt(myArr);
		
		assertTrue(r.getAllProducts() != null);
		double [] output = new double[2];
		output = r.generateTotal();
		
		// Total Sales Tax
		assertTrue(output[0] == 1.50 );
		
		// Total 
		assertTrue(output[1] == 29.83);
	}
	
	/* 
	 * 
Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15
	 * */
	@Test public void testGivenInputTwo() {
		BasicTaxExemptProduct chocolateBox = new BasicTaxExemptProduct(10.00, true, "chocolateBox");
		BasicTaxApplicableProduct perfumeBottle = new BasicTaxApplicableProduct(47.50, true, "perfumeBottle");
		
		Product [] myArr = {chocolateBox, perfumeBottle};
		
		Receipt r = new Receipt(myArr);
		
		assertTrue(r.getAllProducts() != null);
		double [] output = new double[2];
		output = r.generateTotal();
		
		// Total Sales Tax
		assertTrue(output[0] == 7.65 );
		
		// Total 
		assertTrue(output[1] == 65.15);
	}
	
	/* 
	 * 
Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 imported box of chocolates at 11.25

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
	 * */
	@Test public void testGivenInputThree() {

		BasicTaxApplicableProduct ImportedPerfumeBottle = new BasicTaxApplicableProduct(27.99, true, "ImportedPerfumeBottle");
		BasicTaxApplicableProduct perfumeBottle = new BasicTaxApplicableProduct(18.99, false, "localBottle");
		BasicTaxExemptProduct headPills = new BasicTaxExemptProduct(9.75, false, "Tylenol");
		BasicTaxExemptProduct chocolateBox = new BasicTaxExemptProduct(11.25, true, "chocolateBox");
		
		Product [] myArr = {chocolateBox, perfumeBottle, ImportedPerfumeBottle, headPills};
		
		Receipt r = new Receipt(myArr);
		
		assertTrue(r.getAllProducts() != null);
		double [] output = new double[2];
		output = r.generateTotal();
		
		// Total Sales Tax
		assertTrue(output[0] == 6.65 );
		
		// Total 
		assertTrue(output[1] == 74.63);
	}
}
