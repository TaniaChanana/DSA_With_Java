package programs;
public class TrappingRainWater {

public static int WRONG_INPUT = -1;
public static int EMPTY = 0;

/*
 * @param heights
 * @param size
 * @return
 * An array element can store the x amount of water and x is calculated as follows :
 * 	x = Min(Max from left including itself, Max from right including itself) - current element.
 * 	To find the max element I have made two arrays which are used to store the max element from left and right elements.
 *  Then find x for every element of array and add that value in final answer.
 */
	public int trappingRainWater(int[] heights,int size){ // heights : arrays of heights of blocks and size : size of array 
		
		if(checkWrongInputs (heights, size) == WRONG_INPUT) {
			return WRONG_INPUT;
		}
				
		int leftMax[] = new int[size];    // stores max element form left
        int rightMax[] = new int[size];  // stores max element form right
        
        int max = heights[0];
        leftMax[0] = max;
        for(int i=1;i<size;i++){
            max = Math.max(max,heights[i]);
            leftMax[i] = max;
        }
        
        max = heights[size-1];
        rightMax[size-1] = max;
        for(int i=size-2;i>=0;i--){
            max = Math.max(max,heights[i]);
            rightMax[i] = max;
        }
        
        int ans = 0;
        for(int i=0;i<size;i++){
            int min = Math.min(leftMax[i],rightMax[i]); // water the index can store is the min form leftmax and rightmax 
            ans+=(min-heights[i]); // and then subtract the element value from minimum value
        }
        return ans;
    }
	
	/*
	 * This function is used to check if our input is wrong or not.
	 * Wrong inputs like : if the array size and given size is not same
	 * 					   if heights array is null
	 * 					   if heights array contains a negative value
	 */
	private static int checkWrongInputs(int[] heights, int size) {
		
		if((heights == null) || (heights.length!=size) || (heights.length == 0))
			return WRONG_INPUT;
		
		boolean hasNegative = false;
		for(int i=0;i<size;i++) {
			if(heights[i] < 0 || heights[i]>=Integer.MAX_VALUE)
				return WRONG_INPUT;
		}
		return 0;
	}
	
}
