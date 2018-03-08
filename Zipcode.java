/* Horstmann Programming Project 8.3
 *
 * Encodes and decodes zip codes into bar codes
 * using the scheme on the given table.
 *
 */

public class Zipcode {

    // Array where index corresponds to digit encoded. 
    private final String[] scheme = { "||:::", ":::||", "::|:|", "::||:", 
                                      ":|::|", ":|:|:", ":||::", "|:::|", 
                                      "|::|:", "|:|::" } ;
    private String zipcode;
    private String barcode;

    // Constructor given original zip code.
    public Zipcode(int zip_number) {
        this.zipcode = String.format("%05d", zip_number);
        this.toBarcode();
    }

    // Constructor given encoded zip code.
    public Zipcode(String zip_bar) {
        this.barcode = zip_bar;
        this.toZIPcode();
    }

    public String getBarcode() {
        return barcode;
    }

    public String getZIPcode() {
        return zipcode;
    }

    // Decodes zip code.
    private void toZIPcode() {
        this.zipcode = "";
        for (int i = 0; i < scheme[0].length(); ++i) {
            int index = 5 * i + 1;
            this.zipcode += toDigit(this.barcode.substring(index,index+5));
        }
    }

    // Turns an encoded digit to a decimal digit.
    private String toDigit(String code) {
        for (int i = 0; i < scheme.length; ++i) {
            if (code.equals(scheme[i])) return String.valueOf(i);
        }
        return null;
    }

    // Encodes zip code.
    private void toBarcode() {
        this.barcode = "|";
        for (int i = 0; i < this.zipcode.length(); ++i) {
            this.barcode += scheme[Integer.parseInt(zipcode.substring(i,i+1))];
        }
        this.barcode += scheme[checkDigit()] + "|";
    }

    // Computes the check digit of the current zipcode.
    private int checkDigit() {
        int sum = 0;
        for (int i = 0; i < this.zipcode.length(); ++i) {
            sum += Integer.parseInt(this.zipcode.substring(i,i+1));
        }
        int multiple = 0;
        while (multiple < sum) multiple += 10;
        return multiple - sum;
    }
}


