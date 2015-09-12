# SalesTax

How to run this?

1) git clone
2) cd trunk
3) mvn test

Also, you can import the project into Eclipse as a "Existing Maven Project" and Run the Tests

Instead of making a main() function and taking using input and printing output, I decided to add the objects and test the values of the resulting Sales Tax and Total on the Receipt

Sales Tax is composed of two types of taxes:<br><br>
  1) Basic Sales Tax (10% applicable to all EXCEPT food, medical products and books) <br>
  2) Import Tax (5% applicable to ALL imported goods)

<b>Input:</b><br>
1 imported bottle of perfume at 27.99<br>
1 bottle of perfume at 18.99<br>
1 packet of headache pills at 9.75<br>
1 imported box of chocolates at 11.25<br>

<b>Output:</b><br>
1 imported bottle of perfume: 32.19<br>
1 bottle of perfume: 20.89<br>
1 packet of headache pills: 9.75<br>
1 imported box of chocolates: 11.85<br>
Sales Taxes: 6.70<br>
Total: 74.68<br>


Each good is hence categorized as:<br>
  1) BasicTaxApplicableProduct<br>
  2) BasicTaxExemptProduct (food, medical products and books)<br>
  
You can add goods to the Receipt class from either of these two categories and it can output an ArrayList of all the products. Furthermore it computes the Total Sales Tax and the Total amount to be paid. 
