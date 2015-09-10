package pkg;

public abstract class Product {
    
	/*  accessible to subclasses */
	protected String name;
	protected boolean isImported = false;
	protected double price; 
	
	public abstract double computeSalesTax ();

	/* getters */
	public boolean isImported () {
		return this.isImported;
	};

	public double getPrice () {
		return price;
	}; 

	public double getImportTax () {
		if (!this.isImported())
			return 0;
		else return 0.05 * this.getPrice();
	};
	
	public double computeTotalPrice () {
		return getPrice() + computeSalesTax();
	}
}
