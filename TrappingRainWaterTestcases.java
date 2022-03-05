package programs;

import java.lang.reflect.Method;

public class TrappingRainWaterTestcases {
	/*
	 * Each testcase function is used to test our method, here I am providing input and getting an output and matching it with the 
	 * expected output if it match then it prints testcase passes otherwise it prints testcase failed.
	 */
	static int testCasesCount = 0;
    TrappingRainWater obj = new TrappingRainWater();
	/*
	 * In this, input is an empty array and we are expecting WRONG_INPUT(-1) as a output in this case.
	 */
	public int TestCase1() {
		int input[] = {};
		int output = obj.trappingRainWater(input, 0);
		int expectedOutput = TrappingRainWater.WRONG_INPUT;

		return expectOutputCheck(1, output, expectedOutput);
	}
	/*
	 * In this, input is an array of zeroes and we are expecting 0 as an output becaz water can't collected in this scenerio.
	 */
	public int TestCase2() {
		int input[] = { 0, 0, 0, 0 };
		int output = obj.trappingRainWater(input, 4);
		int expectedOutput = 0;

		return expectOutputCheck(2, output, expectedOutput);
	}
	/*
	 * In this, input array is of length 1 and we are expecting 0 as an output becaz water is not collected in this scenerio. 
	 */
	public int TestCase3() {
		int input[] = { 99999 };
		int output = obj.trappingRainWater(input, 1);
		int expectedOutput = 0;

		return expectOutputCheck(3, output, expectedOutput);
	}
	/*
	 * In this, we are giving a null array and expecting WRONG_INPUT(-1) in this case.
	 */
	public int TestCase4() {
		int input[] = null;
		int output = obj.trappingRainWater(input, -1);
		int expectedOutput = TrappingRainWater.WRONG_INPUT;

		return expectOutputCheck(4, output, expectedOutput);
	}
	/*
	 * In this, we are giving Integer MAX_VALUE in the array and expecting WRONG_INPUT(-1) in this case.
	 */
	public int TestCase5() {
		int input[] = { Integer.MAX_VALUE };
		int output = obj.trappingRainWater(input, 1);
		int expectedOutput = TrappingRainWater.WRONG_INPUT;

		return expectOutputCheck(5, output, expectedOutput);
	}
	/*
	 * In this, we are giving an array and giving size which is not equal to length of array and we are expecting
	 * WRONG_INPUT(-1) in this case.
	 */
	public int TestCase6() {
		int input[] = { 4, 3, 5, 6, 7 };
		int output = obj.trappingRainWater(input, 7);
		int expectedOutput = TrappingRainWater.WRONG_INPUT;

		return expectOutputCheck(6, output, expectedOutput);
	}
	/*
	 * Input : |  | So expected output : 2
	 * 		   |__|
	 */
	public int TestCase7() {
		int input[] = { 2, 0, 2 };
		int output = obj.trappingRainWater(input, 3);
		int expectedOutput = 2;

		return expectOutputCheck(7, output, expectedOutput);
	}
	/*         
	 * Input : Array of 6 elements
	 * Output : water is collected : 1 unit at 2nd index and 2 units at 4th index so total : 3 units
	 */
	public int TestCase8() {
		int input[] = { 2,3,2,4,0,2 };
		int output = obj.trappingRainWater(input, 6);
		int expectedOutput = 3;

		return expectOutputCheck(8, output, expectedOutput);
	}
	/*
	 * Input : Array of 5 elements
	 * Output : 7 (3 units at 1st index, 1 unit at 2nd index and 3 units at 3rd index)
	 */
	public int TestCase9() {
		int input[] = { 3, 0, 2, 0, 4 };
		int output = obj.trappingRainWater(input, 5);
		int expectedOutput = 7;

		return expectOutputCheck(9, output, expectedOutput);
	}
	/*
	 * Input : Array of 12 elements 
	 * Output : 6 (1 unit at 1st index, 1 unit at 3rd index, 2 units at 4th index, 1 unit at 5th index and 1 unit at 8th index)
	 */
	public int TestCase10() {
		int input[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int output = obj.trappingRainWater(input, 12);
		int expectedOutput = 6;

		return expectOutputCheck(10, output, expectedOutput);
	}
	/*
	 * Based on matching of Our output with expected output it prints success or failure.
	 */
	private static int expectOutputCheck(int testCaseNumber, int output, int expectedOutput) {
		if (output == expectedOutput) {
			System.out.println("TestCase " + testCaseNumber + " Success");
			return 1;
		}

		System.out.println("TestCase " + testCaseNumber + " Failed");
		return 0;
	}

	public static void main(String[] args) {
		try {
			/*
			 * Loop to call the 10 testcases function.
			 */
			for (int i = 1; i <= 10; i++) {
				String methodName = "TestCase" + i;
				Method method =  TrappingRainWaterTestcases.class.getMethod(methodName);
				int result = (Integer) method.invoke(new TrappingRainWaterTestcases());
				testCasesCount += result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\nTotal Testcases passed : "+testCasesCount+" out of 10");

	}
}
