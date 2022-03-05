package programs;

public class ReduceNumTo1Amazon2 {

	public static void main(String[] args) {
		int n = 7;
		int ans = find(n,0);
		System.out.println(ans);
	}
	
	public static int find(int n, int count){
	    
	    if(n==1){
	        return count;
	    }
	    
	    if(n%2==0){
	        return find(n/2,count+1);
	    }
	    else if(n%2!=0){
	        int count1 = find(n-1,count+1);
	        int count2 = find(n+1,count+1);
	        return Math.min(count1,count2);
	    }
	    return count;
	}

}
