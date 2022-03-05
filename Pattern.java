package programs;

public class Pattern {

	public static void main(String[] args) {
		int row,col;
		for (row=1;row<=5;row++) {
			for (col=1;col<=9;col++) {
				if ((col>=6-row) && (col<=4+row)) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		// System.out.println(row);
		for (;row<=10;row++) {
			
			for (col=1;col<=9;col++) {
				if ((col>=row-5) && (col<=15-row)) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
