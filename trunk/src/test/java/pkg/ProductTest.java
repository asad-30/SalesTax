package pkg;

import static org.junit.Assert.*;

import org.junit.*;

public class ProductTest {
    
    // setUp environment before every test method
    @Before public void setUp () {
    	BasicTaxApplicableProduct a = new BasicTaxApplicableProduct();
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
}
