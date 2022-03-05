package programs;

public class SortWithSquaresAmazon1 {

	public static void main(String[] args) {
		int a[] =  {-6, -3, -1, 2, 4, 5};
		int res[] = sortedSquares(a);
		for (int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}

	}

	public static void reverseNegPart(int si,int ei,int[] a){
        int temp;
        while(si<ei){
            temp = a[si];
            a[si] = a[ei];
            a[ei] = temp;
            si++;
            ei--;
        }
    }
    
    public static int[] sortedSquares(int[] a) {
        
        int countNeg = 0;
        for(int i=0;i<a.length;i++){
            if (a[i]<0)
                countNeg++;
            a[i] *= a[i];
        }
        
        reverseNegPart(0,countNeg-1,a);
        
        int res[] = new int[a.length];
        int k =0 ;
        int i = 0,j = countNeg;
        while(i<countNeg && j<a.length){
            if(a[i]<a[j]){
                res[k] = a[i];
                i++;k++;
            }else{
                res[k] = a[j];
                j++;k++;
            }
        }
        while(i<countNeg){
            res[k] = a[i];
            i++;k++;
        }
        while(j<a.length){
            res[k] = a[j];
            j++;k++;
        }
        return res;
    }
	
}
