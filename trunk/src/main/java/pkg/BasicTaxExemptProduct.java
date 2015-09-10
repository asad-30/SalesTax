package pkg;

class BasicTaxExemptProduct extends Product {
	
	// Constructors
	public BasicTaxExemptProduct() { };
	
	public BasicTaxExemptProduct (double price, boolean isImported, String name) {
		this.price = price;
		this.isImported = isImported;
		this.name = name;
	};
	
	// compute basic and add imported
	public double computeSalesTax() {
		return getImportTax() + 0;
	};
}