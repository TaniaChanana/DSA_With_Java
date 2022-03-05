package programs;

public class ClockConversion {

	public static void main(String[] args) {
		String res = timeConversion("12:01:00PM");
		System.out.println(res);
	}

	public static String timeConversion(String s) {
        String[] a = s.split(":");
        if(a[0].equals("12") && a[2].contains("P")){
            a[0] = "12";
        }else if(a[0].equals("12") && a[2].contains("A")){
            a[0] = "00";
        }else{
            String str = a[0];
            int hour = Integer.parseInt(str);
            hour += 12;
            a[0] = hour+"";
        }
        
        String result = a[0]+":"+a[1]+":"+a[2].substring(0,2);
        return result;

    }
	
}
